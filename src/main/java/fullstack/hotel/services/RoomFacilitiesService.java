package fullstack.hotel.services;

import fullstack.hotel.model.entity.RoomFacilities;
import fullstack.hotel.repositories.RoomFacilitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomFacilitiesService {

    private final RoomFacilitiesRepository roomFacilitiesRepository;

    public Optional<RoomFacilities> getRoomFacilitiesForRoom(Long roomId) {
        return roomFacilitiesRepository.findById(roomId);
    }
}
