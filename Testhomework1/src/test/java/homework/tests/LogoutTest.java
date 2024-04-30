package homework.tests;

import homework.testbase.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static java.lang.Thread.sleep;

public class LogoutTest extends TestBase {

    @Test
    public void logout() throws InterruptedException {
        navigationHelper.openLoginPage();
        navigationHelper.setPageSize();
        loginHelper.inputMailAndPasswordAndLogin(new AccountData("daniils1406@mail.ru", "Landrover2013"));
        driver.manage().window().setSize(new Dimension(945, 1020));
        sleep(5000);
        driver.findElement(By.cssSelector(".quick-menu > .habitica-menu-dropdown:nth-child(3) path")).click();
        driver.findElement(By.linkText("Выйти")).click();
    }
}
