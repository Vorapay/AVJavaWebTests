package core.base;

import com.codeborne.selenide.Configuration;
import core.pages.mob.MobEnteringPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class MobileBaseTest extends AbstractBaseTest{

    @Override
    protected void configure() {
        Configuration.browser = "chrome";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone X"));
        Configuration.browserCapabilities = chromeOptions;
    }
}
