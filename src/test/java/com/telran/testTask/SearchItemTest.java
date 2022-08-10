package com.telran.testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
Проект должен быть оформлен
Предусмотреть параметризацию тестовых данных
Использовать браузер ChromeDriver
Результатом выполнения должен быть Log
Исходный код проекта должен быть выложен на github.*/

public class SearchItemTest {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchItemTest() {
        wd.findElement(By.cssSelector("[data-id='market']")).click();
        switchToNextTab(1);
        wd.findElement(By.xpath("//a[contains(.,'Экспресс')]")).click();
        wd.findElement(By.xpath("//a[contains(.,'Электроника')]")).click();
        wd.findElement(By.xpath("//a[contains(.,'Смартфоны и аксессуары')]")).click();
    }

    public void switchToNextTab(int number) {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(number));
        }
    }

    @AfterMethod
    public void stopTest(){
        wd.quit();
    }
}
