package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilPage {
    WebDriver driver;
    WebDriverWait wait;
    By headerBy = By.id("top");

    LoginPage loginPage;

    public ProfilPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadProfilPage() {
        loginPage.validUsernameAndValidPwTest();
        WebElement hamburgerMenu = driver.findElement(By.id("menu-toggle"));
        hamburgerMenu.click();
        WebElement profilMenuOption = driver.findElement(By.linkText("Profile"));
        profilMenuOption.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#profile");
        System.out.println("Profile page is loaded");
    }
}
