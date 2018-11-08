package com.owm.testUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.own.baseTest.TestBase;

public class TestUtil extends TestBase {

	public static final long PAGE_LOAD_TIMEOUT = 60;
	public static final long IMPLICIT_WAIT = 20;
	
	public static String testDataPath = currentDir + "/testdata/TestData.xls";
	public static String parent;
	
	static Workbook book;
	static Sheet sheet;
	static String data;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static String getTestData(String sheetName, String fieldName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(testDataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    for (int i = 1; i < rowCount+1; i++) {
	        Row row = sheet.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            if(row.getCell(j).getStringCellValue().equals(fieldName)) {
	            	data = row.getCell(j + 1).getStringCellValue();
	            	break;
	            }

	        }
		}
		return data;
	}
	
	public static void waitScriptLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			return;
		}
	}
	
	public static void switchToChildWindow() {
		parent =  driver.getWindowHandle();
		//System.out.println(driver.getCurrentUrl());
		Set<String>s1=driver.getWindowHandles();
		s1.remove(parent);
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
		  String child_window=I1.next();
		  if(!parent.equals(child_window))
		  {
			driver.switchTo().window(child_window);
		    //System.out.println(driver.switchTo().window(child_window).getTitle());
		  }
		}
	}
	
	public static void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}
	
	public static void tearDown(String window) {
		if (window.equals("child")) {
		driver.close();
		driver.switchTo().window(parent);
		}
		else {
			driver.close();
		}
	}
	
}
