package ssafy.antalbum.entity.photo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.antalbum.entity.travel.Travel;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Photo {

    @Id @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @Embedded
    private PhotoMeta photoMeta;

    @Embedded
    private PhotoPath photoPath;

    @Builder
    public Photo(PhotoMeta photoMeta, PhotoPath photoPath) {
        this.photoMeta = photoMeta;
        this.photoPath = photoPath;
    }

    public static Photo createPhoto(PhotoMeta photoMeta, PhotoPath photoPath) {
        return Photo.builder().photoMeta(photoMeta).photoPath(photoPath).build();
    }

    public void assignTravel(Travel travel) {
        this.travel = travel;
    }

}
