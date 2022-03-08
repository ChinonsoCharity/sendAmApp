package africa.semicolon.sendAm.Dtos.requests;

import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.Status;
import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class RegisterPackageRequest {
    private User owner;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightInGrammes() {
        return weightInGrammes;
    }

    public void setWeightInGrammes(double weightInGrammes) {
        this.weightInGrammes = weightInGrammes;
    }

    private double weightInGrammes;

    public int getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(int packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    private int packageQuantity;

    public User getOwner() {
        return owner;
    }

    public void setOwner(String ownerFullName, String ownerEmail, String ownerPhoneNumber) {
        User owner = new User();
        owner.setFullName(ownerFullName);
        owner.setEmail(ownerEmail);
        owner.setPhoneNumber(ownerPhoneNumber);
    }

    public void setPackageDescription(String packageName, double packageWeight) {
        PackageDescription thePackageDescription = new PackageDescription();
        thePackageDescription.setName(packageName);
        thePackageDescription.setWeightInGrammes(packageWeight);
    }
}


