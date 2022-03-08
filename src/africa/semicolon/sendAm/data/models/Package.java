package africa.semicolon.sendAm.data.models;

import java.util.ArrayList;
import java.util.List;

public class Package {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public int getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(int packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    private int packageQuantity;
    private User owner;
//    private PackageDescription packageDescription;
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
    private final List<Status> statusList = new ArrayList<>();


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

//    public PackageDescription getPackageDescription() {
//        return packageDescription;
//    }
//
//    public void setPackageDescription(PackageDescription packageDescription) {
//        this.packageDescription = packageDescription;
//    }

    public List<Status> getStatusList() {
        return statusList;
    }
    public void setStatusList(Status status) {
        statusList.add(status);
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageQuantity=" + packageQuantity +
                ", owner=" + owner +
                ", statusList=" + statusList +
                '}';
    }
}
