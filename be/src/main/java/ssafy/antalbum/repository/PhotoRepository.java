package ssafy.antalbum.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ssafy.antalbum.entity.photo.Photo;

@Repository
@RequiredArgsConstructor
public class PhotoRepository {

    private final EntityManager em;

    public void save(Photo photo) {
        em.persist(photo);
    }

}
