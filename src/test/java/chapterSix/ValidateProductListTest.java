package chapterSix;

import browser.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateProductListTest extends TestShopScenario {

    @Test
    public void validateProductListTest() {

        // Navigeer naar dresses
        driver.findElement(By.cssSelector("#block_top_menu > ul > li > a[title='Dresses']")).click();

        // Navigeer naar summer dresses
        driver.findElement(By.xpath("//*[@id='categories_block_left']//a[contains(text(), 'Summer Dresses')]")).click();


        // Webelement aanmaken met daarin jurken
        List<WebElement> dresses = driver.findElements(By.cssSelector(".product-container .product-name"));

        // List van Strings aanmaken om daarin een forloop te doen
        List<String> dressNames = new ArrayList<>();

        // Geavanceerde optie met forloop er al in
//        List<String> dressNames = dresses.stream().map(WebElement::getText).collect(Collectors.toList());

        for (WebElement dress : dresses) {
            dressNames.add(dress.getText());
        }
        
        // Assertion dat 'n specifieke dress in de list 'dressNames' zit
        Assertions.assertThat(dressNames).contains("Printed Chiffoon Dress");
    }
}
