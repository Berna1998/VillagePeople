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

  String orario = "16:00";
  String prezzo = "10.0";
  String categoria = "//*[@id=\"cateogorie\"]";
  String giorno = "//*[@id=\"giorno\"]";
  
  @Test
  public void modificaAttivita() {

	System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
    WebDriver driverModif = new ChromeDriver();

	driverModif.manage().window().setSize(new Dimension(1552, 840));
	driverModif.get("http://localhost:8083/VillagePeople/Login.jsp");
		    
	driverModif.findElement(By.xpath("//*[@id=\"codiceID\"]")).click();
    driverModif.findElement(By.xpath("//*[@id=\"codiceID\"]")).sendKeys(codiceId);
    driverModif.findElement(By.xpath("//*[@id=\"password\"]")).click();
    driverModif.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin");
    driverModif.findElement(By.xpath("/html/body/form/div/div/div[1]/div/div/input[3]")).click();

    driverModif.findElement(By.xpath("/html/body/form/ul/li[3]/a")).click();

    driverModif.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/input")).click();

    driverModif.findElement(By.xpath(categoria)).click();
    
    WebElement dropdown = driverModif.findElement(By.xpath(categoria));
    dropdown.findElement(By.xpath("//option[. = 'Sport']")).click();
    
   
    driverModif.findElement(By.xpath(categoria)).click();

    driverModif.findElement(By.xpath(giorno)).click();
    
    dropdown = driverModif.findElement(By.xpath(giorno));
    dropdown.findElement(By.xpath("//option[. = 'Giovedi']")).click();
    
    driverModif.findElement(By.xpath(giorno)).click();

    driverModif.findElement(By.xpath("/html/body/form/div/div/div[2]/input[1]")).click();

    driverModif.findElement(By.xpath("/html/body/form/div/div/div[2]/table/tbody/tr[3]/td[1]/input")).click();

    driverModif.findElement(By.xpath("//*[@id=\"orario\"]")).click();

    driverModif.findElement(By.xpath("//*[@id=\"orario\"]")).sendKeys("16:00");

    driverModif.findElement(By.xpath("//*[@id=\"prezzo\"]")).click();

    driverModif.findElement(By.xpath("//*[@id=\"prezzo\"]")).sendKeys("10.0");

    driverModif.findElement(By.xpath("/html/body/form/div/div/div[2]/input[5]")).click();

    driverModif.findElement(By.xpath("/html/body/form/div/div/div[2]/input[1]")).click();


    String prezzoModif = driverModif.findElement(By.xpath("/html/body/form/div/div/div[2]/table/tbody/tr[3]/td[5]/strong")).getText();
    driverModif.close();

    assertEquals(prezzoModif, "10.0");
  }
}
