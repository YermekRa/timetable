package kz.bcc.balatime.timetable.model.dto.teacher;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SchedulerRow {
    private String time;
    private LessonItem l1;
    private LessonItem l2;
    private LessonItem l3;
    private LessonItem l4;
    private LessonItem l5;
    private LessonItem l6;
}
