package fullstack.hotel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Table(name = "cleanup_room")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CleanupRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "procedures")
    private String procedures;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
