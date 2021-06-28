package kz.bcc.balatime.timetable.model;

import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;

@Table(name = "timetable", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

public class Timetable {
    @Id
    @SequenceGenerator(name = "timetable_id_seq",
            sequenceName = "timetable_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "timetable_id_seq")


    @Column(name = "id")
    private Integer id;
    @Column(name = "subject_id")
    private Integer subjectId;
    @ManyToOne
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private Subject subject;
    @Column(name = "room_id")
    private Integer roomId;
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @ManyToOne
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;
    @Column(name = "class_id")
    private Integer classId;
    @ManyToOne
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    private Classs classs;
    @Column(name = "edu_year")
    private EduYear eduYear;
    @Column(name = "subject_order")
    private Integer subjectOrder;
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;


}
