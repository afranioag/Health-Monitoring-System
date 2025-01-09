package com.hms.ms_devices.applications.dots;

import com.hms.ms_devices.domain.entities.Device;
import com.hms.ms_devices.shared.enums.DeviceStatus;
import com.hms.ms_devices.shared.enums.DeviceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DeviceDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String deviceName;
    private String deviceCode;
    @Enumerated(EnumType.STRING)
    private DeviceType type;
    private String unit;
    @Enumerated(EnumType.STRING)
    private DeviceStatus status;
    private String manufacturer;
    private String model;

    public Device createDevice() {
        return Device
                .builder()
                .deviceName(deviceName)
                .deviceCode(deviceCode)
                .type(type)
                .unit(unit)
                .status(status)
                .manufacturer(manufacturer)
                .model(model)
                .build();
    }
}
