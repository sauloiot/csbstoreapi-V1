package com.ghost.csbstoreapi.services.Email;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractMailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendBuyOrderConfirmationEmail(BuyOrder obj){
        SimpleMailMessage smg = prepareSimpleMailMessageFromBuyOrder(obj);
        sendEmail(smg);

    }

    protected SimpleMailMessage prepareSimpleMailMessageFromBuyOrder(BuyOrder obj) {
        SimpleMailMessage smg = new SimpleMailMessage();
        smg.setTo(obj.getClient().getEmail());
        smg.setFrom(sender);
        smg.setSubject("Order confirmed, code: " + obj.getId());
        smg.setSentDate(new Date(System.currentTimeMillis()));
        smg.setText(obj.toString());
        return smg;
    }

}
