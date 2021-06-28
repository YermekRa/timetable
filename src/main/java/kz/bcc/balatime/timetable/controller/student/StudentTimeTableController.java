package kz.bcc.balatime.timetable.controller.student;

import kz.bcc.balatime.timetable.model.EduYear;
import kz.bcc.balatime.timetable.model.dto.studentUser.StudentTimeTableRow;
import kz.bcc.balatime.timetable.service.student.StudentTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/student/timetable", produces = APPLICATION_JSON_VALUE)
public class StudentTimeTableController {

    @Autowired
    private StudentTimeTableService studentTimeTableService;

    /*@ApiOperation(value = "Get All records")
    @GetMapping("/all")
    public List<StudentTimeTableRow> getAll() {
        return studentTimeTableService.getAll();
    }
*/
    @GetMapping("/all/classsId/{classsId}")
    public List<StudentTimeTableRow> getAll(
            @PathVariable Integer classsId,
            @RequestParam EduYear eduYear
    ) {
        return studentTimeTableService.getAll(classsId, eduYear);
    }

}

