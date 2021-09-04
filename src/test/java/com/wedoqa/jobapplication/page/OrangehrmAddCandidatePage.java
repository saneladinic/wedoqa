/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangehrmAddCandidatePage {
    private final WebDriver driver;

    public OrangehrmAddCandidatePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSelectResume() {
        return driver.findElement(By.id("addCandidate_resume"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("addCandidate_firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("addCandidate_lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("addCandidate_email"));
    }

    public WebElement getVacancy() {
        return driver.findElement(By.id("add-candidate-vacancy-widget-container"));
    }

    public WebElement getCandidateName() {
        return driver.findElement(By.cssSelector("[competancy-id='44']"));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.id("saveCandidateButton"));
    }

    public void inputSelectResume(String fullFilePath) {
        this.getSelectResume().sendKeys(fullFilePath);
    }

    public void insertFirstName(String firstName) {
        this.getFirstName().sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        this.getLastName().sendKeys(lastName);
    }

    public void insertEmail(String email) {
        this.getEmail().sendKeys(email);
    }

    public void clickVacancy() {
        this.getVacancy().click();
    }

    public void clickCandidateName() {
        this.getCandidateName().click();
    }

    public void clickSaveButton() {
        this.getSaveButton().click();
    }
}