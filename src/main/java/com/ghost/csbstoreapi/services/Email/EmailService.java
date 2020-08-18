package com.ghost.csbstoreapi.services.Email;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;


public interface EmailService {

    void sendBuyOrderConfirmationEmail(BuyOrder obj);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(BuyOrder obj);

    void sendHtmlEmail(MimeMessage msg);

}

