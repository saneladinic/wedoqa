/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

    private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchField() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
    }

    public WebElement getResults() {
        return driver.findElement(By.id("result-stats"));
    }

    public WebElement getSiteDemoqa() {
        return driver.findElement(By.xpath("/html//div[@id='rso']/div//div[@class='eKjLze']/div[@class='g']/div//a[@href='https://demoqa.com/']/h3[.='Demo QA']"));
    }

    public void insetrFieldText(String nameWebSite) {
        this.getSearchField().sendKeys(nameWebSite);
    }

    public void enterClick() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
    }

    public void clickSiteDemoqa() {
        this.getSiteDemoqa().click();
    }

    public String textResults() {
        return this.getResults().getText();
    }

}