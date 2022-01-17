package fullstack.hotel.model.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "message",length = 200)
    private String message;
    @Column(name = "rating")
    private int rating;

    @Column(name = "tourist_name")
    private String touristName;

    @ManyToOne
    private Room room;


}
