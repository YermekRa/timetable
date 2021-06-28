package kz.bcc.balatime.timetable.model.dto.teacher;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Data
@Getter
@Setter
public class WorkspaceRow {
    private String time;
    private DayOfWeek dayOfWeek;
    private LessonItem lesson;
}
