package fr.hexagone.back;

import fr.hexagone.Starter;
import fr.hexagone.model.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
class ReservationControllerTest {

    @Autowired
    ReservationController reservationController;

    @Test
    void findAllReservations() {
        List<Reservation> all = reservationController.findAllReservations();
        assertEquals(3, all.size());
    }
}