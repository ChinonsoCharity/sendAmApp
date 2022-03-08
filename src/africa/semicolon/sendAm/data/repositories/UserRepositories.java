package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;

import java.util.List;

public interface UserRepositories {
    User save(User user);
    User findByName(String fullName);
    User findByEmail(String email);
    void delete(User user);
    void deleteByEmail(String email);
    List<User> findAll();
    int count();



}
