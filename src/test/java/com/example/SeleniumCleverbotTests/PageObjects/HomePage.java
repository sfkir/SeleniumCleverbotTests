package com.example.SeleniumCleverbotTests.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.example.SeleniumCleverbotTests.Utils.Environment.baseUrl;

public class HomePage {

    private SelenideElement signInMenuBtn = $(By.xpath("//*[@id=\"cbsocialsigninup\"]/span"));
    private SelenideElement agreementBtn = $(By.xpath("//*[@id=\"noteb\"]/form/input"));
    public SelenideElement messageInput = $("[name=stimulus]");
    private SelenideElement thinkAboutItBtn = $("[name=thinkaboutitbutton]");
    public SelenideElement userResponse = $(By.xpath("//*[@id=\"line2\"]//span[contains(@class, 'user')]"));
    public SelenideElement botResponse = $(By.xpath("//*[@id=\"line1\"]/span[contains(@class, 'bot')]"));

    public SelenideElement snippetIcon = $("#snipTextIcon");

    public HomePage open() {
        Selenide.open(baseUrl);
        return this;
    }

    @Step("Tap on 'SIgn In' button")
    public SignUpForm openSignInForm() {
        signInMenuBtn.click();
        return new SignUpForm();
    }

    @Step("Accept terms of use")
    public HomePage acceptTermsOfUse() {
        agreementBtn.click();
        return this;
    }

    @Step("Enter and send message")
    public HomePage enterAndSendMessage(String message) {
        messageInput.waitUntil(Condition.attribute("placeholder", "say to cleverbot..."), 4000);
        messageInput.sendKeys(message);
        thinkAboutItBtn.click();
        snippetIcon.waitUntil(Condition.visible, 10000);
        return this;
    }


}
