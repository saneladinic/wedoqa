/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolQaAlwaysVisibleMenuPage {

    private final WebDriver driver;

    public ToolQaAlwaysVisibleMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWidgetsElement() {
        WebElement element = driver.findElement(By.cssSelector(".accordion .element-group:nth-of-type(4) .header-wrapper"));
        // Calling a click on this element did not work always, while this works
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }
}
