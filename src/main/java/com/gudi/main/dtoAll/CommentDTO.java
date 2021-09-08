package com.gudi.main.dtoAll;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CommentDTO {
    private int cmNum;
    private String id;
    private String division;
    private String content;
    private String date;
    private String delCheck;
}
