package ssafy.antalbum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ssafy.antalbum.dto.SearchCondition;
import ssafy.antalbum.entity.Attraction;
import ssafy.antalbum.service.AttractionService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AttractionController {

    private final AttractionService attractionService;

    @GetMapping("api/attraction")
    public ResponseEntity<List<Attraction>> findAllAttractions() {

        List<Attraction> attractions = attractionService.findAll();

        return ResponseEntity.ok().body(attractions);
    }

    // default : [0, 0, ""]
    @PostMapping("api/attraction/condition")
    public ResponseEntity<List<Attraction>> findByCondition(@RequestBody SearchCondition condition) {

        List<Attraction> attractions = attractionService.findByCondition(condition);
        return ResponseEntity.ok().body(attractions);
    }

}
