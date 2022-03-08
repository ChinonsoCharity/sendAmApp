package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.Dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.Dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.Dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;
    @BeforeEach
    public void testSetup(){
        userService= new UserServiceImpl();
    }
    private RegisterUserRequest createRegisterForm(){
        RegisterUserRequest requestForm =new RegisterUserRequest();
        requestForm.setFirstName("Chinonso");
        requestForm.setLastName("Nwokonko");
        requestForm.setEmailAddress("chacha@yahoo.com");
        requestForm.setAddress("Semicolon");
        requestForm.setPhoneNumber("08132227300");
        return requestForm;
    }
    @Test
    void afterRegister_repositoryContainOneElement(){
        RegisterUserRequest requestForm =new RegisterUserRequest();
        requestForm.setFirstName("Chinonso");
        requestForm.setLastName("Nwokonko");
        requestForm.setEmailAddress("chacha@yahoo.com");
        requestForm.setAddress("Semicolon");
        requestForm.setPhoneNumber("08132227300");
//        when
        userService.register(requestForm);
//        assert
        assertEquals(1,userService.getRepository().count());
    }
    @Test
    public void duplicateEmail_throwExceptions(){
        RegisterUserRequest nonsoForm = createRegisterForm();
//        when
        userService.register(nonsoForm);
//        assert
        assertThrows(SendAmAppException.class,()->userService.register(nonsoForm));
        assertThrows(RegisterFailureException.class,()->userService.register(nonsoForm));
    }
    @Test
    public void duplicateEmailWithDifferentCase_throwException(){
        RegisterUserRequest nonsoForm =createRegisterForm();
        userService.register(nonsoForm);
        nonsoForm.setEmailAddress("ChaCha@yahoo.com");
        assertThrows(SendAmAppException.class,()->userService.register(nonsoForm));
    }
    @Test
    public void registrationReturnCorrectResponseTest(){
        RegisterUserRequest nonsoForm =createRegisterForm();
        RegisterUserResponse response = userService.register(nonsoForm);

        assertEquals("Nwokonko Chinonso",response.getFullName());
        assertEquals("chacha@yahoo.com",response.getEmail());
    }
    @Test
    public void findRegisteredUserByEmailTest(){
        RegisterUserRequest nonsoForm = createRegisterForm();
        userService.register(nonsoForm);
        FindUserResponse response = userService.findUserByEmail(nonsoForm.getEmailAddress().toLowerCase());

        assertEquals("Nwokonko Chinonso",response.getFullName());
        assertEquals("chacha@yahoo.com",response.getEmail());
     }
    @Test
    public void findRegisteredUserByEmailTest_throwsExceptionTest() {
        RegisterUserRequest nonsoForm = createRegisterForm();
        userService.register(nonsoForm);
        assertThrows(UserNotFoundException.class, () -> userService.findUserByEmail("nonso@gamil.com"));
    }
    @Test
    public void findRegisteredUserByEmailIsCanCaseSensitiveTest(){
        RegisterUserRequest nonsoForm = createRegisterForm();
        userService.register(nonsoForm);
        FindUserResponse response = userService.findUserByEmail("ChaCha@yahoo.com");

        assertEquals("Nwokonko Chinonso",response.getFullName());
        assertEquals("chacha@yahoo.com",response.getEmail());
    }


}