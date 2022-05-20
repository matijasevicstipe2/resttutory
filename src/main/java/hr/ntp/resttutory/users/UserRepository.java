package hr.ntp.resttutory.users;

import hr.ntp.resttutory.users.User;
import hr.ntp.resttutory.users.User2;

import java.io.IOException;
import java.util.List;

public interface UserRepository {
    int save(User user) throws IOException;
    List<User2> findAll();
    User2 findById(Long id);
}
