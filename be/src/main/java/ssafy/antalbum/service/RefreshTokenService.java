package ssafy.antalbum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssafy.antalbum.entity.user.RefreshToken;
import ssafy.antalbum.repository.RefreshTokenRepository;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }

}
