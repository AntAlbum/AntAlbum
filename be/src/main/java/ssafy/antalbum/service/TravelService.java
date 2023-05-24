package ssafy.antalbum.service;

import com.drew.imaging.ImageProcessingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ssafy.antalbum.entity.adventure.Adventure;
import ssafy.antalbum.entity.photo.Photo;
import ssafy.antalbum.entity.photo.PhotoMeta;
import ssafy.antalbum.entity.photo.PhotoPath;
import ssafy.antalbum.entity.travel.Travel;
import ssafy.antalbum.repository.TravelRepository;
import ssafy.antalbum.util.MetadataExtractor;
import ssafy.antalbum.util.PhotoUtil;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    @Transactional
    public Long create(Travel travel) {
        travelRepository.save(travel);
        return travel.getId();
    }

    @Transactional
    public void updatePhoto(Long id, List<MultipartFile> files, List<String> names)
            throws IOException, ImageProcessingException {
        Travel travel = findOne(id);

        List<Photo> photos = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            PhotoMeta photoMeta = PhotoUtil.extractMetaData(files.get(i).getInputStream());
            PhotoPath photoPath = PhotoPath.createPhotoPath(bucketName, id.toString(), names.get(i));
            Photo photo = Photo.createPhoto(photoMeta, photoPath);
            photo.assignTravel(travel);
            photos.add(photo);
        }

        travel.getPhotos().addAll(photos);
        travelRepository.updateWithPhotos(travel);
    }

    public Travel findOne(Long id) {
        return travelRepository.findOne(id);
    }

}
