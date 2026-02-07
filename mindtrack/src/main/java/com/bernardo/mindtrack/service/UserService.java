package com.bernardo.mindtrack.service;

import com.bernardo.mindtrack.dto.UserCreateRequest;
import com.bernardo.mindtrack.dto.UserResponse;
import com.bernardo.mindtrack.model.User;
import com.bernardo.mindtrack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse create(UserCreateRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        User saved = userRepository.save(user);

        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail());
    }
}
