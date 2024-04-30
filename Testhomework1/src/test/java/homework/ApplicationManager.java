package homework;

import homework.helpers.LoginHelper;
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


    public ApplicationManager() {
        this.driver = new ChromeDriver();
        this.js = (JavascriptExecutor) driver;
        this.vars = new HashMap<String, Object>();
        this.loginHelper = new LoginHelper(this);
        this.navigationHelper = new NavigationHelper(this,"https://habitica.com");
    }

    public void quit(){
        driver.quit();
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


}
