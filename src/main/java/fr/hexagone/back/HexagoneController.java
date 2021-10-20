package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HexagoneController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomController roomController;

    public List<Reservation> getListReservationOfARoom(Room room){
        return reservationRepository.getAllReservationFromRoom(room);
    }

    // TODO Systeme duration to change.
    // FIXME ne marche pas correctement pour l'instant.
    public Map<Room, Availability> listAvailabilityRoom(LocalDateTime date, int duration){
        Map<Room, Availability> listRoomSorted = new HashMap<>();

        List<Room> rooms = roomController.findAllRooms();

        for(Room room :rooms){
            Availability available = null;
            List<Reservation> listReservation = getListReservationOfARoom(room);
            for(Reservation reservation : listReservation){
                LocalDateTime localDateTime = LocalDateTime.of(reservation.getStartDateTime().getYear(),
                        reservation.getStartDateTime().getMonth(), reservation.getStartDateTime().getDayOfMonth(),
                        reservation.getStartDateTime().getHour()+reservation.getDuration(),
                        reservation.getStartDateTime().getMinute());

                LocalDateTime localDateTimeWithDuration = LocalDateTime.of(date.getYear(), date.getMonth(),
                        date.getDayOfMonth(), date.getHour()+duration, date.getMinute());

                if(((date.isAfter(reservation.getStartDateTime()) && date.isAfter(localDateTime)) ||
                        date.isEqual(reservation.getStartDateTime()) ||
                        date.isEqual(localDateTime)) &&
                        ((localDateTimeWithDuration.isAfter(reservation.getStartDateTime())&&localDateTimeWithDuration.isAfter(localDateTime))
                        || localDateTimeWithDuration.isEqual(reservation.getStartDateTime()) || localDateTimeWithDuration.isEqual(localDateTime))){
                    available = Availability.Not_Yet;
                }


                if(available != null){
                    break;
                }

            }

            if(available == null){
                available = Availability.available;
            }
            listRoomSorted.put(room, available);
        }

        return listRoomSorted;
    }

}











