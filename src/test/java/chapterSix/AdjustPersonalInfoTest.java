package chapterSix;

import browser.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class AdjustPersonalInfoTest extends TestShopScenario {

    @Test
    public void adjustPersonalInfoTest()

    {

        {
            //Login
            driver.findElement(By.cssSelector(".login")).click();
            driver.findElement(By.cssSelector("#email")).sendKeys("dantester@jourrapide.com");
            driver.findElement(By.cssSelector("#passwd")).sendKeys("1qazxsw2");
            driver.findElement(By.cssSelector("#SubmitLogin")).click();

            //Navigeer naar personal info
            driver.findElement(By.cssSelector(".icon-user")).click();

            //WebElement aanmaken zodat deze vaker gezocht kan worden zonder steeds 'driver.findElement'
            WebElement firstNameField = driver.findElement(By.cssSelector("#firstname"));

            System.out.println("The name in the box is ["  + firstNameField.getAttribute("value") +"]");

            // Naam in tekstveld ophalen
            String newFirstName;
            if (firstNameField.getAttribute("value").equals("Dan")) {
                // Nieuwe naam moet Bob zijn
                newFirstName = "Bob";
            } else {
                // Nieuwe naam moet Dan zijn
                newFirstName = "Dan";
            }

            firstNameField.clear();
            firstNameField.sendKeys(newFirstName);
            System.out.println("I changed the name to " + newFirstName);


            //Change birthday
            // Eerst een int met een dag aanmaken (in dit geval random van 1 tot en met 31)
            int day = ThreadLocalRandom.current().nextInt(1, 31);
            System.out.println(day);

            // Dan een int met een maand aanmaken (in dit geval random van 1 tot en met 12)
            int month = ThreadLocalRandom.current().nextInt(1, 12);
            System.out.println(month);

            // Dan een int met een jaar aanmaken (in dit geval random van 1900 tot 2018)
            int year = ThreadLocalRandom.current().nextInt(1900, 2018);
            System.out.println(year);

            // Dag aanpassen
            Select daySelector = new Select(driver.findElement(By.cssSelector("#days")));
            daySelector.selectByValue(Integer.toString(day));

            // Maand aanpassen
            Select monthSelector = new Select(driver.findElement(By.cssSelector("#months")));
            monthSelector.selectByValue(Integer.toString(month));

            // Jaar aanpassen
            Select yearSelector = new Select(driver.findElement(By.cssSelector("#years")));
            yearSelector.selectByValue(Integer.toString(year));

            // Password
            driver.findElement(By.cssSelector("#old_passwd")).sendKeys("1qazxsw2");


            driver.findElement(By.name("submitIdentity")).click();

            Assertions.assertThat(driver.findElement(By.cssSelector(".account")).getText()).containsIgnoringCase(newFirstName);
        }


    }
}
