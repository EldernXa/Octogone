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

    @Basic(optional = false)
    @Min(1)
    @Max(6)
    private int duration;

    public static final int MAX_DURATION = 6;

    @ManyToOne
    Room room;

    public Reservation(Room room, String email, LocalDateTime startDateTime, int duration) {
        this.email = email;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.room = room;
    }

    /**
     * Retourne la date de fin d'une reservation
     * @param startDateTime date du début de la reservation
     * @param duration durée de la reservation
     * @return date de fin
     */
    public static LocalDateTime getEndDateTime(LocalDateTime startDateTime, int duration) {
        return DateUtils.addMinutes(startDateTime, duration * 30L);
    }

    /**
     * Retourne vrai si deux reservations se chevauchent
     * @param r1 reservation 1
     * @param r2 reservation 2
     * @return vrai/faux
     */
    public static boolean isOverlapping(Reservation r1, Reservation r2) {
        return DateUtils.isOverlapping(r1.getStartDateTime(), r1.getEndDateTime(), r2.getStartDateTime(), r2.getEndDateTime());
    }

    /**
     * Retorune vrai si une reservation tiers chevauchent l'instance en cours
     * @param r reservation tiers
     * @return vrai/faux
     */
    public boolean isOverlapping(Reservation r) {
        return isOverlapping(this, r);
    }

    /**
     * Retourne la date de fin de l'instance de la reservation en cours
     * @return date de fin
     */
    public LocalDateTime getEndDateTime() {
        return getEndDateTime(getStartDateTime(), getDuration());
    }

    @PrePersist
    public void verifyConstraint() throws PersistenceException {
        int minute = getStartDateTime().getMinute();
        if ( minute > 0 && minute != 30) {
            throw new PersistenceException("invalid start time: only hh:00 or hh:30 are accepted");
        }

        if (getEndDateTime().isBefore(LocalDateTime.now())) {
            throw new PersistenceException("invalid end datetime: cannot book with an end date in the past");
        }
    }
}
