package ParllelTest;


import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



public class MiningTechCompany {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 
@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    driver = new ChromeDriver();

	//HtmlUnitDriver driver = new HtmlUnitDriver();
driver.manage().window().maximize(); 
    baseUrl = "http://www.mining-technology.com/";
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);                      
  }

 @Test 
  public void testNew() throws Exception {
    driver.get("http://www.mining-technology.com/");
    driver.manage().window().maximize();
    Thread.sleep(1000);

    driver.findElement(By.id("cookiepopup-closebutton")).click();
    Thread.sleep(100);
   
    
    // Cliking All Button
    driver.findElement(By.xpath(".//*[@id='menu-main-navigation']/li[9]/span")).click();
    Thread.sleep(2000);
    
    //Clicking A-z Company From List
    driver.findElement(By.xpath("(//a[contains(text(),'Company A-Z')])[5]")).click();
    Thread.sleep(2000);
    
    //Scrolling Down
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0,250)");
    
    Thread.sleep(2000);
    
    // Clicking ABB company
    driver.findElement(By.xpath("//div[@id='a']/ul/li[4]/a/span")).click();
    Thread.sleep(2000);
    
    jse.executeScript("window.scrollBy(0,950)");
    
    Thread.sleep(2000);
    
    driver.navigate().back();
    
    Thread.sleep(1000);
   
     //Clicking M Alphabet
    driver.findElement(By.xpath(".//*[@id='company-az']/div[1]/a[13]")).click();
    Thread.sleep(2000);
    
    //Clicking Maguire Coaches and Travel Company
    driver.findElement(By.xpath(".//*[@id='l']/ul/li[7]/a/span")).click();
    jse.executeScript("window.scrollBy(0,850)");
    Thread.sleep(2000);
    driver.navigate().back();
    
    
    Thread.sleep(2000);
    //Clicking S Alhabet
    driver.findElement(By.xpath(".//*[@id='company-az']/div[1]/a[20]")).click();
    Thread.sleep(2000);
    
    //Clicking Salter Cyclones Ltd
    driver.findElement(By.xpath(".//*[@id='s']/ul/li[5]/a/span")).click();
    jse.executeScript("window.scrollBy(0,850)");
    Thread.sleep(2000);
    driver.navigate().back();
     Thread.sleep(2000);
   
     //Clicking W Alphabet
    driver.findElement(By.xpath(".//*[@id='company-az']/div[1]/a[22]")).click();
    Thread.sleep(2000);
    
    //clicking Urecon Insulation company
    driver.findElement(By.xpath(".//*[@id='u']/ul/li[2]/a/span")).click();
    jse.executeScript("window.scrollBy(0,850)");
    Thread.sleep(2000);
    driver.navigate().back();
    
    Thread.sleep(2000);
    
    //clicking W Alphabet
    driver.findElement(By.xpath(".//*[@id='company-az']/div[1]/a[24]")).click();
    Thread.sleep(2000);
    
    // clicking Wassara company
    driver.findElement(By.xpath(".//*[@id='w']/ul/li[8]/a/span")).click();
    jse.executeScript("window.scrollBy(0,950)");
    Thread.sleep(2000);
    driver.navigate().back();
    
    Thread.sleep(2000);
    
    driver.findElement(By.xpath(".//*[@id='company-az']/div[1]/a[26]")).click();
    Thread.sleep(2000);
    
    //Clicking yale Cordage company
    driver.findElement(By.xpath(".//*[@id='y']/ul/li[1]/a/span")).click();
    jse.executeScript("window.scrollBy(0,950)");
    Thread.sleep(2000);
    driver.navigate().back();
    
    Thread.sleep(2000);
    
    //Clicking C Alphabet
    driver.findElement(By.xpath(".//*[@id='company-az']/div[1]/a[4]")).click();
    Thread.sleep(2000);
    
    //Clicking Camel Bank Company!!!
    driver.findElement(By.xpath(".//*[@id='c']/ul/li[4]/a/span")).click();
    jse.executeScript("window.scrollBy(0,950)");
    Thread.sleep(2000);
    driver.navigate().back();
    
    Thread.sleep(2000);
    
    
   }

  
@AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
	  //driver.close();
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
