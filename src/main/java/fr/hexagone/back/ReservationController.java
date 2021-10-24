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

    @Autowired
    RoomController roomController;

    @Autowired
    HexagoneController hexaController;

    @PostConstruct
    public void init(){
        //reservationRepository.deleteAll();
        if(reservationRepository.count() == 0){
            //reservationRepository.save(new Reservation(roomController.getRoom("H1"), "first@email.fr", LocalDateTime.now(), 2));
            reservationRepository.save(new Reservation(roomController.getRoom("H2"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    LocalDateTime.now().getHour(),30
            ), 2));
            reservationRepository.save(new Reservation(roomController.getRoom("H2"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    LocalDateTime.now().getHour() + 1,0
            ), 3));
            reservationRepository.save(new Reservation(roomController.getRoom("H3"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    LocalDateTime.now().getHour() + 2,0
            ), 5));
        }

        for (Reservation r : hexaController.getListReservationOfARoom(roomController.getRoom("H2"))){
            System.out.println(r.getId() + " " + r.getRoom().getName());
            System.out.println(r.getStartDateTime().getHour() + ":" + r.getStartDateTime().getMinute() + " " + r.getDuration() + " --- "+
                    r.getEndDateTime().getHour() + ":" + r.getEndDateTime().getMinute());
        }

        Reservation r = hexaController.getListReservationOfARoom(roomController.getRoom("H2")).get(0);

        LocalDateTime localDateTime = LocalDateTime.of(r.getStartDateTime().getYear(),
                r.getStartDateTime().getMonth(),r.getStartDateTime().getDayOfMonth(),
                r.getStartDateTime().getHour(),r.getStartDateTime().getMinute());

        for(Map.Entry<Room, Availability> mapEntry : hexaController.listAvailabilityRoom(localDateTime, 2, 8).entrySet()){
            System.out.println(mapEntry.getKey().getName() + " " + mapEntry.getValue());
        }
    }

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }
}
