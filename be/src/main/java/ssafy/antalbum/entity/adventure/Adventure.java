package ssafy.antalbum.entity.adventure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import ssafy.antalbum.entity.comment.Comment;
import ssafy.antalbum.entity.like.Like;
import ssafy.antalbum.entity.travel.Travel;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
public abstract class Adventure {

    @Id @GeneratedValue
    @Column(name = "adventure_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private String thumbnail;

    public void assignTravel(Travel travel) {
        this.travel = travel;
    }

    public void assignThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
