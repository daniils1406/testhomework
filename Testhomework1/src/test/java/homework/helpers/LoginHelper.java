package homework.helpers;

import homework.ApplicationManager;
import homework.testbase.HelperBase;
import homework.tests.AutoTestsOneTest;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void inputMailAndPasswordAndLogin(AutoTestsOneTest.AccountData user) {
        driver.findElement(By.id("usernameInput")).sendKeys(user.getMail());
        driver.findElement(By.id("passwordInput")).sendKeys(user.getPassword());
        driver.findElement(By.id("usernameInput")).click();
        driver.findElement(By.id("passwordInput")).click();
        driver.findElement(By.cssSelector(".btn-info")).click();
    }
}
