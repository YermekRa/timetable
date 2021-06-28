package kz.bcc.balatime.timetable.service.teacher;

import kz.bcc.balatime.timetable.model.teacher.journal.TeacherJournalDto;

import java.util.List;

public interface TeacherJournalService {
    List<TeacherJournalDto> getLesson ();
}
