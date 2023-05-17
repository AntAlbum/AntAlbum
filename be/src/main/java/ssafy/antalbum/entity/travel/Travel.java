package ssafy.antalbum.entity.travel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.antalbum.entity.adventure.Adventure;
import ssafy.antalbum.entity.photo.Photo;
import ssafy.antalbum.entity.tag.Tag;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Travel {

    @Id @GeneratedValue
    @Column(name = "travel_id")
    private Long id;

    private int area_level;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TravelStatus travelStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "travel")
    private List<Tag> tags;

    @JsonIgnore
    @OneToMany(mappedBy = "travel")
    private List<Photo> photos;

    @OneToMany(mappedBy = "travel")
    private List<Adventure> adventures;

    private String thumbnail;

}
