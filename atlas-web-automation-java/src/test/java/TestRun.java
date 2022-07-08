
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TestRun {

  @Test
  public void testRunWebAutomation() throws InterruptedException {
    //setup chromedriver
    WebDriverManager.chromedriver().setup();
    //initialize chrome options
    ChromeOptions options = new ChromeOptions();
    //setting chrome capabilities https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--start-maximized,--incognito");
    WebDriver driver = new ChromeDriver(options);
    //for mac it --start-maximized not working properly. So need use this command to maximize
    driver.manage().window().maximize();
    driver.get("http://bdd.atlasid.tech/");
    Thread.sleep(5000);
    driver.findElement(By.id("inputQuote")).sendKeys("Testing automation nih");

    //select element with dropdown
    WebElement colourElement = driver.findElement(By.id("colorSelect"));
    colourElement.click();
//    colourElement.sendKeys("Blue");
//    Thread.sleep(3000);
//
    Select select = new Select(colourElement);
//    select.selectByIndex(3);
//    Thread.sleep(3000);
//
//    select.selectByValue("White");
//    Thread.sleep(2000);

    select.selectByVisibleText("Cyan");
    System.out.println("berhasil memilih warna Cyan");


    String xpathButtonAddQuote = "//*[@class='btn btn-primary']";
    WebElement buttonElement = driver.findElement(By.id("buttonAddQuote"));
    buttonElement.click();
    Thread.sleep(4000);

    WebElement buttonElement2 = driver.findElement(By.xpath(xpathButtonAddQuote));
    buttonElement2.click();
    Thread.sleep(4000);

    String xpathAlert = "//*[@class='alert alert-info']";
    WebElement alertInfo = driver.findElement(By.xpath(xpathAlert));
    String alert = alertInfo.getText();
    System.out.println("alertnya ini adalah: " + alert);
//  Assert.assertTrue(alert.equals("Info: Click on a Quote to delete it!"));
//  Thread.sleep(4000);

    driver.quit();
  }
}
