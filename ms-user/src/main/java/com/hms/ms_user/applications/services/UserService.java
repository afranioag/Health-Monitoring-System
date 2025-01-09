package com.hms.ms_user.applications.services;

import com.hms.ms_user.applications.dtos.UserDto;
import com.hms.ms_user.domain.entities.User;
import com.hms.ms_user.domain.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(UserDto userDto) {
        User user = userDto.getUser();
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
