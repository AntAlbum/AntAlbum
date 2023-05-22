package ssafy.antalbum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssafy.antalbum.entity.user.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long userId);

    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
