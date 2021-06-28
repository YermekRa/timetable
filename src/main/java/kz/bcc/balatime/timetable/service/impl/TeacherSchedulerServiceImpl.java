package kz.bcc.balatime.timetable.service.impl;

import kz.bcc.balatime.timetable.model.EduYear;
import kz.bcc.balatime.timetable.model.Teacher;
import kz.bcc.balatime.timetable.model.Timetable;
import kz.bcc.balatime.timetable.model.User;
import kz.bcc.balatime.timetable.model.dto.teacher.LessonItem;
import kz.bcc.balatime.timetable.model.dto.teacher.SchedulerRow;
import kz.bcc.balatime.timetable.repository.TeacherRepository;
import kz.bcc.balatime.timetable.repository.TimetableRepository;
import kz.bcc.balatime.timetable.repository.UserRepository;
import kz.bcc.balatime.timetable.service.admin.TeacherSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherSchedulerServiceImpl implements TeacherSchedulerService {
    @Autowired
    TimetableRepository timetableRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<SchedulerRow> getAll(String username, EduYear eduYear) {
        List<SchedulerRow> schedulerTable = new ArrayList<>();
        User user = userRepository.getUserByLogin(username);
        Teacher teacher = teacherRepository.findFirstByUserId(user.getId());
        for (int i = 0; i < 10; i++) {
            Integer subjectOrder = i + 1;
            List<Timetable> timetableListByOrder = timetableRepository.findAllByTeacherIdAndSubjectOrder(teacher.getId(), subjectOrder);
            SchedulerRow schedulerRow = new SchedulerRow();
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

    LessonItem objectMapperDto(List<Timetable> timetableListByOrder, DayOfWeek dayOfWeek) {

        LessonItem lessonItem = new LessonItem();
        Optional<Timetable> ot = timetableListByOrder.stream().filter(tt -> tt.getDayOfWeek().getValue() == dayOfWeek.getValue()).findFirst();
        if (ot.isPresent()) {
            Timetable timetable = ot.get();
            lessonItem.setClassRoom(timetable.getRoom().getCode() + ", " + timetable.getRoom().getName());
            lessonItem.setGroup(timetable.getClasss().getCode());
            lessonItem.setName(timetable.getSubject().getCode());
            lessonItem.setTeacher(timetable.getTeacher().getFirstName());
            lessonItem.setTeacherln(timetable.getTeacher().getLastName());
            lessonItem.setTimetableId(timetable.getId());
            lessonItem.setFree(false);
        } else {
            lessonItem.setClassRoom("");
            lessonItem.setGroup("");
            lessonItem.setName("empty");
            lessonItem.setTeacher("");
            lessonItem.setFree(true);
        }
        return lessonItem;

    }
}
