package config;

import locators.androidLocators.LoginPageLocatorsAndroid;
import locators.iosLocators.LoginPageLocatorsIOS;

import java.util.HashMap;
import java.util.Map;

public class LocatorClassConfig {
    public static final Map<String, Class<?>> androidLocators = new HashMap<>();
    public static final Map<String, Class<?>> iosLocators = new HashMap<>();

    static {
        // Add Android locator classes
        androidLocators.put("LoginPage", LoginPageLocatorsAndroid.class);

        // Add iOS locator classes
        iosLocators.put("LoginPage", LoginPageLocatorsIOS.class);
    }

}
