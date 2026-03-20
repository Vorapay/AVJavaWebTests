package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByPhone extends BasePage {

    private SelenideElement phoneNumberField = $("[tsid='phone-form_input_fe1c7a']");
    private SelenideElement countryField = $("[tsid='phone-form_input_d363f7']");
    private SelenideElement getCodeButton = $("[tsid='abstract-phone-link-block_input_683b97']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        phoneNumberField.shouldBe(visible);
        countryField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Вводим телефонный номер: {phoneNumber}")
    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.shouldBe(visible).setValue(phoneNumber);
    }

    @Step("Выбираем страну")
    public void selectCountry(String countryName) {
        countryField.shouldBe(visible).selectOption(countryName);
    }

    @Step("Нажать на кнопку получить код")
    public void clickToCodeButton() {
        getCodeButton.shouldBe(visible).click();
    }
}
