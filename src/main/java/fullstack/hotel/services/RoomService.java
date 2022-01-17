package fullstack.hotel.services;


import fullstack.hotel.exceptions.RoomException;
import fullstack.hotel.model.RoomFilters;
import fullstack.hotel.model.entity.Room;
import fullstack.hotel.repositories.RoomDAO;
import fullstack.hotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository repository;
    private final RoomDAO roomDAO;
    private final RoomValidator validator;


    public List<Room> getAll(RoomFilters roomFilters) {
        return roomDAO.getAll(roomFilters);
    }

    public Room getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoomException("Rooom with id " + id + " could not be found"));
    }

    public Room addRoom(Room room) {
        validator.validateNewThrow(room);
        return repository.save(room);
    }

    public Room replaceRoom(Long id, Room room) {
        validator.validateReplaceWithThrow(id, room);
        Room roomDB = repository.findById(id).get();
        copyRoom(roomDB, room);
        return repository.save(roomDB);
    }

    private void copyRoom(Room roomDB, Room room) {
        roomDB.setRoomNumber(room.getRoomNumber());
        roomDB.setFloor(room.getFloor());
        roomDB.setHotelName(room.getHotelName());
        roomDB.setRoomFacilities(room.getRoomFacilities());
        roomDB.setCleaningProcedure(room.getCleaningProcedure());
    }

    public Optional<Room> deleteRoom(Long id) {
        Optional<Room> room = repository.findById(id);
        room.ifPresent(room1 -> repository.delete(room1));
        return room;
    }
}
