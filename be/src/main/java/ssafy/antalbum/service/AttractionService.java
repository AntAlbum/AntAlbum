package ssafy.antalbum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssafy.antalbum.dto.SearchCondition;
import ssafy.antalbum.entity.Attraction;
import ssafy.antalbum.repository.AttractionRepositsory;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttractionService {

    private final AttractionRepositsory attractionRepository;

    public List<Attraction> findAll() {
//        return attractionRepository.findAll();
        return attractionRepository.findTop100ByOrderByReadCountDesc();
    }

    public List<Attraction> findByCondition(SearchCondition searchCondition) {
        int sidoCode = searchCondition.getSidoCode();
        int contentTypeId = searchCondition.getContentTypeId();
        String keyword = searchCondition.getKeyword();

        return attractionRepository.findByCondition(sidoCode, contentTypeId, keyword);
    }


}