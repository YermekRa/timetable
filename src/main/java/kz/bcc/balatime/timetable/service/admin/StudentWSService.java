package kz.bcc.balatime.timetable.service.admin;

import kz.bcc.balatime.timetable.model.dto.studentUser.StudentHTDLItem;
import kz.bcc.balatime.timetable.model.dto.studentUser.StudentLessons;

import java.util.List;

public interface StudentWSService {
    List<StudentHTDLItem> getHotData(Integer studentId);

    List<StudentLessons> getMyCources(Integer studentId);

}


