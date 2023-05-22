package ssafy.antalbum.repository;

import ssafy.antalbum.entity.Attraction;

import java.util.List;

public interface AttractionRepositoryCustom {

    List<Attraction> findByCondition(int sidoCode, int contentTypeId, String keyword);
}
