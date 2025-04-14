package com.app.saloonmicroservice.Controller;

import com.app.saloonmicroservice.Mapper.SalonMapper;
import com.app.saloonmicroservice.Modal.Salon;
import com.app.saloonmicroservice.Service.SalonService;
import com.app.saloonmicroservice.payload.DTO.SalonDTO;
import com.app.saloonmicroservice.payload.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon=salonService.createSalon(salonDTO, userDTO);
        SalonDTO res= SalonMapper.mapToSalonDTO(salon);
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/{salonId}")
    public ResponseEntity<SalonDTO> updateSalon(@RequestBody SalonDTO salonDTO,
                                                @PathVariable Long salonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon=salonService.updateSalon(salonDTO,userDTO,salonId);
        SalonDTO res= SalonMapper.mapToSalonDTO(salon);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<SalonDTO>> getsalons() {

        List<Salon> salon=salonService.getAllSalons();
       List<SalonDTO>salonDTOS=salon.stream().map(SalonMapper::mapToSalonDTO).collect(Collectors.toList());
       return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> getsalonById(@PathVariable Long salonId) throws Exception {

        Salon salon=salonService.getSalonById(salonId);
        SalonDTO salonDTO=SalonMapper.mapToSalonDTO(salon);
        return ResponseEntity.ok(salonDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchsalons(
            @RequestParam("city") String city
    ) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        List<Salon> salon=salonService.getSalonsByCity(city);
        List<SalonDTO>salonDTOS=salon.stream().map(SalonMapper::mapToSalonDTO).collect(Collectors.toList());
        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/owner")
    public ResponseEntity<SalonDTO> getsalonByOwnerId() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon=salonService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO=SalonMapper.mapToSalonDTO(salon);
        return ResponseEntity.ok(salonDTO);
    }


}
