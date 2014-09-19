package com.epam.jjp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class SiteTest {
    private static final String CHROME_DRIVER_PATH = "D:/WebServers/chromedriver.exe";
    private static final String IE_DRIVER_PATH = "D:/WebServers/IEDriverServer.exe";

    private static final String PAGINATION_URL = "http://localhost:8080/sales/pages/";
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
//      File file = new File(IE_DRIVER_PATH);
//      System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//      driver = new InternetExplorerDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("^a User is logged in with \"([^\"]*)\" and password of \"([^\"]*)\" on the page \"([^\"]*)\"$")
    public void a_User_is_logged_in_with_and_password_of_on_the_page(String username, String password, String page) throws Throwable {
        driver.get(page);
        driver.findElement(By.id("user")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @Given("^User is on the \"([^\"]*)\" page$")
    public void User_is_on_the_page(String url) throws Throwable {
        driver.get(url);
    }

    @Given("^User fills in the form:$")
    public void User_fills_in_the_form(List<List<String>> dataTable) throws Throwable {
        for (List<String> table : dataTable) {
            driver.findElement(By.id(table.get(0))).sendKeys(table.get(1));
        }
        
        //Click on textbox so that datepicker will come  
        driver.findElement(By.id("datepicker")).click();  
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
        //Click on next so that we will be in next month  
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();  
          
        /*DatePicker is a table.So navigate to each cell   
         * If a particular cell matches value 13 then select it  
         */  
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));  
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
          
        for (WebElement cell: columns){  
             //Select 13th Date   
             if (cell.getText().equals("13")){  
                 cell.findElement(By.linkText("13")).click();  
                 break;  
             }   
        }
    }

    @When("^User click on the submit button$")
    public void User_click_on_the_submit_button() throws Throwable {
        driver.findElement(By.name("submit")).click();
    }

    @Then("^the User should receive a Save successfull. message$")
    public void the_User_should_receive_a_Save_successfull_message() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return (input.findElements(By.className("bg-success")).size() > 0);
            }
        };
        Assert.assertNotNull(wait.until(conditionToCheck));
    }

    @Given("^a User is on the \"([^\"]*)\" page$")
    public void a_User_is_on_the_page(String arg1) throws Throwable {
        driver.get(arg1);
    }

    @When("^a User enters the username \"([^\"]*)\"$")
    public void a_User_enters_the_username(String arg1) throws Throwable {
        driver.findElement(By.id("user")).sendKeys(arg1);
    }

    @And("^password of \"([^\"]*)\"$")
    public void password_of(String arg1) throws Throwable {
        driver.findElement(By.id("password")).sendKeys(arg1);
    }

    @And("^a User click on the submit button$")
    public void a_User_click_on_the_submit_button() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^the user should be redirected to the \"([^\"]*)\"$")
    public void the_user_should_be_redirected_to_the(String arg1) throws Throwable {
        Assert.assertEquals(driver.getCurrentUrl(), arg1);
    }

    @When("^User clicks on a buy button$")
    public void User_clicks_on_a_buy_button() throws Throwable {
        List<WebElement> buyButtons = driver.findElements(By.cssSelector("button[id^=\"buy_\"]"));
        int paginationPage = 1;
        while (buyButtons.size() == 0 && paginationPage <=100) {
            driver.get(PAGINATION_URL + (++paginationPage));
            buyButtons = driver.findElements(By.cssSelector("button[id^=\"buy_\"]"));
        }
        buyButtons.get(0).click();
    }

    @Then("^the User should get an alert window with successful purchase$")
    public void the_User_should_get_an_alert_window_with_successful_purchase() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 300 /*timeout in seconds*/);
        Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
    }
}
