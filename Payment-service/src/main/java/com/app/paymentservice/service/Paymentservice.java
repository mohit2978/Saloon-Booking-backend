package com.app.paymentservice.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.app.paymentservice.domain.PaymentMethod;
import com.app.paymentservice.modal.PaymentOrder;
import com.app.paymentservice.payload.dto.BookingDTO;
import com.app.paymentservice.payload.dto.UserDTO;
import com.app.paymentservice.payload.response.PaymentLinkResponse;
import com.stripe.exception.StripeException;

public interface Paymentservice {

    PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod) throws RazorpayException, StripeException;

    PaymentOrder getPaymentOrderById(Long id);

    PaymentOrder getPaymentOrderByPaymentId(String paymentId);

    PaymentLink createRazorpayPaymentLink(UserDTO user, Long Amount, Long orderId) throws RazorpayException;

    String createStripePaymentLink(UserDTO user,Long Amount,Long orderId) throws StripeException;

}
