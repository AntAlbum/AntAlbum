package ssafy.antalbum.dto;

import java.util.List;
import lombok.Getter;
import ssafy.antalbum.entity.tag.Tag;
import ssafy.antalbum.entity.tag.TagStatus;
import ssafy.antalbum.entity.travel.Travel;

@Getter
public class CreateTravelInfoRequest {
    private Travel travel;
    private List<MemberDto> members;
}

