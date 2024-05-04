package homework.helpers;

import homework.ApplicationManager;
import homework.testbase.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static java.lang.Thread.sleep;

public class LogoutHelper extends HelperBase {


    public LogoutHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void logout() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(945, 1020));
        sleep(5000);
        driver.findElement(By.cssSelector(".quick-menu > .habitica-menu-dropdown:nth-child(3) path")).click();
        driver.findElement(By.linkText("Выйти")).click();
        applicationManager.getLoginHelper().cleanContext();
    }
}
