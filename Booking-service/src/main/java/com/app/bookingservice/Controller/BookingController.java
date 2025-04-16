package com.app.bookingservice.Controller;


import com.app.bookingservice.Mapper.BookingMapper;
import com.app.bookingservice.domain.BookingStatus;
import com.app.bookingservice.domain.PaymentMethod;
import com.app.bookingservice.modal.Booking;
import com.app.bookingservice.modal.SalonReport;
import com.app.bookingservice.payload.dto.*;
import com.app.bookingservice.payload.request.BookingRequest;
import com.app.bookingservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;



    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestParam Long salonId,
            @RequestParam PaymentMethod paymentMethod,
            @RequestBody BookingRequest bookingRequest) throws Exception {


        UserDTO user = new UserDTO();
        user.setId(1L);

        SalonDTO salon =new SalonDTO();
        salon.setId(1L);

        if(salon.getId()==null){
            throw new Exception("Salon not found");
        }

        Set<ServiceOfferingDTO> services = new HashSet<>();

        ServiceOfferingDTO serviceOfferingDTO = new ServiceOfferingDTO();
        serviceOfferingDTO.setId(1L);
        serviceOfferingDTO.setPrice(399);
        serviceOfferingDTO.setDuration(45);
        serviceOfferingDTO.setName("HairCut");
        services.add(serviceOfferingDTO);


        Booking createdBooking = bookingService.createBooking(
                bookingRequest,
                user,
                salon,
                services
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);

    }

    /**
     * Get all bookings for a customer
     */
    @GetMapping("/customer")
    public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer()
    {

        UserDTO user = new UserDTO();
        user.setId(1L);
        List<Booking> bookings = bookingService.getBookingsByCustomer(user.getId());
        return ResponseEntity.ok(getBookingDTOs(bookings));

    }

    /**
     * Get all bookings for a salon
     */
    @GetMapping("/report")
    public ResponseEntity<SalonReport> getSalonReport() throws Exception {

        SalonDTO salon =new SalonDTO();
        salon.setId(1L);

        SalonReport report = bookingService.getSalonReport(salon.getId());

        return ResponseEntity.ok(report);

    }

    @GetMapping("/salon")
    public ResponseEntity<Set<BookingDTO>> getBookingsBySalon () throws Exception {

        UserDTO user = new UserDTO();
        user.setId(1L);

        SalonDTO salon =new SalonDTO();
        salon.setId(1L);


        List<Booking> bookings = bookingService.getBookingsBySalon(salon.getId());

        return ResponseEntity.ok(getBookingDTOs(bookings));


    }



    private Set<BookingDTO> getBookingDTOs(List<Booking> bookings) {

        return bookings.stream()
                .map(booking -> { return BookingMapper.toDTO(booking);})
                .collect(Collectors.toSet());
    }

    /**
     * Get a booking by its ID
     */
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        BookingDTO bookingDTO=BookingMapper.toDTO(booking);
        return ResponseEntity.ok(bookingDTO);
    }

    /**
     * Update the status of a booking
     */
    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookingDTO> updateBookingStatus(
            @PathVariable Long bookingId,
            @RequestParam BookingStatus status) throws Exception {



        Booking updatedBooking = bookingService.updateBookingStatus(bookingId, status);

        BookingDTO bookingDTO=BookingMapper.toDTO(updatedBooking);

        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);

    }

    @GetMapping("/slots/salon/{salonId}/date/{date}")
    public ResponseEntity<List<BookedSlotsDTO>> getBookedSlots (@PathVariable Long salonId,
            @PathVariable LocalDate date) {
        List<Booking> bookings = bookingService.getBookingsByDate(date,salonId);
        List<BookedSlotsDTO> slotsDTOS = bookings.stream()
                .map(booking -> {
                    BookedSlotsDTO slotDto = new BookedSlotsDTO();

                    slotDto.setStartTime(booking.getStartTime());
                    slotDto.setEndTime(booking.getEndTime());
                    return slotDto;
                })
                .toList();


        return ResponseEntity.ok(slotsDTOS);


    }
}
