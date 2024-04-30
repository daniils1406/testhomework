package homework.testbase;

import homework.ApplicationManager;
import homework.helpers.LoginHelper;
import homework.helpers.NavigationHelper;
import org.junit.Before;
import org.junit.After;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class TestBase {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    protected ApplicationManager applicationManager;

    protected LoginHelper loginHelper;

    protected NavigationHelper navigationHelper;

    public TestBase() {
        this.applicationManager = new ApplicationManager();
        this.loginHelper = applicationManager.getLoginHelper();
        this.navigationHelper = applicationManager.getNavigationHelper();
    }

    @Before
    public void setUp() {
        driver = applicationManager.getDriver();
        js = (JavascriptExecutor) applicationManager.getDriver();
        vars = applicationManager.getVars();
    }

    @After
    public void tearDown() {
        applicationManager.quit();
    }

    public class AccountData {
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
