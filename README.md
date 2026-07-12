# 🚀 Web UI Test Otomasyonu (Java Selenium & Docker)

Bu proje, kurumsal test otomasyonu standartlarına uygun olarak **Page Object Model (POM)** tasarım deseni ile geliştirilmiş örnek bir UI test altyapısıdır. 

Testler, otomasyon pratikleri için hazırlanmış [SauceDemo](https://www.saucedemo.com/) e-ticaret sitesi üzerinde koşulmakta olup, **TestNG** framework'ü ile senaryolaştırılmış ve **Docker** üzerinde izole (Grid) ortamda çalışacak şekilde yapılandırılmıştır.

## 🛠️ Kullanılan Teknolojiler

* **Dil:** Java 17
* **Web Otomasyon:** Selenium WebDriver (v4.21.0)
* **Test Framework:** TestNG (v7.10.1)
* **Proje Yönetimi:** Maven
* **İzole Ortam (CI/CD Hazırlığı):** Docker (Selenium Standalone Chrome)
* **Tasarım Deseni:** Page Object Model (POM)

## 📁 Proje Hiyerarşisi

Kodlar, sayfa elementleri ile test senaryolarının birbirinden ayrıldığı POM mimarisine göre organize edilmiştir:

```text
src/main/java/com/staj/
├── pages/                  # Web sayfalarının haritası ve aksiyon metotları
│   └── LoginPage.java      # (Örn: Locators, click, sendKeys işlemleri)
└── tests/                  # TestNG senaryoları ve doğrulamalar (Assertions)
    └── LoginTest.java      # (Örn: Başarılı/Başarısız giriş testleri)
