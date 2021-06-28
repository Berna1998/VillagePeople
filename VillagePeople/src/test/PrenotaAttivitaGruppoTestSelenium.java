package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class PrenotaAttivitaGruppoTestSelenium {

  String codiceId = "33003";
  String password = "client";
	
  @Test
  public void prenotaAttivitaGruppo() {
	 System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.get("http://localhost:8083/VillagePeople/Login.jsp");
    
    driver.findElement(By.xpath("//*[@id=\"codiceID\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"codiceID\"]")).sendKeys(codiceId);
    driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
    driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div/input[3]")).click();

    
    driver.findElement(By.xpath("/html/body/ul/li[3]/a")).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/input")).click();
    
    String categoria = "//*[@id=\"categorie\"]";

    driver.findElement(By.xpath(categoria)).click();

    
    WebElement dropdown = driver.findElement(By.xpath(categoria));
    dropdown.findElement(By.xpath("//option[. = 'Sport']")).click();
    

    driver.findElement(By.xpath(categoria)).click();
    
    String giorno = "//*[@id=\"giorno\"]";

    driver.findElement(By.xpath(giorno)).click();

    
    dropdown = driver.findElement(By.xpath(giorno));
    dropdown.findElement(By.xpath("//option[. = 'Giovedi']")).click();
    

    driver.findElement(By.xpath(giorno)).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/input[1]")).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/table/tbody/tr[3]/td[1]/input")).click();


    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/input[3]")).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/input[1]")).click();

    String prenotati = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/table/tbody/tr[3]/td[6]/strong")).getText();

    driver.close(); 
    assertEquals(prenotati, "1");
 
  }
}
