package com.revature.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	
	private WebDriver driver;
	private WebDriverWait wdw;
	
	@FindBy(id="userName")
	private WebElement usernameInput;
	
	@FindBy (id="pswrd")
	private WebElement passwordInput;
	
	@FindBy (id="FirstName")
	private WebElement firstNameInput;
	
	@FindBy (id="LastName")
	private WebElement lastNameInput;
	
	@FindBy (id="email")
	private WebElement emailInput;
	
	@FindBy (id="role")
	private WebElement roleInput;
	
	@FindBy (id="message-div")
	private WebElement errorMessage;
	
	@FindBy (id="succes-div")
	private WebElement successMessage;
	
	@FindBy(id = "signupBtn")
	private WebElement signupButton;
	
	public SignupPage(WebDriver driver) {
		this.driver = driver;	
		this.wdw = new WebDriverWait(driver, Duration.ofSeconds(15)); // wait for a maximum of 15 seconds before throwing an exception
		
		// PageFactory initialization
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsernameInput() {
		return this.usernameInput;
	}
	
	public WebElement getPasswordInput() {
		return this.passwordInput;
	}
	
	public WebElement getFirstNameInput() {
		return this.firstNameInput;
	}
	
	public WebElement getLastNameInput() {
		return this.lastNameInput;
	}
	
	public WebElement getEmailInput() {
		return this.emailInput;
	}
	
	public WebElement getRoleInput() {
		return this.roleInput;
	}
	
	public WebElement getSignupButton() {
		return this.signupButton;
	}
	
	public WebElement getErrorMessage() {
		return this.wdw.until(ExpectedConditions.visibilityOf(this.errorMessage));
	}
	
	public WebElement getSuccessMessage() {
		return this.wdw.until(ExpectedConditions.visibilityOf(this.successMessage));
	}
	
	
	
	
	
}
	
