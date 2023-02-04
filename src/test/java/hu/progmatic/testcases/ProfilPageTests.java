package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.ProfilPage;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverBaseTest {

    ProfilPage profilPage;

    @Test
    public void loadProfilPageTest(){
        profilPage = new ProfilPage(driver, wait);
        profilPage.loadProfilPage();
    }
}
