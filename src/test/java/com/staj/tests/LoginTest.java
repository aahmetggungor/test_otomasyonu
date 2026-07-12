package com.staj.tests;

import com.staj.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI; // Yeni eklendi

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        
        // UYARI ÇÖZÜMÜ: new URL() yerine URI.create().toURL() kullanıyoruz
        driver = new RemoteWebDriver(URI.create("http://localhost:4444").toURL(), options);
        
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        System.out.println("Test Docker içinde başladı!");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        System.out.println("Giriş yapıldı, 15 saniye bekliyor...");
    }

    @AfterMethod
    public void tearDown() {
        // Canlı izleyebilmen için kapanmadan önce 15 saniye (15000 milisaniye) bekletiyoruz
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if (driver != null) {
            driver.quit();
            System.out.println("Tarayıcı kapatıldı.");
        }
    }
}