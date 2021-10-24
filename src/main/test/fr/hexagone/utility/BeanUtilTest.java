package fr.hexagone.utility;

import fr.hexagone.Starter;
import fr.hexagone.back.RoomController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
class BeanUtilTest {

    @Autowired
    RoomController roomController;

    @Test
    void getBean() {
        RoomController controller = BeanUtil.getBean(RoomController.class);
        assertNotNull(controller);
        assertEquals(roomController, controller);
    }
}