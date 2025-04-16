package com.app.bookingservice.service;



import com.app.bookingservice.domain.BookingStatus;
import com.app.bookingservice.modal.Booking;
import com.app.bookingservice.modal.PaymentOrder;
import com.app.bookingservice.modal.SalonReport;
import com.app.bookingservice.payload.dto.SalonDTO;
import com.app.bookingservice.payload.dto.ServiceOfferingDTO;
import com.app.bookingservice.payload.dto.UserDTO;
import com.app.bookingservice.payload.request.BookingRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {


    Booking createBooking(
            BookingRequest booking,
            UserDTO user,
            SalonDTO salon,
            Set<ServiceOfferingDTO> serviceOfferingSet) throws Exception;


    List<Booking> getBookingsByCustomer(Long customerId);


    List<Booking> getBookingsBySalon(Long salonId);


    Booking getBookingById(Long bookingId);

    Booking bookingSucess(PaymentOrder order);


    Booking updateBookingStatus(Long bookingId, BookingStatus status) throws Exception;

    SalonReport getSalonReport(Long salonId);

    List<Booking> getBookingsByDate(LocalDate date,Long salonId);
}
