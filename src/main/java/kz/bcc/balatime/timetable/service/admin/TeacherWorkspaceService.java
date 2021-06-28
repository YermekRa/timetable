package kz.bcc.balatime.timetable.service.admin;

import kz.bcc.balatime.timetable.model.dto.teacher.WorkspaceRow;

import java.util.List;

public interface TeacherWorkspaceService {
     List<WorkspaceRow> getAll(String username);
}
