/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToolsQaDroppablePage {

    private final WebDriver driver;

    public ToolsQaDroppablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAndHold() {
        Actions act = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        act.clickAndHold(from).moveToElement(to).release().build().perform();
    }
}
