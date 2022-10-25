package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment extends BaseEntity {

    private BigDecimal amount;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentDetailId")
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

    public Payment(BigDecimal amount, LocalDate createdDate, Status paymentStatus) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
    }
}
