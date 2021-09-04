/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangehrmLoginPage {

    private final WebDriver driver;

    public OrangehrmLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("btnLogin"));
    }

    public void clickLoginButton() {
        this.getLoginButton().click();
    }
}
