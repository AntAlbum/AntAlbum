package ssafy.antalbum.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import ssafy.antalbum.entity.Attraction;
import ssafy.antalbum.entity.QAttraction;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AttractionRepositoryCustomImpl implements AttractionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    QAttraction attraction = QAttraction.attraction;


    @Override
    public List<Attraction> findByCondition(int sidoCode, int contentTypeId, String keyword) {
        return jpaQueryFactory.selectFrom(attraction)
                .where(
                        eqSidoCode(sidoCode),
                        eqContentTypeId(contentTypeId),
                        eqKeyword(keyword)
                )
                .orderBy(attraction.readCount.desc())
                .limit(100)
                .fetch();
    }

    private BooleanExpression eqSidoCode(int sidoCode) {
        return sidoCode == 0? null : attraction.sido.sidoCode.eq(sidoCode);
    }

    private BooleanExpression eqContentTypeId(int contentTypeId) {
        return contentTypeId == 0 ? null : attraction.contentTypeId.eq(contentTypeId);
    }

    private BooleanExpression eqKeyword(String keyword) {
        return StringUtils.hasText(keyword)? attraction.title.contains(keyword): null;
    }
}