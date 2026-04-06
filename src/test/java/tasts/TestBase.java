package tasts;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.CheckFormPages;
import pages.components.SubmitRegComponent;
import tasts.testdata.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    CheckFormPages checkFormPages = new CheckFormPages();
    SubmitRegComponent submitRegComponent = new SubmitRegComponent();
    TestData dto = new TestData();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";

    }

    @AfterEach()
    void closeBrowser() {
        closeWebDriver();
    }

}
