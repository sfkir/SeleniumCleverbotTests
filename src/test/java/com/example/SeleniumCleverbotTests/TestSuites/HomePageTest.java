package com.example.SeleniumCleverbotTests.TestSuites;

import com.codeborne.selenide.Condition;
import com.example.SeleniumCleverbotTests.PageObjects.HomePage;
import com.example.SeleniumCleverbotTests.PageObjects.SignUpForm;
import com.example.SeleniumCleverbotTests.Utils.MailingService;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.example.SeleniumCleverbotTests.Utils.FakeData.*;


public class HomePageTest extends BaseTest {

    @Test
    void signUpAndSendMessage() throws NoSuchAlgorithmException, InterruptedException {
        String username = generateRandomUsername();
        String fullName = generateRandomFullName();
        String password = "testPassword";

        MailingService ms = new MailingService();
        String email = ms.generateEmail(username);

        HomePage homePage = new HomePage();
        SignUpForm signUpForm = new SignUpForm();

        homePage.open();
        homePage.openSignInForm()
                .enterRegistrationData(username, fullName, email, password)
                .tapOnSignUpBtn();
        signUpForm.signUpMsg.shouldBe(Condition.visible);

        List<String> mail = ms.getVerificationLink(email);
        open(mail.get(1));

        signUpForm.doLogin(username, password)
                .acceptTermsOfUse();
        for (int i = 0; i < 3; i++) {
            String message = generateRandomMessage();
            homePage.enterAndSendMessage(message);
            homePage.userResponse.shouldHave(Condition.text(message));
            homePage.botResponse.shouldBe(Condition.visible);
        }

    }
}