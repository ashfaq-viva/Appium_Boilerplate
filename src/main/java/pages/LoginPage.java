package pages;

import enums.LocatorClassName;
import enums.LocatorType;


public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    public void LoginWithEmail(String email , String password) {
//        way to get the source page locators
//        System.out.println(BasePage.driver.getPageSource());
        waitForVisibilityOfElement("OPEN_MENU", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,40);
        this.clickButton("OPEN_MENU", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("LOGIN_OPTION", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.clickButton("LOGIN_OPTION", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("USERNAME", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
        this.writeTextField("USERNAME", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, email);
        this.writeTextField("PASSWORD", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH, password);
        this.clickButton("LOGIN_BUTTON", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("OPEN_MENU", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,40);
        this.clickButton("OPEN_MENU", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        this.clickButton("CATALOG_OPTION", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH);
        waitForVisibilityOfElement("PRODUCTS_TEXT", LocatorClassName.LOGIN_LOCATOR_CLASS.toString(), LocatorType.XPATH,60);
    }
}
