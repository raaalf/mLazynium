package com.malski.core.mobile.elements.api;

public interface ElementWait {

    void waitUntilPresent();

    void waitUntilPresent(long timeout);

    void waitUntilVisible();

    void waitUntilVisible(long timeout);

    void waitUntilDisappear();

    void waitUntilDisappear(long timeout);

    void waitUntilEnabled();

    void waitUntilEnabled(long timeout);

    void waitUntilDisabled();

    void waitUntilDisabled(long timeout);

    void waitUntilAttributeChange(String attributeName, String expectedValue);

    void waitUntilAttributeChange(String attributeName, String expectedValue, long timeout);

    void waitUntilAttributeChangeFrom(String attributeName, String startValue);

    void waitUntilIsInViewport();

    void waitUntilIsInViewport(long timeout);
}
