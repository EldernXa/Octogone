package fr.hexagone.dao;

import fr.hexagone.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findById(int id);
    Room findByName(String name);
    void deleteAll();
}
