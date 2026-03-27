package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByEmail extends BasePage {

    private SelenideElement emailField = $("[tsid='email-field-component_input_fd390f']");
    private SelenideElement getCodeButton = $("[tsid='recovery-start-email-verification-block_input_7f2bff']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        emailField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Вводим email")
    public void enterEmail(String password) {
        emailField.shouldBe(visible).setValue(password);
    }

    @Step("Нажать на кнопку получить код")
    public void clickToCodeButton() {
        getCodeButton.shouldBe(visible).click();
    }
}
