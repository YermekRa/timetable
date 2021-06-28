package kz.bcc.balatime.timetable.controller.student;

import kz.bcc.balatime.timetable.model.dto.studentUser.StudentProgressListDto;
import kz.bcc.balatime.timetable.service.student.StudentProgressListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/student/progressList", produces = APPLICATION_JSON_VALUE)
public class StudentProgressListController {

    @Autowired
    private StudentProgressListService studentProgressListService;

    @GetMapping("/studentId/{studentId}")
    public List<StudentProgressListDto> getAll(
            @PathVariable Integer studentId
    ) {
        return studentProgressListService.getAll(studentId);
    }
}
