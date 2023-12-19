package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class goibibo {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.goibibo.com/");

        String date = "10";

        homePage home = new homePage();
        searchPage search = new searchPage();

        home.closeLoginPopUP(driver);
        home.selectMenu(driver);

        search.searchFilter(driver, date);

        search.busFilter(driver);

        search.findAlternateSeat(driver);
    }

    public static void waitForEnableCondition(WebDriver driver, WebElement e){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
}
