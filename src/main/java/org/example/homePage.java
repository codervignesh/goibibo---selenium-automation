package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class homePage {
    public void closeLoginPopUP(ChromeDriver driver){
        try {
            WebElement closePopup = driver.findElement(By.xpath("//span[@class=\"sc-gsFSXq bGTcbn\"]"));
            closePopup.click();
        }
        catch (Exception e){
            System.out.println("no pop up found");
        }
    }

    public void selectMenu(ChromeDriver driver) {
        WebElement menu = driver.findElement(By.xpath("//a[@href=\"/bus/\"]"));
        menu.click();
    }
}
