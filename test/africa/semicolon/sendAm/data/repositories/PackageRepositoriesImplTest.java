package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoriesImplTest {
    private PackageRepositories packageRepositories;
    @BeforeEach
    void setUp(){
        packageRepositories = new PackageRepositoriesImpl();
    }
    private void saveThreePackage(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();
        packageRepositories.save(firstPackage);
        packageRepositories.save(secondPackage);
        packageRepositories.save(thirdPackage);
    }
    @Test
    void repositorySaveTest(){
        //given there is a package
        Package aPackage = new Package();
        //when I try to save in the repository
        Package savePackage = packageRepositories.save(aPackage);
        //assert that the returned has an id;
        assertEquals(1,savePackage.getId());
        //assert that the count is 1;
        assertEquals(1,packageRepositories.count());

    }
    @Test
    void repositoryFindByIdTest(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();
        packageRepositories.save(firstPackage);
        packageRepositories.save(secondPackage);
        packageRepositories.save(thirdPackage);

        Package foundPackage = packageRepositories.findById(2);
        assertEquals(secondPackage,foundPackage);
        assertEquals(2,foundPackage.getId());

    }
    @Test
    void deleteByIdTest(){
       saveThreePackage();

        packageRepositories.delete(2);
        assertEquals(2,packageRepositories.count());
    }
    @Test
    void findByIdWorksAfterDeleteTest(){
      saveThreePackage();
      packageRepositories.delete(2);

      Package foundPackage = packageRepositories.findById(2);
      assertNull(foundPackage);
    }
@Test
    void saveAfterADelete_giveCorrectPackageIdTest(){
        saveThreePackage();
        packageRepositories.delete(1);
        Package savePackage =packageRepositories.save(new Package());
        assertEquals(4,savePackage.getId());
}
@Test
    void deleteByPackageTest(){
    Package firstPackage = new Package();
    Package secondPackage = new Package();
    Package thirdPackage = new Package();
    packageRepositories.save(firstPackage);
    packageRepositories.save(secondPackage);
    packageRepositories.save(thirdPackage);

    packageRepositories.delete(secondPackage);
    assertEquals(2,packageRepositories.count());
    assertNull(packageRepositories.findById(2));
}
@Test
    void findAllTest(){
        saveThreePackage();
    List<Package> all = packageRepositories.findAll();
    assertEquals(3,all.size());
}
}