package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.BasePage;


public class LoginPageTest extends BaseTest {
    @Test(groups = {"smoke"})
    @Description("Verify login of a user")
    public void testLoginWithEmail() {
    	loginPage.LoginWithEmail(this.email,this.password);
        BasePage.quitDriver();
    }

}

