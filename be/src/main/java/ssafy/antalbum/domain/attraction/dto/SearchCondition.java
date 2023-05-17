package ssafy.antalbum.domain.attraction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCondition {

    int sidoCode;
    int contentTypeId;
    String keyword;
}
