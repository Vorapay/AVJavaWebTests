package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.MobEnteringPage;
import core.pages.mob.MobLoginPage;
import core.pages.mob.MobSearchGroupsPage;
import core.pages.web.SearchGroupsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MobSearchGroupsTest extends MobileBaseTest {

    private static MobLoginPage mobLoginPage;
    private static MobEnteringPage mobEnteringPage;
    private static MobSearchGroupsPage mobSearchGroupsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobEnteringPage = new MobEnteringPage();
        mobEnteringPage.clickToEnter();
        mobLoginPage = new MobLoginPage();
    }

    @Test
    public void LoginWithQrCodeTest() {
        mobLoginPage.mobSearch("Тестировщик");
        mobSearchGroupsPage = new MobSearchGroupsPage();
        mobSearchGroupsPage.verifyGroupsExistSimpleMob();
    }
}
