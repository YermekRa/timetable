package kz.bcc.balatime.timetable.service.impl.student;

import kz.bcc.balatime.timetable.model.EduYear;
import kz.bcc.balatime.timetable.model.Timetable;
import kz.bcc.balatime.timetable.model.dto.studentUser.StudentLessonItem;
import kz.bcc.balatime.timetable.model.dto.studentUser.StudentTimeTableRow;
import kz.bcc.balatime.timetable.repository.TimetableRepository;
import kz.bcc.balatime.timetable.service.student.StudentTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentTimeTableServiceImpl implements StudentTimeTableService {

    @Autowired
    TimetableRepository timetableRepository;

    @Override
    public List<StudentTimeTableRow> getAll(Integer classs, EduYear eduYear) {
        List<StudentTimeTableRow> schedulerTable = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Integer subjectOrder = i + 1;
            List<Timetable> timetableListByOrder = timetableRepository.findAllByClasssIdAndSubjectOrder(classs, subjectOrder);
            StudentTimeTableRow schedulerRow = new StudentTimeTableRow();
            schedulerRow.setTime((i + 8) + ":00");
            schedulerRow.setL1(objectMapperDto(timetableListByOrder, DayOfWeek.MONDAY));
            schedulerRow.setL2(objectMapperDto(timetableListByOrder, DayOfWeek.TUESDAY));
            schedulerRow.setL3(objectMapperDto(timetableListByOrder, DayOfWeek.WEDNESDAY));
            schedulerRow.setL4(objectMapperDto(timetableListByOrder, DayOfWeek.THURSDAY));
            schedulerRow.setL5(objectMapperDto(timetableListByOrder, DayOfWeek.FRIDAY));
            schedulerRow.setL6(objectMapperDto(timetableListByOrder, DayOfWeek.SATURDAY));
            schedulerTable.add(schedulerRow);
        }


        return schedulerTable;
    }

    StudentLessonItem objectMapperDto(List<Timetable> timetableListByOrder, DayOfWeek dayOfWeek) {

        StudentLessonItem lessonItem = new StudentLessonItem();
        Optional<Timetable> ot = timetableListByOrder.stream().filter(tt -> tt.getDayOfWeek().getValue() == dayOfWeek.getValue()).findFirst();
        //if (ot.isPresent()) {
            Timetable timetable = ot.get();
            lessonItem.setClassRoom(timetable.getRoom().getCode() + ", " + timetable.getRoom().getName());
            lessonItem.setGroup(timetable.getClasss().getCode());
            lessonItem.setName(timetable.getSubject().getCode());
            lessonItem.setTeacher(timetable.getTeacher().getFirstName());
            lessonItem.setFree(false);
       // } else {
        /*    lessonItem.setClassRoom("");
            lessonItem.setGroup("");
            lessonItem.setName("empty");
            lessonItem.setTeacher("");
            lessonItem.setFree(true);
        }*/
        return lessonItem;

    }

}
