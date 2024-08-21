package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.DataGenerator;

public class CreateAccountTests extends UIBaseClass {
    @Test
    public void createNewAccountTestPositive() {
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);

        String expectedEmail = DataGenerator.genereteRandomEmail("Mohammad");

        signUpPage.fillUpCreateAccountForm("Mohammad",
                expectedEmail,
                "Password@123");

        String actualEmail = getElementText(accountProfilePage.accountEmailInfo);

        Assert.assertEquals(actualEmail, expectedEmail,
                "Profile Page should have same email as Created");
    }

    /*
   Story 4.1 (Activity 15 Minute)
   Navigate to Create Account page and Create new Account
   With existing email and validate error message "this email is already exist, please use another email address".
    */
    @Test
    public void createNewAccountWithExistingEmail() {
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);

        signUpPage.fillUpCreateAccountForm("Mohammad", "mohammad2536@gmail.com", "Password!321");

        String actualError = getElementText(signUpPage.signUpError);

        Assert.assertEquals(actualError, "this email is already exist, please use another email address",
                "Error Message for Existing Email should match");

    }

   /* Activity:

    Story# 4.2
    Navigate to Create new Account page and click sign up button without filling the form
    Validate all errors on all fields.

    */

    @Test
    public void createNewAccountWithEmptyField() {
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);

        clickOnElement(signUpPage.signUpButton);

        String actualErrorName = getElementText(signUpPage.nameError);
        Assert.assertEquals(actualErrorName, "Name is a required field",
                "Error Message for empty name field should match");

        String actualErrorEmail = getElementText(signUpPage.emailError);
        Assert.assertEquals(actualErrorEmail, "Email is a required field",
                "Error Message for empty email field should match");

        String actualErrorPassword = getElementText(signUpPage.passwordError);
        Assert.assertEquals(actualErrorPassword, "Password is a required field",
                "Error Message for empty name field should match");

        String actualErrorConfirmPassword = getElementText(signUpPage.confirmPasswordError);
        Assert.assertEquals(actualErrorConfirmPassword, "Confirm Password is a required field",




                "Error Message for empty name field should match");

    }
}







