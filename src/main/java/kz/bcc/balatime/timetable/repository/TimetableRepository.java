package kz.bcc.balatime.timetable.repository;

import kz.bcc.balatime.timetable.model.Timetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
    List<Timetable> findAllByTeacherIdAndDayOfWeek(Integer teacherId, DayOfWeek dayOfWeek);

    List<Timetable> getAllByTeacherIdAndSubjectOrder(Integer teacherId, Integer subjectOrder);

    List<Timetable> findAllByTeacherIdAndSubjectOrder(Integer teacherId, Integer subjectOrder);

    List<Timetable> findAllByTeacherId(Integer teacherId);

    List<Timetable> findAllByClasssAndDayOfWeek(Integer classs, DayOfWeek dayOfWeek);
    List<Timetable> findAllByClasssIdAndSubjectOrder(Integer classsId, Integer subjectOrder);
//    Timetable findFirstByTeacherIdAndDayOfWeekAndSubject_order(Integer teacherId, DayOfWeek dayOfWeek, Integer subjectOrd);
}
