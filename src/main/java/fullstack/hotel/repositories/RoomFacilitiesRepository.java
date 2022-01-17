package fullstack.hotel.repositories;

import fullstack.hotel.model.entity.RoomFacilities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFacilitiesRepository extends JpaRepository<RoomFacilities, Long> {
}
