package kz.bcc.balatime.timetable.controller.admin;

import io.swagger.annotations.ApiOperation;

import kz.bcc.balatime.timetable.model.dto.teacher.WorkspaceRow;
import kz.bcc.balatime.timetable.service.admin.TeacherWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/teacher/workspace", produces = APPLICATION_JSON_VALUE)
public class TeacherWorkspaceController {
    @Autowired
    TeacherWorkspaceService teacherWorkspaceService;

    @ApiOperation(value = "Get SchedulerRow map")
    @GetMapping("/all")
    public ResponseEntity<List<WorkspaceRow>> getAll(
            Principal principal
    ) {
        return ResponseEntity.ok(teacherWorkspaceService.getAll(principal.getName()));
    }
}
