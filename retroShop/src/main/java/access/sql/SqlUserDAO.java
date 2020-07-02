package access.sql;

import access.UserDAO;
import transferobjects.User;

import java.sql.Date;
import java.sql.PreparedStatement;

public class SqlUserDAO extends SqlDaoBase implements UserDAO {


    //private static final String findAllQuery = "SELECT ID,NAME,PRICE,DESCRIPTION,RELEASEDATE,MINPRICE,IMAGEPATH,SELLERID FROM WebEng.retroShop.Article";
    private static final String findQuery = "SELECT * FROM WebEng.retroShop.Customer WHERE USERNAME=?";
    private static final String updateQuery = "UPDATE WebEng.retroShop.Customer SET USERNAME=?, BIRTHDATE=?, EMAIL=?, CONTACTNUMBER=?, ADRESS=?, PASSWORD=? WHERE ID=?";
    private static final String insertQuery = "INSERT INTO WebEng.retroShop.Customer (USERNAME,BIRTHDATE,EMAIL,CONTACTNUMBER,ADDRESS,PASSWORD) VALUES(?, convert(date ,?), ?, ?, ?, ?)";
    //private static final String deleteQuery = "DELETE FROM WebEng.retroShop.Article WHERE ID=?";


    @Override
    public void add(User user) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(insertQuery);
            statement.setString(1, user.getUserName());
            statement.setDate(2, Date.valueOf(user.getBirthDate()));
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getContactNumber());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getPassword());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(updateQuery);
            statement.setString(1, user.getUserName());
            statement.setDate(2, Date.valueOf(user.getBirthDate()));
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getContactNumber());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getPassword());
            statement.setLong(7, user.getId());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(User user) {

        try {
            PreparedStatement statement = getConnection().prepareStatement(findQuery);
            statement.setString(1, user.getUserName());
            statement.execute();
            //statement.close();

            if (statement.getResultSet().first()) {
                if (user.getPassword().equals(statement.getResultSet().getString("password"))) {
                    statement.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            System.out.println("finally");
        }
        return false;
    }
}
