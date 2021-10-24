package fr.hexagone.back;

import fr.hexagone.Starter;
import fr.hexagone.dao.RoomRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
class RoomControllerTest {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomController roomController;

    @Test
    void bookRoom() {

        Room room = roomRepository.findAll().stream().findFirst().orElseThrow();

        LocalDateTime start2000 = LocalDateTime.of(2020, 12, 20, 13, 30, 0);
        LocalDateTime start2100 = LocalDateTime.of(2100, 12, 20, 13, 0, 0);
        LocalDateTime start2200 = LocalDateTime.of(2200, 12, 20, 13, 0, 0);

        assertEquals(
                BookRoomResult.INVALID_MAIL,
                roomController.bookRoom(room.getId(), "fake@gmail.com", start2100, 1)
        );

        assertEquals(
                BookRoomResult.OK,
                roomController.bookRoom(room.getId(), "random@univ-amu.fr", start2100, 2)
        );

        assertEquals(
                BookRoomResult.ROOM_NOT_AVAILABLE,
                roomController.bookRoom(room.getId(), "random@univ-amu.fr", start2100, 2)
        );

        assertEquals(
                BookRoomResult.INVALID_DURATION,
                roomController.bookRoom(room.getId(), "random@univ-amu.fr", start2100, Reservation.MAX_DURATION + 1)
        );

        assertEquals(
                BookRoomResult.INVALID_END_DATETIME,
                roomController.bookRoom(room.getId(), "random@univ-amu.fr", start2000, 2)
        );

        assertEquals(
                BookRoomResult.PERSISTANCE_ERROR,
                roomController.bookRoom(room.getId(), "random@univ-amu.fr@univ-amu.fr", start2200, 2)
        );

    }
}