package ir.reyhaneh.hotelreservation.controller;

import ir.reyhaneh.hotelreservation.model.Customers;
import ir.reyhaneh.hotelreservation.model.Rooms;
import ir.reyhaneh.hotelreservation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/room/")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<Rooms> getAllRoom() {
        return roomService.getAllRooms();
    }

    @GetMapping("{id}")
    public Rooms getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("{type}/{status}/{price}")
    public void saveRoom(@PathVariable String type, @PathVariable String status, @PathVariable Long price) {
        roomService.saveRoom(type, status, price);
    }

    @PutMapping("{id}/{type}/{status}/{price}/")
    public void updateRoom(@PathVariable Long id, @PathVariable String type, @PathVariable String status, @PathVariable Long price) {
        roomService.updateRoom(id, type, status, price);
    }

    @DeleteMapping("{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }


}
