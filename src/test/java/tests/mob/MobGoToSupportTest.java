package tests.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import core.pages.mob.MobAnonymRecoveryPage;
import core.pages.mob.MobEnteringPage;
import core.pages.mob.MobLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MobGoToSupportTest extends MobileBaseTest {
    private static MobLoginPage mobLoginPage;
    private static MobAnonymRecoveryPage mobAnonymRecoveryPage;
    private static MobEnteringPage mobEnteringPage;
    private SelenideElement SupportWindowMob = $("[title='Служба поддержки']");
    private SelenideElement SupportWindowExitMob = $("[class='button__tndfc button-icon__tndfc']");
    private SelenideElement SupportWindowExitYesMob = $("[class='button__pe9qo button-core-container__0ej09" +
            " btn__x281t button__1ejp4 _mob__x281t']");

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobEnteringPage = new MobEnteringPage();
        mobEnteringPage.clickToEnter();
        mobLoginPage = new MobLoginPage();
    }

    @Test
    public void LoginWithQrCodeTest() {
        mobLoginPage.openForgotPasswordPage();
        mobAnonymRecoveryPage = new MobAnonymRecoveryPage();
        mobAnonymRecoveryPage.goToSupport();
        SupportWindowMob.shouldBe(visible);
        SupportWindowExitMob.shouldBe(visible).click();
        SupportWindowExitYesMob.shouldBe(visible).click();
    }
}
