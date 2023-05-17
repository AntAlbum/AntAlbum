package ssafy.antalbum.domain.attraction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssafy.antalbum.domain.attraction.dto.SearchCondition;
import ssafy.antalbum.domain.attraction.entity.Attraction;
import ssafy.antalbum.domain.attraction.repository.AttractionRepositsory;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttractionService {

    private final AttractionRepositsory attractionRepository;

    public List<Attraction> findAll() {
        return attractionRepository.findAll();
    }

    public List<Attraction> findByCondition(SearchCondition searchCondition) {
        int sidoCode = searchCondition.getSidoCode();
        int contentTypeId = searchCondition.getContentTypeId();
        String keyword = searchCondition.getKeyword();

        return attractionRepository.findByCondition(sidoCode, contentTypeId, keyword);
    }

//    public Attraction findByContentId(int )


}