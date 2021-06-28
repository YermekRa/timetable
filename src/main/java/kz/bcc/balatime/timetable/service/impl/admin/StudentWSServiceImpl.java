package kz.bcc.balatime.timetable.service.impl.admin;

import kz.bcc.balatime.timetable.model.dto.studentUser.StudentHTDLItem;
import kz.bcc.balatime.timetable.model.dto.studentUser.StudentHTDLItemContent;
import kz.bcc.balatime.timetable.model.dto.studentUser.StudentLessons;
import kz.bcc.balatime.timetable.service.admin.StudentWSService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentWSServiceImpl implements StudentWSService {
    @Override
    public List<StudentHTDLItem> getHotData(Integer studentId) {
        List<StudentHTDLItem> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            StudentHTDLItem studentHTDLItem = new StudentHTDLItem();
            studentHTDLItem.setTitle("08:00 Subject " + i);
            studentHTDLItem.setSummary("Teacher " + i);
            StudentHTDLItemContent content = new StudentHTDLItemContent();
            content.setClassRoom("Classroom " + i);
            content.setHomeWork("Homework " + i);
            content.setNextLesson("Lesson title " + i);
            content.setAttendance(i % 2 == 0);
            content.setGrade(i * 10 - 4);
            studentHTDLItem.setContent(content);
            list.add(studentHTDLItem);
        }
        return list;
    }

    @Override
    public List<StudentLessons> getMyCources(Integer studentId) {
        List<StudentLessons> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentLessons myCourcesItem = new StudentLessons();
            myCourcesItem.setName("Subject" + i);
            myCourcesItem.setTeacher("Teacher" + i);
            list.add(myCourcesItem);
        }
        return list;
    }
}
