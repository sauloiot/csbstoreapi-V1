package com.ghost.csbstoreapi.services;

import com.ghost.csbstoreapi.models.purchase.PaymentSlip;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class SlipService {
    public void fillPaymentSlip(PaymentSlip paymentSlip, Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        paymentSlip.setExpireDate(calendar.getTime());

    }
}
