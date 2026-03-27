package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.MobAnonymRecoveryPage;
import core.pages.mob.MobEnteringPage;
import core.pages.mob.MobLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MobAnonymMobRecoveryByEmailTest extends MobileBaseTest {
    private static MobLoginPage mobLoginPage;
    private static MobAnonymRecoveryPage mobAnonymRecoveryPage;
    private static MobEnteringPage mobEnteringPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobEnteringPage = new MobEnteringPage();
        mobEnteringPage.clickToEnter();
        mobLoginPage = new MobLoginPage();
    }

    @Test
    public void anonymRecoveryByEmailTest() {
        mobLoginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            mobLoginPage.onlyPassword("1");
            mobLoginPage.clickLogin();
        }
        mobLoginPage.clickToRecoveryButton();
        mobAnonymRecoveryPage = new MobAnonymRecoveryPage();
        mobAnonymRecoveryPage.goToRecoveryByEmail();
    }
}
