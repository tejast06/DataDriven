package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class DataDriven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Get the data from the sheet
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Tejas Toley\\eclipse-workspace\\DataDRiven\\src\\com\\testdata\\TestData.xlsx");
		String firstName=reader.getCellData("Sheet1", "FirstName", 2);
		System.out.println(firstName);
		
		String secondName=reader.getCellData("Sheet1", "LastName", 2);
		System.out.println(secondName);
		
		String date=reader.getCellData("Sheet1", "Date", 2);
		System.out.println(date);
		
		//Launch the browser
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(secondName);
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(date);
		
		
		
		
		
		
		

	}

}
