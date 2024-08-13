package datadrivertesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartScenario {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.name("q")).sendKeys("moblies");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		List<WebElement> moblienames= driver.findElements(By.className("KzDlHZ"));
		
		FileInputStream fis = new FileInputStream("./src/test/resources/New Microsoft Excel Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("sheet2");
		
		for(int i = 0; i < moblienames.size(); i++) {
		String name = moblienames.get(i).getText();
		String price = driver.findElement(By.xpath("//div[text()='"+name+"']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']")).getText();
		sheet.createRow(i).createCell(0).setCellValue(name);
		sheet.createRow(i).createCell(1).setCellValue(price);
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/New Microsoft Excel Worksheet.xlsx");
		wb.write(fos);
		
		wb.close();
		driver.quit();

	

}
}
