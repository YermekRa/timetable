package kz.bcc.balatime.timetable.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "grade", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Grade {
    @Id
    @SequenceGenerator(name = "grade_id_seq",
            sequenceName = "grade_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "grade_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "longname")
    private String longname;
}
