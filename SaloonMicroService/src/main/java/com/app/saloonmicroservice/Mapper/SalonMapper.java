package com.app.saloonmicroservice.Mapper;

import com.app.saloonmicroservice.Modal.Salon;
import com.app.saloonmicroservice.payload.DTO.SalonDTO;

public class SalonMapper {

    public static SalonDTO mapToSalonDTO(Salon salon) {
        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(salon.getId());
        salonDTO.setName(salon.getName());
        salonDTO.setAddress(salon.getAddress());
        salonDTO.setCity(salon.getCity());
        salonDTO.setImages(salon.getImages());
        salonDTO.setCloseTime(salon.getCloseTime());
        salonDTO.setOpenTime(salon.getOpenTime());
        salonDTO.setOwnerId(salon.getOwnerId());
        salonDTO.setPhone(salon.getPhone());
        return salonDTO;

    }
}
