package businesslogic;

import access.DAOFactory;
import access.UserDAO;
import transferobjects.User;

import java.io.Serializable;

public class UserManager implements Serializable {

    UserDAO userDao = DAOFactory.getUserDAO();


    public void addUser(User user){
        userDao.add(user);
    }
}
