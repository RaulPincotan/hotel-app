package fullstack.hotel.repositories;

import fullstack.hotel.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomNumberAndFloorAndHotelName(String roomNumber, int floor, String hotelName);

    boolean existsByRoomNumberAndFloorAndHotelNameAndIdNot(String roomNumber, int floor, String hotelName, Long id);

}
