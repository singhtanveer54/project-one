package com.revature.gluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.page.LoginPage;
import com.revature.page.SignupPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignupTest {
	
	private WebDriver driver;
	private SignupPage signupPage;
	
	@Given("I am at the signup page")
	public void i_am_at_the_signup_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		
		this.driver.get("http://localhost:5500");
		this.signupPage = new SignupPage(driver);
	}
	@When("I type in a first name of {string}")
	public void i_type_in_a_first_name_of(String string) {
	    this.signupPage.getFirstNameInput().sendKeys(string);
	}

	@When("I type in a last name of {string}")
	public void i_type_in_a_last_name_of(String string) {
	    this.signupPage.getLastNameInput().sendKeys(string);
	}

	@When("I type in a email of {string}")
	public void i_type_in_a_email_of(String string) {
	    this.signupPage.getEmailInput().sendKeys(string);
	}

	@When("I type in a role of {string}")
	public void i_type_in_a_role_of(String string) {
	    this.signupPage.getRoleInput().sendKeys(string);
	}

	@When("I click the sign up button")
	public void i_click_the_sign_up_button() {
	    this.signupPage.getSignupButton().click();
	}


}
