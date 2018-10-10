package chapterSix;

import browser.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;


public class EmptyCartTest extends TestShopScenario {


        @Test
        public void EmptyCartTest() throws InterruptedException {
//        ChromeDriverManager.getInstance().setup();
//        WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            Actions action = new Actions(driver);
            WebElement productcontainer = driver.findElement(By.cssSelector(".product-container"));
            WebElement cart = driver.findElement(By.cssSelector(".shopping_cart>a"));

//        driver.get("http://automationpractice.com/");
//        driver.manage().window().maximize();

            //Cart empty
            Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()).isTrue();

            //Add to cart after hover over
            action.moveToElement(productcontainer).build().perform();
            driver.findElement(By.cssSelector(".ajax_add_to_cart_button")).click();
//            driver.switchTo().defaultContent();
////
            //Overlay confirmation
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("layer_cart_overlay"))));
            Assertions.assertThat(driver.findElement(By.className("icon-ok")).isDisplayed()).isTrue();
            driver.findElement(By.className("cross")).click();

//            //Block cart show & remove product. Eventueel een wait inbouwen
            action.moveToElement(cart).build().perform();
            driver.findElement(By.cssSelector(".ajax_cart_block_remove_link")).click();


            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ajax_cart_no_product"))));
            Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()).isTrue();





        }
    }