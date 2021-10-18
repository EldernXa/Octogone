package fr.hexagone.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id = 0;

    @Basic(optional = false)
    @Email
    private String email;

    @Basic(optional = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDateTime;

    // Duration in multiple of 30 minutes (1 = 30 min, 6 = 30 min x 6 = 3 hours)
    @Basic(optional = false)
    @Min(1)
    @Max(6)
    private int duration;


    @ManyToOne
    Room room;

    public Reservation() {
    }

    public Reservation(Room room, String email, LocalDateTime startDateTime, int duration) {
        this.email = email;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.room = room;

    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }


    public int getDuration() {
        return duration;
    }

    public Room getRoom() {
        return room;
    }
}
