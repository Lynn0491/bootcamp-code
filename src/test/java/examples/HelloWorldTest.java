package examples;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelloWorldTest {

    @Test
    public void printText(){
        System.out.println("Hello World");
        Reporter.log(" Hi!");
    }


}


