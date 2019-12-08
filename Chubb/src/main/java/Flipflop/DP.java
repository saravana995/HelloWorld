package Flipflop;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DP {

	public static String[][] getData(String getSheetName) throws IOException
	{
		
		String[][] testData;
		
		FileInputStream FIS = new FileInputStream("./testData/"+getSheetName+".xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(FIS);
		
		XSSFSheet sh = wb.getSheetAt(0);
		
		int row = sh.getLastRowNum();
		int cols = sh.getRow(0).getLastCellNum();
		
		testData = new String[row][cols];
		for(int i=1;i<=row;i++){
			
			XSSFRow row1=sh.getRow(i);
				
				for(int j=0;j<cols;j++){
				String cellData=row1.getCell(j).getStringCellValue();
				System.out.println(cellData);
				testData[i-1][j]=cellData;
				}

			}
			return testData;
		}
		
	
}
