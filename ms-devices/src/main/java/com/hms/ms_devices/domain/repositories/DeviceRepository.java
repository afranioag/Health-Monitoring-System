package com.hms.ms_devices.domain.repositories;

import com.hms.ms_devices.domain.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
