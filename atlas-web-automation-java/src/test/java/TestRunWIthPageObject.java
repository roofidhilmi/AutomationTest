import driver.WebdriverInit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.InputQuotePage;

public class TestRunWIthPageObject {

    private InputQuotePage inputQuotePage = new InputQuotePage();

    @BeforeEach
    public  void initializeWebdriver(){
        WebdriverInit.initialize();
    }

    @AfterEach
    public void quitWebDriver() throws InterruptedException {
        Thread.sleep(4000);
        WebdriverInit.quit();
    }

    @Test
    public  void addQuote() throws InterruptedException {
        //inisialisasi webdrivernya
        inputQuotePage.openPage();
        inputQuotePage.inputQuote("Testing automation testing");
        inputQuotePage.selectColor("Yellow");
        Thread.sleep(4000);
        inputQuotePage.clickButtonAddQuote();
        Assertions.assertTrue(inputQuotePage.checkQuoteExist("Testing automation testing"));
        //wait
        Thread.sleep(4000);

    }
}
