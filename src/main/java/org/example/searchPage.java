package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class searchPage {
    public void searchFilter(ChromeDriver driver, String date) throws InterruptedException {
        WebElement fromCity = driver.findElement(By.xpath("//input[@placeholder=\"Enter Source\"]"));
        fromCity.sendKeys("coimbatore");

//        waitForEnableCondition(driver, driver.findElement(By.xpath("//div[@aria-label=\"downshift-1-label\"]//li/span")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@aria-label=\"downshift-1-label\"]//li/span")).click();

        Thread.sleep(1000);
        WebElement toCity = driver.findElement(By.xpath("//input[@placeholder=\"Enter Destination\"]"));
        toCity.sendKeys("banglore");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@aria-label=\"downshift-2-label\"]//li/span")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-testid=\"openCheckinCalendar\"]")).click();

        Thread.sleep(1000);
        WebElement month = driver.findElement(By.xpath("//p[@class=\"dcalendarstyles__MonthNamePara-sc-r2jz2t-3 gryMsr\"]"));

        while(!month.getText().equals("February 2024")){
            driver.findElement(By.xpath("//div[@class=\"dcalendarstyles__MonthChangeRightArrowDiv-sc-r2jz2t-16 iJqGSS\"]")).click();
        }

        WebElement selectdate = driver.findElement(By.xpath("//ul[@class=\"dcalendarstyles__DateWrapDiv-sc-r2jz2t-7 gJsKZe\"]//li//span[text()='" + date + "']"));
        selectdate.click();

        driver.findElement(By.xpath("//button[@data-testid=\"searchBusBtn\"]")).click();

    }

    public void busFilter(ChromeDriver driver) throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[text() = \"AC\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text() = \"Sleeper\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text() = \"6 PM - 12 midnight\"]")).click();

        driver.findElement(By.xpath("//button[@class=\"Button-sc-110xfhu-4 jcHJWt\"]")).click();

    }

    public void findAlternateSeat(ChromeDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> seatElements = driver.findElements(By.cssSelector(".SeatWithTooltipstyles__BusSleeper-sc-dkrka-1"));

        Thread.sleep(5000);

        for(int i=0;i<6;i++) {
            WebElement seat1 = seatElements.get(i);
            WebElement seat2 = seatElements.get(i + 6);
            WebElement seat3 = seatElements.get(i + 12);

            if (seat1.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill").equals("rgb(255, 255, 255)")
                    && seat2.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill").equals("rgb(255, 255, 255)")
                    && seat3.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill").equals("rgb(255, 255, 255)")) {
                System.out.println("Empty seat: " + seat2.findElement(By.xpath(".//span[@class=\"seatPrice\"]")).getText());
                System.out.println(seat2.getText() + "seats " + i + " " + (i+6) + " " + (i+12) + " are empty");
//                System.out.println(seat1.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill"));
//                System.out.println(seat2.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill"));
//                System.out.println(seat3.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill"));
            }
        }
    }
}
