package kz.bcc.balatime.timetable.service.student;

import kz.bcc.balatime.timetable.model.EduYear;
import kz.bcc.balatime.timetable.model.dto.studentUser.StudentTimeTableRow;

import java.util.List;

public interface StudentTimeTableService {
    List<StudentTimeTableRow> getAll(Integer classs, EduYear eduYear);
}
