package ssafy.antalbum.entity.adventure;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Entity
@DiscriminatorValue("D")
@Getter
public class AdventureDate extends Adventure {

    @Temporal(TemporalType.DATE)
    private Date date;

    @Builder
    public AdventureDate(Date date, String thumbnail) {
        this.date = date;
        assignThumbnail(thumbnail);
    }

    protected AdventureDate() {

    }

    public static AdventureDate createAdventureDate(String date, String thumbnail) throws ParseException {
        Date target = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        return AdventureDate.builder().date(target).thumbnail(thumbnail).build();
    }

}
