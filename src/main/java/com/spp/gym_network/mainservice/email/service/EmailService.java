package com.spp.gym_network.mainservice.email.service;

import com.spp.gym_network.mainservice.email.context.AbstractEmailContext;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;


public interface EmailService {

    void sendMail(final AbstractEmailContext email) throws MessagingException;
}
