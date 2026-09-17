package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegisterPage;
import utils.ExcelUtils;

public class RegistrationTest extends BaseTest {

    // =========================================================
    // 1. VALID REGISTRATION
    // =========================================================

    @Test
    public void validRegistrationTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName("Sharma");

        rp.enterEmail(
                "rahul" + System.currentTimeMillis() + "@example.com"
        );

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");

        rp.selectNewsletterYes();
        rp.acceptPrivacyPolicy();

        rp.clickContinue();

        Assert.assertTrue(
                getDriver().getPageSource()
                        .contains("Your Account Has Been Created!"),
                "Registration failed"
        );
    }


    // =========================================================
    // 2. DUPLICATE EMAIL
    // =========================================================

    @Test
    public void duplicateEmailTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName("Sharma");

        rp.enterEmail("test@test.com");

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");

        rp.acceptPrivacyPolicy();

        rp.clickContinue();

        Assert.assertTrue(
                getDriver().getPageSource()
                        .contains("E-Mail Address is already registered!"),
                "Duplicate email warning was not displayed"
        );
    }


    // =========================================================
    // 3. EMPTY REGISTRATION
    // =========================================================

    @Test
    public void emptyRegistrationTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.clickContinue();

        String pageSource = getDriver().getPageSource();

        Assert.assertTrue(
                pageSource.contains("First Name must be between")
                        || pageSource.contains("Last Name must be between")
                        || pageSource.contains("E-Mail Address does not appear to be valid")
                        || pageSource.contains("Telephone must be between")
                        || pageSource.contains("Password must be between"),
                "Required field validation messages were not displayed"
        );
    }


    // =========================================================
    // 4. PASSWORD MISMATCH
    // =========================================================

    @Test
    public void passwordMismatchTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName("Sharma");

        rp.enterEmail(
                "mismatch" + System.currentTimeMillis() + "@example.com"
        );

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@5678");

        rp.acceptPrivacyPolicy();

        rp.clickContinue();

        Assert.assertTrue(
                getDriver().getPageSource()
                        .contains("Password confirmation does not match password!"),
                "Password mismatch validation was not displayed"
        );
    }


    // =========================================================
    // 5. PRIVACY POLICY NOT ACCEPTED
    // =========================================================

    @Test
    public void privacyPolicyNotAcceptedTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName("Sharma");

        rp.enterEmail(
                "privacy" + System.currentTimeMillis() + "@example.com"
        );

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");

        // Privacy Policy intentionally NOT accepted

        rp.clickContinue();

        Assert.assertTrue(
                getDriver().getPageSource()
                        .contains("Warning: You must agree to the Privacy Policy!"),
                "Privacy policy validation was not displayed"
        );
    }


    // =========================================================
    // 6. REQUIRED FIELD VALIDATION
    // =========================================================

    @Test
    public void requiredFieldValidationTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        // Leave all fields empty

        rp.clickContinue();

        String pageSource = getDriver().getPageSource();

        Assert.assertTrue(
                pageSource.contains("must be between")
                        || pageSource.contains("does not appear to be valid"),
                "Required field validation was not displayed"
        );
    }


    // =========================================================
    // 7. FIRST NAME VALIDATION (data-driven)
    // Excel Sheet2 -> FirstName column
    // =========================================================

    @DataProvider(name = "invalidFirstNameData")
    public Object[][] invalidFirstNameData() throws IOException {

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/login.xlsx";

        return ExcelUtils.getColumnData(
                filePath,
                "Sheet2",
                "FirstName"
        );
    }


    @Test(dataProvider = "invalidFirstNameData")
    public void firstNameValidationTest(String firstName) {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName(firstName);
        rp.enterLastName("Sharma");

        rp.enterEmail(
                "firstname" + System.currentTimeMillis() + "@example.com"
        );

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");

        rp.acceptPrivacyPolicy();

        rp.clickContinue();

        String pageSource = getDriver().getPageSource();

        if (firstName == null || firstName.trim().isEmpty()) {
            // Blank First Name -> app rejects it with the length-validation message
            Assert.assertTrue(
                    pageSource.contains("First Name must be between 1 and 32 characters!"),
                    "Expected First Name validation message for blank input, but it wasn't shown"
            );
        } else {
            // OpenCart only checks length (1-32 chars), not character format,
            // so any non-blank value - "12345", "@#$%", "A" - is accepted.
            Assert.assertTrue(
                    pageSource.contains("Your Account Has Been Created!"),
                    "Registration failed for first name: '" + firstName + "'"
            );
        }
    }


    // =========================================================
    // 8. LAST NAME VALIDATION (data-driven)
    // Excel Sheet2 -> LastName column
    // =========================================================

    @DataProvider(name = "invalidLastNameData")
    public Object[][] invalidLastNameData() throws IOException {

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/login.xlsx";

        return ExcelUtils.getColumnData(
                filePath,
                "Sheet2",
                "LastName"
        );
    }


    @Test(dataProvider = "invalidLastNameData")
    public void lastNameValidationTest(String lastName) {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName(lastName);

        rp.enterEmail(
                "lastname" + System.currentTimeMillis() + "@example.com"
        );

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");

        rp.acceptPrivacyPolicy();

        rp.clickContinue();

        String pageSource = getDriver().getPageSource();

        if (lastName == null || lastName.trim().isEmpty()) {
            Assert.assertTrue(
                    pageSource.contains("Last Name must be between 1 and 32 characters!"),
                    "Expected Last Name validation message for blank input, but it wasn't shown"
            );
        } else {
            Assert.assertTrue(
                    pageSource.contains("Your Account Has Been Created!"),
                    "Registration failed for last name: '" + lastName + "'"
            );
        }
    }


    // =========================================================
    // 9. EMAIL VALIDATION (data-driven)
    // Excel Sheet2 -> Email column
    // =========================================================

    @DataProvider(name = "invalidEmailData")
    public Object[][] invalidEmailData() throws IOException {

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/login.xlsx";

        Object[][] data = ExcelUtils.getColumnData(
                filePath,
                "Sheet2",
                "Email"
        );

        List<Object[]> invalidEmails = new ArrayList<>();

        for (Object[] row : data) {

            String email = (String) row[0];

            if (email == null
                    || email.trim().isEmpty()
                    || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {

                invalidEmails.add(row);
            }
        }

        return invalidEmails.toArray(new Object[0][1]);
    }


    @Test(dataProvider = "invalidEmailData")
    public void emailValidationTest(String email) {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName("Sharma");
        rp.enterEmail(email);
        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");
        rp.acceptPrivacyPolicy();

        // Check browser HTML5 validation BEFORE clicking Continue
        String validationMessage = rp.getEmailValidationMessage();

        if (!validationMessage.isEmpty()) {

            // Chrome/HTML5 validation
            Assert.assertFalse(
                    validationMessage.isEmpty(),
                    "HTML5 email validation failed for: " + email
            );

        } else {

            // No HTML5 validation, so submit and check website validation
            rp.clickContinue();

            String errorMessage = rp.getEmailErrorMessage();

            Assert.assertEquals(
                    errorMessage,
                    "E-Mail Address does not appear to be valid!",
                    "Website email validation failed for: " + email
            );
        }
    }


    // =========================================================
    // 10. NEWSLETTER YES
    // =========================================================

    @Test
    public void newsletterYesTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName("Sharma");

        rp.enterEmail(
                "newsletteryes"
                        + System.currentTimeMillis()
                        + "@example.com"
        );

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");

        rp.selectNewsletterYes();

        rp.acceptPrivacyPolicy();

        rp.clickContinue();

        Assert.assertTrue(
                getDriver().getPageSource()
                        .contains("Your Account Has Been Created!"),
                "Registration with Newsletter Yes failed"
        );
    }


    // =========================================================
    // 11. NEWSLETTER NO
    // =========================================================

    @Test
    public void newsletterNoTest() {

        RegisterPage rp = new RegisterPage(getDriver());

        rp.goToRegisterPage();

        rp.enterFirstName("Rahul");
        rp.enterLastName("Sharma");

        rp.enterEmail(
                "newsletterno"
                        + System.currentTimeMillis()
                        + "@example.com"
        );

        rp.enterTelephone("9876543210");
        rp.enterPassword("Test@1234");
        rp.enterConfirmPassword("Test@1234");

        rp.selectNewsletterNo();

        rp.acceptPrivacyPolicy();

        rp.clickContinue();

        Assert.assertTrue(
                getDriver().getPageSource()
                        .contains("Your Account Has Been Created!"),
                "Registration with Newsletter No failed"
        );
    }
}