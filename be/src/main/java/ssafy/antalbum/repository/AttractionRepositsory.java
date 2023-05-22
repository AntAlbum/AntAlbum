package ssafy.antalbum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssafy.antalbum.entity.Attraction;

public interface AttractionRepositsory extends JpaRepository<Attraction, Long>, AttractionRepositoryCustom {

}