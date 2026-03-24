package tests;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoToSupportTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private SelenideElement SupportWindow = $("[data-tsid='supportChatTitle']");
    private SelenideElement SupportWindowExit = $("[title='Закрыть чат со службой поддержки']");
    private SelenideElement SupportWindowExitYes = $("[class='button-core__0ej09 __size-m__0ej09 __wide__0ej09']");

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void LoginWithQrCodeTest() {
        loginPage.openForgotPasswordPage();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();
        SupportWindow.shouldBe(visible);
        SupportWindowExit.shouldBe(visible).click();
        SupportWindowExitYes.shouldBe(visible).click();
    }
}
