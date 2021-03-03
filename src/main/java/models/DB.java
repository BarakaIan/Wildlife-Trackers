package models;

import org.sql2o.Sql2o;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa","D2000sep10");

    static String connectionString = "jdbc:postgresql://ec2-54-209-43-223.compute-1.amazonaws.com:5432/d48ug4jn1iqcb1";
    public static Sql2o sql2o = new Sql2o(connectionString, "srkbnttatmxstb", "352f53fd31b19ea8eef837dcbd7d7260e05ee7cddffa5e305a3b253dc7df04cd");

}

