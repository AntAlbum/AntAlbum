package ssafy.antalbum.dto;

import lombok.Getter;

@Getter
public class FriendDto {

    private Long id;
    private String profile;

    public FriendDto(Object[] info) {
        this.id = (Long) info[0];
        this.profile = (String) info[1];
    }

}
