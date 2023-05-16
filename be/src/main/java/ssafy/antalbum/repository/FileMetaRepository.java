package ssafy.antalbum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ssafy.antalbum.entity.FileMeta;

@Repository
public interface FileMetaRepository extends CrudRepository<FileMeta, Integer> {
}
