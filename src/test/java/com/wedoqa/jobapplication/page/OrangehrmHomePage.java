/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangehrmHomePage {
    private final WebDriver driver;

    public OrangehrmHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRequirement() {
        return driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
    }

    public WebElement getUserIcon() {
        return driver.findElement(By.id("user-dropdown"));
    }

    public WebElement getLogOut() {
        return driver.findElement(By.id("logoutLink"));
    }

    public void clickRequirement() {
        this.getRequirement().click();
    }

    public void clickUserIcon() {
        this.getUserIcon().click();
    }

    public void clickLogout() {
        this.getLogOut().click();
    }
}
