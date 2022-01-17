package fullstack.hotel.repositories;

import fullstack.hotel.model.entity.CleanupRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanupRoomRepository extends JpaRepository<CleanupRoom, Long> {
}
