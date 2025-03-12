package com.app.saloonmicroservice.Service;

import com.app.saloonmicroservice.Modal.Salon;
import com.app.saloonmicroservice.payload.DTO.SalonDTO;
import com.app.saloonmicroservice.payload.DTO.UserDTO;

import java.util.List;

public interface SalonService {

    // userDTO is user who is owner of salon
    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(SalonDTO salon, UserDTO user,Long salonid);

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonid);

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> getSalonsByCity(String city);
}
