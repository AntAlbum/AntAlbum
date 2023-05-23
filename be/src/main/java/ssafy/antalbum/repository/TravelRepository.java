package ssafy.antalbum.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ssafy.antalbum.entity.travel.Travel;

@Repository
@RequiredArgsConstructor
public class TravelRepository {

    private final EntityManager em;

    public void save(Travel travel) {
        em.persist(travel);
    }

    public Travel findOne(Long id) {
        return em.find(Travel.class, id);
    }

}
