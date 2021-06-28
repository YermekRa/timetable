package kz.bcc.balatime.timetable.model;

import lombok.*;

import javax.persistence.*;


@Table(name = "room", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Room {
    @Id
    @SequenceGenerator(name = "room_id_seq",
            sequenceName = "room_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "room_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "floor")
    private Integer floor;

}

