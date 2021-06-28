package kz.bcc.balatime.timetable.service.impl.student;

import kz.bcc.balatime.timetable.model.dto.studentUser.StudentProgressListDto;
import kz.bcc.balatime.timetable.service.student.StudentProgressListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentProgressListServiceImpl implements StudentProgressListService {
    @Override
    public List<StudentProgressListDto> getAll(Integer studentId) {
        List<StudentProgressListDto> studentProgressListDtoArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer subjectOrder = i + 1;
            StudentProgressListDto studentProgressListDto = new StudentProgressListDto();
            studentProgressListDto.setOrd(i);
            studentProgressListDto.setSubject("Subject"+i);
            studentProgressListDto.setHomework("Homework"+i);
            studentProgressListDto.setGrade("Grade"+i);
            studentProgressListDtoArrayList.add(studentProgressListDto);
        }


        return studentProgressListDtoArrayList;
    }
}
