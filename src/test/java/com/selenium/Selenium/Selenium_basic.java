package com.selenium.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium_basic {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver","C:/Users/Arnava/eclipse-workspace/Selenium/Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://omayo.blogspot.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("ta1")).sendKeys("Selenium");
		
		//handle Drop box
		Select select = new Select(driver.findElement(By.id("drop1")));
		select.selectByVisibleText("doc 2");
		
		
		driver.findElement(By.id("alert1")).click();
		Thread.sleep(1000);
		
		//handle Alert popup
		Alert alert = driver.switchTo().alert();		
		String text = alert.getText();
		
		if(text.equals("Hello")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Correct");
		}
		
		alert.accept();
		
		//file upload
		driver.findElement(By.id("uploadfile")).sendKeys("C:/Users/Arnava/Desktop/blank.html");
		
		//frames
		driver.switchTo().frame("iframe1");
		driver.switchTo().defaultContent();
		
		//mouse movement
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("blogsmenu"))).build().perform();
		driver.findElement(By.linkText("SeleniumByArun")).click();
		
		//drag and drop
		driver.get("https://jqueryui.com/droppable/");
		
		//driver.quit();
		//driver.close();
		
		
	}
	
}

//xpath - 2
//id  - 1
//name - 3
//linkText: only for text
//partiallinkText: not useful
//CSSSelector - 2
//className: not useful