package tests.mob;

import core.base.MobBasePage;
import core.base.MobileBaseTest;
import core.pages.mob.MobEnteringPage;
import core.pages.mob.MobLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobLoginWithOnlyUsername extends MobileBaseTest {

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
    public void LoginWithOnlyUsername() {
        mobLoginPage.onlyUsername("incorrectUser");
        assertTrue(mobLoginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");
        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = mobLoginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
