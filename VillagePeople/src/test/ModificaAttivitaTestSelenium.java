package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class ModificaAttivitaTestSelenium {

  String codiceId = "10011";
  String password = "admin";
  String orario = "16:00";
  String prezzo = "10.0";
  String categoria = "//*[@id=\"cateogorie\"]";
  String giorno = "//*[@id=\"giorno\"]";
  
  @Test
  public void modificaAttivita() {

	System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

	driver.manage().window().setSize(new Dimension(1552, 840));
	driver.get("http://localhost:8083/VillagePeople/Login.jsp");
		    
	driver.findElement(By.xpath("//*[@id=\"codiceID\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"codiceID\"]")).sendKeys(codiceId);
    driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
    driver.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div/input[3]")).click();

    driver.findElement(By.xpath("/html/body/form/ul/li[3]/a")).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/input")).click();

    driver.findElement(By.xpath(categoria)).click();
    
    WebElement dropdown = driver.findElement(By.xpath(categoria));
    dropdown.findElement(By.xpath("//option[. = 'Sport']")).click();
    
   
    driver.findElement(By.xpath(categoria)).click();

    driver.findElement(By.xpath(giorno)).click();
    
    dropdown = driver.findElement(By.xpath(giorno));
    dropdown.findElement(By.xpath("//option[. = 'Giovedi']")).click();
    
    driver.findElement(By.xpath(giorno)).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/input[1]")).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/table/tbody/tr[3]/td[1]/input")).click();

    driver.findElement(By.xpath("//*[@id=\"orario\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"orario\"]")).sendKeys("16:00");

    driver.findElement(By.xpath("//*[@id=\"prezzo\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"prezzo\"]")).sendKeys("10.0");

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/input[5]")).click();

    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/input[1]")).click();


    String prezzoModif = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/table/tbody/tr[3]/td[5]/strong")).getText();
    driver.close();

    assertEquals(prezzoModif, "10.0");
  }
}
