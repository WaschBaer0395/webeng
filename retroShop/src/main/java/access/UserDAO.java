package access;

import transferobjects.User;

public interface UserDAO {


    void add(User user);
    void update(User user);
    boolean login(User user);
}
