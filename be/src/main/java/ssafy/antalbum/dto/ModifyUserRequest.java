package ssafy.antalbum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ModifyUserRequest {
    String nickname;
    String profile;
    String comment;
}
