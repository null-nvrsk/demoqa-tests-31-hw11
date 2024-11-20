package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private final SelenideElement textBoxTitle = $("h1.text-center"),
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        textBoxTitle.shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage setUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    public TextBoxPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public void submitUserForm() {
        submitButton.click();
    }

    public TextBoxPage verifyUserName(String name) {
        $("#output #name").shouldHave(text(name));
        return this;
    }

    public TextBoxPage verifyEmail(String email) {
        $("#output #email").shouldHave(text(email));
        return this;
    }

    public TextBoxPage verifyCurrentAddress(String currentAddress) {
        $("#output #currentAddress").shouldHave(text(currentAddress));
        return this;
    }

    public TextBoxPage verifyPermanentAddress(String permanentAddress) {
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
        return this;
    }
}