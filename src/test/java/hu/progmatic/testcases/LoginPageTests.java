package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {

    LoginPage loginPage;

    @Test
    public void navigateToLoginPageAndMakeTestsOnItTest() {
        loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.wrongUsernameAndWrongPwTest();
        loginPage.validUsernameAndValidPwTest();

    }

}