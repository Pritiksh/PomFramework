package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.TimeUtil;
/**
 * 
 * @author priti
 *
 */
public class LoginPage extends BasePage{
ElementActions elementActions;
//Define locators without page factory
By email = By.id("username");
By pass = By.id("password");
By loginButton = By.id("loginBtn");
By rememberMecheckbox = By.xpath("//span[@class='private-checkbox__icon private-checkbox__dash']");
By signUpLink = By.linkText("Sign up");
By signUpLabel = By.xpath("//*[@id='hs-login']/div[1]/i18n-string");
By emailAddressLbl = By.xpath("//*[@id='hs-login']/div[3]/div/div/div[1]/label/i18n-string");
By passwordLbl = By.xpath("//*[@id='hs-login']/div[4]/div/div/div[1]/label/i18n-string");
By showPassword = By.xpath("//span[text() = 'Show Password']");
By forgotPassword = By.linkText("Forgot my password");
By rememberMeLbl = By.xpath("//*[@id='hs-login']/div[5]/label/span/span[2]/i18n-string");
By signInWithGoogleButton = By.xpath("//span[text() = 'Sign in with Google']");
By loginWithSSoBtn = By.id("ssoBtn");

public LoginPage(){
	this.driver = driver;
	elementActions = new ElementActions(driver);
}

public String getLoginPageTitle(){
	elementActions.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE);
	return elementActions.getPageTitle();
}

public boolean verifySignUpLinkisDisplayed(){
	return elementActions.elementIsDisplayed(signUpLink);
}

public String verifyAccountText(){
	return elementActions.getElementText(signUpLabel);
}

public String verifyEmailLabel(){
	return elementActions.getElementText(emailAddressLbl);
	}

public String verifyPasswordLabel(){
	return elementActions.getElementText(passwordLbl);
}

public boolean verifyForgotPaaswordDisplayed(){
	return elementActions.elementIsDisplayed(forgotPassword);
}

public boolean verifyRememberMeCheckboxIsDisplyed(){
	return elementActions.elementIsDisplayed(rememberMecheckbox);
}

public String verifyRememberMelabel(){
	return elementActions.getElementText(rememberMeLbl);
}

public boolean verifyGoogleButtonIsDisplayed(){
	return elementActions.elementIsDisplayed(signInWithGoogleButton);
}

public boolean verifySSoButtonIsDisplayed(){
	return elementActions.elementIsDisplayed(loginWithSSoBtn);
}

public HomePage doLogin(String username,String password){
	elementActions.elementSendKeys(email, username);
	elementActions.elementSendKeys(pass, password);
	elementActions.elementClick(loginButton);
	TimeUtil.meduimWait();
	return new HomePage(driver);
}
}
