package kz.bcc.balatime.timetable.model.dto.studentUser;

import lombok.Data;

@Data
public class StudentHTDLItem {
    private String title;
    private String summary;
    private StudentHTDLItemContent content;
}
