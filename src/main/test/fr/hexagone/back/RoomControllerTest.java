package fr.hexagone.back;

import fr.hexagone.Starter;
import fr.hexagone.dao.RoomRepository;
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

        Room room = new Room("TEST1", 4, "Projecteur");
        roomRepository.save(room);

        LocalDateTime start1 = LocalDateTime.of(2021, 12, 20, 13, 0, 0);
        LocalDateTime start2 = LocalDateTime.of(2021, 12, 20, 13, 30, 0);
        LocalDateTime start3 = LocalDateTime.of(2021, 12, 21, 13, 0, 0);


        roomRepository.delete(room);
    }
}