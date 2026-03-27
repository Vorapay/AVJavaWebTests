package core.base;

import com.codeborne.selenide.SelenideElement;
import core.pages.web.SearchGroupsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MobBasePage {
    protected SelenideElement headerLogoMob = $("[class='ticLgo tics portal-logo_img']");
    protected SelenideElement searchButtonMob = $("[class='base-button_target']");
    protected SelenideElement searchFieldMob = $("[placeholder='Искать на сайте']");
    protected SelenideElement vkServicesMob = $("[class='sidebar-menu-icon toolbar_actions-i_inner']");

    public SearchGroupsPage mobSearch(String query) {
        searchButtonMob.shouldBe(visible).click();
        searchFieldMob.shouldBe(visible).setValue(query);
        SelenideElement searchGroupHighGrounde = $x("//a[@class='clickarea']");
        searchGroupHighGrounde.click();
        SelenideElement searchGroup = $x(String.format("//div[contains(@class, 'content-card_data_text_wrapper') and contains(text(), '%s')]", query));
        searchGroup.scrollTo().click();
        return new SearchGroupsPage();
    }

    public void openVkServices() {
        vkServicesMob.shouldBe(visible).click();
    }

    public void clickLogo() {
        headerLogoMob.shouldBe(visible).click();
    }
}

