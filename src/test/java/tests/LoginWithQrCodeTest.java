package tests;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginWithQrCodeTest extends BaseTest {
    private static LoginPage loginPage;
    private SelenideElement QrCode = $("[class='qr_code_image']");

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void LoginWithQrCodeTest() {
        loginPage.openQrCode();
        QrCode.shouldBe(visible);
    }
}
