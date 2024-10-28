package com.antonspring.ordering_system.service.impl;

import com.antonspring.ordering_system.service.OrderMessageSender;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSenderImpl implements OrderMessageSender {

    private final JmsTemplate jmsTemplate;

    public OrderMessageSenderImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendOrderMessage(String order) {
        jmsTemplate.convertAndSend("order.queue", order);
        System.out.println("Order skickad: " + order);
    }
}