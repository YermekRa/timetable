package kz.bcc.balatime.timetable.service.admin;


import kz.bcc.balatime.timetable.model.TeacherSubj;

import java.util.List;

public interface TeacherSubjService {
    TeacherSubj create(TeacherSubj journal);

    TeacherSubj getById(Integer id);

    List<TeacherSubj> getAll();

    void delete(Integer id);
}
