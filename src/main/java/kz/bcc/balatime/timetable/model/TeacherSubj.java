package kz.bcc.balatime.timetable.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "teacher_subj", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class TeacherSubj {
    @Id
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "subject_id")
    private Integer subjectId;
}
