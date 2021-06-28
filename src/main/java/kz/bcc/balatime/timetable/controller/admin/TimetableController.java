package kz.bcc.balatime.timetable.controller.admin;

import io.swagger.annotations.ApiOperation;

import kz.bcc.balatime.timetable.model.Timetable;
import kz.bcc.balatime.timetable.service.admin.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/timetable", produces = APPLICATION_JSON_VALUE)
public class TimetableController {
    @Autowired
    private TimetableService    timetableService;

    @ApiOperation(value = "Get All records")
    @GetMapping("/all")
    public ResponseEntity<List<Timetable>> getAll() {
        return ResponseEntity.ok(timetableService.getAll());
    }

    @ApiOperation(value = "Create or update Timetable object")
    @PostMapping()
    public ResponseEntity<Timetable> calculateTestObject(@RequestBody Timetable timetable) {
        return ResponseEntity.ok(timetableService.create(timetable));
    }
    @ApiOperation(value = "Get Timetable by id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Timetable> getTeacherById(@PathVariable Integer id) {
        return ResponseEntity.ok(timetableService.getById(id));
    }

    @ApiOperation(value = "Delete Timetable by Id")
    @DeleteMapping("/id/{id}")
    public void deleteTeacherById(@PathVariable Integer id) {
        timetableService.delete(id);
    }

//    @ApiOperation(value = "Get Timetable page")
//    @GetMapping("/page/{page}/size/{size}")
//    public ResponseEntity<Page<Timetable>> getByPageAndSize(
//            @PathVariable Integer page,
//            @PathVariable Integer size
//    ) {
//        return ResponseEntity.ok(timetableService.getAllByPageAndSize(page, size));
//    }
}
