package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


/*
Задание 1
1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
Если может - приведите пример, когда.
Разница есть: $("h1 div") ищет первый элемент h1 с div, $("h1").$("div") ищет первый h1 и первый div в нем.
Поиск может найти разные элементы, так как у элемента h1 может не быть вложенного элемента div.
*/


public class SearchSoftAssertions {

    @Test
    void shouldFindJUnit5() {
        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейти в раздел Wiki проекта
        $(byText("Wiki")).click();
        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        //Открыть страницу SoftAssertions
        $(".filterable-active").shouldHave(Condition.text("SoftAssertions")).click();
        //Проверить что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }

    //3. Запрограммируйте Drag&Drop с помощью Selenide.actions()

    @Test
    void moveDragAndDrop() {

        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //- Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        //- Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
        sleep(3000);
    }
}

