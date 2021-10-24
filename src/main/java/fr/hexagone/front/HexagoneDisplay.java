package fr.hexagone.front;

import fr.hexagone.back.Availability;
import fr.hexagone.back.HexagoneController;
import fr.hexagone.back.RoomController;
import fr.hexagone.model.Room;
import fr.hexagone.utility.BeanUtil;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.Map;


public class HexagoneDisplay {

    RoomController rc = BeanUtil.getBean(RoomController.class);
    HexagoneController hc = BeanUtil.getBean(HexagoneController.class);

    double x = Screen.getPrimary().getBounds().getWidth()/2;
    double y =  Screen.getPrimary().getBounds().getHeight()/2;

    private Pane mainPane;
    private Polygon shape;
    private Form form;
    private  ReservationForm reservationForm;
    private boolean isReservable = false;

    private ArrayList<RoomDisplay> roomDisplays = new ArrayList<>();


    public HexagoneDisplay(Pane mainPane){

        this.mainPane = mainPane;

        this.form = new Form();

        this.mainPane.getChildren().add(form);


        this.shape =  new Polygon();

        shape.getPoints().addAll(
                x,y-300,
                x+Math.sqrt(3)/2*300, y-150,
                x+Math.sqrt(3)/2*300, y+150,
                x, y+300,
                x-Math.sqrt(3)/2*300, y+150,
                x-Math.sqrt(3)/2*300, y-150
        );
        this.shape.setFill(Color.WHITE);
        this.shape.setStroke(Color.BLACK);
        this.shape.setStrokeWidth(this.shape.getStrokeWidth() + 5);
        shape.setOnMouseClicked(mouseEvent -> {
            shape.setFill(Color.BLACK);
            shape.setStroke(Color.RED);
        });

        initRooms();

        roomDisplays.get(0).getShape().getPoints().addAll(
                0., -297.5,
                0.,-225.,
                Math.sqrt(3)/2*150-2.5,-225.
        );

        roomDisplays.get(1).getShape().getPoints().addAll(
                0., -297.5,
                0.,-225.,
                -Math.sqrt(3)/2*150+2.5,-225.
        );

        roomDisplays.get(2).getShape().getPoints().addAll(
                -Math.sqrt(3)/2*150+2.5,-225.,
                -(Math.sqrt(3)/2*150+2.5)/2,-225.,
                -(Math.sqrt(3)/2*150+2.5)/2,-150.,
                -Math.sqrt(3)/2*300+2.5,-150.
        );

        roomDisplays.get(3).getShape().getPoints().addAll(
                -Math.sqrt(3)/2*300+2.5,-150.,
                -150.,-150.,
                -150.,0.,
                -Math.sqrt(3)/2*300+2.5,0.
        );

        roomDisplays.get(4).getShape().getPoints().addAll(
                -Math.sqrt(3)/2*300+2.5,0.,
                -150.,0.,
                -150.,150.,
                -Math.sqrt(3)/2*300+2.5,150.
        );

        roomDisplays.get(5).getShape().getPoints().addAll(
                Math.sqrt(3)/2*150-2.5,-225.,
                (Math.sqrt(3)/2*150+2.5)/2,-225.,
                (Math.sqrt(3)/2*150+2.5)/2,-150.,
                Math.sqrt(3)/2*300-2.5,-150.
        );

        roomDisplays.get(6).getShape().getPoints().addAll(
                Math.sqrt(3)/2*300-2.5,-150.,
                150.,-150.,
                150.,0.,
                Math.sqrt(3)/2*300-2.5,0.
        );

        roomDisplays.get(7).getShape().getPoints().addAll(
                Math.sqrt(3)/2*300-2.5,0.,
                150.,0.,
                150.,150.,
                Math.sqrt(3)/2*300-2.5,150.
        );

        roomDisplays.get(8).getShape().getPoints().addAll(
                -Math.sqrt(3)/2*150+2.5,225.,
                -(Math.sqrt(3)/2*150-2.5)/2,225.,
                -(Math.sqrt(3)/2*150-2.5)/2,150.,
                -Math.sqrt(3)/2*300+2.5,150.
        );

        roomDisplays.get(9).getShape().getPoints().addAll(
                Math.sqrt(3)/2*150-2.5,225.,
                (Math.sqrt(3)/2*150+2.5)/2,225.,
                (Math.sqrt(3)/2*150+2.5)/2,150.,
                Math.sqrt(3)/2*300-2.5,150.
        );

        this.form.getButton().addEventHandler(MouseEvent.MOUSE_CLICKED,e ->{
            verifyAvailability();
        });




    }

