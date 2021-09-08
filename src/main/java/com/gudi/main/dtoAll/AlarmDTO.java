package com.gudi.main.dtoAll;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class AlarmDTO {
    private int alarmNum;
    private String id;
    private String content;
    private String date;
    private String alarmCheck;
}
