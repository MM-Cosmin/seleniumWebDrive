package seleniumWebDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class CambiarPassLargo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
		// Descargar Firefox driver (Gecko Driver) de https://github.com/mozilla/geckodriver/releases y copiar en carpeta drivers
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.24.0-win64/geckodriver.exe");
		// Descargar Chrome driver de https://sites.google.com/a/chromium.org/chromedriver/downloads y copiar en carpeta drivers
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
		// System.setProperty("webdriver.opera.driver", "/path/to/operadriver");

		// Descargar IE driver from https://www.seleniumhq.org/download/ y copiar en carpeta drivers
		// System.setProperty("webdriver.ie.driver", "C:/path/to/IEDriverServer.exe");

		// System.setProperty("webdriver.edge.driver", "C:/path/to/MicrosoftWebDriver.exe");
		// System.setProperty("phantomjs.binary.path", "/path/to/phantomjs");

		// driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver = new HtmlUnitDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

  @Test
  public void testCambiarPassLargo() throws Exception {
    driver.get("http://loginapphmis2019jjcanada.azurewebsites.net/");
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.id("Input_Email")).click();
    driver.findElement(By.id("Input_Email")).clear();
    driver.findElement(By.id("Input_Email")).sendKeys("holac2019@ual.es");
    driver.findElement(By.id("Input_Password")).clear();
    driver.findElement(By.id("Input_Password")).sendKeys("ABab12!!");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]")).click();
    assertEquals("Hello holac2019@ual.es!", driver.findElement(By.linkText("Hello holac2019@ual.es!")).getText());
    driver.get("http://loginapphmis2019jjcanada.azurewebsites.net/Account/Manage/ChangePassword");
    driver.findElement(By.id("Input_OldPassword")).clear();
    driver.findElement(By.id("Input_OldPassword")).sendKeys("ABab12!!");
    driver.findElement(By.id("Input_NewPassword")).clear();
    driver.findElement(By.id("Input_NewPassword")).sendKeys("0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A");
    driver.findElement(By.id("Input_ConfirmPassword")).clear();
    driver.findElement(By.id("Input_ConfirmPassword")).sendKeys("0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A0123456789A");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]")).click();
    assertEquals("The New password must be at least 6 and at max 100 characters long.", driver.findElement(By.cssSelector("div.text-danger.validation-summary-errors > ul > li")).getText());
    driver.findElement(By.xpath("//form[@id='logoutForm']/ul/li[2]/button")).click();
    assertTrue(isElementPresent(By.linkText("Log in")));
    assertEquals("Log in", driver.findElement(By.linkText("Log in")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
