
package datadrivertesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcelToNewRow {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/New Microsoft Excel Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		sheet.createRow(5).createCell(0).setCellValue("subject1");
		sheet.getRow(5).createCell(1).setCellValue("khaja");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/New Microsoft Excel Worksheet.xlsx");
		wb.write(fos);
		
		wb.close();
	}

}
