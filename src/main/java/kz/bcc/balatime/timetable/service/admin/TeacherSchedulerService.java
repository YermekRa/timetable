package kz.bcc.balatime.timetable.service.admin;

import kz.bcc.balatime.timetable.model.EduYear;
import kz.bcc.balatime.timetable.model.dto.teacher.SchedulerRow;

import java.util.List;

public interface TeacherSchedulerService {
     List<SchedulerRow> getAll(String username, EduYear eduYear);
}
