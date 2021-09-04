/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolsQaInteractionsPage {

    private final WebDriver driver;

    public ToolsQaInteractionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDroppableElement() {
        WebElement element = driver.findElement(By.cssSelector(".element-list.collapse.show > .menu-list > li:nth-of-type(4)"));
        // Calling a click on this element did not work always, while this works
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
