package models;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa","D2000sep10");

//    static String connectionString = "jdbc:postgresql://ec2-18-207-95-219.compute-1.amazonaws.com:5432/d76oj01pmq8n25";
//    public static Sql2o sql2o = new Sql2o(connectionString, "zaeukqqmtbkels", "65ea0ec8cfd71033e5a03e68df13c1015909206e931da3c4f534e0b28099f529");

}

