package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Given("open url h&m {string}")
    public void open_url_h_m(String url) {
        wd.get(url);
        // wd.manage().window().setSize(new Dimension(1256,744));
        wd.manage().window().maximize();
    }

    @When("website is open accept all cookie")
    public void website_is_open_accept_all_cookie() {
        homePage.acceptAllCookies();
    }
    @Then("start search {string}")
    public void start_search(String searchParam) {
        homePage.searchStaff("dress");
    }
    @Then("click on first image")
    public void click_on_first_image() {
        wd.findElement(By.className("image-container")).click(); // нажать на 1 изображение
    }
    @Then("choose size")
    public void choose_size() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));// таймаут 30 сек
        /*wd.findElements(By.className("item")).get(3).click();// нажать на поле размера, выбрать s
         */

        wd.findElement(By.className("picker-trigger")).click(); // нажать на размеры
        WebDriverWait wait2 = new WebDriverWait(wd, Duration.ofSeconds(30));// таймаут 30 сек

        wd.findElement(By.xpath("//*[@id=\"picker-1\"]/ul/li[2]/div/button")).click(); // нажать на размеры
    }

    @Then("click add button")
    public void click_add_button() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));// таймаут 30 сек
        //wd.findElement(By.className("button-buy")).click(); // нажать кнопку добавить
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div[1]/div[1]/div/div[4]/div[1]/button"))).click(); // нажать кнопку добавить
    }
}
