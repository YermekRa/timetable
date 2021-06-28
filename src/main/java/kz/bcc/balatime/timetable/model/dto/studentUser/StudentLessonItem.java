package kz.bcc.balatime.timetable.model.dto.studentUser;

import lombok.Data;

@Data
public class StudentLessonItem {
    private String name;
    private String teacher;
    private String classRoom;
    private String group;
    private boolean free;
}
