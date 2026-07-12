package com.staj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // 1. Locators (Elementlerin adresleri)
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // 2. Constructor (Testten gelen tarayıcıyı buraya bağlar)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions (Sayfada yapılacak eylemler)
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}