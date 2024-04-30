package homework.helpers;

import homework.ApplicationManager;
import homework.testbase.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationHelper extends HelperBase {

    private String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openMainPage() {
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

    public void setPageSize() {
        driver.manage().window().setSize(new Dimension(945, 1020));
    }

    public void openLoginPage() {
        driver.get(baseUrl + "/login");
    }

    public void openHomePage() {
        driver.get(baseUrl + "/");
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
