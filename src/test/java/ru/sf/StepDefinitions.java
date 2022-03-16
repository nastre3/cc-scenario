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
    private static final ChooseCityPage chooseCityPage;
    private static final CityMenuPage cityMenuPage;
    private static final HomePage homePage;
    static { // конструктор
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        wd = new ChromeDriver();
        homePage = new HomePage(wd);
        chooseCityPage = new ChooseCityPage(wd);
        cityMenuPage = new CityMenuPage(wd);
    }

    @Given("open url of dodo pizza {string}")
    public void open_url_of_dodo_pizza(String url) {
        chooseCityPage.go(url);
    }

    @Then("fill input with {string}")
    public void fill_input_with(String city) {
        chooseCityPage.searchCity(city);
    }

    @Then("assert that chosen city is {string}")
    public void assert_that_choosen_city_is(String expectedCity) {
        //wd.findElement(By.className("header__about-slogan-text"));
        final var currentActiveCity = cityMenuPage.getCurrentActiveCity();
        assertEquals(expectedCity, currentActiveCity);
    }

    @Then("assert that user get message {string}")
    public void assert_that_user_get_message(String errorMessage) {
        String actualMessage = chooseCityPage.getCityNotFoundMessage();
        assertEquals(errorMessage, actualMessage);
    }
}
