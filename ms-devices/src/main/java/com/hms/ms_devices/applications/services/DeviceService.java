package com.hms.ms_devices.applications.services;

import com.hms.ms_devices.applications.dots.DeviceDto;
import com.hms.ms_devices.domain.entities.Device;
import com.hms.ms_devices.domain.repositories.DeviceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Transactional
    public Device createDevice(DeviceDto deviceDto) {
        Device device = deviceDto.createDevice();
        return deviceRepository.save(device);
    }

    public Device getId(UUID id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public void deleteDevice(UUID id) {
        if(deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Device not found");
        }
    }
}
