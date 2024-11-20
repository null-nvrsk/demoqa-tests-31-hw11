package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String formTitle = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbyCheckbox = $("#hobbiesWrapper"),
            inputUploadPicture = $("#uploadPicture"),
            textareaCurrentAddress = $("#currentAddress"),
            buttonSubmit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper h5").shouldHave(text(formTitle));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderRadio.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressTab();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyCheckbox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String filepath) {
        inputUploadPicture.uploadFromClasspath(filepath);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        textareaCurrentAddress.setValue(address);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void submitRegistrationForm() {
        buttonSubmit.click();
    }

    public RegistrationPage verifyResultsModal() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage verifyEmailErrorNotification() {
        emailInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}
