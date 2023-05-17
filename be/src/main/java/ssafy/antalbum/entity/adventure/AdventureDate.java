package ssafy.antalbum.entity.adventure;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;
import lombok.Getter;

@Entity
@Getter
public class AdventureDate extends Adventure {

    @Temporal(TemporalType.DATE)
    private Calendar date;

}
