package ssafy.antalbum.entity.comment;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("L")
@Getter
public class CommentLocation extends Comment {

}
