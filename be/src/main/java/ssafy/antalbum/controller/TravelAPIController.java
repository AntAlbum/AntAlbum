package ssafy.antalbum.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import java.io.IOException;
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
import ssafy.antalbum.entity.travel.Travel;
import ssafy.antalbum.service.MetadataService;
import ssafy.antalbum.service.TravelService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class TravelAPIController {

    private final TravelService travelService;
    private final MetadataService metadataService;

    @PostMapping("/apii/v1/travel")
    public CreateTravelResponse createTravel(@RequestBody @Valid Travel travel) {
        Long id = travelService.create(travel);
        return new CreateTravelResponse(id);
    }

    @PostMapping(value = "/apii/v3/travel/photo")
    public void uploadPhoto3(@RequestParam("file") MultipartFile photo) throws IOException {
        metadataService.upload(photo);
        System.out.println("aaa");
    }

    @PostMapping("/apii/v2/travel/photo")
    public void uploadPhoto2(@RequestParam("files") List<MultipartFile> photos) {
        System.out.println("id: " + photos.size());
    }

    @PostMapping("/apii/v1/travel/photo")
    public void uploadPhoto(@RequestParam("id") String user, @RequestParam("files") List<MultipartFile> photos) {
        System.out.println("id: " + user);
    }

    @Data
    static class CreateTravelResponse {
        private Long id;

        public CreateTravelResponse(Long id) {
            this.id = id;
        }
    }

}
