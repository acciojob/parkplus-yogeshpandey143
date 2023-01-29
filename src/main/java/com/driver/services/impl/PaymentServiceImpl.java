package com.driver.services.impl;

import com.driver.model.Payment;
import com.driver.model.PaymentMode;
import com.driver.model.Reservation;
import com.driver.model.Spot;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
        Reservation reservation = reservationRepository2.findById(reservationId).get();
        Spot spot = reservation.getSpot();
        int bill = reservation.getNumberOfHours()*spot.getPricePerHour();
        if(bill>amountSent){
            throw new Exception("Insufficient Amount");
        }

        boolean check = false;

        if(mode.equalsIgnoreCase("cash")
                || mode.equalsIgnoreCase("card")
                || mode.equalsIgnoreCase("upi")){
            check = true;
        }
        //}
        if(!check){
            throw new Exception("Payment mode not detected");
        }


        Payment payment = new Payment();

        if(mode.equalsIgnoreCase("cash")){
            payment.setPaymentMode(PaymentMode.CASH);
        }
        else if(mode.equalsIgnoreCase("card")){
            payment.setPaymentMode(PaymentMode.CARD);
        }
        else if(mode.equalsIgnoreCase("upi")){
            payment.setPaymentMode(PaymentMode.UPI);
        }

        payment.setPaymentCompleted(true);

        reservation.setPayment(payment);

        reservationRepository2.save(reservation);
        return payment;
    }
}
