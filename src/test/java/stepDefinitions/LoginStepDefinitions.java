package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;

public class LoginStepDefinitions extends Setup {

    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Given("user visits the website")
    public void user_visits_the_website() {
        driver.get("https://www.saucedemo.com/");
    }

//    @When("user enters username and password")
//    public void user_enters_username_and_password() {
//        loginPage.passingUsernameAndPassword();
//    }

    @When("user presses submit button")
    public void user_presses_submit_button() {
        loginPage.pressingLoginButton();
    }

    @Then("user can visit the dashboard")
    public void user_can_visit_the_dashboard() {
        dashboardPage.verifyUserInDashboard();
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.passingUsernameAndPassword(username, password);
    }

//    @Then("user can not visit the dashboard$")
//    public void userCanNotVisitTheDashboard(String username, String password) {
//        loginPage.passingUsernameAndPassword(username, password);
//        loginPage.errorMessageForInvalidCredentials();
//    }
    @Then("Then user can not visit the dashboard {string} {string}")
    public void thenUserCanNotVisitTheDashboard(String username, String password) {
        loginPage.passingUsernameAndPassword(username, password);
        loginPage.errorMessageForInvalidCredentials();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}