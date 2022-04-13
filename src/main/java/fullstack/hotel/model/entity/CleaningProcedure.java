package fullstack.hotel.model.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "cleaning_procedure")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CleaningProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "outcome")
    private int outcome;
}
