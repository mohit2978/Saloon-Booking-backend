package com.app.saloonmicroservice.Implemenatation;

import com.app.saloonmicroservice.Modal.Salon;
import com.app.saloonmicroservice.Repository.SalonRepository;
import com.app.saloonmicroservice.Service.SalonService;
import com.app.saloonmicroservice.payload.DTO.SalonDTO;
import com.app.saloonmicroservice.payload.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDTO req, UserDTO user) {
        Salon salon = new Salon();
        salon.setAddress(req.getAddress());
        salon.setPhone(req.getPhone());
        salon.setName(req.getName());
        salon.setEmail(req.getEmail());
        salon.setOwnerId(user.getId());
        salon.setCity(req.getCity());
        salon.setImages(req.getImages());
        salon.setOpenTime(req.getOpenTime());
        salon.setCloseTime(req.getCloseTime());
        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonid) throws Exception {
        Salon existingSalon = salonRepository.findById(salonid).orElse(null);
        if (existingSalon != null && existingSalon.getOwnerId().equals(user.getId())) {
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setPhone(salon.getPhone());
            existingSalon.setName(salon.getName());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setOwnerId(user.getId());
            existingSalon.setCity(salon.getCity());
            existingSalon.setImages(salon.getImages());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());
            return salonRepository.save(existingSalon);
        }
        throw new Exception("Salon not Exist");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonid) throws Exception {
        Salon salon= salonRepository.findById(salonid).orElse(null);
        if(salon == null){
            throw new Exception("Salon not exist");
        }
        return salon;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> getSalonsByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
