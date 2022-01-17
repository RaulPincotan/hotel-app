package fullstack.hotel.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private int floor;
    private String hotelName;

    @OneToOne
    @JoinColumn(name = "cleaning_procedure_id")
    private CleaningProcedure cleaningProcedure;

    @OneToOne(cascade = CascadeType.ALL)
    private RoomFacilities roomFacilities;




}
