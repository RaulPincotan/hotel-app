package fullstack.hotel.controller;

import fullstack.hotel.model.RoomFilters;
import fullstack.hotel.model.entity.Room;
import fullstack.hotel.model.entity.RoomFacilities;
import fullstack.hotel.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    List<Room> getAll(RoomFilters roomFilters) {
        return roomService.getAll(roomFilters);
    }

    @GetMapping("/{id}")
    Room getById(@PathVariable Long id) {
        return roomService.getById(id);
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PutMapping("/{id}")
    public Room replaceRoom(@PathVariable Long id,@RequestBody Room room) {
        return roomService.replaceRoom(id,room);
    }

    @GetMapping("/{id}/facilities")
    public RoomFacilities getFacilitiesForRoom(@PathVariable Long id) {
        return roomService.getFacilitiesForRoom(id);
    }
}
