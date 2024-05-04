package homework.tests;

import homework.generator.model.HabiticaUser;
import homework.testbase.TestBase;
import org.junit.Test;

import static java.lang.Thread.sleep;

public class LogoutTest extends TestBase {

    @Test
    public void logout() throws InterruptedException {
        navigationHelper.openLoginPage();
        navigationHelper.setPageSize();
        loginHelper.inputMailAndPasswordAndLogin(new HabiticaUser("daniils1406@mail.ru", "Landrover2013"));
        sleep(5000);
        logoutHelper.logout();
    }
}
