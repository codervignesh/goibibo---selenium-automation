package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class goibibo {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.goibibo.com/");

        String date = "10";


        try {
            driver.findElement(By.xpath("//span[@class=\"sc-gsFSXq bGTcbn\"]")).click();
        }
        catch (Exception e){
            System.out.println("no pop up found");
        }
        driver.findElement(By.xpath("//a[@href=\"/bus/\"]")).click();

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
//        List<WebElement> dates = driver.findElements(By.xpath("//ul[@class=\"dcalendarstyles__DateWrapDiv-sc-r2jz2t-7 gJsKZe\"]"));
//        for( WebElement ele : dates) {
//            if (ele.getText().equals(date)){
//                ele.click();
//                break;
//            }
//        }

        WebElement selectdate = driver.findElement(By.xpath("//ul[@class=\"dcalendarstyles__DateWrapDiv-sc-r2jz2t-7 gJsKZe\"]//li//span[text()='" + date + "']"));
        selectdate.click();

        driver.findElement(By.xpath("//button[@data-testid=\"searchBusBtn\"]")).click();

        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[text() = \"AC\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text() = \"Sleeper\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text() = \"6 PM - 12 midnight\"]")).click();

        driver.findElement(By.xpath("//button[@class=\"Button-sc-110xfhu-4 jcHJWt\"]")).click();

//        List<WebElement> seats = driver.findElements(By.xpath("//aside[@class=\"busContent\"]"));
//
//        for(WebElement seat : seats){
//            System.out.println(seat.getAttribute("outerHTML"));
//            System.out.println("hello");
//        }
        Thread.sleep(5000);
        List<WebElement> seatElements = driver.findElements(By.cssSelector(".SeatWithTooltipstyles__BusSleeper-sc-dkrka-1"));

        Thread.sleep(5000);
//        for (WebElement seat : seatElements) {
//            System.out.println(seat.getAttribute("outerHTML"));
//            String seatNumber = seat.findElement(By.xpath(".//span[@class=\"seatNum\"]")).getText();
//            String seatPrice = seat.findElement(By.xpath(".//span[@class=\"seatPrice\"]")).getText();
////            System.out.println("Seat Number: " + seatNumber + ", Price: " + seatPrice);
//
//            String seatColor = seat.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill");
//            System.out.println(seatColor);
//
//            //occupied "rgb(216, 216, 216)"
//            //unoccupied "rgb(255, 255, 255)"
//
//            // Check if the seat is non-empty and its alternate seat is empty
//            if ("rgb(255, 255, 255)".equals(seatColor)) {
//                System.out.println("in"); //working
//            }
//        }

        for(int i=0;i<6;i++){
            WebElement seat1=seatElements.get(i);
            WebElement seat2=seatElements.get(i+6);
            WebElement seat3=seatElements.get(i+12);

            if(seat1.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill").equals("rgb(255, 255, 255)")
                    && seat2.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill").equals("rgb(255, 255, 255)")
                    && seat3.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill").equals("rgb(255, 255, 255)")){
                System.out.println("Empty seat: " + seat2.findElement(By.xpath(".//span[@class=\"seatPrice\"]")).getText());
                System.out.println(seat2.getText() + "seat 2 is empty");
                System.out.println(seat1.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill"));
                System.out.println(seat2.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill"));
                System.out.println(seat3.findElement(By.cssSelector("path:nth-child(1)")).getCssValue("fill"));

            }
        }


    }
    public static void waitForEnableCondition(WebDriver driver, WebElement e){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
}
