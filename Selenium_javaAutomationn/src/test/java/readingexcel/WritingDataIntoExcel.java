package readingexcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {

		 //Excel File --> Workbook  -->  Sheets  -->  Rows  -->  Cells
		
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myFile.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet =wb.createSheet("Data");
		
		XSSFRow row1 =sheet.createRow(0);
		
		row1.createCell(0).setCellValue("ID");
		row1.createCell(1).setCellValue("Name");
		row1.createCell(2).setCellValue("Address"); 
		row1.createCell(3).setCellValue("Course");
		row1.createCell(4).setCellValue("Fees");
		
		XSSFRow row2 =sheet.createRow(1);
		
		row2.createCell(0).setCellValue("101");
		row2.createCell(1).setCellValue("Roshan");
		row2.createCell(2).setCellValue("Pune");
		row2.createCell(3).setCellValue("SDET");
		row2.createCell(4).setCellValue("25000");
		
        XSSFRow row3 =sheet.createRow(2);
		
		row3.createCell(0).setCellValue("102");
		row3.createCell(1).setCellValue("Akash");
		row3.createCell(2).setCellValue("Pune");
		row3.createCell(3).setCellValue("Java");
		row3.createCell(4).setCellValue("35000");
		
		
		wb.write(file);		
		wb.close();
		file.close();
		
	}

}
