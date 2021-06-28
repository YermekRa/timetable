package kz.bcc.balatime.timetable.service.admin;

import kz.bcc.balatime.timetable.model.dto.teacher.MyGroupListRow;

import java.util.List;

public interface TeacherMyGroupListService {
     List<MyGroupListRow> getAll(String username);
}
