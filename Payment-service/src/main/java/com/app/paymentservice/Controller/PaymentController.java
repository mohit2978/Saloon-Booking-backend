package com.app.paymentservice.Controller;

import com.app.paymentservice.domain.PaymentMethod;
import com.app.paymentservice.modal.PaymentOrder;
import com.app.paymentservice.payload.dto.BookingDTO;
import com.app.paymentservice.payload.dto.UserDTO;
import com.app.paymentservice.payload.response.PaymentLinkResponse;
import com.app.paymentservice.service.Paymentservice;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final Paymentservice paymentService;



    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(
           // @RequestHeader("Authorization") String jwt,
            @RequestBody BookingDTO booking,
            @RequestParam PaymentMethod paymentMethod) throws ExecutionControl.UserException,
            RazorpayException, StripeException {

        System.out.println("------"+booking);

       // UserDTO user = userService.getUserFromJwtToken(jwt).getBody();
        UserDTO user=new UserDTO();
        user.setEmail("abcd@gmail.com");
        user.setId(1L);
        user.setFullName("Abcd");
        PaymentLinkResponse paymentLinkResponse = paymentService
                .createOrder(user, booking, paymentMethod);

        return ResponseEntity.ok(paymentLinkResponse);
    }

    @GetMapping("/{paymentOrderId}")
    public ResponseEntity<PaymentOrder> getPaymentOrderById(
            @PathVariable Long paymentOrderId) {
        try {
            PaymentOrder paymentOrder = paymentService.getPaymentOrderById(paymentOrderId);
            return ResponseEntity.ok(paymentOrder);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/proceed")
    public ResponseEntity<Boolean> proceedPayment(
            @RequestParam String paymentId,
            @RequestParam String paymentLinkId) throws Exception {

        PaymentOrder paymentOrder = paymentService.
                getPaymentOrderByPaymentId(paymentLinkId);
        Boolean success = paymentService.ProceedPaymentOrder(
                paymentOrder,
                paymentId, paymentLinkId);
        return ResponseEntity.ok(true);

    }


}
