package homework.helpers;

import homework.ApplicationManager;
import homework.generator.model.HabiticaUser;
import homework.testbase.HelperBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    private static ThreadLocal<String> loggedUser = ThreadLocal.withInitial(() -> "");

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void inputMailAndPasswordAndLogin(HabiticaUser user) throws InterruptedException {
        if (!isLoggedIn()) {
            login(user);
        } else {
            if (!isLoggedIn(user.getUserName())) {
                applicationManager.getLogoutHelper().logout();
                login(user);
            }
        }
    }

    public void cleanContext() {
        loggedUser.set("");
    }

    private void login(HabiticaUser user) {
        driver.findElement(By.id("usernameInput")).sendKeys(user.getUserName());
        driver.findElement(By.id("passwordInput")).sendKeys(user.getPassword());
        driver.findElement(By.id("usernameInput")).click();
        driver.findElement(By.id("passwordInput")).click();
        driver.findElement(By.cssSelector(".btn-info")).click();
        loggedUser.set(user.getUserName());
    }

    private boolean isLoggedIn() {
        return StringUtils.isNotBlank(loggedUser.get());
    }

    private boolean isLoggedIn(String userName) {
        return userName.equals(loggedUser.get());
    }
}
