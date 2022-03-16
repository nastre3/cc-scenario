package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ChooseCityPage {
    private static final String SEARCH_FILLED_CLASS = "locality-selector-popup__search-input";
    private static final String MESSAGE_CLASS = "locality-selector-popup__table-empty-text";
    private final WebDriver wd;

    public ChooseCityPage(WebDriver wd) {
        this.wd = wd;
    }

    public void go (String url) {
        wd.get(url);
    }

    public void searchCity(String city) {
        final var searchInput = wd.findElement(By.className(SEARCH_FILLED_CLASS));
        searchInput.sendKeys(city, Keys.ENTER); // заполнение города и нажатие Enter
    }

    public String getCityNotFoundMessage() {
        return wd.findElement(By.className(MESSAGE_CLASS)).getText();
    }
}
