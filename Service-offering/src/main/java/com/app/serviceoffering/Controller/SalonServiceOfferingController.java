package com.app.serviceoffering.Controller;


import com.app.serviceoffering.modal.ServiceOffering;
import com.app.serviceoffering.payload.dto.CategoryDTO;
import com.app.serviceoffering.payload.dto.SalonDTO;
import com.app.serviceoffering.payload.dto.ServiceDTO;
import com.app.serviceoffering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;


    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO service) throws Exception {

        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(1L);

       CategoryDTO categoryDTO = new CategoryDTO();
       categoryDTO.setId(service.getCategory());

        ServiceOffering createdService = serviceOfferingService
                .createService(service,salonDTO,categoryDTO);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @PatchMapping("/{serviceId}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long serviceId,
            @RequestBody ServiceOffering service) throws Exception {
        ServiceOffering updatedService = serviceOfferingService
                .updateService(serviceId, service);
        if (updatedService != null) {
            return new ResponseEntity<>(updatedService, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
