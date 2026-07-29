package allselenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\BookDetails.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int totalrow = sheet.getLastRowNum();
		
		int totalcell = sheet.getRow(1).getLastCellNum();
		
		for(int r=0;r<=totalrow;r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0;c<totalcell;c++)
			{
				XSSFCell currentcell=currentRow.getCell(c);
				System.out.print(currentcell.toString()+"\t");
			}
			System.out.println();
		}
		wb.close();
		fis.close();
	
	}

}
