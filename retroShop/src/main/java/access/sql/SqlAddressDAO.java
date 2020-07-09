package access.sql;

import access.AddressDAO;
import transferobjects.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SqlAddressDAO extends SqlDaoBase implements AddressDAO {


    private static final String findQuery = "SELECT * FROM WebEng.retroShop.Address WHERE userid = ?";
    private static final String updateQuery = "UPDATE WebEng.retroShop.Address SET CITY=?, REGION=?, STREET=?, HOUSENUMBER=?, ZIPCODE=? WHERE USERID=?";
    private static final String insertQuery = "INSERT INTO WebEng.retroShop.Address (USERID,CITY,REGION,STREET,HOUSENUMBER,ZIPCODE) VALUES(?, ?, ?, ?, ?, ?)";


    @Override
    public void add(Address a) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(insertQuery);
            statement.setLong(1, a.getUserId());
            statement.setString(2, a.getCity());
            statement.setString(3, a.getRegion());
            statement.setString(4, a.getStreet());
            statement.setString(5, a.getHouseNumber());
            statement.setString(6, a.getZipCode());

            statement.execute();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Address getAddress(long userId) {

        Address a = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(findQuery);
            statement.setLong(1, userId);

            ResultSet results = statement.executeQuery();
            if (results.next()) {
                a = new Address();
                a.setUserId(results.getLong(1));
                a.setCity(results.getString(2));
                a.setRegion(results.getString(3));
                a.setStreet(results.getString(4));
                a.setHouseNumber(results.getString(5));
                a.setZipCode(results.getString(6));
            }

            statement.close();
            results.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return a;
    }

    @Override
    public void update(Address a) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = getConnection().prepareStatement(updateQuery);
            statement.setString(1, a.getCity());
            statement.setString(2, a.getRegion());
            statement.setString(3, a.getStreet());
            statement.setString(4, a.getHouseNumber());
            statement.setString(5, a.getZipCode());
            statement.executeUpdate();
            connection.commit();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
