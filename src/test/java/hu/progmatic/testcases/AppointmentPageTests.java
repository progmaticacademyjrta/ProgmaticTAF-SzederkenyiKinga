package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverBaseTest {

    AppointmentPage appointmentPage;

    @Test(description = "Booking an appointment")
    public void navigateToAppointmentPageAndMakeTestsOnItTest() {
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.loadAppointmentPageAndMakeAnAppointmentTest();
    }
}
