package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitions { // содержит шаги для тестовых сценариев
    /* для проверки пятница ли сегодня?
    private String today;
    private String actualAnswer;

    @Given("today is {string}")
    public void today_is(String today) {
        // Write code here that turns the phrase above into concrete actions
        this.today = today;
    }
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        this.actualAnswer = WeekAnalyzer.isItFridayToday(today);
    }
    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("No", actualAnswer); // 1 - ОР, 2 - ФР
    }

    В scenario.feature:
    /* Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given today is 'Friday'
    When I ask whether it's Friday yet
    Then I should be told 'Nope'
     */

    private static final WebDriver wd;
    static { // конструктор
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        wd = new ChromeDriver();
    }

    @Given("open url h&m {string}")
    public void open_url_h_m(String url) {
        wd.get(url);
        wd.manage().window().maximize();
    }

    @When("website is open accept all cookie")
    public void website_is_open_accept_all_cookie() {
        wd.findElement(By.id("onetrust-accept-btn-handler")).click(); // нажать на кнопку принятия кукис
    }
    @Then("start search {string}")
    public void start_search(String searchParam) {
        WebElement searchField = wd.findElement(By.id("main-search"));// заполнить форму поиска
        searchField.sendKeys(searchParam);
        searchField.submit();
    }
    @Then("click on first image")
    public void click_on_first_image() {
        wd.findElement(By.className("image-container")).click(); // нажать на 1 изображение
    }
    @Then("choose size")
    public void choose_size() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));// таймаут 30 сек
        wd.findElement(By.className("trigger-button")).click();// нажать на поле размера, выбрать s
        wait.until(ExpectedConditions.elementToBeClickable(By.className("option")))
                .findElements(By.className("option")).get(1).click();// нажать на поле размера, выбрать s
    }
    @Then("click add button")
    public void click_add_button() {
        wd.findElement(By.className("button-buy")).click(); // нажать кнопку добавить
    }
}
