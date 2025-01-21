package com.hms.ms_patients.infrastructure.messaging.consumer;
import com.hms.ms_patients.application.dtos.BasicUserDto;
import com.hms.ms_patients.domain.services.BasicUserService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventConsumer {

    @Autowired
    private BasicUserService basicUserService;

    @RabbitListener(queues = "hms.basic-user.queue")
    public void handleMessage(BasicUserDto basicUserDto) {

        basicUserService.registerUser(basicUserDto);
    }
}