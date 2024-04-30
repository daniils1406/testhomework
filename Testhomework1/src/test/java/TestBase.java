
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class TestBase {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public class AccountData {
        private String mail;
        private String password;

        public AccountData(String mail, String password) {
            this.mail = mail;
            this.password = password;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMail() {
            return mail;
        }

        public String getPassword() {
            return password;
        }
    }

    protected void openMainPage() {
        {
            WebElement element = driver.findElement(By.cssSelector(".btn-info"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
    }

    protected void inputMailAndPasswordAndLogin(AutoTestsOne.AccountData user) {
        driver.findElement(By.id("usernameInput")).sendKeys(user.getMail());
        driver.findElement(By.id("passwordInput")).sendKeys(user.getPassword());
        driver.findElement(By.id("usernameInput")).click();
        driver.findElement(By.id("passwordInput")).click();
        driver.findElement(By.cssSelector(".btn-info")).click();
    }

    protected void setPageSize() {
        driver.manage().window().setSize(new Dimension(945, 1020));
    }

    protected void openHomePage() {
        driver.get("https://habitica.com/login");
    }
}
