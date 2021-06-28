package kz.bcc.balatime.timetable.service.admin;

import kz.bcc.balatime.timetable.model.CustomPagination;
import kz.bcc.balatime.timetable.model.Subject;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface SubjectService {
    Subject getById(int id);
    Subject create(Subject subject);
    List<Subject> getAll();
    void deleteById(Integer id);
    CustomPagination getAllByPagination(@RequestParam Map<String, String> allRequestParams);
}
