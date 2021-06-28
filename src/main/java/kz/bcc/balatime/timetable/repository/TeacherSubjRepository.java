package kz.bcc.balatime.timetable.repository;

import kz.bcc.balatime.timetable.model.TeacherSubj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherSubjRepository extends JpaRepository<TeacherSubj, Integer> {
}
