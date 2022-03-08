package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.Dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.Dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.Dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepositories;
import africa.semicolon.sendAm.data.repositories.UserRepositoriesImpl;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;

public class UserServiceImpl implements UserService{
    private UserRepositories userRepositories =  new UserRepositoriesImpl();
    @Override
    public RegisterUserResponse register(RegisterUserRequest requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());
        if (emailExists(requestForm.getEmailAddress()))throw new RegisterFailureException("Duplicated Email Address");
        User theUser = new User();
        theUser.setEmail(requestForm.getEmailAddress());
        theUser.setPhoneNumber(requestForm.getPhoneNumber());
        theUser.setFullName(requestForm.getLastName()+" "+requestForm.getFirstName());

         User saveUser = userRepositories.save(theUser);
         RegisterUserResponse response = new RegisterUserResponse();
         response.setEmail(saveUser.getEmail());
         response.setFullName(saveUser.getFullName());

        return response;
    }
    private boolean emailExists(String emailAddress){
        User theUser = userRepositories.findByEmail(emailAddress);
        if (theUser == null)return false;
        return true;
    }

    @Override
    public UserRepositories getRepository() {
        return userRepositories;
    }

    @Override
    public FindUserResponse findUserByEmail(String email) {
        email = email.toLowerCase();
        User theUser = userRepositories.findByEmail(email);
        if (theUser== null)throw new UserNotFoundException(email+ "not found");
        FindUserResponse response = new FindUserResponse();
        response.setEmail(theUser.getEmail());
        response.setFullName(theUser.getFullName());
        return response;
    }

}
