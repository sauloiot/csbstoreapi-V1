package com.ghost.csbstoreapi.services.Email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public class MockEmailService extends AbstractMailService{
    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Email send simulation");
        LOG.info(msg.toString());
        LOG.info("Email Sent");

    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("HTML email send simulation");
        LOG.info(msg.toString());
        LOG.info("Email Sent");
    }
}
