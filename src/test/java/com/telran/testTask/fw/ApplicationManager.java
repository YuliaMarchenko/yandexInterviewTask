package com.telran.testTask.fw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager{

    WebDriver wd;
    MarketHelper marketHelper;

    public MarketHelper getMarket(){
        return marketHelper;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        marketHelper = new MarketHelper(wd);
    }

    public void stop(){
        wd.quit();
    }
}
