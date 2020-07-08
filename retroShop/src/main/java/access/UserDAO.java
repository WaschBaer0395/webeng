package access;

import transferobjects.Article;
import transferobjects.User;

import java.util.List;

public interface UserDAO {


    void add(User user);
    void update(User user);
    User login(User user);
    User findUserById(long id);
}
