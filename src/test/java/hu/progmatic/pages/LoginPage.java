package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By headerBy = By.id("top");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void loadLoginPage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement headerElement = driver.findElement(headerBy);
        Assert.assertTrue(headerElement.isDisplayed());
        System.out.println("Login page loaded properly.");
    }

    public void wrongUsernameAndWrongPwTest() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement headerElement = driver.findElement(headerBy);
        Assert.assertTrue(headerElement.isDisplayed());
        System.out.println("Login page loaded properly.");
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("kinga1");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("titkosjelszo");
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();
        System.out.println("Clicked on login button");
        WebElement alert = driver.findElement(By.className("lead text-danger"));
        Assert.assertEquals(alert.getText(), "Login failed! Please ensure the username and password are valid.");

    }

    public void validUsernameAndValidPwTest(){
        loadLoginPage();
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();
        System.out.println("Clicked on login button");
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

    }
}
