package ssafy.antalbum.entity.like;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("D")
@Getter
public class LikeDate extends Like {

}
