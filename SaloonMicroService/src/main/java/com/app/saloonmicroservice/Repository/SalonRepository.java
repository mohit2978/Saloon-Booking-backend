package com.app.saloonmicroservice.Repository;

import com.app.saloonmicroservice.Modal.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Long> {
}
