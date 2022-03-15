package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitions { // содержит шаги для тестовых сценариев

    private static final WebDriver wd;
    private static final HomePage homePage;
    static { // конструктор
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        wd = new ChromeDriver();
        homePage = new HomePage(wd);
    }

    @Given("open url of dodo pizza {string}")
    public void open_url_of_dodo_pizza(String url) {
        wd.get(url);
    }
    @Then("fill input with {string}")
    public void fill_input_with(String city) {
        final var searchInput = wd.findElement(By.className("locality-selector-popup__search-input"));
        searchInput.sendKeys(city, Keys.ENTER); // заполнение города и нажатие Enter
    }
    @Then("assert that choosen city is {string}")
    public void assert_that_choosen_city_is(String expectedCity) {
        //wd.findElement(By.className("header__about-slogan-text"));
        String actualCity = wd.findElement(By.className("header__about-slogan-text_link")).getText();
        assertEquals(expectedCity, actualCity);

    }
}
