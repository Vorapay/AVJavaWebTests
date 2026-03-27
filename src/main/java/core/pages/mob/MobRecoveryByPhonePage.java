package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobRecoveryByPhonePage extends MobBasePage {

    private SelenideElement phoneNumberFieldMob = $("[id='field_phone']");
    private SelenideElement countryButtonMob = $("[data-no-country-text='noCountry']");
    private SelenideElement getCodeButtonMob = $("[id='getCode']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        phoneNumberFieldMob.shouldBe(visible);
        countryButtonMob.shouldBe(visible);
        getCodeButtonMob.shouldBe(visible);
    }

    @Step("Вводим телефонный номер: {phoneNumber}")
    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberFieldMob.shouldBe(visible).setValue(phoneNumber);
    }

    @Step("Выбираем страну")
    public void selectCountry(String countryName) {
        countryButtonMob.shouldBe(visible).click();
        countryButtonMob.selectOption(countryName);
    }

    @Step("Нажать на кнопку получить код")
    public void clickToCodeButton() {
        getCodeButtonMob.shouldBe(visible).click();
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryButtonMob.click();
        SelenideElement countryItem = $x(String.format("//div[@class='reg_choose_country' and text()='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find("//div[@class='reg_choose_prefix']").text();
        countryItem.click();
        return countryCode;
    }
}
