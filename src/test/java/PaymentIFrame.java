import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentIFrame {
    private final WebDriver driver;

    private final By cost =
            By.xpath("//div[@class='pay-description__cost']/span");
    private final By description =
            By.xpath("//div[@class='pay-description__text']/span");
    private final By buttonText =
            By.xpath("//div[@class='card-page__card']/button[@type='submit']");

    private final By placeholders =
            By.xpath("//app-input//label");
    private final By logos =
            By.xpath("//app-input//img");

    public PaymentIFrame(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='app-wrapper__content']"))));
    }

    @Step ("Checking phone number")
    public boolean isContainsNumber(String number) {
        WebElement descriptionStr = driver.findElement(description);
        return  descriptionStr.getText().contains(number);
    }

    @Step("Checking price from label")
    public String getPriceLabel() {
        return driver.findElement(cost).getText().split(" ")[0];
    }

    @Step("Checking price from button")
    public String getPriceFromButton() {
        return driver.findElement(buttonText).getText().split(" ")[1];
    }

    @Step("Checking placeholders")
    public List<String> getPlaceholders(){
        return driver.findElements(placeholders)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Checking logos")
    public List<WebElement> getLogos() {
        return driver.findElements(logos);
    }
}
