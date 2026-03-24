package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SearchGroupsPage extends BasePage {

    SelenideElement anyGroup = $x("//span[contains(text(), 'Тестировщик')]");

    public void verifyGroupsExistSimple() {
        anyGroup.shouldBe(visible);
    }
}
