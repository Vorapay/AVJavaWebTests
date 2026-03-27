package tests.web;

import com.codeborne.selenide.WebDriverRunner;
import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class AnonymMobRecoveryByEmailTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryByEmailTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.onlyPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();
    }
}
