package homework.tests;

import homework.testbase.AuthBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeleteTaskTest extends AuthBase {

    @Test
    public void deleteTask() throws InterruptedException {
        sleep(5000);
        delete();
    }

    private void delete() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(945, 1020));
        driver.findElement(By.cssSelector(".tasks-column:nth-child(1) .task-wrapper:nth-child(1) p:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".delete-text")).click();
        assertThat(driver.switchTo().alert().getText(), is("Вы уверены, что хотите удалить привычку?"));
        driver.switchTo().alert().accept();
    }
}
