package kz.bcc.balatime.timetable.model.dto.studentUser;

import lombok.Data;

@Data
public class StudentProgressListDto {
    private Integer ord;
    private String  subject;
    private String  homework;
    private String  grade;
}
