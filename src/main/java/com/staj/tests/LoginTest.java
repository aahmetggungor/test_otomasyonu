package com.staj.tests;

import com.staj.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Yeni ekle
import org.openqa.selenium.remote.RemoteWebDriver; // Yeni ekle
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL; // Yeni ekle

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Docker konteynerine bağlanma ayarı
        ChromeOptions options = new ChromeOptions();
        // Artık Docker'daki adrese bağlanıyoruz
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        // ... (Assertion kısımları aynı kalabilir)
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}