    private  void initRooms(){

        String[] roomNames = {"H1","H2","H3","H4","O4","O8","P1","P2","F2","F3"}; //TODO Recuperer toutes les salles d'une coup
        for(int i = 0; i < 10 ; i++){
            this.roomDisplays.add(new RoomDisplay(rc.getRoom(roomNames[i]), new Coordinate(x,y),new Polygon()));
            this.roomDisplays.get(i).getShape().setFill(Color.WHITE);
            this.roomDisplays.get(i).getShape().setStroke(Color.BLACK);

            int finalI = i;

            this.roomDisplays.get(i).getShape().setOnMouseEntered(mouseEvent -> {
                mainPane.getChildren().add(this.roomDisplays.get(finalI).getAndUpdateDisplayPane());
                try {
                    this.roomDisplays.get(finalI).setHoverColor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            this.roomDisplays.get(i).getShape().setOnMouseExited(mouseEvent -> {
                mainPane.getChildren().remove(this.roomDisplays.get(finalI).getDisplayPane());
                try {
                    this.roomDisplays.get(finalI).setUnHoverColor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            this.roomDisplays.get(i).getShape().setOnMouseClicked(e->{
                if (reservationForm != null){
                    reservationForm.close();
                }

                boolean isRoomAvailable = false;
                for(Map.Entry<Room, Availability> roomAvailability : hc.listAvailabilityRoom(form.getLocalDateTime(),form.getDuration(), form.getSeats()).entrySet()){
                    if(roomDisplays.get(finalI).getRoom().getName().equals(roomAvailability.getKey().getName()) && roomAvailability.getValue() == Availability.AVAILABLE){
                        isRoomAvailable = true;
                    }
                }
                if(isReservable && isRoomAvailable){
                    reservationForm = new ReservationForm(roomDisplays.get(finalI).getRoom(),form.getLocalDateTime(),form.getDuration());
                    this.reservationForm.getScene().getWindow().addEventHandler(WindowEvent.WINDOW_HIDDEN, z ->{
                        verifyAvailability();
                    });


                }
            });
        }
    }



    public void verifyAvailability(){
        isReservable = true;

        for(RoomDisplay roomDisplay : roomDisplays){

            for(Map.Entry<Room, Availability> roomAvailability : hc.listAvailabilityRoom(form.getLocalDateTime(),form.getDuration(), form.getSeats()).entrySet()){

                if(roomAvailability.getKey().getName().equals(roomDisplay.getRoom().getName())){

                    switch (roomAvailability.getValue()){

                        case AVAILABLE :
                            roomDisplay.setColorRoom(Color.GREEN);
                            break;

                        case SOON:
                            roomDisplay.setColorRoom(Color.ORANGE);
                            break;

                        case NOT_YET :
                            roomDisplay.setColorRoom(Color.RED);
                            break;
                    }
                    break;
                }
            }

        }
    }

    public Polygon getForme() {
        return shape;
    }

    public void setForme(Polygon shape) {
        this.shape = shape;
    }

    public ArrayList<RoomDisplay> getRoomDisplays() {
        return roomDisplays;
    }

    public void setSallesAffichages(ArrayList<RoomDisplay> roomDisplays) {
        this.roomDisplays = roomDisplays;
    }

}
