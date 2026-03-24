package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[id='field_email']");
    private SelenideElement passwordField = $("[id='field_password']");
    private SelenideElement loginButton = $("[label='Войти']");
    private SelenideElement forgotPasswordLink = $("[aria-label='Не получается войти?']");
    private SelenideElement registrationButton = $x("//button[contains(@class, 'vkuiButton') and @type='submit']");
    private SelenideElement vkButton = $("[class='i ic social-icon __s __vk_id']");
    private SelenideElement mailRuButton = $("[class='i ic social-icon __s __mailru']");
    private SelenideElement yandexButton = $("[class='i ic social-icon __s __yandex']");
    private SelenideElement errorMessage = $x("//span[contains(@class, 'LoginForm-module__error')]");
    private SelenideElement goToRecoveryButton = $x("//span[@class='vkuiButton__content' and text()='Восстановить']");
    private SelenideElement loginQrCodeButton = $("[role='presentation']");
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
        loginQrCodeButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Вводим только логин: {username}")
    public void onlyUsername(String username) {
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Вводим только пароль: {password}")
    public void onlyPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
       // loginButton.shouldBe(visible).click();
    }


    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переход на страницу регистрации")
    private void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    private void loginWithVk() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    private void loginMailru() {
        mailRuButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    private void loginYandex() {
        yandexButton.shouldBe(visible).click();
    }

    @Step("Нажимаем Восстановить профиль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Переход на страницу с QR кодом")
    public void openQrCode() {
        loginQrCodeButton.shouldBe(visible).click();
    }
}


