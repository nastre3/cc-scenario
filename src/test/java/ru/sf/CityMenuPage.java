package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityMenuPage {
    private final WebDriver wd;
    private final static String ACTIVE_CITY_SPAN_XPATH = "header__about-slogan-text_link";

    public CityMenuPage(WebDriver wd) {
        this.wd = wd;
    }

    public String getCurrentActiveCity() {
        return wd.findElement(By.className(ACTIVE_CITY_SPAN_XPATH)).getText();
    }
}
