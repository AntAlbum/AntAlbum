package ssafy.antalbum.dto;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import lombok.Getter;
import ssafy.antalbum.entity.travel.Travel;

@Getter
public class TravelDto {

    private Long id;
    private String title;
    private String description;
    private String duration;
    private String thumbnail;

    public TravelDto(Travel travel, List<String> duration) {
        this.id = travel.getId();
        this.title = travel.getTitle();
        this.description = travel.getDescription();
        this.duration = convertDuration(duration);
        this.thumbnail = travel.getThumbnail();
    }

    private String convertDuration(List<String> duration) {
        if (duration.size() == 0) return "No dates";

        Format formatter = new SimpleDateFormat("MMM.yyyy", Locale.ENGLISH);
        String first = formatter.format(duration.get(0));
        String last = formatter.format(duration.get(duration.size() - 1));
        return String.format("%s ~ %s", first, last);
      }

}
