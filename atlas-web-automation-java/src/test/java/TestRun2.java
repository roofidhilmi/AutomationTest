
import driver.WebdriverInit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TestRun2 {

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
        driver.findElement(By.id("inputQuote")).sendKeys("Rofid");
        System.out.println("Berhasil input Quote: Rofid");

        //select element with dropdown
        WebElement colourElement = driver.findElement(By.id("colorSelect"));
        colourElement.click();
        //Select dropdown list
        Select select = new Select(colourElement);
        select.selectByVisibleText("Cyan");
        System.out.println("berhasil memilih warna Cyan");
//    colourElement.sendKeys("Blue");
//    Thread.sleep(3000);

//    select.selectByIndex(3);
//    Thread.sleep(3000);
//
//    select.selectByValue("White");
//    Thread.sleep(2000);
        String xpathButtonAddQuote = "//*[@class='btn btn-primary']";
        WebElement buttonElement = driver.findElement(By.id("buttonAddQuote"));
        buttonElement.click();
        Thread.sleep(4000);
//        WebElement buttonElement2 = driver.findElement(By.xpath(xpathButtonAddQuote));
//        buttonElement2.click();
//        Thread.sleep(4000);
        String xpathAlert = "//*[@class='col-sm-12']";
        WebElement alertInfo = driver.findElement(By.xpath(xpathAlert));
        String alert = alertInfo.getText();
        System.out.println("alertnya ini adalah: " + alert);

        String xpathAlert2 = "//*[@class='footer-copyright text-center py-3']";
        WebElement alertFooter = driver.findElement(By.xpath(xpathAlert2));
        String alert2 = alertFooter.getText();
        System.out.println("footernya ini adalah: " + alert2);
        Assert.assertTrue(alert2.equals("Powered By Atlas ID"));
        Thread.sleep(4000);

        driver.quit();
    }
}
