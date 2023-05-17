package ssafy.antalbum.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.antalbum.entity.comment.Comment;
import ssafy.antalbum.entity.like.Like;
import ssafy.antalbum.entity.tag.Tag;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String nickname;
    private String comment;
    private String profile;

    @Embedded
    private UserInfo userInfo;

    @OneToMany(mappedBy = "fromUser")
    private List<Friend> following;

    @OneToMany(mappedBy = "toUser")
    private List<Friend> followed;

    @OneToMany(mappedBy = "user")
    private List<Tag> tags;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}
