import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsPageTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void checkJunitCodeOnSelenidePageTest() {
        open("/selenide/selenide");
        $("[data-tab-item='i5wiki-tab']").click();
        $(".markdown-body").shouldHave(text("Welcome to the selenide wiki!"));
        $x("//button[contains(text(),'Show 2 more pages…')]").click();
        $("[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5"));
    }
}

/**
 * - Откройте страницу Selenide в Github
 * <p>
 * - Перейдите в раздел Wiki проекта
 * <p>
 * - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
 * <p>
 * - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
 */