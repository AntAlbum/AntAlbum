package ssafy.antalbum.entity.adventure;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class AdventureLocation extends Adventure {

    private int areaId;

}
