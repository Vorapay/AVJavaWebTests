package core.base;

import com.codeborne.selenide.SelenideElement;
import core.pages.SearchGroups;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    public SearchGroups search(String query) {
        searchField.shouldBe(visible).setValue(query);
        SelenideElement searchGroup = $x(String.format("//a[contains(@class, 'toolbar_search_suggest-item') and contains(text(), '%s')]", query));
        searchGroup.scrollTo().click();
        return new SearchGroups();
    }

    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
}
