package com.gominlog.gominlog.service;

import com.gominlog.gominlog.domain.User;
import com.gominlog.gominlog.dto.UserJoinDto;
import com.gominlog.gominlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(UserJoinDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .build();

        userRepository.save(user);
    }
}
