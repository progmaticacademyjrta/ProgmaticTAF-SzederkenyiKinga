package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;
    By headerBy = By.id("top");

    LoginPage loginPage;

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadAppointmentPageAndMakeAnAppointmentTest() {
        loginPage.validUsernameAndValidPwTest();
        Select facilityDropdown = new Select(driver.findElement(By.id("combo_facility")));
        facilityDropdown.selectByVisibleText("Hongkong CURA Healthcare Center");
        System.out.println("Chosen " + facilityDropdown);

        WebElement healthcareProgramRadio = driver.findElement(By.id("radio_program_none"));
        healthcareProgramRadio.click();
        System.out.println("Chosen " + healthcareProgramRadio);

        WebElement visitDateInput = driver.findElement(By.id("txt_visit_date"));
        visitDateInput.sendKeys("04/02/2023");
        System.out.println("Wrote date: " + visitDateInput);

        WebElement commentInput = driver.findElement(By.name("comment"));
        commentInput.sendKeys("Mindjárt kész vagyok!");
        System.out.println("Wrote comment: " + commentInput);

        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
        bookAppointmentButton.click();
        System.out.println("Clicked on Book Appointment button");

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");


    }
}
