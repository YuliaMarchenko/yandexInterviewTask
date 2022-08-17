package com.telran.testTask.fw;
import com.telran.testTask.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{

    EventFiringWebDriver wd;
    MarketHelper marketHelper;

    public MarketHelper getMarket(){
        return marketHelper;
    }

    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        marketHelper = new MarketHelper(wd);
        wd.register(new MyListener(wd));
    }

    public void stop(){
        wd.quit();
    }
}
