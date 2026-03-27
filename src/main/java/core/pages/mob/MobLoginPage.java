package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobLoginPage extends MobBasePage {
    private SelenideElement usernameFieldMob = $("[name='st.email']");
    private SelenideElement passwordFieldMob = $("[name='st.password']");
    private SelenideElement loginButtonMob = $("[type='submit']");
    private SelenideElement forgotPasswordLinkMob = $x("//button[text()='Не получается войти?']");
    private SelenideElement registrationButtonMob = $x("//span[@class='vkuiButton__content'" +
            " and text()='Регистрация']");
    private SelenideElement vkButtonMob = $("[title='Войти через VK ID']");
    private SelenideElement mailRuButtonMob = $("[title='Войти через Почту']");
    private SelenideElement yandexButtonMob = $("[title='Войти через Яндекс']");
    private SelenideElement errorMessageMob = $("[class='LoginForm-module__error___1xmAD" +
            " vkuiCaption__sizeYNone vkuiCaption__level1 vkuiTypography__host vkuiTypography__normalize" +
            " vkuiRootComponent__host']");
    private SelenideElement goToRecoveryButtonMob = $x("//span[@class='vkuiButton__content' and text()='Восстановить']");
    private SelenideElement goToRecoveryButtonCancelMob = $x("//span[@class='vkuiButton__content' and text()='Отмена']");
    private SelenideElement goToRecoveryButtonExitMob = $("[role='button'] [style='fill: currentcolor;']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameFieldMob.shouldBe(visible);
        passwordFieldMob.shouldBe(visible);
        loginButtonMob.shouldBe(visible);
        forgotPasswordLinkMob.shouldBe(visible);
        registrationButtonMob.shouldBe(visible);
        vkButtonMob.shouldBe(visible);
        mailRuButtonMob.shouldBe(visible);
        yandexButtonMob.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessageMob.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessageMob.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameFieldMob.shouldBe(visible).setValue(username);
        passwordFieldMob.shouldBe(visible).setValue(password);
        loginButtonMob.shouldBe(visible).click();
    }

    @Step("Вводим только логин: {username}")
    public void onlyUsername(String username) {
        usernameFieldMob.shouldBe(visible).setValue(username);
        loginButtonMob.shouldBe(visible).click();
    }

    @Step("Вводим только пароль: {password}")
    public void onlyPassword(String password) {
        passwordFieldMob.shouldBe(visible).setValue(password);
        loginButtonMob.shouldBe(visible).click();
    }


    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLinkMob.shouldBe(visible).click();
    }

    @Step("Переход на страницу регистрации")
    private void openRegistrationPage() {
        registrationButtonMob.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    private void loginWithVk() {
        vkButtonMob.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    private void loginMailru() {
        mailRuButtonMob.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    private void loginYandex() {
        yandexButtonMob.shouldBe(visible).click();
    }

    @Step("Нажимаем Восстановить")
    public void clickToRecoveryButton() {
        goToRecoveryButtonMob.shouldBe(visible).click();
    }

    @Step("Нажимаем Отмена")
    public void clickToRecoveryButtonCancel() {
        goToRecoveryButtonCancelMob.shouldBe(visible).click();
    }

    @Step("Нажимаем крестик")
    public void clickToRecoveryButtonExit() {
        goToRecoveryButtonExitMob.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку войти")
    public void clickLogin() {
        loginButtonMob.shouldBe(visible).click();
    }

}


