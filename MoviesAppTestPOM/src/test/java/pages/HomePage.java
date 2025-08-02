package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;


public class HomePage {

    //Heading Locators
    By TrendingHeadingLocators = By.xpath("//h1[text()='Trending Now']");
    By OriginalHeadingLocators = By.xpath("//h1[text()='Originals']");
    By PlayBtnLocator = By.xpath("//button[contains(text(), 'Play')]");
   // Movies Locators
    By trendingMoviesLocator = By.xpath("//h1[text()='Trending Now']/following-sibling::div//img");
    By originalMoviesLocator= By.xpath("//h1[text()='Originals']/following-sibling::div//img");
    By googleContactUsLocator= By.cssSelector("svg.google-icon");
    By twitterContactUsLocator=By.cssSelector("svg.twitter-icon");
    By intaGramContactUsLocator=By.cssSelector("svg.instagram-icon");
    By youTubeContactUsLocator=By.cssSelector("svg.youtube-icon");
    // NavBar Locators
    By imageLocator=By.cssSelector("img.website-logo[alt='website logo']");
    By homeLinkLocator=By.linkText("Home");
    By popularLinkLocator=By.linkText("Popular");

    //Navigation to pages
    By homePageNavigationLocator=By.xpath("//a[contains(@class, 'nav-link') and contains(@class, 'active-nav-link')]");
    By PopularPageNavigationLocators=By.xpath("//a[text()='Popular']");
    By accountPageNavigationLocator=By.xpath("//img[@alt='profile']");

    // Search Page
    By inputSearchLocator=By.id("search");
    By searchPageLocator=By.cssSelector("button[data-testid='searchButton']");
    By movieTilesLocator= By.xpath("//a[contains(@class,'link-item')]");
    By searchBtnLocator= By.xpath("//button[@data-testid='searchButton']");

    // Movie Page
     By TrendingFirstLocator=By.cssSelector(".slick-slide img");
     By TitleLocator=By.cssSelector("h1.movie-title");
     By RunTimeLocator=By.xpath("//p[@class='watch-time']");
     By SensorRatingLocator=By.xpath("//p[contains(@class, 'sensor-rating') and contains(text(), 'U/')]");
     By ReleaseTimeLocator=(By.xpath("//p[@class='release-year']"));

     // AccountPage
    By AccountHeadingLocators=By.xpath("//h1[@class='account-heading']");
    By MemberShipLocator=By.xpath("//p[@class='membership-heading']");
    By PanDetailsLocator = By.xpath("//p[@class='membership-heading']");
    By PremiumLocator=By.xpath("//p[@class='plan-paragraph']");

    // LogOut Function
    By LogOutButtonLocator=By.className("logout-button");




    WebDriver driver;


    public HomePage(WebDriver driver)
    {
        this.driver = driver;

    }


    public String getIsTrendingHeading() {
        return driver.findElement(TrendingHeadingLocators).getText();
    }


    public String getIsOriginalHeading() {
        return driver.findElement(OriginalHeadingLocators).getText();
    }

