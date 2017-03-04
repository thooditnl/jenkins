package com.testing.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by THOODI on 2/16/2017.
 */




public class Firefox_Browser {
    WebDriver driver = null;
    @BeforeMethod
    public void setUp(String URL, String browserName ) throws MalformedURLException {

        switch (browserName) {
            case "Firefox":
                //Note: Use firefox version 45.0. Please Don't upgrade to latest version. (webdriver.gecko.driver, webdriver.firefox.marionette)
                //	System.setProperty("webdriver.gecko.driver", filePathLoader("geckodriver.exe"));
                this.driver = new FirefoxDriver();
                String remoteHost = System.getProperty("remoteHost");
                remoteHost = "http://localhost:8080/";
                break;
            /*case "chrome":
                System.setProperty("webdriver.chrome.driver", filePathLoader("chromedriver.exe"));
                this.driver = new ChromeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", filePathLoader("IEDriverServer.exe"));
                this.driver = new InternetExplorerDriver();
            case "htmlunitdriver":
                this.driver = new HtmlUnitDriver(true);
                break;
            case "edgedriver":
                System.setProperty("webdriver.edge.driver", filePathLoader("MicrosoftWebDriver.exe"));
                DesiredCapabilities capabilities = DesiredCapabilities.edge();
                driver = new EdgeDriver(capabilities);
                this.driver = new EdgeDriver();
                break;*/
            default:
                System.out.println("browser : " + browserName + " is invalid");
                driver = new FirefoxDriver();
        }
        System.out.println("The browser launched is  ************* " + browserName + " ********************");
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/");
        driver.manage().timeouts().implicitlyWait(90000,TimeUnit.MILLISECONDS);
    }



    @Test
    public void test()  {
     /*   WebDriver driver =  null;

        String remoteHost = System.getProperty("remoteHost");
        if (remoteHost == null)
        {
            remoteHost = "http://localhost:8080/";
        }

      String   browserName = System.getProperty("browserName");
        if (browserName == null) browserName = "Firefox";*/




        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/" + "/");
        WebElement element= driver.findElement(By.name("q"));
        CharSequence cs1 =  "Cheese";
        element.sendKeys(cs1);
        element.submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
