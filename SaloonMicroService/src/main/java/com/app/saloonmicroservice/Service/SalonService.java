package com.app.saloonmicroservice.Service;

import com.app.saloonmicroservice.Modal.Salon;

public interface SalonService {

    Salon createSalon(SalonDTO salon, UserDTO user);
}
