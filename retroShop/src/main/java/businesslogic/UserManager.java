package businesslogic;

import access.DAOFactory;
import access.UserDAO;
import transferobjects.User;

import java.io.Serializable;

public class UserManager implements Serializable {

    private UserDAO userDao = DAOFactory.getUserDAO();


    public void addUser(User user){
        userDao.add(user);
    }
    public void updateUser(User user){
        userDao.update(user);
    }


    public boolean loginUser(User user){
        return userDao.login(user);
    }
}
