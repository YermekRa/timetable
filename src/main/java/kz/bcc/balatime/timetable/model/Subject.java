package kz.bcc.balatime.timetable.model;

import lombok.*;

import javax.persistence.*;


@Table(name = "subject", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Subject {
    @Id
    @SequenceGenerator(name = "subject_id_seq",
            sequenceName = "subject_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "subject_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "long_name")
    private String longName;

    /*@ManyToMany(mappedBy = "subjectsT")
    private List<Teacher> teachers;

    @ManyToMany(mappedBy = "subjects")
    private List<Classs> classs;*/

}
