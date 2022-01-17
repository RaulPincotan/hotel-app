package fullstack.hotel.startup;

import fullstack.hotel.model.entity.Room;
import fullstack.hotel.model.entity.RoomFacilities;
import fullstack.hotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {

        populateRooms();
    }

    private void populateRooms() {
        Random random = new Random();
        boolean b=random.nextBoolean();

        int floor = 0;
        for (int i = 0; i < 30; i++) {
            if (i < 10) {
                floor = 1;
            } else if (i < 20) {
                floor = 2;
            } else {
                floor = 3;
            }
            roomRepository.save(Room.builder()
                    .floor(floor)
                    .hotelName("Melody")
                    .roomFacilities(RoomFacilities.builder()
                            .tv(random.nextBoolean())
                            .doubleBed(random.nextBoolean())
                            .build())
                    .roomNumber("R" + floor + i % 10)
                    .build());

        }
    }
}