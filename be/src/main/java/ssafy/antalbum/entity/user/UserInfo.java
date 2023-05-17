package ssafy.antalbum.entity.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo {

    private String username;
    private String email;
    private String provider;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    public UserInfo(String username, String email, String provider, UserStatus userStatus) {
        this.username = username;
        this.email = email;
        this.provider = provider;
        this.userStatus = userStatus;
    }

}
