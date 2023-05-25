package ssafy.antalbum.controller;

import com.drew.imaging.ImageProcessingException;
import jakarta.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ssafy.antalbum.dto.CreateTravelInfoRequest;
import ssafy.antalbum.dto.CreateTravelInfoResponse;
import ssafy.antalbum.dto.TravelDto;
import ssafy.antalbum.service.TravelService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class TravelAPIController {

    private final TravelService travelService;

    @PostMapping("/apii/v1/travel/info")
    public CreateTravelInfoResponse createTravelInfo(@RequestBody @Valid CreateTravelInfoRequest request) {
        Long id = travelService.create(request);
        return new CreateTravelInfoResponse(id);
    }

    @PostMapping("/apii/v1/travel/photo")
    public CreateTravelInfoResponse addTravelPhoto(@RequestParam("id") String travel,
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam("names") List<String> names)
            throws IOException, ImageProcessingException, ParseException {
        travelService.updatePhoto(Long.parseLong(travel), files, names);
        return new CreateTravelInfoResponse(Long.parseLong(travel));
    }

    @GetMapping("/apii/v1/travel/{userid}")
    public List<TravelDto> listTravel(@PathVariable("userid") Long userId) {
        return travelService.findAllTravelInfo(userId);
    }

}
