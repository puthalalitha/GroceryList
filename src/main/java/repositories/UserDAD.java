package repositories;

import models.User;

public interface UserDAD {
    User getUserGivenUsername(String username);
    void createUser(User user);
}
