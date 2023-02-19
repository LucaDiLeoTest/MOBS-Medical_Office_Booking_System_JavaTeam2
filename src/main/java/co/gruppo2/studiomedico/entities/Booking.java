package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private Long id;

    @Column(name = "booking_start_time")
    private LocalDateTime startingTime;

    @Column(name = "booking_end_time")
    private LocalDateTime endingTime;

    public Booking() {
    }

    public Booking(long id, LocalDateTime startingTime, LocalDateTime endingTime) {
        this.id = id;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }
}
