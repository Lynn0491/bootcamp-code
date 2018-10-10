package chapterSix;

import browser.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FillCartTest extends TestShopScenario {

    @Test
    public void emptyCart() throws InterruptedException {
//        ChromeDriverManager.getInstance().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

//        driver.get("http://automationpractice.com/");
//        driver.manage().window().maximize();

        //Cart empty
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()).isTrue();

        //Search dress
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector(".button-search")).click();
        driver.findElement(By.xpath("//*[@class='product_list grid row']//img[@title='Printed Chiffon Dress']")).click();


        driver.switchTo().defaultContent(); // you are now outside both frames

        //Switch iframe & add to cart
        driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#add_to_cart"))));
        driver.findElement(By.cssSelector("#add_to_cart")).click();


        driver.switchTo().parentFrame();

        //Confirmation cart
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("layer_cart_overlay"))));
        Assertions.assertThat(driver.findElement(By.className("icon-ok")).isDisplayed()).isTrue();

        //Continue shopping
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/span[1]"))));
        driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span")).click();

        //Assert shopping cart
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='shopping_cart']//span[@class='ajax_cart_quantity unvisible']"))));
        Assertions.assertThat(driver.findElement(By.xpath("//div[@class='shopping_cart']//span[@class='ajax_cart_quantity unvisible']")).getText()).isEqualTo("1");



//        driver.quit();
    }



}
