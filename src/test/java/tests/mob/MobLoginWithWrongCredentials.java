package tests.mob;

import core.base.BaseTest;
import core.base.MobileBaseTest;
import core.pages.mob.MobEnteringPage;
import core.pages.mob.MobLoginPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobLoginWithWrongCredentials extends MobileBaseTest {

    private static MobLoginPage mobLoginPage;
    private static MobEnteringPage mobEnteringPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobEnteringPage = new MobEnteringPage();
        mobEnteringPage.clickToEnter();
        mobLoginPage = new MobLoginPage();
    }

    @Test
    public void LoginWithWrongCredentials() {
        mobLoginPage.login("incorrectUser", "incorrectPassword");
        assertTrue(mobLoginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = mobLoginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
