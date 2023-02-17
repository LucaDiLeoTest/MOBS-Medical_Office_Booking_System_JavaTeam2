package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private long id;

    @Column(name = "booking_start_time")
    private LocalDateTime startingTime;

    @Column(name = "booking_end_time")
    private LocalDateTime endingTime;

}
