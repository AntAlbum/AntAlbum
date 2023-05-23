package ssafy.antalbum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssafy.antalbum.entity.Attraction;

import java.util.List;

public interface AttractionRepositsory extends JpaRepository<Attraction, Long>, AttractionRepositoryCustom {

    List<Attraction> findTop100ByOrderByReadCountDesc();

}