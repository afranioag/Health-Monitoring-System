package com.hms.ms_user.infraestructure.messaging.producer;

import com.hms.ms_user.applications.dtos.BasicUserDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void updateBasicUser(BasicUserDto message) {
        rabbitTemplate.convertAndSend("hms.user.exchange", "", message);
    }
}
