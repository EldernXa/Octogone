package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class  HexagoneController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomController roomController;

    ReservationController reservationController = new ReservationController();

    public List<Reservation> getListReservationOfARoom(Room room){
        return reservationRepository.getAllReservationFromRoom(room);
    }

    // TODO Use Soon from enum Availability
    public Map<Room, Availability> listAvailabilityRoom(LocalDateTime date, int duration){
        Map<Room, Availability> listRoomSorted = new HashMap<>();

        List<Room> rooms = roomController.findAllRooms();

        for(Room room :rooms){
            Availability available = null;
            List<Reservation> listReservation = getListReservationOfARoom(room);
            for(Reservation reservation : listReservation){
                LocalDateTime localDateTime = reservationController.getTimeAfterDuration(reservation);

                LocalDateTime localDateTimeWithDuration = reservationController.getTimeAfterDuration(date, duration);

                if (isOverlapping(reservation.getStartDateTime(), localDateTime, date, localDateTimeWithDuration)) {
                    available = Availability.NOT_YET;
                }

                if(available != null){
                    break;
                }
            }

            if(available == null){
                available = Availability.AVAILABLE;
            }
            listRoomSorted.put(room, available);
        }

        return listRoomSorted;
    }

    private boolean isOverlapping(LocalDateTime startReservationTime, LocalDateTime endReservationTime, LocalDateTime startClientTime,
                                  LocalDateTime endClientTime){
        return startReservationTime.compareTo(endClientTime)<=0 && endReservationTime.compareTo(startClientTime)>=0;
    }

}













