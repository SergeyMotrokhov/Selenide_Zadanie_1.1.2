package selenide.PO;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexPageSearch {

    public YandexPageResult search(String query){
        $(By.xpath("//input[@id='text']")).setValue(query).pressEnter();
        return page(YandexPageResult.class);
    }
}
