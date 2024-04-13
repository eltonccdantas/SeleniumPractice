import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {

    @Test
    public void deveInteragirComAlertSimples() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();

        driver.quit();
    }

    @Test
    public void deveInteragirComAlertConfirm() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Confirm Simples", texto);

        alert.accept();

        alert = driver.switchTo().alert();

        String textoConfirm = alert.getText();
        Assert.assertEquals("Confirmado", textoConfirm);

        driver.quit();
    }

    @Test
    public void deveInteragirComAlertCancel() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Confirm Simples", texto);

        alert.dismiss();

        alert = driver.switchTo().alert();

        String textoCancel = alert.getText();
        Assert.assertEquals("Negado", textoCancel);

        driver.quit();
    }

    @Test
    public void deveInteragirComAlertPrompt() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Digite um numero", texto);

        alert.sendKeys("12");
        alert.accept();
        Assert.assertEquals("Era 12?", alert.getText());
        alert.accept();
        Assert.assertEquals(":D", alert.getText());
        alert.accept();

        driver.quit();
    }
}
