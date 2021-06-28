package kz.bcc.balatime.timetable.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "teacher", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_id_seq",
            sequenceName = "teacher_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "teacher_id_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "b_user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "b_user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "level")
    private String level;
    @Column(name = "birth_date")
    private Date birthdate;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_subject",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id", referencedColumnName = "id")}
    )
    private List<Subject> subjectsT;*/

}
