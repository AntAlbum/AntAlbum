package ssafy.antalbum.repository;

import jakarta.persistence.EntityManager;
import java.util.List;
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

    public void updateWithPhotosAndAdventures(Travel travel) {
        em.persist(travel);
    }

    public List<Travel> findAllTravelsWithUser(Long userId) {
        return em.createQuery(
                        "select t from Travel t where t.id in " +
                                "(select t2.travel.id from Tag t2" +
                                " where t2.user.id = :userId)", Travel.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<String> findTravelDuration(Long travelId) {
        return em.createQuery(
                "select a.date from AdventureDate a" +
                        " where a.travel.id = :travelId" +
                        " order by a.date", String.class)
                .setParameter("travelId", travelId)
                .getResultList();
    }

}
