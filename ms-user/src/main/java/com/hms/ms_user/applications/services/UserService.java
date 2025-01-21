package com.hms.ms_user.applications.services;

import com.hms.ms_user.applications.dtos.BasicUserDto;
import com.hms.ms_user.applications.dtos.UserDto;
import com.hms.ms_user.domain.entities.User;
import com.hms.ms_user.domain.repositories.UserRepository;
import com.hms.ms_user.infraestructure.messaging.producer.UserEventProducer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final UserEventProducer userEventProducer;

    @Transactional
    public User save(UserDto userDto) {
        try {
            User user = userDto.getUser();

            userRepository.saveAndFlush(user);
            userEventProducer.updateBasicUser(new BasicUserDto(user));
            return user;
        } catch (Exception e) {
            log.error("Error saving user", e);
            throw new RuntimeException("Error saving user", e);
        }
}

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
