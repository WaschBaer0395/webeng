package access.mock;

import access.UserDAO;
import transferobjects.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MockUserDAO implements UserDAO {

    List<User> list = new ArrayList<>();

    public MockUserDAO(){

        //SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        //https://stackoverflow.com/questions/2923227/displaying-date-of-birth-in-java-by-using-date-util



        User user1 = new User();
        user1.setId(0);
        user1.setUserName("Laura");
        user1.setBirthDate("01/08/1985");
        user1.setAddress("Holunderblütenallee 2b");
        user1.setEmail("hallo@hallo.de");
        user1.setContactNumber("01405432");
        user1.setPassword("daihdiwdia332!");
        list.add(user1);

        User user2 = new User();
        user2.setId(1);
        user2.setUserName("Nadtjia");
        user2.setBirthDate("01/08/1985");
        user2.setAddress("Holunderblütenallee 2b");
        user2.setEmail("hallo@hallo.de");
        user2.setContactNumber("01405432");
        user2.setPassword("daihdiwdia332!");
        list.add(user2);

        User user3 = new User();
        user3.setId(2);
        user3.setUserName("Michelle");
        user3.setBirthDate("01/08/1985");
        user3.setAddress("Holunderblütenallee 2b");
        user3.setEmail("hallo@hallo.de");
        user3.setContactNumber("01405432");
        user3.setPassword("daihdiwdia332!");
        list.add(user3);

        User user4 = new User();
        user4.setId(3);
        user4.setUserName("Mattthias");
        user4.setBirthDate("01/08/1985");
        user4.setAddress("Holunderblütenallee 2b");
        user4.setEmail("hallo@hallo.de");
        user4.setContactNumber("01405432");
        user4.setPassword("daihdiwdia332!");
        list.add(user4);
    }


    @Override
    public void add(User user) {
        list.add(user);
    }

    @Override
    public void update(User user) {
        User a = get(user.getId());
        a.setPassword(user.getPassword());
        a.setEmail(user.getEmail());
        a.setAddress(user.getAddress());
        a.setUserName(user.getUserName());
        a.setBirthDate(user.getBirthDate());
        a.setContactNumber(user.getContactNumber());
    }

    @Override
    public boolean login(User user) {
        return false;
    }


    public User get(long id) {
        User a = null;
        try
        {
            a = list.get((int) id);
            return a;
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("MockArticleDAO::get: indexOutOfBounds");
        }

        return a;
    }
}
