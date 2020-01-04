package com.rest.mshala.Impl;

import com.rest.mshala.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl<S, B, T> implements MailService<S, B, T> {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Override
    public boolean sendMessage(S subject, B body, T to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject.toString());
        simpleMailMessage.setText(body.toString());
        simpleMailMessage.setTo(to.toString());

        javaMailSender.send(simpleMailMessage);
        return true;
    }
}
