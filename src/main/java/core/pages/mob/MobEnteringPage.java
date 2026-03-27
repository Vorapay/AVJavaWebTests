package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobEnteringPage extends MobBasePage {

    private SelenideElement buttonEnter = $("[name='loginButton']");

    public void clickToEnter() {
        buttonEnter.shouldBe(visible).click();
    }
}
