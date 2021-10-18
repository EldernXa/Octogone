package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

import fr.hexagone.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomController roomController;

    @PostConstruct
    public void init(){
        if(reservationRepository.count() == 0){
            reservationRepository.save(new Reservation(roomController.getRoom("H1"), "first@email.fr", LocalDateTime.now(), 2));
            reservationRepository.save(new Reservation(roomController.getRoom("H2"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    15,0
            ), 2));
            reservationRepository.save(new Reservation(roomController.getRoom("H3"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    12,0
            ), 2));
        }

    }

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    // String email, LocalDateTime startDateTime, int duration

}
