package selenide.PO;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class YandexPageResult{
    private ElementsCollection listOfElements =$$(By.xpath("//*[@id='search-result']//a"));

    public ElementsCollection searchList(){
        return listOfElements;
    }
}
