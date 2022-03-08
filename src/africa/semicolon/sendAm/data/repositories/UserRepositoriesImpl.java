package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesImpl implements UserRepositories {
    private List<User> db = new ArrayList<>();

    @Override
    public User save(User user) {
//        return null;
        db.add(user);
        return user;

    }

    @Override
    public User findByName(String fullName) {
        for (User theUser : db){
            if (theUser.getFullName().equals(fullName)){
                return theUser;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
//        return null;
        for (User theUser :db){
            if (theUser.getEmail().equals(email)){
                return theUser;
            }
        }
        return null;
    }

    @Override
    public void delete(User theUser) {
        db.remove(theUser);

    }

    @Override
    public void deleteByEmail(String email) {
        User theUser = findByEmail(email);
        delete(theUser);

    }

    @Override
    public List<User> findAll() {
//        return null;
        return db;
    }

    @Override
    public int count() {
        return db.size();
    }
}
