package com.malski.core.utils;

import com.malski.core.mobile.control.Application;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static boolean initiated = true;

    private static Application app;

    public static void initialize() {
        if(initiated) {
            if (properties == null) {
                properties = CustomProperties.getProperties("test_properties.xml");
            }
            if (config == null) {
                config = new TestConfig();
            }
            if (container == null) {
                container = new HashMap<>();
            }
            initiated = false;
        }
    }

    public static Application application() {
        Application app = TestContext.app;
        if (app == null) {
            throw new IllegalStateException("Application not set on the TestContext");
        }
        return app;
    }


    public static void setApplication(String driver) {
        app = new Application(driver);
    }

    private static Map<ContainerKey, Object> container;

    public static Map<ContainerKey, Object> container() {
        return container;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getFromContainer(ContainerKey key) {
        return (T) container.get(key);
    }

    public static void setInContainer(ContainerKey key, Object value) {
        container.put(key, value);
    }

    public static boolean containerContainsKey(ContainerKey key) {
        return container().containsKey(key);
    }

    public static boolean containerContainsValue(Object value) {
        return container().containsValue(value);
    }

    public static Object removeFromContainer(ContainerKey key) {
        return container().remove(key);
    }

    //properties for running tests
    private static Map<String, String> properties;
    private static TestConfig config;

    public static String getPropertyByKey(PropertyKey key){
        return properties.get(key.toString());
    }

    public static TestConfig config() {
        return config;
    }
}
