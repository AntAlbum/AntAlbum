package ssafy.antalbum.service;

import com.drew.imaging.ImageProcessingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ssafy.antalbum.dto.CreateTravelInfoRequest;
import ssafy.antalbum.dto.MemberDto;
import ssafy.antalbum.dto.TravelDto;
import ssafy.antalbum.entity.adventure.AdventureDate;
import ssafy.antalbum.entity.photo.Photo;
import ssafy.antalbum.entity.photo.PhotoMeta;
import ssafy.antalbum.entity.photo.PhotoPath;
import ssafy.antalbum.entity.tag.Tag;
import ssafy.antalbum.entity.travel.Travel;
import ssafy.antalbum.entity.user.User;
import ssafy.antalbum.repository.TravelRepository;
import ssafy.antalbum.util.PhotoUtil;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;
    private final AmazonS3Service amazonS3Service;
    private final UserService userService;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    @Transactional
    public Long create(CreateTravelInfoRequest request) {
        Travel travel = request.getTravel();
        List<MemberDto> members = request.getMembers();

        List<Tag> tags = new ArrayList<>();
        for (MemberDto member: members) {
            User user = userService.findById(member.getUserId());
            tags.add(Tag.createTag(travel, user, member.getTagStatus()));
        }

        travel.addTags(tags);
        travelRepository.save(travel);
        return travel.getId();
    }

    @Transactional
    public void updatePhoto(Long id, List<MultipartFile> files, List<String> names)
            throws IOException, ImageProcessingException, ParseException {
        Travel travel = findOne(id);

        List<Photo> photos = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            PhotoMeta photoMeta = PhotoUtil.extractMetaData(files.get(i).getInputStream());
            PhotoPath photoPath = PhotoPath.createPhotoPath(bucketName,
                    id.toString(), names.get(i), photoMeta.getExpectedFileNameExtension());

            Photo photo = Photo.createPhoto(photoMeta, photoPath);
            photo.assignTravel(travel);
            photos.add(photo);

            Map<String, String> metadata = PhotoUtil.extractAWSMetaData(files.get(i));
            String url = amazonS3Service.upload(photoPath, metadata, files.get(i).getInputStream());
            if (travel.getThumbnail() == null) travel.updateThumbnail(url);
        }

        HashSet<String> dates = new HashSet<>();
        for (Photo photo: photos) {
            String date = photo.getDate(photo);
            if (date != null) dates.add(date);
        }

        List<AdventureDate> adventures = new ArrayList<>();
        for (String date: dates) {
            AdventureDate adventure = AdventureDate.createAdventureDate(date);
            adventure.assignTravel(travel);
            adventures.add(adventure);
        }

        travel.getPhotos().addAll(photos);
        travel.getAdventures().addAll(adventures);
        travelRepository.updateWithPhotosAndAdventures(travel);
    }

    public Travel findOne(Long id) {
        return travelRepository.findOne(id);
    }

    public List<TravelDto> findAllTravelInfo(Long userId) {
        List<TravelDto> result = new ArrayList<>();
        for(Travel travel: findAllTravelsWithUser(userId)) {
            List<String> duration = travelRepository.findTravelDuration(travel.getId());
            result.add(new TravelDto(travel, duration));
        }

        return result;
    }

    public List<Travel> findAllTravelsWithUser(Long userId) {
        return travelRepository.findAllTravelsWithUser(userId);
    }

}
