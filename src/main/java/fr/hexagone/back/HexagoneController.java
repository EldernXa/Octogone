package fr.hexagone.back;

import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import fr.hexagone.utility.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class  HexagoneController {

    /**
     * Variable pour indiquer à partir de quel durée une salle est bientôt disponible.
     */
    private static final int DURATION_FOR_SOON = 1;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomController roomController;

    /**
     * Pour obtenir une liste de réservation à partir d'une salle.
     * @param room une salle
     * @return une liste contenant toutes les réservations d'une salle.
     */
    public List<Reservation> getListReservationOfARoom(Room room){
        return reservationRepository.getAllReservationFromRoom(room);
    }

    /**
     * Renvoie la liste des disponibilités des salles en fonction de plusieurs paramètres.
     * @param date la date de la réservations voulues.
     * @param duration la durée de la réservation.
     * @param capacity la capacité de la salle voulue.
     * @return une map contenant en clé une salle et en valeur la disponibilité de cette salle.
     */
    public Map<Room, Availability> listAvailabilityRoom(LocalDateTime date, int duration, int capacity){
        Map<Room, Availability> listRoomSorted = new HashMap<>();

        List<Room> rooms = roomController.findAllRooms();

        for(Room room :rooms) {
            listRoomSorted.put(room, getAvailabilityForARoom(room, capacity, date, duration));
        }

        return listRoomSorted;
    }

    /**
     *
     * @param roomToVerify la salle pour laquel on veut vérifier la disponibilité.
     * @param capacity la capacité que l'utilisateur désire avoir.
     * @param date la date de la réservation.
     * @param duration la durée de réservation que l'utilisateur désire.
     * @return la disponibilité de la salle donné en paramètre.
     */
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

    /**
     *
     * @param reservation une réservation pour vérifier qu'elle rentre pas en conflit avec la réservation voulue par l'utilisateur.
     * @param date la date de la réservation voulue par l'utilisateur.
     * @param duration la durée que l'utilisateur désire.
     * @return la disponibilité en fonction de si la réservation actuelle rentre en conflit avec la réservation voulue par l'utilisateur.
     */
    private Availability getAvailabilityFromAReservation(Reservation reservation, LocalDateTime date, int duration){
        Availability available = null;
        LocalDateTime resEndDateTime = reservation.getEndDateTime();
        LocalDateTime localDateTimeAfterDuration = Reservation.getEndDateTime(date, duration);


        if(DateUtils.isOverlapping(reservation.getStartDateTime(), resEndDateTime, date, localDateTimeAfterDuration)){
            if (date.isEqual(resEndDateTime)) {
                return null;
            }
            LocalDateTime local = Reservation.getEndDateTime(date, DURATION_FOR_SOON);
            if(!DateUtils.isOverlapping(reservation.getStartDateTime(), resEndDateTime, local, localDateTimeAfterDuration)){
                available = Availability.SOON;
            }else {
                available = Availability.NOT_YET;
            }
        }

        return available;
    }


}













