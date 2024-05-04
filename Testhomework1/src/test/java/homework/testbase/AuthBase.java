package homework.testbase;

import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;

public class AuthBase extends TestBase {

    @Override
    @Before
    public void setUp() {
        driver = applicationManager.getDriver();
        js = (JavascriptExecutor) applicationManager.getDriver();
        vars = applicationManager.getVars();
        try {
            applicationManager.getNavigationHelper().loginAndOpenHomePage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
