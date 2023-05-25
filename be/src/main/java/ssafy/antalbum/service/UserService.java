package ssafy.antalbum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ssafy.antalbum.dto.AddUserRequest;
import ssafy.antalbum.dto.ModifyUserRequest;
import ssafy.antalbum.entity.user.User;
import ssafy.antalbum.repository.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long save(AddUserRequest dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    public User modifyUser(Long userId, ModifyUserRequest modifyUserRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
        user.setNickname(modifyUserRequest.getNickname());
        user.setProfile(modifyUserRequest.getProfile());
        user.setComment(modifyUserRequest.getComment());

        return userRepository.save(user);

    }


}
