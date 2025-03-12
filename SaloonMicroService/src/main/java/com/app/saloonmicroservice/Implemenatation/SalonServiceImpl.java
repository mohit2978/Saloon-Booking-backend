package com.app.saloonmicroservice.Implemenatation;

import com.app.saloonmicroservice.Modal.Salon;
import com.app.saloonmicroservice.Service.SalonService;
import com.app.saloonmicroservice.payload.DTO.SalonDTO;
import com.app.saloonmicroservice.payload.DTO.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SalonServiceImpl implements SalonService {


    @Override
    public Salon createSalon(SalonDTO salon, UserDTO user) {
        return null;
    }

    @Override
    public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonid) {
        return null;
    }

    @Override
    public List<Salon> getAllSalons() {
        return List.of();
    }

    @Override
    public Salon getSalonById(Long salonid) {
        return null;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<Salon> getSalonsByCity(String city) {
        return List.of();
    }
}
