package tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends BaseTest {

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName(testData.fullName)
                .setUserEmail(testData.userEmail)
                .setCurrentAddress(testData.currentAddress)
                .setPermanentAddress(testData.permanentAddress);

        textBoxPage.submitUserForm();

        textBoxPage.verifyUserName(testData.fullName)
                .verifyEmail(testData.userEmail)
                .verifyCurrentAddress(testData.currentAddress)
                .verifyPermanentAddress(testData.permanentAddress);
    }
}