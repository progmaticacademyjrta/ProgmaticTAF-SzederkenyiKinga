package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverBaseTest {

    HomePage homePage;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    ProfilPage profilPage;

    @Test
    public void endToEndTest() {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
        profilPage = new ProfilPage(driver, wait);

        homePage.loadHomePage();
        loginPage.loadLoginPage();
        loginPage.validUsernameAndValidPwTest();
        appointmentPage.loadAppointmentPageAndMakeAnAppointmentTest();

        WebElement hamburgerMenu = driver.findElement(By.id("menu-toggle"));
        hamburgerMenu.click();
        WebElement logOutMenuOption = driver.findElement(By.linkText("Logout"));
        logOutMenuOption.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Loaded home page, loaded login page, booked an appointment and exited from profile");
    }

}
