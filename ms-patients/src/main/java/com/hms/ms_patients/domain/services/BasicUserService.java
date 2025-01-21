package com.hms.ms_patients.domain.services;

import com.hms.ms_patients.application.dtos.BasicUserDto;
import com.hms.ms_patients.domain.model.entities.BasicUser;
import com.hms.ms_patients.domain.repositories.BasicUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BasicUserService {

    private final BasicUserRepository basicUserRepository;

    @Transactional
    public void registerUser(BasicUserDto basicUserDto) {
        BasicUser basicUser = basicUserDto.toBasicUser();
        basicUserRepository.save(basicUser);
    }
}
