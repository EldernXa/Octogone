package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }
}
