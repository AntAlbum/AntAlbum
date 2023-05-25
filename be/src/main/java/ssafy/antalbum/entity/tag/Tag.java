package ssafy.antalbum.entity.tag;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.antalbum.dto.MemberDto;
import ssafy.antalbum.entity.travel.Travel;
import ssafy.antalbum.entity.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {

    @Id @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @Enumerated(EnumType.STRING)
    private TagStatus tagStatus;

    @Builder
    public Tag(Travel travel, User user, TagStatus tagStatus) {
        this.travel = travel;
        this.user = user;
        this.tagStatus = tagStatus;
    }

    public static Tag createTag(Travel travel, User user, TagStatus tagStatus) {
        return Tag.builder()
                .travel(travel)
                .user(user)
                .tagStatus(tagStatus)
                .build();
    }
}
