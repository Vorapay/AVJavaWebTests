package tests.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import core.pages.mob.MobAnonymRecoveryPage;
import core.pages.mob.MobEnteringPage;
import core.pages.mob.MobLoginPage;
import core.pages.mob.MobRecoveryByPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobAnonymRecoveryByPhoneTest extends MobileBaseTest {

    private static MobLoginPage mobLoginPage;
    private static MobAnonymRecoveryPage mobAnonymRecoveryPage;
    private static MobRecoveryByPhonePage mobRecoveryByPhonePage;
    private static MobEnteringPage mobEnteringPage;
    SelenideElement errorMassage = $("[class='field_error-descr']");

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobEnteringPage = new MobEnteringPage();
        mobEnteringPage.clickToEnter();
        mobLoginPage = new MobLoginPage();
    }

    @Test
    public void mobAnonymRecoveryByPhoneTest() {
        mobLoginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            mobLoginPage.onlyPassword("1");
            mobLoginPage.clickLogin();
        }
        mobLoginPage.clickToRecoveryButton();
        mobAnonymRecoveryPage = new MobAnonymRecoveryPage();
        mobAnonymRecoveryPage.goToRecoveryByPhone();
        mobRecoveryByPhonePage = new MobRecoveryByPhonePage();
        String countryCode = mobRecoveryByPhonePage.selectCountryByName("Россия");
        assertEquals("+7", countryCode, "Код Страны не совпадает с ожидаемым");
        mobRecoveryByPhonePage.clickToCodeButton();
        String errorMassageText = errorMassage.getText();
        String expectedMassageText = "Введен неверный номер телефона";
        assertEquals(expectedMassageText, errorMassageText);
    }
}
