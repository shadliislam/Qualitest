import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {




    public static void main(String[] args) {
        int x=10;
        String num="24";

        int result=Integer.parseInt(num);
        System.out.println(result+x);
    }


    public void checkElementText(String webElementID, String expectedtext){

        WebDriver driver=new ChromeDriver();

        WebElement element=driver.findElement(By.id(webElementID));

        String elementText=element.getText();

        Assert.assertEquals(elementText,expectedtext);

    }
}

