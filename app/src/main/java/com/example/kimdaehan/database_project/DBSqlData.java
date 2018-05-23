package com.example.kimdaehan.database_project;

public class DBSqlData
{

    public static final String SQL_DB_CREATE_TABLE
            = "CREATE TABLE db_table_test " +
            "(reg_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL, " +
            "make TEXT NOT NULL, " +
            "buy TEXT NOT NULL, " +
            "open TEXT NOT NULL, " +
            "store TEXT NOT NULL, " +
            "num TEXT NOT NULL)";

    public static final String SQL_DB_SELECT_ALL
            = "SELECT * FROM db_table_test ORDER BY reg_id DESC";

    public static final String SQL_DB_DELETE_DATA
            = "DELETE FROM db_table_test " + "WHERE phone_number=?";
}