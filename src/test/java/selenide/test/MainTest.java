package selenide.test;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import selenide.PO.YandexPageResult;
import selenide.PO.YandexPageSearch;

import static com.codeborne.selenide.Selenide.open;

public class MainTest {
    @BeforeEach
    public void option(){
        Configuration.timeout = 20000;
        Configuration.browser="chrome";
        Configuration.startMaximized=true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

@Test
    public void firstTest(){
    YandexPageSearch yandexPageSearch = open("https://yandex.ru/", YandexPageSearch.class);
    YandexPageResult yandexPageResult = yandexPageSearch.search("Гладиолус");
    Boolean chek = false;
    for (WebElement we : yandexPageResult.searchList())
        if(we.getAttribute("href").equals("https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA"))
            chek=true;
    Assertions.assertTrue(chek);
    }
}
