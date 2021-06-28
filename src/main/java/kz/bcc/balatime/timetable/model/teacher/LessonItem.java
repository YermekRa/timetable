package kz.bcc.balatime.timetable.model.teacher;

import lombok.Data;

@Data
public class LessonItem {
    private String name;
    private String teacher;
    private String teacherln;
    private String classRoom;
    private String group;
    private Integer timetableId;
    private boolean free;
}
