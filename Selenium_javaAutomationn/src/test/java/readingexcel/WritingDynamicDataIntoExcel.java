package readingexcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {

		//Excel file --> Workbook  -->  Sheets  -->  Rows  -->  Cells
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//testdata//myFile_dynamicData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet =wb.createSheet("DynamicData");
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of rows :");
		int noOfRows = sc.nextInt();
		
		System.out.println("Enter the number of cells :");
		int noOfCells = sc.nextInt();
		
		for(int r=0;r<=noOfRows;r++)
		{
			XSSFRow currentRow =sheet.createRow(r);
			for(int c =0;c<noOfCells;c++)
			{
				XSSFCell cell=currentRow.createCell(c);
				cell.setCellValue(sc.next());
				
			}
		}
		
		wb.write(file);
		wb.close();
		file.close();
		
		System.out.println("File is Created");
		
	}

}
