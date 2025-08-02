import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import java.util.List;

import java.time.Duration;


public class MovieDetailsPageTest {
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage =new LoginPage(driver);
        homePage =new HomePage(driver);

        loginPage.LogInToApplication("rahul", "rahul@2021");
        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));

    }


    @Test
    public void TestMovieDetailPage(){
    homePage.clickHomePage();
   }

   // Loading first movie from Trending

   @Test (priority = 1)
    public void TestMovieDetailTrending(){
        try {

            List<WebElement> movies =driver.findElements(By.cssSelector(".slick-slide img"));
            if (movies.size() > 0) {
                movies.get(0).click();

            } else {
                System.out.println("Movies are not found");
                driver.quit();
                return;
            }

            // Movie Title
        Assert.assertTrue( homePage.getTrendingTittleLocator(),"Title Not displayed");
        Assert.assertTrue(homePage.getRunTime(),"Run time not displayed");
        Assert.assertTrue(homePage.getSenSorRating(),"Sensor rating not displayed");
        Assert.assertTrue(homePage.getReleasingTime(),"Releasing time not displayed");

        }

        catch(Exception e){
            System.out.println("Error");

        }

   }

   @AfterMethod
    public void TearDown(){
        driver.close();
   }

}
