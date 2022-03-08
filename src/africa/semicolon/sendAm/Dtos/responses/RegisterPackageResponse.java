package africa.semicolon.sendAm.Dtos.responses;

import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.Status;
import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class RegisterPackageResponse {
   private int packageQuantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public int getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(int packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public PackageDescription getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(PackageDescription packageDescription) {
        this.packageDescription = packageDescription;
    }

    private PackageDescription packageDescription;


}
