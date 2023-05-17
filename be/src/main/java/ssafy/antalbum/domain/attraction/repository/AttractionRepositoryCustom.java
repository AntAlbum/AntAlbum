package ssafy.antalbum.domain.attraction.repository;

import ssafy.antalbum.domain.attraction.entity.Attraction;

import java.util.List;

public interface AttractionRepositoryCustom {

    List<Attraction> findByCondition(int sidoCode, int contentTypeId, String keyword);
}
