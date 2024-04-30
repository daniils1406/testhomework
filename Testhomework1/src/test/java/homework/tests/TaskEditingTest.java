package homework.tests;

import homework.testbase.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class TaskEditingTest extends TestBase {

    @Test
    public void editExistenceTask() throws InterruptedException {
        navigationHelper.openLoginPage();
        navigationHelper.setPageSize();
        loginHelper.inputMailAndPasswordAndLogin(new AccountData("daniils1406@mail.ru", "Landrover2013"));
        navigationHelper.openMainPage();
        editTask();
        logoutHelper.logout();
    }

    private void editTask() throws InterruptedException {
        navigationHelper.openHomePage();
        driver.manage().window().setSize(new Dimension(945, 1020));
        sleep(1000);
        driver.findElement(By.cssSelector(".tasks-column:nth-child(1) .task-wrapper:nth-child(1) .task-clickable-area > .d-flex")).click();
        driver.findElement(By.cssSelector(".input-title")).sendKeys("editedTestNameWithNumber");
        driver.findElement(By.cssSelector(".m-auto")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".m-auto"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
    }
}
