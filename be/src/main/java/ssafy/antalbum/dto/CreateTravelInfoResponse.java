package ssafy.antalbum.dto;

import lombok.Getter;

@Getter
public class CreateTravelInfoResponse {
    private Long id;

    public CreateTravelInfoResponse(Long id) {
        this.id = id;
    }
}
