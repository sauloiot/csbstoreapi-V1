package com.ghost.csbstoreapi.services.Email;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public abstract class AbstractMailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

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

    protected String htmlFromTemplateBuyOrder(BuyOrder obj){
        Context context = new Context();
        context.setVariable("buyorder", obj);
        return templateEngine.process("email/buyOrderConfirmation", context);
    }


    @Override
   public void sendOrderConfirmationHtmlEmail(BuyOrder obj){
        try {
            MimeMessage mm = prepareMimeMessageFromBuyOrder(obj);
            sendHtmlEmail(mm);
        }catch (MessagingException e){
            sendBuyOrderConfirmationEmail(obj);
        }
    }

    protected MimeMessage prepareMimeMessageFromBuyOrder(BuyOrder obj) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(obj.getClient().getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Order confirmed, code: " + obj.getId());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateBuyOrder(obj),true);
        return mimeMessage;
    };

}
