package ssafy.antalbum.domain.attraction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attraction_info")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private int contentId; // info / description / detail

    @Column(name = "content_type_id")
    private int contentTypeId;

    @Column(name = "title")
    private String title;

    @Column(name = "addr1")
    private String addr1;

    @Column(name = "addr2")
    private String addr2;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "tel")
    private String tel;

    @Column(name = "first_image")
    private String firstImage;

    @Column(name = "first_image2")
    private String firstImage2;

    @Column(name = "readcount")
    private int readCount;

    @ManyToOne
    @JoinColumn(name = "sido_code")
    private Sido sido;

    @Column(name = "gugun_code")
    private int gugunCode;

    @Column(name = "latitude", precision = 20, scale = 17)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 20, scale = 17)
    private BigDecimal longitude;

    @Column(name = "mlevel")
    private String mlevel;

}
