package businesslogic;

import access.DAOFactory;
import access.UserDAO;
import transferobjects.Article;
import transferobjects.User;

import java.io.Serializable;
import java.util.List;

public class UserManager implements Serializable {

    private UserDAO userDao = DAOFactory.getUserDAO();


    public void addUser(User user){
        userDao.add(user);
    }
    public void updateUser(User user){
        userDao.update(user);
    }

    public User getUserById(long id){
        return userDao.findUserById(id);
    }

    public User loginUser(User user){
        return userDao.login(user);
    }
}
