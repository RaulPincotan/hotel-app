package fullstack.hotel.services;

import fullstack.hotel.exceptions.ValidatorException;
import fullstack.hotel.model.entity.Room;
import fullstack.hotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoomValidator {

    private final RoomRepository roomRepository;

    public void validateNewThrow(Room newRoom) {
        validate(newRoom, true).ifPresent(ex -> {
            throw ex;
        });
    }

    public void validateReplaceWithThrow(Long id, Room room) {
        exist(id).or(() -> validate(room, false))
                .ifPresent(ex -> {
                    throw ex;
                });
    }


    private Optional<ValidatorException> validate(Room room, boolean newEntity) {
        if (room.getFloor() < 0 || room.getRoomNumber() == null || room.getHotelName() == null) {
            return Optional.of(new ValidatorException("Floor cannot be less than 0 and hotel name should be valid and the room number must exist"));
        } else if (newEntity && roomRepository.existsByRoomNumberAndFloorAndHotelName(room.getRoomNumber(), room.getFloor(), room.getHotelName())) {
            return Optional.of(new ValidatorException("Room with the same room number, floor and hotel name cannot exist"));
        } else if (newEntity && roomRepository.existsByRoomNumberAndFloorAndHotelNameAndIdNot(room.getRoomNumber(), room.getFloor(), room.getHotelName(), room.getId())) {
            return Optional.of(new ValidatorException("Room with the same room number, floor and hotel name cannot exist"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<ValidatorException> exist(Long id) {
        return roomRepository.existsById(id) ? Optional.empty() :
                Optional.of(new ValidatorException("Room with id " + id + " does not exist"));
    }


}
