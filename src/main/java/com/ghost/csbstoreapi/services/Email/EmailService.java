package com.ghost.csbstoreapi.services.Email;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import org.springframework.mail.SimpleMailMessage;


public interface EmailService {

    void sendBuyOrderConfirmationEmail(BuyOrder obj);

    void sendEmail(SimpleMailMessage msg);

}

