package com.hms.ms_patients.domain.repositories;

import com.hms.ms_patients.domain.model.entities.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BasicUserRepository extends JpaRepository<BasicUser, UUID> {
}
