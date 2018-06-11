package com.cbt;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.UUID;

public class Order {
public static void main(String[] args) throws InterruptedException, IOException {
		
	System.setProperty("webdriver.chrome.driver", "/Users/Z/Documents/seleniumDependencies/drivers/chromedriver");
	WebDriver driver = new ChromeDriver();

	
	Random r = new Random();
	int number = r.nextInt(100);
	String num = ""+ number;
	int zip = r.nextInt(70000);
	String zipCode = ""+zip;
	
	/////
	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	driver.findElement(By.linkText("Order")).click();
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(num);
	

	ArrayList<String> names = new ArrayList<>();
	FileReader fr = new FileReader("MiddleNames.txt");
	BufferedReader br = new BufferedReader(fr);
	
	String middleName =  "";

	
	while( (middleName=br.readLine()) != null) {
		 names.add(middleName);
	}
	
	int nameID = r.nextInt(500);
	

	
	////
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + names.get(nameID) + " Smith");
	Thread.sleep(2000);
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any St");
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipCode);
	int cardID = r.nextInt(3);
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+cardID)).click();
	
	int cardNumber = 10000000 + r.nextInt(99999999);
	String creditCard = ""+ cardNumber;
	if(driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).isSelected()) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("41234567" + creditCard);
	}
	if(driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).isSelected()) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("51234567" + creditCard);
	}
	if(driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).isSelected()) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3123456" + creditCard);
	}
	
	int rMonth = r.nextInt(12);
	int rDate = 18 + r.nextInt(25);
	
	if(rMonth < 10) {
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("0"+rMonth+"/"+rDate);
	}else {
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(rMonth+"/"+rDate);
	}
	
	Thread.sleep(2000);
	    driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	

	
	

}

}