package ssafy.antalbum.entity.comment;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("D")
@Getter
public class CommentDate extends Comment {

}
