package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignOutTest {

    @Test
    public void logInSuccesfull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");

        driver.manage().window().maximize();

        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys("dantester@jourrapide.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertThat(driver.getTitle()).as("Login failed").isEqualToIgnoringCase("My account - My store");

        driver.findElement(By.className("logout")).click();
        Assertions.assertThat(driver.findElement(By.className("login")).getText()).as("Logout failed").isEqualTo("Sign in");

        driver.quit();
    }

}
