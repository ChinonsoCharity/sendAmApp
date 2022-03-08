package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.Dtos.requests.RegisterPackageRequest;
import africa.semicolon.sendAm.Dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.data.models.Status;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServiceImplTest {
    private PackageService packageService;

    @BeforeEach
    public void setUp() {
        packageService = new PackageServiceImpl();
    }

    private RegisterPackageRequest createRegisterForm() {
        RegisterPackageRequest requestForm = new RegisterPackageRequest();
//        requestForm.setId(1);
        requestForm.setPackageDescription("Blue Ray", 30.0);
        requestForm.setOwner("Van Adams", "van@yahoo.com", "08132345678");

        return requestForm;
    }

    @Test
    void afterRegister_containOnePackage() {
        RegisterPackageRequest requestForm = new RegisterPackageRequest();

        requestForm.setName("Blue Ray");
        requestForm.setWeightInGrammes(30.0);
        requestForm.setOwner("Van Adams", "van@yahoo.com", "08132345678");
        requestForm.setPackageQuantity(4);
//        when
        packageService.register(requestForm);
//      assert
        assertEquals(1, packageService.getRepositories().count());
    }

    @Test
    public void duplicateId_throwExceptions() {
        RegisterPackageRequest blueForm = createRegisterForm();
//        when
        packageService.register(blueForm);
//        assert
        assertThrows(SendAmAppException.class, () -> packageService.register(blueForm));
        assertThrows(RegisterFailureException.class, () -> packageService.register(blueForm));

    }

}