package kz.bcc.balatime.timetable.repository;


import kz.bcc.balatime.timetable.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Page<Teacher> findAll(Pageable pageableRequest);

    Teacher findFirstByUserId(Integer userId);
}
