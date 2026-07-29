package readingexcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

		//ExcelFile -> WorkBook -->Sheets  -->Rows --->Cells
		
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\BookDetails.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int totalRows =sheet.getLastRowNum();
		
		int totalCells = sheet.getRow(1).getLastCellNum();
//		
//		System.out.println("Total number of Rows :"+totalRows);
//		System.out.println("Total number of Cell :"+totalCells);
//		
		for(int r=0;r<=totalRows;r++ )
		{
		XSSFRow currentRow=sheet.getRow(r);
			
			for(int c=0;c<totalCells;c++)
			{
				XSSFCell cell=currentRow.getCell(c);
				System.out.print(cell.toString()+"\t ");
			}
			System.out.println();
		}
		
		wb.close();
		file.close();
		
		
	}

}
