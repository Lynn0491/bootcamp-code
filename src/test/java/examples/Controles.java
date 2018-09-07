package examples;


import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles {

    @Test
    public void assertIntegerGreaterThan(){
        int testInt = 4;
        Assertions.assertThat(testInt).as("Getal is niet groter dan 3").isGreaterThan(3);
    }

    @Test
    public void assertTextToContainNoneOfTheText(){
        String motivationLetter = ("Ik ben heel gemotiveerd");
        Assertions.assertThat(motivationLetter).as("Tekst is gelijk").isNotEqualTo("Ik ben heel sportief");

    }

    @Test
    public void assertBoolean(){
        boolean testBoolean = true;
        Assertions.assertThat(testBoolean).as("Selectionbox is disabled").isTrue();


    }



}
