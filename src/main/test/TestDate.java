import fr.hexagone.Starter;
import fr.hexagone.back.RoomController;
import fr.hexagone.dao.ReservationRepository;
import fr.hexagone.dao.RoomRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class TestDate {

    @Autowired
    RoomController roomController;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;


    Room room = new Room("H10",8);








    @Order(1)
    @Test
    public void testGetResOfDay(){
        Reservation reservation = new Reservation(room,"aaaa@gmail.com", LocalDateTime.now(),4);
        room.addReservation(reservation);
        LocalDateTime aDateTime = LocalDateTime.of(2021,
                Month.OCTOBER, reservation.getStartDateTime().getDayOfMonth()+1, 19, 30, 40);
        Reservation r2 = new Reservation(room,"bbbb@gmail.com",aDateTime,5);
        room.addReservation(r2);
        assertEquals(1,roomController.getReservationsOfday(room).size());
    }

    @Order(2)
    @Test
    public void testGetResOfWeek(){
        Reservation reservation = new Reservation(room,"aaaa@gmail.com", LocalDateTime.now(),4);
        room.addReservation(reservation);
        LocalDateTime aDateTime = LocalDateTime.of(2021,
                Month.OCTOBER, reservation.getStartDateTime().getDayOfMonth()-1, 19, 30, 40);
        Reservation r2 = new Reservation(room,"bbbb@gmail.com",aDateTime,5);
        room.addReservation(r2);
        assertEquals(2,roomController.getReservationsOfWeek(room).size());

    }


}
