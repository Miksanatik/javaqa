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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @BeforeEach
    public void acceptCookies(){
        driver.get("https://mts.by");
        try {
            WebElement cookieBtn = driver.findElement(By.id("cookie-agree"));
            if (cookieBtn.isDisplayed()) {
                cookieBtn.click();
            }
        } catch (NoSuchElementException ignored) {
            //ignore exception if cookie acceptance window does not appear
        }
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
    public void buttonTest() {
        MTSPage mts = new MTSPage(driver);
        assertDoesNotThrow(() -> mts.fillPaymentInfo("297777777","1"));
    }

    @Test
    @DisplayName("Checking placeholders")
    public void checkPlaceholders(){
        String[] expected = new String[] {"Номер телефона","Сумма","E-mail для отправки чека",
                                            "Номер абонента", "Сумма","E-mail для отправки чека",
                                            "Номер счета на 44","Сумма","E-mail для отправки чека",
                                            "Номер счета на 2073","Сумма","E-mail для отправки чека"};

        MTSPage mts = new MTSPage(driver);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], mts.getPlaceholder().get(i));
        }
    }

    @Test
    @DisplayName("Checking payment window's elements")
    public void checkPaymentWindow() {

        String number = "297777777";
        String sum = "1.00";
        String[] expected = new String[] {
                "Номер карты",
                "Срок действия",
                "CVC",
                "Имя держателя (как на карте)"
        };

        MTSPage mts = new MTSPage(driver);
        PaymentIFrame frame = mts.openPaymentWindow(number,sum);

        List<String> placeholders = frame.getPlaceholders();
        for(int i = 0; i<placeholders.size(); i++) {
            assertEquals(expected[i], placeholders.get(i));
        }
        assertTrue(frame.isContainsNumber(number));
        assertEquals(sum, frame.getPriceLabel());
        assertEquals(sum, frame.getPriceFromButton());
        assertFalse(frame.getLogos().isEmpty());
    }
}
