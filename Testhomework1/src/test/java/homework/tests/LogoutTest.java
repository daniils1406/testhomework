package homework.tests;

import homework.testbase.TestBase;
import org.junit.Test;

public class LogoutTest extends TestBase {

    @Test
    public void logout() throws InterruptedException {
        navigationHelper.openLoginPage();
        navigationHelper.setPageSize();
        loginHelper.inputMailAndPasswordAndLogin(new AccountData("daniils1406@mail.ru", "Landrover2013"));
        logoutHelper.logout();
    }
}
