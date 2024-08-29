import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MTSPage {
    private final WebDriver driver;

    private final By blockTitle = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private final By logosList = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li/img");
    private final By link = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");

    private final By selectComServices = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p");
    private final By numberField = By.xpath("//*[@id=\"connection-phone\"]");
    private final By sumField = By.xpath("//*[@id=\"connection-sum\"]");
    private final By submitBtn = By.xpath("//*[@id=\"pay-connection\"]/button");
    private final By paymentIFrame = By.xpath("//iframe[@class='bepaid-iframe']");

    private final By fields = By.xpath("//section[@class=\"pay\"]//div//input");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(link));
        element.click();
        return driver.getCurrentUrl();
    }

    public void fillPaymentInfo() {
        driver.findElement(numberField).click();
        driver.findElement(numberField).sendKeys("297777777");
        driver.findElement(sumField).click();
        driver.findElement(sumField).sendKeys("1");
        driver.findElement(submitBtn).click();
        //driver.findElement(paymentIFrame);
    }

    public List<String> getPlaceholder(){
        return driver.findElements(fields).stream()
                .map(webElement -> webElement.getAttribute("placeholder")).collect(Collectors.toList());
    }

}
