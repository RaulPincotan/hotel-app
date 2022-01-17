package fullstack.hotel.services;

import fullstack.hotel.model.entity.RoomFacilities;
import fullstack.hotel.repositories.RoomFacilitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomFacilitiesService {

    private final RoomFacilitiesRepository roomFacilitiesRepository;

    public List<RoomFacilities> getRoomFacilitiesForRoom(Long roomId) {
        return roomFacilitiesRepository.findAll();
    }


}
