package ir.reyhaneh.hotelreservation.service;

import ir.reyhaneh.hotelreservation.model.Customers;
import ir.reyhaneh.hotelreservation.model.Rooms;

import java.util.List;

public interface RoomService {

    List<Customers> getAllRooms();

    Rooms getRoomById(Long id);

    void saveRoom(String type, String status, Long price);

    void updateRoom(Long id, String type, String status, Long price);

    void deleteRoom(Long id);

}





