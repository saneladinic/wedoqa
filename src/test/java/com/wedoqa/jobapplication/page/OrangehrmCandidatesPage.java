/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangehrmCandidatesPage {
    private final WebDriver driver;

    public OrangehrmCandidatesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddGreenButton() {
        return driver.findElement(By.id("addItemBtn"));
    }

    public WebElement getSelectLastCandidate() {
        return driver.findElement(By.cssSelector("#content > div.row.content > div > div.nova-content-wrap > table > tbody > tr:nth-child(1) > td.material-checkbox > label"));
    }

    public WebElement getThreeDots() {
        return driver.findElement(By.id("ohrmList_Menu"));
    }

    public WebElement getDelete() {
        return driver.findElement(By.id("deleteItemBtn"));
    }

    public WebElement getConfirmationDelete() {
        return driver.findElement(By.id("candidate-delete-button"));
    }

    public WebElement getSideMenu() {
        return driver.findElement(By.id("side-menu-hamburger"));
    }

    public int countCandidates() {
        //Identify all the elements on web page
        List<WebElement> allCandidates = driver.findElements(By.cssSelector("tr.dataDefaultRaw.dataRaw.handCuser"));
        //Count the total all element on web page
        return allCandidates.size();
    }

    public void clickAddGreenButton() {
        this.getAddGreenButton().click();
    }

    public void clickSelectLastCanddate() {
        this.getSelectLastCandidate().click();
    }

    public void clickThreeDots() {
        this.getThreeDots().click();
    }

    public void clickDelete() {
        this.getDelete().click();
    }

    public void clickConfirmationDelete() {
        this.getConfirmationDelete().click();
    }

    public void clickSideMenu() {
        this.getSideMenu().click();
    }
}
