package com.gudi.main.reserve.dao;

public class ReserveSQL {
    public static final String CM_INSERT = "INSERT INTO cm(cmNum,id,division,content,delCheck,divisionNum)" +
            "VALUES(cm_seq.NEXTVAL,#{id},'camping',#{content},'N',#{divisionNum})";
}
