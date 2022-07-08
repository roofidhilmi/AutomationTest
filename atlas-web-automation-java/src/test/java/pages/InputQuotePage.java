package pages;

import base.PageObject;
import driver.WebdriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class InputQuotePage extends PageObject {

    public void openPage(){
//        WebdriverInit.driver.get("http://bdd.atlasid.tech/");
        openUrl("http://bdd.atlasid.tech/");
    }

    public  void inputQuote(String quote){
//        WebElement inputQuote = WebdriverInit.driver.findElement(By.id("inputQuote"));
//        inputQuote.sendKeys(quote);
//        System.out.println("Berhasil input Quote");
       type(By.id("inputQuote"), quote);

    }

    public  void selectColor(String color){
        //Select color
//        WebElement colourElement = WebdriverInit.driver.findElement(By.id("colorSelect"));
//        colourElement.click();
//        //Select dropdown list
//        Select select = new Select(colourElement);
//        select.selectByVisibleText(color);
//        System.out.println("berhasil memilih warna: " + color);
        selectByVisibleText(By.id("colorSelect"), color);
    }

    public void clickButtonAddQuote(){

//        String xpathButtonAddQuote = "//*[@class='btn btn-primary']";
//        WebElement buttonElement = WebdriverInit.driver.findElement(By.id("buttonAddQuote"));
//        buttonElement.click();
        click(By.id("buttonAddQuote"));

    }

    public boolean checkQuoteExist(String quote){
        List<WebElement> quoteElements = WebdriverInit.driver.findElements(By.name("quoteText"));
        boolean isSame = false;
        for(WebElement data : quoteElements){
            if(data.getText().equals(quote)){
                isSame = true;
                break;
            }
        }

        return isSame;
    }

}
