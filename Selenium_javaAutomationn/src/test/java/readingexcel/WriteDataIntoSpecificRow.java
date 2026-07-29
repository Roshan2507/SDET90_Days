package readingexcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoSpecificRow {

	public static void main(String[] args) throws IOException {

		//Excel File --> Workbook  -->  Sheets  -->  Rows  -->  Cells
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myRandom_File.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet =wb.createSheet("RandomData");
		
		XSSFRow row =sheet.createRow(3);
		
		XSSFCell cell =row.createCell(4);
		
		cell.setCellValue("Hello World");
		
		wb.write(file);
		wb.close();
		file.close();
		
		System.out.println("File is Created");
		
		
	}

}
