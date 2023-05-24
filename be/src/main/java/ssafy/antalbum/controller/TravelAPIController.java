package ssafy.antalbum.controller;

import com.amazonaws.services.iotevents.model.Input;
import com.drew.imaging.ImageProcessingException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ssafy.antalbum.entity.photo.Photo;
import ssafy.antalbum.entity.photo.PhotoMeta;
import ssafy.antalbum.entity.photo.PhotoPath;
import ssafy.antalbum.entity.travel.Travel;
import ssafy.antalbum.service.MetadataService;
import ssafy.antalbum.service.TravelService;
import ssafy.antalbum.util.MetadataExtractor;
import ssafy.antalbum.util.PhotoUtil;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class TravelAPIController {

    private final TravelService travelService;
    private final MetadataService metadataService;

    @PostMapping("/apii/v1/travel/info")
    public CreateTravelInfoResponse createTravelInfo(@RequestBody @Valid Travel travel) {
        Long id = travelService.create(travel);
        return new CreateTravelInfoResponse(id);
    }

    @PostMapping("/apii/v1/travel/photo")
    public void addTravelPhoto(@RequestParam("id") String travel,
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam("names") List<String> names)
            throws IOException, ImageProcessingException {
        travelService.updatePhoto(Long.parseLong(travel), files, names);
    }

    @Data
    static class CreateTravelInfoResponse {
        private Long id;

        public CreateTravelInfoResponse(Long id) {
            this.id = id;
        }
    }

}
