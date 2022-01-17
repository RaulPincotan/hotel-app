package fullstack.hotel.repositories;

import fullstack.hotel.model.entity.RoomFacilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomFacilitiesRepository extends JpaRepository<RoomFacilities, Long> {
    Optional<RoomFacilities> findRoomFacilitiesByRoom_Id(Long roomId);
}
