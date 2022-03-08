package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.Dtos.requests.RegisterPackageRequest;
import africa.semicolon.sendAm.Dtos.responses.RegisterPackageResponse;
import africa.semicolon.sendAm.Dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.data.repositories.PackageRepositories;
import africa.semicolon.sendAm.data.repositories.UserRepositories;

public interface PackageService {
    RegisterPackageResponse register(RegisterPackageRequest requestForm);

    PackageRepositories getRepositories();
}
