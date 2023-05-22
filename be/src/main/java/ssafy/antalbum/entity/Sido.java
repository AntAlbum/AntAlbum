package ssafy.antalbum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "sido")
public class Sido {

    @Id
    @Column(name = "sido_code")
    private int sidoCode;

    @Column(name = "sido_name")
    private String sidoName;

}

