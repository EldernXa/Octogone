package fr.hexagone.dao;

import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query("SELECT r FROM Reservation r, Room ro WHERE r.room.id = ro.id AND r.room = :room")
    List<Reservation> getAllReservationFromRoom(@Param("room")Room room);

}
