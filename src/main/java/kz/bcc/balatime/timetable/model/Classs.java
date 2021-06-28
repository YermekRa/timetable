package kz.bcc.balatime.timetable.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "classs", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Classs {
    @Id
    @SequenceGenerator(name = "class_id_seq",
            sequenceName = "class_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "class_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "room_id")
    private Integer roomId;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "classs_subject",
            joinColumns = {@JoinColumn(name = "classs_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id", referencedColumnName = "id")}
    )
    private List<Subject> subjects;*/
}
