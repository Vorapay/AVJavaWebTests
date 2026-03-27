package tests.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import core.pages.web.RecoveryByPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryByPhoneTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhonePage recoveryByPhonePage;
    SelenideElement errorMassage = $x("//div[@class='input-e js-ph-vl-hint' and text()='Неправильный номер телефона.']");

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryByPhoneTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.onlyPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        recoveryByPhonePage = new RecoveryByPhonePage();
        String countryCode = recoveryByPhonePage.selectCountryByName("Россия");
        assertEquals("+7", countryCode, "Код Страны не совпадает с ожидаемым");
        recoveryByPhonePage.clickToCodeButton();
        String errorMassageText = errorMassage.getText();
        String expectedMassageText = "Неправильный номер телефона.";
        assertEquals(expectedMassageText, errorMassageText);
    }
}
