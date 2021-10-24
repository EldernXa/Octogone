package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }
}
