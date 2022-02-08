package com.revature.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerPage {
	
	private WebDriver driver;
	private WebDriverWait wdw; // Explicit waits
	
	@FindBy(xpath="//*[text()='Welcome to the Manager homepage']")
	private WebElement welcomeHeading;

	@FindBy(xpath="//input[@id='userId']")
	private WebElement userIdInput;

	@FindBy(xpath="//input[@id='status']")
	private WebElement statusInput;

	@FindBy(id="submitBTN")
	private WebElement submitButton;
	
	@FindBy(xpath="//*[text()='Log Out']")
	private WebElement logoutButton;

	@FindBy(xpath="//p[contains(text(),'Reimbursement already been approved')]")
	private WebElement displayMessage;

	@FindBy(xpath="/html[1]/body[1]/nav[1]/div[2]/a[2]")
	private WebElement allReimbursementButton;

	@FindBy(id = "fnLn")
	private WebElement displayAllMessage;

	@FindBy(xpath = "//h1[contains(text(),'Expense Reimbursement System')]")
	private WebElement loginHeading;

	@FindBy(xpath = "//a[contains(text(),'Pending Reimbursement')]")
	private WebElement pendingButton;

	@FindBy(xpath = "//b[contains(text(),'Pending Reimbursements')]")
	private WebElement pendingPage;
	
	public ManagerPage(WebDriver driver) {
		this.driver = driver;	
		this.wdw = new WebDriverWait(driver, Duration.ofSeconds(15)); // wait for a maximum of 15 seconds before throwing an exception
		
		// PageFactory initialization
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getWelcomeHeading() {
		return this.wdw.until(ExpectedConditions.visibilityOf(welcomeHeading));
	}

	public WebElement getUserId(){
		return this.wdw.until(ExpectedConditions.visibilityOf(userIdInput));
	}

	public WebElement getStatus(){
		return this.statusInput;
	}

	public WebElement getSubmit(){
		return this.submitButton;
	}

	public WebElement getErrorMessage() {
		return this.wdw.until(ExpectedConditions.visibilityOf(this.displayMessage));
	}

	public WebElement getAllReimbursement(){
		return this.allReimbursementButton;
	}

	public WebElement getDisplayAllReimbursementMessage(){
		return this.wdw.until(ExpectedConditions.visibilityOf(displayAllMessage));
	}
	
	public WebElement getLogoutButton() {
		return this.wdw.until(ExpectedConditions.visibilityOf(logoutButton));
		
	}

	public WebElement getLoginHeading(){
		return this.wdw.until(ExpectedConditions.visibilityOf(loginHeading));
	}

	public WebElement getPendingButton(){
		return this.pendingButton;
	}
	public WebElement getPendingPage(){
		return this.wdw.until(ExpectedConditions.visibilityOf(pendingPage));
	}

}
