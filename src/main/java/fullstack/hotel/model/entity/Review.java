package fullstack.hotel.model.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "review")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", length = 200)
    private String message;

    @Column(name = "rating")
    private int rating;

    @Column(name = "tourist_name")
    private String touristName;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


}
