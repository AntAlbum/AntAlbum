package ssafy.antalbum.dto;

import lombok.Getter;
import ssafy.antalbum.entity.tag.TagStatus;

@Getter
public class MemberDto {
    private Long userId;
    private TagStatus tagStatus;
}
