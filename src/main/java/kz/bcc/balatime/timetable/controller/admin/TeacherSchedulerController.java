package kz.bcc.balatime.timetable.controller.admin;

import io.swagger.annotations.ApiOperation;
import kz.bcc.balatime.timetable.model.EduYear;
import kz.bcc.balatime.timetable.model.dto.teacher.SchedulerRow;
import kz.bcc.balatime.timetable.service.admin.TeacherSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/teacher/scheduler", produces = APPLICATION_JSON_VALUE)
public class TeacherSchedulerController {
    @Autowired
    TeacherSchedulerService teacherSchedulerService;

    @ApiOperation(value = "Get SchedulerRow map")
    @GetMapping("/all")
    public ResponseEntity<List<SchedulerRow>> getAll(
            @RequestParam EduYear eduYear,
            Principal principal
    ) {
        return ResponseEntity.ok(teacherSchedulerService.getAll(principal.getName(), eduYear));
    }
}
