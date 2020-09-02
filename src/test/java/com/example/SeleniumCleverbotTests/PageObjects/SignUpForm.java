package com.example.SeleniumCleverbotTests.PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignUpForm extends HomePage {

    private SelenideElement signUpUsernameInput = $("#cbsocialsignupform [name=\"username\"]");
    private SelenideElement signUpFullnameInput = $("#cbsocialsignupform [name=\"fullname\"]");
    private SelenideElement signUpEmailInput = $("#cbsocialsignupform [name=\"email\"]");
    private SelenideElement signUpPasswordInputNotActive = $("#cbsocialsignupform .passwordclear");
    private SelenideElement signUpPasswordInputActive = $("#cbsocialsignupform .passwordnormal");
    private SelenideElement signUpTermsDropdown = $("#cbsocialregisterterms");
    private SelenideElement signUpBtn = $("#cbsocialsignupform .standout");

    private SelenideElement signInUsernameInput = $(By.xpath("//*[@id=\"cbsocialsigninup\"]/ul/li[1]/form/input[1]"));
    private SelenideElement signInPasswordInputClear = $(By.xpath("//*[@id=\"cbsocialsigninup\"]/ul/li[1]/form/input" +
            "[2]"));
    private SelenideElement signInPasswordInputActive = $(By.xpath("//*[@id=\"cbsocialsigninup\"]/ul/li[1]/form/input" +
            "[3]"));
    private SelenideElement signInBtn = $(By.xpath("//*[@id=\"cbsocialsigninup\"]/ul/li[1]/form/input[5]"));


    public SelenideElement signUpMsg = $("#cbsocialmessagesignup");


    @Step("Enter registration date {username} {fullName} {email} {password}")
    public SignUpForm enterRegistrationData(String username, String fullName, String email, String password) {
        signUpUsernameInput.sendKeys(username);
        signUpFullnameInput.sendKeys(fullName);
        signUpEmailInput.sendKeys(email);
        signUpPasswordInputNotActive.click();
        signUpPasswordInputActive.sendKeys(password);
        return this;
    }

    @Step("Accept terms of use and click on 'SignUp' button")
    public SignUpForm tapOnSignUpBtn() {
        signUpTermsDropdown.selectOption(1);
        signUpBtn.click();
        return this;
    }

    @Step("Enter sign in data {username,} {password} and  do login")
    public HomePage doLogin(String username, String password) {
        signInUsernameInput.sendKeys(username);
        signInPasswordInputClear.click();
        signInPasswordInputActive.sendKeys(password);
        signInBtn.click();
        return new HomePage();
    }


}
