import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MTSPage {
    private final WebDriver driver;

    private final By blockTitle = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private final By logosList = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li/img");
    private final By link = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");

    private final By numberField = By.xpath("//*[@id=\"connection-phone\"]");
    private final By sumField = By.xpath("//*[@id=\"connection-sum\"]");
    private final By submitBtn = By.xpath("//*[@id=\"pay-connection\"]/button");
    private final By paymentIFrame = By.xpath("//iframe[@class='bepaid-iframe']");

    public  MTSPage (WebDriver driver) {
        this.driver = driver;
    }

    public String getPaymentBlockTitle () {
        return driver.findElement( blockTitle).getAccessibleName();
    }

    public List<WebElement> getLogos () {
        return driver.findElements(logosList);
    }

    public String movingToLink() {
        driver.findElement(link).click();
        return driver.getCurrentUrl();
    }

    public void fillPaymentInfo() {
        driver.findElement(numberField).click();
        driver.findElement(numberField).sendKeys("297777777");
        driver.findElement(sumField).click();
        driver.findElement(sumField).sendKeys("1");
        driver.findElement(submitBtn).click();
        driver.findElement(paymentIFrame);
    }

}
