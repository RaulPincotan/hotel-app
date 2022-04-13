package fullstack.hotel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "room_facilities")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tv")
    private boolean tv;

    @Column(name = "double_bed")
    private boolean doubleBed;
}
