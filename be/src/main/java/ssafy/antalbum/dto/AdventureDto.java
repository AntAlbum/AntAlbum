package ssafy.antalbum.dto;

import lombok.Getter;

@Getter
public class AdventureDto {

    private Long id;
    private String thumbnail;

    public AdventureDto(Object[] adventure) {
        this.id = (Long) adventure[0];
        this.thumbnail = (String) adventure[1];
    }

}
