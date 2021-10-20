package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import fr.hexagone.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class ReservationController {/*

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
            reservationRepository.save(new Reservation(roomController.getRoom("H1"), "first@email.fr", LocalDateTime.now(), 2));
            reservationRepository.save(new Reservation(roomController.getRoom("H2"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    15,0
            ), 2));
            reservationRepository.save(new Reservation(roomController.getRoom("H2"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    18,0
            ), 3));
            reservationRepository.save(new Reservation(roomController.getRoom("H3"), "first@email.fr", LocalDateTime.of(
                    LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),
                    12,0
            ), 5));
        }

        for (Reservation r : hexaController.getListReservationOfARoom(roomController.getRoom("H2"))){
            System.out.println(r.getId() + " " + r.getRoom().getName());
            LocalDateTime l = getTimeAfterDuration(r);
            System.out.println(r.getStartDateTime().getHour() + ":" + r.getStartDateTime().getMinute() + " " + r.getDuration() + " --- "+
                    l.getHour() + ":" + l.getMinute());
        }

        Reservation r = hexaController.getListReservationOfARoom(roomController.getRoom("H2")).get(0);

        LocalDateTime localDateTime = LocalDateTime.of(r.getStartDateTime().getYear(),
                r.getStartDateTime().getMonth(),r.getStartDateTime().getDayOfMonth(),
                r.getStartDateTime().getHour(),r.getStartDateTime().getMinute());

        for(Map.Entry<Room, Availability> mapEntry : hexaController.listAvailabilityRoom(localDateTime, 2).entrySet()){
            System.out.println(mapEntry.getKey().getName() + " " + mapEntry.getValue());
        }
    }

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    public LocalDateTime getTimeAfterDuration(Reservation reservation){
        LocalDateTime actualDateTime = reservation.getStartDateTime();
        int duration = reservation.getDuration();
        return getTimeAfterDuration(actualDateTime, duration);
    }

    public LocalDateTime getTimeAfterDuration(LocalDateTime actualDateTime, int duration){
        int hour = duration/2;
        int minute = (duration%2)*30;
        return LocalDateTime.of(actualDateTime.getYear(), actualDateTime.getMonth(), actualDateTime.getDayOfMonth(),
                actualDateTime.getHour()+hour, actualDateTime.getMinute()+minute);
    }*/

    // String email, LocalDateTime startDateTime, int duration

}
