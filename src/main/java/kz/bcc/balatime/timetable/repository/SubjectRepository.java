package kz.bcc.balatime.timetable.repository;


import kz.bcc.balatime.timetable.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByCode(String code);
    boolean existsByCode(String code);
}
