package homework.testbase;

import homework.ApplicationManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class HelperBase {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    protected ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
        this.vars = applicationManager.getVars();
        this.js = applicationManager.getJs();
    }
}
