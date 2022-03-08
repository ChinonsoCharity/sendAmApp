package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.Dtos.requests.RegisterPackageRequest;
import africa.semicolon.sendAm.Dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.Dtos.responses.RegisterPackageResponse;
import africa.semicolon.sendAm.Dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.Status;
import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.PackageRepositories;
import africa.semicolon.sendAm.data.repositories.PackageRepositoriesImpl;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;

public class PackageServiceImpl implements PackageService{

private PackageRepositories packageRepositories = new PackageRepositoriesImpl();
    @Override
    public RegisterPackageResponse register(RegisterPackageRequest requestForm) {
//        if (idExists(requestForm.getId()))throw new RegisterFailureException("Duplicated Package ID");
        Package thePackage = new Package();
        thePackage.setName(requestForm.getName());
        thePackage.setWeightInGrammes(requestForm.getWeightInGrammes());
        thePackage.setOwner(requestForm.getOwner());
        thePackage.setPackageQuantity(requestForm.getPackageQuantity());
        Package savePackage = packageRepositories.save(thePackage);
        RegisterPackageResponse response = new RegisterPackageResponse();
        response.setName(savePackage.getName());
        response.setPackageQuantity(savePackage.getPackageQuantity());
//        response.getStatusList();

        return response;
    }

    private boolean idExists(int id) {
        Package thePackage = packageRepositories.findById(id);
        if (thePackage == null)return false;
        return true;
    }

    @Override
    public PackageRepositories getRepositories() {
        return packageRepositories;
    }


}

