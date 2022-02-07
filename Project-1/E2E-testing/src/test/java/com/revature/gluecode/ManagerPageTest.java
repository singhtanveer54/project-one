package com.revature.gluecode;

import com.revature.page.LoginPage;
import com.revature.page.ManagerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagerPageTest {

    private WebDriver driver;
    private ManagerPage managerPage;


    @Given("I am the manager homepage")
    public void i_am_the_manager_homepage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");

        this.driver = new ChromeDriver();

        this.driver.get("http://localhost:5500/main-manager-page.html");
        this.managerPage = new ManagerPage(driver);
        driver.manage().window().maximize();
        Thread.sleep(4000);
    }
    @When("I type in a user id of {string}")
    public void i_type_in_a_user_id_of(String string) throws InterruptedException {
        this.managerPage.getUserId().sendKeys(string);
        Thread.sleep(4000);
    }
    @When("I type in a status of {string}")
    public void i_type_in_a_status_of(String string) throws InterruptedException {
       this.managerPage.getStatus().sendKeys(string);
        Thread.sleep(4000);
    }
    @When("I click the submit button")
    public void i_click_the_submit_button() throws InterruptedException {
        this.managerPage.getSubmit().click();
        Thread.sleep(4000);
    }
    @Then("I should see a error message of {string}")
    public void i_should_see_a_error_message_of(String string) throws InterruptedException {
        String actual = this.managerPage.getErrorMessage().getText();

        Assertions.assertEquals(string, actual);

        Thread.sleep(4000);

        this.driver.quit();
    }


    @When("I click on all reimbursement button")
    public void i_click_on_all_reimbursement_button() {
        this.managerPage.getAllReimbursement().click();
    }
    @Then("I should be able to see all reimbursement")
    public void i_should_be_able_to_see_all_reimbursement() {
        this.managerPage.getDisplayAllReimbursementMessage().getText();
    }
}
