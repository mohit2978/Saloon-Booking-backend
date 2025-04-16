package com.app.bookingservice.modal;

import com.app.bookingservice.domain.PaymentMethod;
import com.app.bookingservice.domain.PaymentOrderStatus;
import lombok.Data;

@Data
public class PaymentOrder {
    private Long id;

    private Long amount;

    private PaymentOrderStatus status;

    private PaymentMethod paymentMethod;

    private String paymentLinkId;

    private Long userId;

    private Long bookingId;
}
