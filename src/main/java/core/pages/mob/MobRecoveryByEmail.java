package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MobRecoveryByEmail extends MobBasePage {

    private SelenideElement emailFieldMob = $("[id='field_email']");
    private SelenideElement getCodeButtonMob = $("[id='reg_email_button']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        emailFieldMob.shouldBe(visible);
        getCodeButtonMob.shouldBe(visible);
    }

    @Step("Вводим email")
    public void enterEmail(String password) {
        emailFieldMob.shouldBe(visible).setValue(password);
    }

    @Step("Нажать на кнопку получить код")
    public void clickToCodeButton() {
        getCodeButtonMob.shouldBe(visible).click();
    }
}
