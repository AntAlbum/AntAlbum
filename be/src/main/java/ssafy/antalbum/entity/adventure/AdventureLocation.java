package ssafy.antalbum.entity.adventure;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("L")
@Getter
public class AdventureLocation extends Adventure {

    private int areaId;

}
