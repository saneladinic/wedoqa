/*
 * Copyright (C) 2021 Sanela Dinic
 */
package com.wedoqa.jobapplication;

import com.wedoqa.jobapplication.page.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Automated tests for QA position for wedoqa.com.
 */
public class InterviewTest {

    // IMPORTANT! This path needs to be adjusted to match an existing file on file system
    public static final String RESUME_PATH = "/home/sanela/Downloads/Sanela Dinic CV.pdf";

    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = new FirefoxDriver(new FirefoxOptions());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void firstTest() throws Exception {
        GooglePage googlePage = new GooglePage(driver);
        ToolsQaMenuNavigationPage toolsQaMenuNavigationPage = new ToolsQaMenuNavigationPage(driver);
        ToolsQaInteractionsPage toolsQaInteractionsPage = new ToolsQaInteractionsPage(driver);
        ToolsQaDroppablePage toolsQaDroppablePage = new ToolsQaDroppablePage(driver);
        ToolQaAlwaysVisibleMenuPage toolQaAlwaysVisibleMenuPage = new ToolQaAlwaysVisibleMenuPage(driver);
        ToolsQaWidgetsPage toolsQaWidgetsPage = new ToolsQaWidgetsPage(driver);
        ToolsQaToolTipsPage toolsQaToolTipsPage = new ToolsQaToolTipsPage(driver);

        // Go to google
        driver.navigate().to("http://www.google.com");

        // Search for demoqa.com
        googlePage.insetrFieldText("demoqa.com");
        googlePage.enterClick();

        // Hit the first result which will navigate to demoqa.com
        googlePage.clickSiteDemoqa();

        // Navigate to the Droppable element in Interactions section
        toolsQaMenuNavigationPage.interactionsSelector();

        // Pick and drop the “Drag me” box into the “Drop here” box
        toolsQaInteractionsPage.clickDroppableElement();
        toolsQaDroppablePage.clickAndHold();

        // Print out the text from the “Drop here” box.
        String printText=toolsQaDroppablePage.printTextDropHere();
        System.out.println(printText);

        // Take a screenshot
        File tempScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file = new File(Instant.now() + ".png");
        Files.copy(tempScreenshotFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(tempScreenshotFile.getAbsolutePath());

        // Click on the ToolTips link on the left hand side in the Widgets section.
        toolQaAlwaysVisibleMenuPage.clickWidgetsElement();
        toolsQaWidgetsPage.clickToolTips();

        // Move your cursor to the “Hover me to see” button input element and print out the text from the pop-up tooltip.
        toolsQaToolTipsPage.moveCursorToolTipsAndPrintText();
    }

    @Test
    public void secondTest() {
        GooglePage googlePage = new GooglePage(driver);

        // Go to google.com
        driver.navigate().to("http://www.google.com");

        // Search for cheese
        googlePage.insetrFieldText("cheese");
        googlePage.enterClick();

        // Compare the number of results to 777
        String actualText = googlePage.textResults();
        String actualNumberText = actualText.split(" ")[1];
        Assertions.assertEquals("777", actualNumberText, "There is too much cheese on the internet");
    }

    @Test
    public void thirdTest() throws InterruptedException {
        OrangehrmLoginPage orangehrmLoginPage = new OrangehrmLoginPage(driver);
        OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
        OrangehrmRequirementPage orangehrmRequirementPage = new OrangehrmRequirementPage(driver);
        OrangehrmCandidatesPage orangehrmCandidatesPage = new OrangehrmCandidatesPage(driver);
        OrangehrmAddCandidatePage orangehrmAddCandidatePage = new OrangehrmAddCandidatePage(driver);

        // Go to https://orangehrm-demo-7x.orangehrmlive.com/
        driver.navigate().to("https://orangehrm-demo-7x.orangehrmlive.com/");

        // Login with admin credentials (form is prefilled with the login data)
        orangehrmLoginPage.clickLoginButton();

        // Wait for the dashboard page to load
        sleep(3000);

        // Go to Recruitment page
        orangehrmHomePage.clickRequirement();
        sleep(3000);

        // Click on Candidates
        orangehrmRequirementPage.clickCandidates();

        // Switch to a frame
        driver.switchTo().frame("noncoreIframe");

        int candidatesCount = orangehrmCandidatesPage.countCandidates();
        // Print out the number of candidates
        System.out.println("Total Number of All Element on webpage = " + candidatesCount);

        // Click on the green Add button
        orangehrmCandidatesPage.clickAddGreenButton();
        sleep(3000);

        // Fill the mandatory fields and vacancy. (Resume is also mandatory)
        orangehrmAddCandidatePage.inputSelectResume(RESUME_PATH);
        orangehrmAddCandidatePage.insertFirstName("Sanela");
        orangehrmAddCandidatePage.insertLastName("Dinic");
        orangehrmAddCandidatePage.insertEmail("dinicsanela90@gmail.com");
        orangehrmAddCandidatePage.clickVacancy();
        orangehrmAddCandidatePage.clickCandidateName();
        orangehrmAddCandidatePage.clickSaveButton();

        // Check if the number of candidates is increased by 1
        int candidateCountAfterAdd = orangehrmCandidatesPage.countCandidates();
        Assertions.assertEquals(candidatesCount + 1, candidateCountAfterAdd, "Candidate not added");

        // Select the freshly created candidate
        orangehrmCandidatesPage.clickSelectLastCanddate();

        // Click on the three dots in the left upper side of the table
        orangehrmCandidatesPage.clickThreeDots();

        // Delete the candidate
        orangehrmCandidatesPage.clickDelete();
        sleep(3000);
        orangehrmCandidatesPage.clickConfirmationDelete();
        sleep(3000);

        // Check if the number of candidates decreased by 1
        int candidateCountAfterDelete = orangehrmCandidatesPage.countCandidates();
        Assertions.assertEquals(candidateCountAfterAdd - 1, candidateCountAfterDelete, "Candidate not deleted");

        // Click on the User icon
        orangehrmHomePage.clickUserIcon();

        // Click Logout
        orangehrmHomePage.clickLogout();
        sleep(3000);
    }
}
