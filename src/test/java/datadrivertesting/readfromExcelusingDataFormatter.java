package datadrivertesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readfromExcelusingDataFormatter {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/New Microsoft Excel Worksheet.xlsx");
		
		Workbook wb= WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
//		String data=df.formatCellValue(wb.getSheet("sheet1").getRow(2).getCell(1));
//		System.out.println(data);
		System.out.println(wb.getSheet("sheet1").getRow(2).getCell(1).getNumericCellValue());
		
		wb.close();
	}

}
