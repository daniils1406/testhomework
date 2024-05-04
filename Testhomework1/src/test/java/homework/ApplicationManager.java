package homework;

import homework.helpers.LoginHelper;
import homework.helpers.LogoutHelper;
import homework.helpers.NavigationHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;

    private LogoutHelper logoutHelper;

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager applicationManager = new ApplicationManager();
            app.set(applicationManager);
        }
        return app.get();
    }

    private ApplicationManager() {
        this.driver = new ChromeDriver();
        this.js = (JavascriptExecutor) driver;
        this.vars = new HashMap<>();
        this.loginHelper = new LoginHelper(this);
        this.navigationHelper = new NavigationHelper(this, "https://habitica.com");
        this.logoutHelper = new LogoutHelper(this);
    }

    @Override
    protected void finalize() throws Throwable {
        driver.quit();
        super.finalize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Map<String, Object> getVars() {
        return vars;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }


    public LogoutHelper getLogoutHelper() {
        return logoutHelper;
    }
}
