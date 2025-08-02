import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import pages.LoginPage;
import pages.HomePage;




public class HomePageTest {

    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.LogInToApplication("rahul", "rahul@2021");
        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));
    }

    @Test(priority = 1)
    public void TestHomePageHeading() {
        String actualTrendingHeading = homePage.getIsTrendingHeading();
        String expedtedTrendingHeading = "Trending Now";

        Assert.assertEquals(expedtedTrendingHeading, actualTrendingHeading, "Heading Trending doesnot matched");

        String actualOriginalHeading = homePage.getIsOriginalHeading();
        String expectedOriginalHeading = "Originals";

        Assert.assertEquals(expectedOriginalHeading, actualOriginalHeading, "Heading Originals doesnot matched");

        Assert.assertTrue(homePage.IsPlayButtonDisplay(), "Play button not displayed");

    }

    @Test

    public void testTrendingAndOriginalMoviesDisplayed() {
        Assert.assertTrue(homePage.getTrendingMoviesDsply(), "Trending movies should be displayed");
        Assert.assertTrue(homePage.getOriginalMoviesDsply(), "Original movies should be displayed");
    }

    @Test
    public void testContactUsDisplayed(){
        Assert.assertTrue(homePage.getGoogleContactUsDsply(),"Google icon dispalyed");
        Assert.assertTrue(homePage.getTwitterContactUsDsply(),"Twitter icon displayed");
        Assert.assertTrue(homePage.getInstagramContactUsDsply(),"Instagram icon displayed");
        Assert.assertTrue(homePage.getYouTubeContactUsDsply(),"Youtube icon displayed");
    }

    @AfterMethod
    public void tearDown(){
      driver.close();
    }

}
