// Generated by Selenium IDE

import org.junit.Test;

public class AutoTestsOne extends TestBase {


    @Test
    public void userLogin() {
        openHomePage();
        setPageSize();
        inputMailAndPasswordAndLogin(new AccountData("daniils1406@mail.ru", "Landrover2013"));
        openMainPage();
    }
}