    public Boolean IsPlayButtonDisplay() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(PlayBtnLocator));
            return playButton.isDisplayed();
        } catch (
                TimeoutException e) {
            System.out.println("Play button not found in time: " + e.getMessage());
            return false;
        } catch (
                NoSuchElementException e) {
            System.out.println("Play button not found: " + e.getMessage());
            return false;
        }

    }

    public boolean getTrendingMoviesDsply() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {

                WebElement trending = wait.until(ExpectedConditions.visibilityOfElementLocated(trendingMoviesLocator));
                return trending.isDisplayed();
            }
         catch (TimeoutException e) {
                return false;
            }

        }

      public boolean getOriginalMoviesDsply(){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        try{
            WebElement original=wait.until(ExpectedConditions.visibilityOfElementLocated(originalMoviesLocator));
            return  original.isDisplayed();
          }
        catch(TimeoutException e){
            return  false;
        }
      }


      public boolean getGoogleContactUsDsply(){

        try {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement googleIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(googleContactUsLocator));
            return googleIcon.isDisplayed();
        }
        catch(TimeoutException e){
            return  false;
        }
      }

      public boolean getTwitterContactUsDsply(){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
            WebElement twitterIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(twitterContactUsLocator));
            return twitterIcon.isDisplayed();
            }
        catch(TimeoutException e){
            return false;
        }
      }
      public boolean getInstagramContactUsDsply() {
          try {
              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
              WebElement instagramIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(intaGramContactUsLocator));
              return instagramIcon.isDisplayed();
          } catch (TimeoutException e) {
              return false;

          }
      }

      public boolean getYouTubeContactUsDsply(){
            try{
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
                WebElement youTubeIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(youTubeContactUsLocator));
                return youTubeIcon.isDisplayed();
            }
            catch(TimeoutException e){
                return false;
            }
          }


      public boolean getImageHeaderSectionDsply(){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
            WebElement imageIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(imageLocator));
            return imageIcon.isDisplayed();
        }
        catch(TimeoutException e){
            return false;
        }
      }

      public boolean getNavbarHomeHeaderSectionDsply(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement HomeNavBar = wait.until(ExpectedConditions.visibilityOfElementLocated(homeLinkLocator));
            return HomeNavBar.isDisplayed();
        }
        catch(TimeoutException e){
            return false;

        }
      }

      public boolean getNavbarPopularHeaderSectionDsply(){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
            WebElement PopularNavBar= wait.until(ExpectedConditions.visibilityOfElementLocated(popularLinkLocator));
            return PopularNavBar.isDisplayed();
        }
        catch(TimeoutException e){
            return false;
        }
      }

      public void clickHomePage(){
        driver.findElement(homePageNavigationLocator).click();

      }

      public void clickPopular(){
        driver.findElement(PopularPageNavigationLocators).click();
      }

      public void clickAccount(){
        driver.findElement(accountPageNavigationLocator).click();
      }



      public void clickSearch(){
        driver.findElement(searchBtnLocator).click();
      }

     public void searchForMovie(String movieName){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input= wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchLocator));
        input.clear();
        input.sendKeys(movieName);
        driver.findElement(searchBtnLocator).click();
     }

     public List <WebElement> getSearchResult(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTilesLocator));
        return driver.findElements(movieTilesLocator);


     }



    public void searchForMovieFailure(String movieName){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement input= wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchLocator));
        input.clear();
        input.sendKeys(movieName);
        driver.findElement(searchPageLocator).click();
    }

   public boolean getTrendingTittleLocator(){

       try{
           WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
           WebElement TitleTrending= wait.until(ExpectedConditions.visibilityOfElementLocated(TitleLocator));
           return TitleTrending.isDisplayed();
       }
       catch(TimeoutException e){
           return false;
       }

   }

public boolean getRunTime(){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement RunTime=wait.until(ExpectedConditions.visibilityOfElementLocated(RunTimeLocator));
            return RunTime.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
   }

public boolean getSenSorRating(){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement SenSorRate=wait.until(ExpectedConditions.visibilityOfElementLocated(SensorRatingLocator));
            return SenSorRate.isDisplayed();
         }
        catch(Exception e){
            return false;
        }
}
 public boolean getReleasingTime(){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement ReleasingTime=wait.until(ExpectedConditions.visibilityOfElementLocated(ReleaseTimeLocator));
            return ReleasingTime.isDisplayed();

           }
        catch(Exception e){
            return false;
        }
 }

 public boolean getMemberShipLocator(){
        try{

            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement MemberShip=wait.until(ExpectedConditions.visibilityOfElementLocated(MemberShipLocator));
            return  MemberShip.isDisplayed();

         }
        catch(Exception e){
            return false;
        }
 }


    public boolean getAccountHeading(){
        try{

            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement AccountHeading=wait.until(ExpectedConditions.visibilityOfElementLocated(AccountHeadingLocators));
            return  AccountHeading.isDisplayed();

        }
        catch(Exception e){
            return false;
        }
    }



    public boolean getPanDetail(){
        try{

            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement PanDetail=wait.until(ExpectedConditions.visibilityOfElementLocated(PanDetailsLocator));
            return  PanDetail.isDisplayed();

        }
        catch(Exception e){
            return false;
        }
    }


    public boolean getPremium(){
        try{

            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement Premium=wait.until(ExpectedConditions.visibilityOfElementLocated(PremiumLocator));
            return  Premium.isDisplayed();

        }
        catch(Exception e){
            return false;
        }
    }

  public void clickLogOut(){
   driver.findElement(LogOutButtonLocator).click();

  }

}






