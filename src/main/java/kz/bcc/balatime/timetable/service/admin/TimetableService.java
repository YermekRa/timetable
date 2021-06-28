package kz.bcc.balatime.timetable.service.admin;


import kz.bcc.balatime.timetable.model.Timetable;

import java.util.List;

public interface TimetableService {
    Timetable create(Timetable timetable);

    Timetable getById(Integer id);

    List<Timetable> getAll();

    void delete(Integer id);

  //  Page<Timetable> getAllByPageAndSize(Integer page, Integer size);  //pagination
}
