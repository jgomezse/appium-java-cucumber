package com.appium.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CapabilitiesConfig {

    private static final Logger log = LogManager.getLogger(CapabilitiesConfig.class);
    private static final Properties props = new Properties();

    static {
        String filename = "appium.properties";

        try (InputStream is = CapabilitiesConfig.class.getClassLoader()
                .getResourceAsStream(filename)) {
            if (is != null) {
                props.load(is);
                log.info("{} cargado", filename);
            } else {
                log.warn("{} no encontrado en classpath, usando config vacía", filename);
            }
        } catch (IOException e) {
            log.error("Error al cargar {}", filename, e);
        }
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();

        setIfPresent(caps, "platformName", get("appium.platformName"));
        setIfPresent(caps, "appium:deviceName", get("appium.deviceName"));
        setIfPresent(caps, "appium:automationName", get("appium.automationName"));
        setIfPresent(caps, "appium:appPackage", get("appium.appPackage"));
        setIfPresent(caps, "appium:appActivity", get("appium.appActivity"));
        setIfPresent(caps, "appium:autoGrantPermissions", get("appium.autoGrantPermissions"));
        setIfPresent(caps, "appium:appWaitActivity", get("appium.appWaitActivity"));

        String appPath = get("appium.appPath");
        if (!appPath.isEmpty()) {
            Path fullPath = Paths.get(appPath);
            if (!fullPath.isAbsolute()) {
                fullPath = Paths.get(System.getProperty("user.dir")).resolve(appPath);
            }
            caps.setCapability("appium:app", fullPath.toAbsolutePath().toString());
            log.info("Ruta de la app: {}", fullPath.toAbsolutePath());
        }

        String noReset = get("appium.noReset");
        if (!noReset.isEmpty()) {
            caps.setCapability("appium:noReset", Boolean.parseBoolean(noReset));
        }

        return caps;
    }

    private static String get(String key) {
        String value = System.getProperty(key);
        if (value != null && !value.isEmpty()) return value;
        return props.getProperty(key, "");
    }

    private static void setIfPresent(DesiredCapabilities caps, String key, String value) {
        if (value != null && !value.isEmpty()) {
            caps.setCapability(key, value);
        }
    }
}
