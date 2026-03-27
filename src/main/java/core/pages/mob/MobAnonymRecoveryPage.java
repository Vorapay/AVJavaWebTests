package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobAnonymRecoveryPage extends MobBasePage {

    private SelenideElement recoveryByPhoneButtonMob = $x("//div[@class='content-card_data_inner' and text()='Телефон']");
    private SelenideElement recoveryByEmailButtonMob = $("[data-log-click*='email']");
    private SelenideElement goToSupportButtonMob = $x("//a[@class='registration_footer_link' and text()='Служба поддержки']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButtonMob.should(exist);
        recoveryByEmailButtonMob.should(exist);
        goToSupportButtonMob.should(exist);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButtonMob.should(exist).click();
    }

    @Step("Нажимаем на кнопку восстановления через Email")
    public void goToRecoveryByEmail() {
        recoveryByEmailButtonMob.should(exist).click();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        goToSupportButtonMob.should(exist).click();
    }
}
