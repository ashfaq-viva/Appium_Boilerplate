package config;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DeviceConfig {

    public static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/Config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Config.properties");
        }
    }
    public static DesiredCapabilities getCapabilities(String platformName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (platformName.toLowerCase()) {
            case "android":
                capabilities = getAndroidCapabilities();
                break;

            case "ios":
                capabilities = getIOSCapabilities();
                break;

            default:
                throw new IllegalArgumentException("Unsupported platform: " + platformName);
        }

        return capabilities;
    }

    public static String detectPlatform() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac") || osName.contains("ios")) {
            return "iOS";
        } else if (osName.contains("windows") || osName.contains("linux") || osName.contains("android")) {
            return "Android";
        } else {
            throw new RuntimeException("Unable to detect platform. Please ensure the device is connected and recognized.");
        }
    }

    public static DesiredCapabilities getDynamicCapabilities() {
        String platformName = detectPlatform();
        return getCapabilities(platformName);
    }

    public static DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", properties.getProperty("platformName"));
        capabilities.setCapability("appium:automationName", properties.getProperty("automationName"));
        capabilities.setCapability("appium:newCommandTimeout", Integer.parseInt(properties.getProperty("newCommandTimeout")));
        String apkPath;
        if (System.getenv("GITHUB_ACTIONS") != null) {
            // Running in GitHub Actions
            apkPath = "/home/runner/work/Findit-App/V1.2.2.apk";
        } else {
            // Running locally
            apkPath = System.getProperty("user.dir") + "/" + properties.getProperty("appPath");
        }

        capabilities.setCapability("appium:app", apkPath);
        capabilities.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000);
        capabilities.setCapability("appium:unicodeKeyboard", true);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:androidInstallTimeout", 90000);
        capabilities.setCapability("appium:adbExecTimeout", 60000);
        capabilities.setCapability("appium:uiautomator2ServerLaunchTimeout", 120000);
        capabilities.setCapability("appium:uiautomator2ServerInstallTimeout", 120000);
//        capabilities.setCapability("appium:deviceName", properties.getProperty("deviceName"));
//        capabilities.setCapability("appium:udid", properties.getProperty("udid"));
//        capabilities.setCapability("appium:platformVersion", properties.getProperty("platformVersion"));
//        capabilities.setCapability("appium:fullReset", true);
//        capabilities.setCapability("appium:noReset", false);
// ✅ Fix: Add a capability to skip hidden API restrictions (for Android 9+)
//        capabilities.setCapability("appium:enforceAppInstall", true);
//        capabilities.setCapability("appium:skipDeviceInitialization", true);
//        capabilities.setCapability("appium:skipServerInstallation", false);
//        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/" + properties.getProperty("appPath"));
        return capabilities;
    }

    public static DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", properties.getProperty("iosPlatformName"));
        capabilities.setCapability("appium:deviceName", properties.getProperty("iosDeviceName"));
        capabilities.setCapability("appium:automationName", properties.getProperty("iosAutomationName"));
        capabilities.setCapability("appium:udid",properties.getProperty("iosUdid") );
        capabilities.setCapability("appium:bundleId",properties.getProperty("iosBundleId") );
        capabilities.setCapability("appium:platformVersion",properties.getProperty("iosPlatformVersion") );
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:newCommandTimeout", 300);
        capabilities.setCapability("appium:wdaLaunchTimeout", 60000);
        capabilities.setCapability("appium:wdaConnectionTimeout", 60000);
        capabilities.setCapability("appium:unicodeKeyboard", true);
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:usePrebuiltApp", true);
        capabilities.setCapability("appium:resetOnLaunch", true);
        capabilities.setCapability("appium:autoAcceptAlerts", true);
        capabilities.setCapability("appium:clearSystemFiles", true);
        return capabilities;

    }
}

