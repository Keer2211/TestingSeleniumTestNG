package Pages;

import com.aventstack.extentreports.Status;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.extentTest;

public class ProductsPage
{
    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";
    public static String formalShoes_DropDown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportsShoes_DropDown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sneakers_DropDown_xpath = "/html/body/div[2]/center/div/i[1]";

    public static String formalShoes_DropUp_xpath = "/html/body/div[2]/center/div/i[2]";
    public static String sportsShoes_DropUp_xpath = "/html/body/div[2]/center/div/i[2]";
    public static String sneakers_DropUp_xpath = "/html/body/div[2]/center/div/i[2]";
    public static String formalShoes_shoeOne_xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoes_shoeOne_xpath = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakers_shoeOne_xpath = "/html/body/div[4]/table/tbody/tr[1]/td[1]";

    public static void formalShoes_verifyTitle()
    {
        String expectedTitle = "Formal Shoes";
        String actualTitle = driver.findElement(By.xpath(formalShoes_xpath)).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        if(expectedTitle.equals(actualTitle)){
            extentTest.log(Status.PASS,"Test passed for title verification of formal shoes");
        }
    }
    public static void sportsShoes_verifyTitle()
    {
        String expectedTitle = "Sports Shoes";
        String actualTitle = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        if(expectedTitle.equals(actualTitle)){
            extentTest.log(Status.PASS,"Test passed for title verification for sports shoes");
        }
    }
    public static void sneakers_verifyTitle()
    {
        String expectedTitle = "Sneakers";
        String actualTitle = driver.findElement(By.xpath(sneakers_xpath)).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        if(expectedTitle.equals(actualTitle)){
            extentTest.log(Status.PASS,"Test passed for title verification for sneakers");
        }
    }
    public static void formalShoes_DropDown_Click()
    {
        driver.findElement(By.cssSelector(".fa.fa-angle-double-down.formalshoedropdown")).click();
        String actualName = driver.findElement(By.xpath(formalShoes_shoeOne_xpath)).getText();
        Assert.assertEquals(actualName.trim(), "Classic Cheltenham");
        driver.findElement(By.cssSelector(".fa.fa-angle-double-up.formalshoedropup")).click();
        if(actualName.trim().equals("Classic Cheltenhan")){
            extentTest.log(Status.PASS,"Test passed for verification of first formal shoes");
        }
        else{
            extentTest.log(Status.FAIL,"Test failed actual shoe name is not as expected");
        }
    }
    public static void sportsShoes_DropDown_Click()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click dropdown
        driver.findElement(By.cssSelector(".fa.fa-angle-double-down.sportsshoedropdown")).click();

        // Wait until shoe element is visible
        WebElement shoeElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(sportsShoes_shoeOne_xpath))
        );
        String actualName = shoeElement.getText();

        Assert.assertEquals(actualName.trim(), "Ultimate");

        // Click dropup
        driver.findElement(By.cssSelector(".fa.fa-angle-double-up.sportsshoedropup")).click();
        if(actualName.trim().equals("Ultimate")){
            extentTest.log(Status.PASS,"Test passed for verification of first sports shoes");
        }
    }

    public static void sneakers_DropDown_Click()
    {
        // Click dropdown
        driver.findElement(By.cssSelector(".fa.fa-angle-double-down.sneakershoedropdown")).click();

        // Get shoe name
        String actualName = driver.findElement(By.xpath(sneakers_shoeOne_xpath)).getText();
        Assert.assertEquals(actualName.trim(), "Archivo");

        // Click dropup
        driver.findElement(By.cssSelector(".fa.fa-angle-double-up.sneakersshoedropup")).click();
        if(actualName.trim().equals("Archivo")){
            extentTest.log(Status.PASS,"Test passed for verification of first sneakers shoes");
        }
    }

//    public static void formalShoes_shoeOne_getTitle()
//    {
//
//    }
//    public static void sportsShoes_shoeOne_getTitle()
//    {
//
//    }
//    public static void sneakers_shoeOne_getTitle()
//    {
//
//    }
}
