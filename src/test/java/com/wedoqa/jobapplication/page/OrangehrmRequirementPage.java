/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangehrmRequirementPage {
    private final WebDriver driver;

    public OrangehrmRequirementPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCandidates() {
        return driver.findElement(By.id("menu_recruitment_viewCandidates"));
    }

    public void clickCandidates() {
        this.getCandidates().click();
    }
}
