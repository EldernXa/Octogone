package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import fr.hexagone.utility.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class  HexagoneController {

    private static final int DURATION_FOR_SOON = 1;

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
            listRoomSorted.put(room, getAvailabilityForARoom(room, capacity, date, duration));
        }

        return listRoomSorted;
    }

    private Availability getAvailabilityForARoom(Room roomToVerify, int capacity, LocalDateTime date, int duration){
        Availability available = null;
        if(roomToVerify.getCapacity() >= capacity){
            List<Reservation> listReservation = getListReservationOfARoom(roomToVerify);
            for(Reservation reservation : listReservation){
                available = getAvailabilityFromAReservation(reservation, date, duration);

                if(available != null){
                    break;
                }

            }
        }else{
            available = Availability.NOT_YET;
        }

        if(available == null)
        {
            available = Availability.AVAILABLE;
        }

        return available;
    }

    private Availability getAvailabilityFromAReservation(Reservation reservation, LocalDateTime date, int duration){
        Availability available = null;
        LocalDateTime resEndDateTime = reservation.getEndDateTime();
        LocalDateTime localDateTimeAfterDuration = Reservation.getEndDateTime(date, duration);

        LocalDateTime timeForSoonTest = null;
        if(duration > 1){
            timeForSoonTest = Reservation.getEndDateTime(reservation.getStartDateTime(), reservation.getDuration() - DURATION_FOR_SOON);
        }

        if(DateUtils.isOverlapping(reservation.getStartDateTime(), resEndDateTime, date, localDateTimeAfterDuration)){
            available = timeForSoonTest != null &&
                    ChronoUnit.MINUTES.between(timeForSoonTest, date) <= (DURATION_FOR_SOON * 30) &&
                    ChronoUnit.MINUTES.between(timeForSoonTest, date) >= 0 ? Availability.SOON : Availability.NOT_YET;
        }

        return available;
    }


}













