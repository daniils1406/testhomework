package homework.testbase;

import homework.ApplicationManager;
import homework.helpers.LoginHelper;
import homework.helpers.LogoutHelper;
import homework.helpers.NavigationHelper;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TestBase {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    protected ApplicationManager applicationManager;

    protected LoginHelper loginHelper;

    protected NavigationHelper navigationHelper;

    protected LogoutHelper logoutHelper;

    public TestBase() {
        this.applicationManager = ApplicationManager.getInstance();
        this.loginHelper = applicationManager.getLoginHelper();
        this.navigationHelper = applicationManager.getNavigationHelper();
        this.logoutHelper = applicationManager.getLogoutHelper();
    }

    @Before
    public void setUp() {
        driver = applicationManager.getDriver();
        js = (JavascriptExecutor) applicationManager.getDriver();
        vars = applicationManager.getVars();
    }


    public static class AccountData {
        private String mail;
        private String password;

        public AccountData(String mail, String password) {
            this.mail = mail;
            this.password = password;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMail() {
            return mail;
        }

        public String getPassword() {
            return password;
        }
    }
}
