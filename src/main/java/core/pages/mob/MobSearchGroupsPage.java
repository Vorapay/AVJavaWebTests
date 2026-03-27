package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MobSearchGroupsPage extends MobBasePage {

    SelenideElement anyGroupMob = $x("//li[contains(text(), 'Тестировщик')]");

    public void verifyGroupsExistSimpleMob() {
        anyGroupMob.shouldBe(visible);
    }
}
