package kz.bcc.balatime.timetable.service.student;

import kz.bcc.balatime.timetable.model.dto.studentUser.StudentProgressListDto;

import java.util.List;

public interface StudentProgressListService {
    List<StudentProgressListDto> getAll(Integer studentId);
}
