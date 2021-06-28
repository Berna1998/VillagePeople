package test;

import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;

public class SignUpTestSelenium {
  

  String nome = "Marco";
  String cognome = "Rossi";
  String codiceId = "12348";
  String email = "marco.rossi@gmail.com";
  String password = "marcorossi";
  String confermaPass = "marcorossi";
  String giorni = "8";
  
  @Test
  public void signUpSelenium() {
	System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	driver.manage().window().setSize(new Dimension(1552, 840));
	driver.get("http://localhost:8083/VillagePeople/Login.jsp");
    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/input")).click();
 
    driver.findElement(By.xpath("//*[@id=\"nome\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"nome\"]")).sendKeys(nome);

    driver.findElement(By.xpath("//*[@id=\"cognome\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"cognome\"]")).sendKeys(cognome);


    driver.findElement(By.xpath("//*[@id=\"codiceID\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"codiceID\"]")).sendKeys(codiceId);

    driver.findElement(By.xpath("//*[@id=\"email\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);

    driver.findElement(By.xpath("//*[@id=\"password\"]")).click();

    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
  
    driver.findElement(By.xpath("//*[@id=\"confermaPassword\"]")).click();
  
    driver.findElement(By.xpath("//*[@id=\"confermaPassword\"]")).sendKeys(confermaPass);
    
    driver.findElement(By.xpath("//*[@id=\"giorni\"]")).click();
  
    driver.findElement(By.xpath("//*[@id=\"giorni\"]")).sendKeys(giorni);

    driver.findElement(By.xpath("//*[@id=\"saluteBenessere\"]")).click();
    
    driver.findElement(By.xpath("//*[@id=\"sport\"]")).click();
    
    driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/input")).click();
   
    String conferma = driver.findElement(By.xpath("/html/body/p")).getText();

    driver.close();  

    assertEquals(conferma,"Registrazione Effettuata");
    
    
  }
}
