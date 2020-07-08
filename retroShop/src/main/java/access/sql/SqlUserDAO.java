package access.sql;

import access.UserDAO;
import transferobjects.Article;
import transferobjects.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SqlUserDAO extends SqlDaoBase implements UserDAO {


    //private static final String findAllQuery = "SELECT ID,NAME,PRICE,DESCRIPTION,RELEASEDATE,MINPRICE,IMAGEPATH,SELLERID FROM WebEng.retroShop.Article";
    private static final String findQuery = "SELECT * FROM WebEng.retroShop.Customer WHERE USERNAME=?";
    private static final String updateQuery = "UPDATE WebEng.retroShop.Customer SET USERNAME=?, BIRTHDATE=?, EMAIL=?, CONTACTNUMBER=?, ADRESS=?, PASSWORD=? WHERE ID=?";
    private static final String insertQuery = "INSERT INTO WebEng.retroShop.Customer (USERNAME,BIRTHDATE,EMAIL,CONTACTNUMBER,ADDRESS,PASSWORD) VALUES(?, convert(date ,?), ?, ?, ?, ?)";
    private static final String findUserByIdQuery = "SELECT * FROM WebEng.retroShop.Customer WHERE USERID = ?";
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
    public User login(User user) {
        User u = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(findQuery);
            statement.setString(1, user.getUserName());
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                if (user.getPassword().equals(statement.getResultSet().getString("password"))) {
                    u = new User();
                    u.setId(results.getInt(1));
                    u.setUserName(results.getString(2));
                    u.setBirthDate(results.getDate(3).toLocalDate());
                    u.setEmail(results.getString(4));
                    u.setContactNumber(results.getString(5));
                    u.setAddress(results.getString(6));

                    statement.close();
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return u;
    }

    @Override
    public User findUserById(long id){
        User u = new User();
        try {
            PreparedStatement statement = getConnection().prepareStatement(findUserByIdQuery);

            statement.setLong(1, id);

            ResultSet results = statement.executeQuery();
            if (results.next()) {
                u = new User();
                u.setId(results.getInt(1));
                u.setUserName(results.getString(2));
                u.setBirthDate(results.getDate(3).toLocalDate());
                u.setEmail(results.getString(4));
                u.setContactNumber(results.getString(5));
                u.setAddress(results.getString(6));
            }

            statement.close();
            results.close();
            return u;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

}
