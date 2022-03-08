package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.Dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.Dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.Dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.data.repositories.PackageRepositories;
import africa.semicolon.sendAm.data.repositories.UserRepositories;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest requestForm);

    UserRepositories getRepository();

    FindUserResponse findUserByEmail(String email);
}
