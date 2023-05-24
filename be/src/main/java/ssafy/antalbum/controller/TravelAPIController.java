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

    @PostMapping("/apii/v1/travel/info")
    public CreateTravelResponse createTravelInfo(@RequestBody @Valid Travel travel) {
        Long id = travelService.create(travel);
        return new CreateTravelResponse(id);
    }

    @PostMapping("/apii/v1/travel/photo")
    public void addTravelPhoto(@RequestParam("id") String user, @RequestParam("files") List<MultipartFile> photos)
            throws IOException {
        System.out.println("id: " + user);
        for (MultipartFile photo: photos) {
            metadataService.upload(photo);
        }
    }

    @Data
    static class CreateTravelResponse {
        private Long id;

        public CreateTravelResponse(Long id) {
            this.id = id;
        }
    }

}
