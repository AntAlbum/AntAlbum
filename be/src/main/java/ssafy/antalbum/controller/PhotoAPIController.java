package ssafy.antalbum.controller;

import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ssafy.antalbum.service.MetadataService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class PhotoAPIController {

    private final MetadataService metadataService;

    @PostMapping(value = "/apii/v1/photo/single")
    public void uploadSinglePhoto(@RequestParam("file") MultipartFile photo) throws IOException {
        metadataService.upload(photo);
    }

    @PostMapping("/apii/v1/photo/multi")
    public void uploadMultiPhoto(@RequestParam("files") List<MultipartFile> photos) throws IOException {
        for (MultipartFile photo: photos) {
            metadataService.upload(photo);
        }
    }

}
