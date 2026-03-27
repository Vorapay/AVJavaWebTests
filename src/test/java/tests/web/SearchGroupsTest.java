package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import core.pages.web.SearchGroupsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchGroupsTest extends BaseTest {
    private static LoginPage loginPage;
    private static SearchGroupsPage searchGroupsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void TestSearchGroup() {
        loginPage.search("Тестировщик");
        searchGroupsPage = new SearchGroupsPage();
        searchGroupsPage.verifyGroupsExistSimple();
    }
}
