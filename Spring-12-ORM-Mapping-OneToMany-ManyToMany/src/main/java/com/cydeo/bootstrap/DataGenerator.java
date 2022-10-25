package com.cydeo.bootstrap;

import com.cydeo.entity.Payment;
import com.cydeo.entity.PaymentDetail;
import com.cydeo.enums.Status;
import com.cydeo.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

   private final PaymentRepository paymentRepository;

    public DataGenerator(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(new BigDecimal("150000"), LocalDate.of(2022, 10, 18), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("10000"), new BigDecimal("140000"), LocalDate.of(2022, 10, 22));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(new BigDecimal("120000"), LocalDate.of(2022, 9, 23), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("8500"), new BigDecimal("136000"), LocalDate.of(2022, 9, 19));

        payment2.setPaymentDetail(paymentDetail2);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}
