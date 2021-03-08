package com.spp.gym_network.mainservice.service.email.service;

import com.spp.gym_network.mainservice.service.email.context.AbstractEmailContext;

import javax.mail.MessagingException;


public interface EmailService {

    void sendMail(final AbstractEmailContext email) throws MessagingException;
}
