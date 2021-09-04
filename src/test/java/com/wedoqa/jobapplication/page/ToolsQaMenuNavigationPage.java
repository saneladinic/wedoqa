/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolsQaMenuNavigationPage {

    private final WebDriver driver;

    public ToolsQaMenuNavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInteractionsSelector() {
        return driver.findElement(By.xpath("//div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']//h5[.='Interactions']"));
    }

    public void interactionsSelector() {
        this.getInteractionsSelector().click();
    }
}
