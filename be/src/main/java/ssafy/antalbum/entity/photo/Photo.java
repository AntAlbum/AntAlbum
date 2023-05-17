package ssafy.antalbum.entity.photo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ssafy.antalbum.entity.travel.Travel;

@Entity
public class Photo {

    @Id @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @Embedded
    private Metadata metadata;

    private String url;

}
