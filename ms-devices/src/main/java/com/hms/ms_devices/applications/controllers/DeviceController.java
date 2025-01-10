package com.hms.ms_devices.applications.controllers;

import com.hms.ms_devices.applications.dots.DeviceDto;
import com.hms.ms_devices.applications.services.DeviceService;
import com.hms.ms_devices.domain.entities.Device;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/devices")
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody DeviceDto deviceDto) {
        Device device = deviceService.createDevice(deviceDto);
        return new ResponseEntity<>(device, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable UUID id) {
        return new ResponseEntity<>(deviceService.getId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDeviceById(@PathVariable UUID id) {
        deviceService.deleteDevice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
