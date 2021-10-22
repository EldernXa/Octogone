package fr.hexagone.model;

import fr.hexagone.utility.DateUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
public @Data @NoArgsConstructor class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    public Reservation(Room room, String email, LocalDateTime startDateTime, int duration) {
        this.email = email;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.room = room;
    }

    public static LocalDateTime getEndDateTime(LocalDateTime startDateTime, int duration) {
        return DateUtils.addMinutes(startDateTime, duration * 30L);
    }

    public LocalDateTime getEndDateTime() {
        return getEndDateTime(getStartDateTime(), getDuration());
    }
}
