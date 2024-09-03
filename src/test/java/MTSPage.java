import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MTSPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By blockTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By logosList = By.xpath("//div[@class='pay__partners']//img");
    private final By link = By.xpath("//div[@class='pay__wrapper']/a");

    private final By numberField = By.xpath("//*[@id=\"connection-phone\"]");
    private final By sumField = By.xpath("//*[@id=\"connection-sum\"]");

    private final By paymentIFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By fields = By.xpath("//section[@class=\"pay\"]//div//input");
    private final By button = By.xpath("//form[@id='pay-connection']/button");

    public  MTSPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@class = 'pay']"))));
    }

    @Step("Block name checking")
    public String getPaymentBlockTitle () {
        return driver.findElement( blockTitle).getAccessibleName();
    }

    public List<WebElement> getLogos () {
        return driver.findElements(logosList);
    }
    @Step("Move to hyperlink")
    public String movingToLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(link));
        element.click();
        return driver.getCurrentUrl();
    }

    @Step("Fill payment Info")
    public void fillPaymentInfo(String number, String sum) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(numberField))).click();
        driver.findElement(numberField).sendKeys(number);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(sumField))).click();
        driver.findElement(sumField).sendKeys(sum);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(button))).click();
    }

    @Step ("Checking placeholders")
    public List<String> getPlaceholder(){
        return driver.findElements(fields).stream()
                .map(webElement -> webElement.getAttribute("placeholder"))
                .collect(Collectors.toList());
    }
    @Step("Open payment confirmation window")
    public PaymentIFrame openPaymentWindow(String number, String sum) {
        fillPaymentInfo(number, sum);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo()
                .frame(wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentIFrame))));
        return new PaymentIFrame(driver);
    }

}
