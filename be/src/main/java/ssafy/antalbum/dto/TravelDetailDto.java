package ssafy.antalbum.dto;

import java.util.List;
import lombok.Getter;
import ssafy.antalbum.entity.travel.Travel;

@Getter
public class TravelDetailDto {

    private Long travelId;
    private int numAdventures;
    private Long numPhotos;
    private List<AdventureDto> adventures;
    private List<FriendDto> friends;

    public TravelDetailDto(Long travelId, Long numPhotos,
            List<AdventureDto> adventures, List<FriendDto> friends) {
        this.travelId = travelId;
        this.numAdventures = adventures.size();
        this.numPhotos = numPhotos;
        this.adventures = adventures;
        this.friends = friends;
    }

}
