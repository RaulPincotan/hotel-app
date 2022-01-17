package fullstack.hotel.repositories;

import fullstack.hotel.model.entity.CleaningProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleaningProcedureRepository extends JpaRepository<CleaningProcedure, Long> {
}
