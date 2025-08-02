import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HeaderSection {

    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage= new LoginPage(driver);
        homePage=new HomePage(driver);

        loginPage.LogInToApplication("rahul", "rahul@2021");
        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));
    }

    @Test(priority = 1)
    public void HeaderSectionUI(){
        Assert.assertTrue(homePage.getImageHeaderSectionDsply(),"Image not displayed");
        Assert.assertTrue(homePage.getNavbarHomeHeaderSectionDsply(),"Home navbar element displayed");
        Assert.assertTrue(homePage.getNavbarPopularHeaderSectionDsply(),"Popular navbar element displayed");
       }


    @Test(priority = 2)
    public void HeaderSectionFunctionalities(){
            // navigation to home page
            homePage.clickHomePage();
            String expectedUrlHome="https://qamoviesapp.ccbp.tech/";
            String actualUrlHome=driver.getCurrentUrl();
            Assert.assertEquals(expectedUrlHome,actualUrlHome,"Url do not matched");

            // navigation to popular page
            homePage.clickPopular();
            String expectedUrlPopular="https://qamoviesapp.ccbp.tech/popular";
            String actualUrlPopular=driver.getCurrentUrl();
            Assert.assertEquals(expectedUrlPopular,actualUrlPopular,"Url do not matched");

            // navigation to account page
            homePage.clickAccount();
            String expectedUrlAccount="https://qamoviesapp.ccbp.tech/account";
            String actualUrlAccount=driver.getCurrentUrl();
            Assert.assertEquals(expectedUrlAccount,actualUrlAccount,"Url do not matched");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
