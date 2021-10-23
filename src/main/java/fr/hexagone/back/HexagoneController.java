package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class  HexagoneController {

    private final int durationForSoon = 1;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomController roomController;

    public List<Reservation> getListReservationOfARoom(Room room){
        return reservationRepository.getAllReservationFromRoom(room);
    }


    public Map<Room, Availability> listAvailabilityRoom(LocalDateTime date, int duration, int capacity){
        Map<Room, Availability> listRoomSorted = new HashMap<>();

        List<Room> rooms = roomController.findAllRooms();

        for(Room room :rooms) {
            Availability available = null;
            if (room.getCapacity() >= capacity){
                List<Reservation> listReservation = getListReservationOfARoom(room);
                for (Reservation reservation : listReservation) {
                    LocalDateTime resEndDateTime = reservation.getEndDateTime();
                    LocalDateTime localDateTimeAfterDuration = Reservation.getEndDateTime(date, duration);

                    LocalDateTime timeForSoonTest = null;
                    if (duration > 1) {
                        timeForSoonTest = Reservation.getEndDateTime(reservation.getStartDateTime(), reservation.getDuration() - durationForSoon);
                    }

                    if (isOverlapping(reservation.getStartDateTime(), resEndDateTime, date, localDateTimeAfterDuration)) {

                        available = timeForSoonTest != null &&
                                ChronoUnit.MINUTES.between(timeForSoonTest, date) <= (durationForSoon * 30) &&
                                ChronoUnit.MINUTES.between(timeForSoonTest, date) >= 0 ? Availability.SOON : Availability.NOT_YET;
                    }

                    if (available != null) {
                        break;
                    }
                }
            }else{
                available = Availability.NOT_YET;
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













