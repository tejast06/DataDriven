package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class ParameterizedTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Tejas Toley\\eclipse-workspace\\DataDRiven\\src\\com\\testdata\\TestData.xlsx");
        int rowCnt =reader.getRowCount("Sheet1");
        
        for(int rowNum=2; rowNum<=rowCnt; rowNum++ )
        {
        	String firstname=reader.getCellData("Sheet1", "FirstName", rowNum);
        	System.out.println(firstname);
        	
        	String secondname=reader.getCellData("Sheet1", "LastName", rowNum);
        	System.out.println(secondname);
        	
        	String date=reader.getCellData("Sheet1", "Date", rowNum);
        	System.out.println(date);
        	
        	//Launch the browser
    		
    		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
    		driver.findElement(By.xpath("//input[@name='firstname']")).clear();
    		
    		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(secondname);
    		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
    		
    		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(date);
    		driver.findElement(By.xpath("//input[@id='datepicker']")).clear();
        }

	}

}
