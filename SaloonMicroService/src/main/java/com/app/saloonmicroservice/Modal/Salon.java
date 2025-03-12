package com.app.saloonmicroservice.Modal;
import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false)
    private String name;

    @ElementCollection
    private List<String> images;

    @Column( nullable = false)
    private String address;

    @Column( nullable = false)
    private String phone;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String city;

    @Column( nullable = false)
    private Long ownerId;

    @Column( nullable = false)
    private LocalTime openTime;

    @Column( nullable = false)
    private LocalTime closeTime;
}
