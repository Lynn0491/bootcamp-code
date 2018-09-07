package examples;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;



public class FirstSeleniumTest {


    @Test
    public void logInSuccesfull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");
        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys("dantester@jourrapide.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();


        driver.getTitle();

        Assertions.assertThat(driver.getTitle()).as("Not on the right page").isEqualToIgnoringCase("My account - My store");

        driver.quit();
    }



}