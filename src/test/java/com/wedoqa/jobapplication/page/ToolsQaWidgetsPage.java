/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolsQaWidgetsPage {

    private final WebDriver driver;

    public ToolsQaWidgetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToolTips() {
        WebElement element = driver.findElement(By.cssSelector(".collapse.element-list.show > .menu-list > li:nth-of-type(7)"));
        // Calling a click on this element did not work always, while this works
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
