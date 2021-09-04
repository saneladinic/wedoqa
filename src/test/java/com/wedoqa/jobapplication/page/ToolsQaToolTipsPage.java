/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToolsQaToolTipsPage {
    private final WebDriver driver;

    public ToolsQaToolTipsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveCursorToolTipsAndPrintText() {
        // Retrieve WebElement
        WebElement hoverMeToSee = driver.findElement(By.id("toolTipButton"));

        // Instantiate Action Class
        Actions action = new Actions(driver);

        // Using the action class to mimic mouse hover
        action.moveToElement(hoverMeToSee).build().perform();
        WebElement toolTipElement = driver.findElement(By.xpath("/html//button[@id='toolTipButton']"));
        String toolTipText = toolTipElement.getText();
        System.out.println(toolTipText);
    }
}
