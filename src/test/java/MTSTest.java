import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MTSTest {
    private static WebDriver driver;

    private MTSPage mts;

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
        MTSPage mts = new MTSPage(driver);
        assertEquals("Онлайн пополнение без комиссии", mts.getPaymentBlockTitle());
    }

    @Test
    @DisplayName("Payments systems logos checking")
    public void paymentTest() {
        MTSPage mts = new MTSPage(driver);
        assertFalse(mts.getLogos().isEmpty());

    }

    @Test
    @DisplayName("Hyperlink checking")
    public void hrefTest() {
        MTSPage mts = new MTSPage(driver);
        String current = driver.getCurrentUrl();
        assertNotEquals(current, mts.movingToLink());
    }

    @Test
    @DisplayName("Checking the operation of the \"Continue\" button")
    @Disabled ("Submit form not")
    public void buttonTest() {
        MTSPage mts = new MTSPage(driver);
        assertDoesNotThrow(mts::fillPaymentInfo);
    }

}
