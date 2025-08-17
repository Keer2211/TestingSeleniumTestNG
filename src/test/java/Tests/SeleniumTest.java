package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumTest
{
    public static WebDriver driver;
     static ExtentReports extent;
    public static ExtentTest extentTest;

    @BeforeSuite
    public static void SetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

        // Setup ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        HomePage.click_hamburger_menu_xpath();
        HomePage.click_onlineProducts_link_xpath();
    }

    @Test
    void ValidateTitles_OnlineProducts()
    {
        extentTest = extent.createTest("Validate Shoe Titles",
                "This test validates whether the shoes are correct in the webpage");
        ProductsPage.formalShoes_verifyTitle();
        ProductsPage.sportsShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();
    }

    @Test(priority = 3)
    void ValidateFormalShoeOne()
    {
        extentTest = extent.createTest("Validate Formal Shoe",
                "This test validates whether the first formal shoe is as expected");
        ProductsPage.formalShoes_DropDown_Click();
    }

    @Test(priority = 2)
    void ValidateSportsShoeOne()
    {
        extentTest = extent.createTest("Validate Sports Shoe",
                "This test validates whether the first sport shoe is as expected");
        ProductsPage.sportsShoes_DropDown_Click();
    }

    @Test(priority = 1)
    void ValidateSneakersShoeOne()
    {
        extentTest = extent.createTest("Validate Sneakers",
                "This test validates whether the first sneaker is as expected");
        ProductsPage.sneakers_DropDown_Click();
    }

    @AfterSuite
    public void CleanUp(){
        extent.flush();
        driver.quit();
    }
}
