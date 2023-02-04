package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;
    By headerBy = By.id("top");

    LoginPage loginPage;

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadAppointmentPageAndMakeAnAppointmentTest(){
        loginPage.validUsernameAndValidPwTest();
        Select facilityDropdown = new Select(driver.findElement(By.id("combo_facility")));
        facilityDropdown.selectByVisibleText("Hongkong CURA Healthcare Center");
        System.out.println("Chosen "+ facilityDropdown);

        WebElement healthcareProgramRadio = driver.findElement(By.id("radio_program_none"));
        healthcareProgramRadio.click();
        System.out.println("Chosen "+ healthcareProgramRadio);

        

    }
}
