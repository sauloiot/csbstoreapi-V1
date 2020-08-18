package com.ghost.csbstoreapi.services.Email;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SmtpEmailService extends AbstractMailService{

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Email send simulation");
        LOG.info(msg.toString());
        mailSender.send(msg);
        LOG.info("Email Sent");


    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Email send simulation");
        LOG.info(msg.toString());
        javaMailSender.send(msg);
        LOG.info("Email Sent");

    }
}
