package com.example.majorproject;

public class DBstruct {
    private DBstruct() {};

    public static final String TBL_NAME = "historyTBL";
    public static final String COL_NO = "NO";
    public static final String COL_DATE = "DATE";
    public static final String COL_DEVICE = "DEVICE";
    public static final String COL_SIZE = "SIZE";
    public static final String COL_SUCCESS = "ISSUCCESS";

    public static final String SQL_CREATE_TBL
            = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " " +
            "(" +
            COL_NO + "INTEGER NOT NULL" + ", " +
            COL_DATE + "TEXT" + ", " +
            COL_DEVICE + "TEXT" + ", " +
            COL_SIZE + "INTEGER" + ", " +
            COL_SUCCESS + "INTEGER" +
            ")";
    public static final String SQL_SELECT
            = "SELECT * FROM " + TBL_NAME;

    public static final String SQL_DELETE
            = "DELETE FROM " + TBL_NAME;

}