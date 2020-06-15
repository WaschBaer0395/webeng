package webengShop2.acess;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnect {

    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/articles?characterEncoding=utf8","webeng","qwertz");
            return con;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }
}
