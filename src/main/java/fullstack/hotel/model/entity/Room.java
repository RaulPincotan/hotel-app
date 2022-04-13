package fullstack.hotel.model.entity;

import lombok.*;

import javax.persistence.*;
@Table(name = "room")
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

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "fllor")
    private int floor;

    @Column(name = "hotel_name")
    private String hotelName;

    @OneToOne
    @JoinColumn(name = "cleaning_procedure_id")
    private CleaningProcedure cleaningProcedure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_facilities")
    private RoomFacilities roomFacilities;
}
