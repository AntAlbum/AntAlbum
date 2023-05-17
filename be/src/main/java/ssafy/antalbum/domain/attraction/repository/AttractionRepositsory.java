package ssafy.antalbum.domain.attraction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssafy.antalbum.domain.attraction.entity.Attraction;

public interface AttractionRepositsory extends JpaRepository<Attraction, Long>, AttractionRepositoryCustom {

}