package fullstack.hotel.model;

import lombok.Data;
import lombok.Value;

import java.util.Optional;

@Value
public class RoomFilters {
    //    String number;
    Integer floor;
    String hotel;
    Boolean doubleBed;
    Boolean tv;
}
