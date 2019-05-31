package Samplepackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Xls_Reader;

public class FlightBookingforRoundtrip1 {
	
	@Test(dataProvider="getData")
	public void login(String username,String password)
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\archana2019\\Drivers\\chromedriver.exe");
		ChromeDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://www.newtours.demoaut.com/");
		dr.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		dr.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		dr.findElement(By.xpath("//input[@name='login']")).click();
		
		int count=dr.findElements(By.xpath("//b[contains(text(),'Passengers:')]")).size();
		Assert.assertEquals(count, 1);
		

	
			dr.findElement(By.xpath("//input[@value='roundtrip']")).click();

			FlightBookingfor1.selectOption(dr, "//select[@name='passCount']", "1");
			FlightBookingfor1.selectOption(dr, "//select[@name='fromPort']", "London");
			FlightBookingfor1.selectOption(dr, "//select[@name='fromMonth']", "May");
			FlightBookingfor1.selectOption(dr, "//select[@name='fromDay']", "28");
			FlightBookingfor1.selectOption(dr, "//select[@name='toPort']", "New York");
			FlightBookingfor1.selectOption(dr, "//select[@name='toMonth']", "March");
			FlightBookingfor1.selectOption(dr, "//select[@name='toDay']", "28");
			dr.findElement(By.xpath("//input[@value='Business']")).click();
			FlightBookingfor1.selectOption(dr, "//select[@name='airline']", "Blue Skies Airlines");
			dr.findElement(By.name("findFlights")).click();

			dr.findElement(By.xpath("//input[@value='Unified Airlines$363$281$11:24']")).click();

			dr.findElement(By.xpath("//input[@name='reserveFlights']")).click();

			dr.findElement(By.name("passFirst0")).sendKeys("Rahul");
			dr.findElement(By.name("passLast0")).sendKeys("Gupta");

			FlightBookingfor1.selectOption(dr, "//select[@name='pass.0.meal']", "Diabetic");
			// creditcard details
			FlightBookingfor1.selectOption(dr, "//select[@name='creditCard']", "MasterCard");
			dr.findElement(By.name("creditnumber")).sendKeys("987-654-322-345");
			FlightBookingfor1.selectOption(dr, "//select[@name='cc_exp_dt_mn']", "02");
			FlightBookingfor1.selectOption(dr, "//select[@name='cc_exp_dt_yr']", "2009");
			dr.findElement(By.name("cc_frst_name")).sendKeys("Rahul");
			dr.findElement(By.name("cc_mid_name")).sendKeys("Shivkumar");
			dr.findElement(By.name("cc_last_name")).sendKeys("Gupta");

			dr.findElement(By.xpath("//input[@value='checkbox']")).click();
			// billing address

			dr.findElement(By.name("billAddress1")).clear();
			dr.findElement(By.name("billAddress1")).sendKeys("xyz colony");
			dr.findElement(By.name("billAddress2")).clear();
			dr.findElement(By.name("billAddress2")).sendKeys("nagar road");
			dr.findElement(By.name("billCity")).clear();
			dr.findElement(By.name("billCity")).sendKeys("pune");
			dr.findElement(By.name("billState")).clear();
			dr.findElement(By.name("billState")).sendKeys("maharshtra");
			dr.findElement(By.name("billZip")).clear();
			dr.findElement(By.name("billZip")).sendKeys("411014");
			FlightBookingfor1.selectOption(dr, "//select[@name='billCountry']", "UNITED STATES");

			// Shipping address

			dr.findElement(By.xpath("//input[@value='checkbox']")).click();

			// billing address
			dr.findElement(By.name("delAddress1")).clear();
			dr.findElement(By.name("delAddress1")).sendKeys("xyz colony");
			dr.findElement(By.name("delAddress2")).clear();
			dr.findElement(By.name("delAddress2")).sendKeys("nagar road");
			dr.findElement(By.name("delCity")).clear();
			dr.findElement(By.name("delCity")).sendKeys("pune");
			dr.findElement(By.name("delState")).clear();
			dr.findElement(By.name("delState")).sendKeys("maharshtra");
			dr.findElement(By.name("delZip")).clear();
			dr.findElement(By.name("delZip")).sendKeys("411014");
			FlightBookingfor1.selectOption(dr, "//select[@name='delCountry']", "UNITED STATES");

			dr.findElement(By.name("buyFlights")).click();
			String text = dr.findElement(By.xpath("//font[contains(text(),'itinerary has been booked!')]")).getText();

			System.out.println(text);

			// to check element

			List<WebElement> list = dr.findElements(By.xpath("//font[contains(text(),'itinerary has been booked!')]"));

			if (list.size() >= 1) {
				System.out.println("Flight is booked for Roundtrip");
			} else {
				System.out.println("not booked");
			}

		}
	@DataProvider
	public String[][] getData() throws IOException
	{
		Xls_Reader xl=new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\Testdata1.xls");
		int rows=xl.getrowcount("Sheet3");
		int cols=xl.getColumncount("Sheet3");
		
		String[][] data=new String[rows-1][cols];
		
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				data[r-2][c-1]=xl.getCellData("Sheet3", r, c);
			}
		}
		
		return data;
		
	}
	}



