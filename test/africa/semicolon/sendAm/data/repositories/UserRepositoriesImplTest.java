package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserRepositoriesImplTest {
    private UserRepositories userRepositories;

    @BeforeEach
    void setUp() {
        userRepositories = new UserRepositoriesImpl();
    }

    private void createUsers() {
        User theUser1 = new User("van@yahoo.com");
        User theUser2 = new User("ven@yahoo.com");
        User theUser3 = new User("vin@yahoo.com");
        userRepositories.save(theUser1);
        userRepositories.save(theUser2);
        userRepositories.save(theUser3);
    }

    @Test
    void repositorySaveTest() {
//        given that there is a user
        User theUser = new User("vin@yahoo.com");
//        when i try to save
        User saveUser = userRepositories.save(theUser);

        assertEquals("vin@yahoo.com", saveUser.getEmail());
        assertEquals(1, userRepositories.count());
    }

    @Test
    void saveMoreUsers() {
        User theUser1 = new User("van@yahoo.com");
        User theUser2 = new User("ven@yahoo.com");
        User theUser3 = new User("vin@yahoo.com");
        userRepositories.save(theUser1);
        userRepositories.save(theUser2);
        userRepositories.save(theUser3);
        assertEquals(3, userRepositories.count());
    }

    @Test
    void findByEmail() {
        User theUser1 = new User("van@yahoo.com");
        User theUser2 = new User("ven@yahoo.com");
        User theUser3 = new User("vin@yahoo.com");
        userRepositories.save(theUser1);
        userRepositories.save(theUser2);
        userRepositories.save(theUser3);
        User findUser = userRepositories.findByEmail("ven@yahoo.com");
        assertEquals(theUser2, findUser);
        assertEquals("ven@yahoo.com", findUser.getEmail());
    }

    @Test
    void canDeleteUserByEmail() {
        createUsers();
        assertEquals(3, userRepositories.count());
//        when i try to delete by email
        userRepositories.deleteByEmail("ven@yahoo.com");
        assertEquals(2, userRepositories.count());
    }

    @Test
    void checkThatAfterDelete_itIsNull() {
        User theUser1 = new User("van@yahoo.com");
        User theUser2 = new User("ven@yahoo.com");
        User theUser3 = new User("vin@yahoo.com");
        userRepositories.save(theUser1);
        userRepositories.save(theUser2);
        userRepositories.save(theUser3);
        userRepositories.deleteByEmail("ven@yahoo.com");
        User findUser = userRepositories.findByEmail("ven@yahoo.com");
        assertNull(findUser);

    }
    @Test
    void findByNameTest(){
        User theUser1 = new User("van@yahoo.com");
        theUser1.setFullName("Van Adam");
        User theUser2 = new User("ven@yahoo.com");
        theUser2.setFullName("Ven David");
        User theUser3 = new User("vin@yahoo.com");
        theUser3.setFullName("Vin Mark");
        userRepositories.save(theUser1);
        userRepositories.save(theUser2);
        userRepositories.save(theUser3);
        User findUser = userRepositories.findByName("Van Adam");
        assertEquals(findUser, theUser1);
    }

    @Test
    void findAllTest() {
        createUsers();
        List<User> all = userRepositories.findAll();
        assertEquals(3, all.size());
    }
}
