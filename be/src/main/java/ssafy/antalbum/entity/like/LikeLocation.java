package ssafy.antalbum.entity.like;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("L")
@Getter
public class LikeLocation extends Like{

}
