package ssafy.antalbum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssafy.antalbum.entity.travel.Travel;
import ssafy.antalbum.repository.TravelRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;

    @Transactional
    public Long create(Travel travel) {
        travelRepository.save(travel);
        return travel.getId();
    }

}
