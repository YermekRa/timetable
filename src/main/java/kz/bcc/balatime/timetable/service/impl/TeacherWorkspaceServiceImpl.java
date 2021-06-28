package kz.bcc.balatime.timetable.service.impl;

import kz.bcc.balatime.timetable.model.Teacher;
import kz.bcc.balatime.timetable.model.Timetable;
import kz.bcc.balatime.timetable.model.User;
import kz.bcc.balatime.timetable.model.dto.teacher.LessonItem;
import kz.bcc.balatime.timetable.model.dto.teacher.WorkspaceRow;
import kz.bcc.balatime.timetable.repository.TeacherRepository;
import kz.bcc.balatime.timetable.repository.TimetableRepository;
import kz.bcc.balatime.timetable.repository.UserRepository;
import kz.bcc.balatime.timetable.service.admin.TeacherWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherWorkspaceServiceImpl implements TeacherWorkspaceService {
    @Autowired
    TimetableRepository timetableRepository;
    @Autowired
    UserRepository userRepository;  ///get id by login
    @Autowired
    TeacherRepository teacherRepository;  ///get id by login
    @Override
    public List<WorkspaceRow> getAll(String username) {
        List<WorkspaceRow> workspaceTable = new ArrayList<>();
        User user = userRepository.getUserByLogin(username); ///get id by login
        Teacher teacher = teacherRepository.findFirstByUserId(user.getId()); //get id by login
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        for (int i = 0; i < 10; i++) {

            List<Timetable> timetableListByOrder = timetableRepository.findAllByTeacherIdAndDayOfWeek(teacher.getId(), dayOfWeek);
            WorkspaceRow workspaceRow = new WorkspaceRow();
            workspaceRow.setTime((i + 8) + ":00");
            workspaceRow.setDayOfWeek(dayOfWeek);
            workspaceRow.setLesson( objectMapperDto(timetableListByOrder,dayOfWeek));

            workspaceTable.add(workspaceRow);
        }


        return workspaceTable;
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

            lessonItem.setFree(false);
        } else {
            lessonItem.setClassRoom("");
            lessonItem.setGroup("");
            lessonItem.setName("Записи нет");
            lessonItem.setTeacher("");
            lessonItem.setFree(true);
        }
        return lessonItem;

    }
}
