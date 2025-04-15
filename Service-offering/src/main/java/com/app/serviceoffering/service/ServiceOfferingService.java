package com.app.serviceoffering.service;


import com.app.serviceoffering.modal.ServiceOffering;
import com.app.serviceoffering.payload.dto.CategoryDTO;
import com.app.serviceoffering.payload.dto.SalonDTO;
import com.app.serviceoffering.payload.dto.ServiceDTO;

import java.util.Set;

public interface ServiceOfferingService {


    ServiceOffering createService(
            ServiceDTO service,
            SalonDTO salon,
            CategoryDTO category
    );

    ServiceOffering updateService(
            Long serviceId,
            ServiceOffering service
    ) throws Exception;

    Set<ServiceOffering> getAllServicesBySalonId(Long salonId,Long categoryId);

    ServiceOffering getServiceById(Long serviceId);

    Set<ServiceOffering> getServicesByIds(Set<Long> ids);
}
