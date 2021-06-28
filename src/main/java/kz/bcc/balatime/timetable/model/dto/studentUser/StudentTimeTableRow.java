package kz.bcc.balatime.timetable.model.dto.studentUser;

import lombok.Data;

@Data
public class StudentTimeTableRow {
    private String time;
    private StudentLessonItem l1;
    private StudentLessonItem l2;
    private StudentLessonItem l3;
    private StudentLessonItem l4;
    private StudentLessonItem l5;
    private StudentLessonItem l6;
}
