package fr.hexagone.back;

import fr.hexagone.dao.RoomRepository;
import fr.hexagone.model.Reservation;
import fr.hexagone.model.Room;
import fr.hexagone.utility.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @PostConstruct
    public void init(){
        if(roomRepository.count() == 0){
            roomRepository.save(new Room("H1",1));
            roomRepository.save(new Room("H2",2,"Tableau"));
            roomRepository.save(new Room("H3",3,"Video Projecteur","Tableau"));
            roomRepository.save(new Room("H4",4,"Video Projecteur","Tableau"));
            roomRepository.save(new Room("O4",4,"Video Projecteur","Tableau","Table Ronde"));
            roomRepository.save(new Room("O8",8,"Video Projecteur","Tableau","Table Ronde"));
            roomRepository.save(new Room("P1",1,"Tableau"));
            roomRepository.save(new Room("P2",2,"Tableau"));
            roomRepository.save(new Room("F2",2,"Video Projecteur","Tableau"));
            roomRepository.save(new Room("F3",3,"Video Projecteur","Tableau"));
        }

        System.out.println(getRoom("H4").getName());
    }

    public List<Room> findAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoom(String name){
        return roomRepository.findByName(name);
    }

    public int getNbPlaces(String name){
        return roomRepository.findByName(name).getCapacity();
    }

    public List<Reservation> getReservationsOfday(Room room){

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation r : room.getReservations()){
            if(DateUtils.isSameDay(r.getStartDateTime(),LocalDateTime.now())){
                reservations.add(r);
            }

        }
        return reservations;
    }

    public List<Reservation> getReservationsOfWeek(Room room){
        List<Reservation> reservations = new ArrayList<>();
        for (Reservation r : room.getReservations()){
            if(DateUtils.isSameWeek(r.getStartDateTime(),LocalDateTime.now())){
                reservations.add(r);
            }

        }
        return reservations;
    }


}
