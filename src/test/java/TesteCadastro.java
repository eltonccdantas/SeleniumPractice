import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

    WebDriver driver = new FirefoxDriver();

    @Before
    public void inicializa() {
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveValidarNomeObrigatorio() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Nome eh obrigatorio", texto);
    }

    @Test
    public void deveValidarSobrenomeObrigatorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Elton");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Sobrenome eh obrigatorio", texto);
    }

    @Test
    public void deveValidarSexoObrigatorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Elton");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dantas");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Sexo eh obrigatorio", texto);
    }

    @Test
    public void deveValidarComidaFavorita() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Elton");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dantas");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", texto);
    }

    @Test
    public void deveValidarEsporte() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Elton");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dantas");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Voce faz esporte ou nao?", texto);
    }
}
