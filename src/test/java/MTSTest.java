import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MTSTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            WebElement coockieBtn = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
            if (coockieBtn.isDisplayed()) {
                coockieBtn.click();
            }
        } catch (NoSuchElementException ignored) {
            //ignore exception if cookie acceptance window does not appear
        }
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }

    @BeforeEach
    public void setUpEach() {
        driver.navigate().refresh();
    }

    @Test
    @DisplayName("Block name checking")
    public void blockNameTest() {

        WebElement payWindow = driver.findElement( By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));

        assertEquals("Онлайн пополнение без комиссии",payWindow.getAccessibleName() );

    }

    @Test
    @DisplayName("Payments systems logos checking")
    public void paymentTest() {
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li/img"));

        assertFalse(logos.isEmpty());

    }

    @Test
    @DisplayName("Hyperlink checking")
    public void hrefTest() {

        WebElement href = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        String current = driver.getCurrentUrl();
        href.click();
        assertNotEquals(current, driver.getCurrentUrl());

    }

    @Test
    @DisplayName("Checking the operation of the \"Continue\" button")
    public void buttonTest() {
        WebElement numberField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        numberField.click();
        numberField.sendKeys("297777777");
        WebElement sumField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumField.click();
        sumField.sendKeys("1");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();
        assertDoesNotThrow(() -> {
            driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        });
    }

}
