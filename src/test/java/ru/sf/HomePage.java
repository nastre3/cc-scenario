package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver wd;

    public HomePage(WebDriver wd) {
        this.wd = wd;
    }

    public void acceptAllCookies() {
        wd.findElement(By.id("onetrust-accept-btn-handler")).click(); // нажать на кнопку принятия кукис
    }

    public void searchStaff(String name) {
        WebElement searchField = wd.findElement(By.id("main-search"));// заполнить форму поиска
        searchField.sendKeys(name);
        searchField.submit();
    }
}
