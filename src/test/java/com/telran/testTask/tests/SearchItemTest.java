package com.telran.testTask.tests;

import com.telran.testTask.models.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

/* Автоматизировать следующий сценарий
1. Открыть браузер и развернуть на весь экран
2. Зайти на yandex.ru
3. Перейти на Яндекс Маркет
4. Выбрать раздел Экспресс
5. Выбрать раздел Электроника
6. Выбрать раздел Смартфоны
7. Зайти в расширенный поиск
8. Задать параметр поиска от 20000 до 35000 рублей.
9. Выбрать производителя “Apple”
10. Применить условия поиска
11. Запомнить второй элемент в результатах поиска
12. В поисковую строку ввести запомненное значение.
13. Найти и проверить, что наименование товара соответствует запомненному значению.

Условия:
1. Проект должен быть оформлен
2. Предусмотреть параметризацию тестовых данных
3. Использовать браузер ChromeDriver
4. Результатом выполнения должен быть Log
5. Исходный код проекта должен быть выложен на github.*/

public class SearchItemTest extends TestBase {

    @Test
    public void searchItemTest() throws InterruptedException {
        app.getMarket().selectMarket();
        app.getMarket().switchToNextTab(1);
        app.getMarket().acceptCookies();
        app.getMarket().selectDepartment("Экспресс");
        app.getMarket().selectCatalog("Электроника");
        app.getMarket().selectCategoryType("Смартфоны и аксессуары");
        app.getMarket().filterItem(new Item().setPriceFrom("20000").setPriceTo("35000").setBrand("Apple"));
        app.getMarket().pause(10000);
        String itemName = app.getMarket().getItemName(3);
        app.getMarket().typeAndSearchInputField(itemName);
        app.getMarket().pause(10000);
        String foundItemName = app.getMarket().getItemName(2);
        Assert.assertEquals(foundItemName, itemName);
    }

}
