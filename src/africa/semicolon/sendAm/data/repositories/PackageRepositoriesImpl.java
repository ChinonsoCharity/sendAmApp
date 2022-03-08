package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PackageRepositoriesImpl implements PackageRepositories{
    private List<Package> db = new ArrayList<>();
    private int id = 0;
    @Override
    public Package save(Package aPackage) {
//        return null;
        int id = generateId();
        aPackage.setId(id);
        db.add(aPackage);
//        return db.get(id-1);
//        return db.get(--id/id--);
        return aPackage;

    }

    private int generateId() {
//       return id = id + 1;
     return ++ this.id;
//        return db.size()+1;
//        return 0;
    }

    @Override
    public Package findById(int id) {
//        return null;
        for (Package aPackage :db){
            if (aPackage.getId()==id) {
                return aPackage;
            }
        }

        return null;
    }

    @Override
    public void delete(Package aPackage) {
        db.remove(aPackage);

    }

    @Override
    public void delete(int id) {
        Package foundPackage = findById(id);
        delete(foundPackage);
    }

    @Override
    public List<Package> findAll() {
        return db;
    }

    @Override
    public int count() {
//        return 0;
        return db.size();
    }
}
