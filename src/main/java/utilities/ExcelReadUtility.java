package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//public class ExcelReadUtility {
//	XSSFWorkbook wb;
//	XSSFSheet sh;	

//	public void ExcelReadUtilities() throws IOException {
//
//		FileInputStream file = new FileInputStream("D://New folder//Book1.xlsx");
//		wb = new XSSFWorkbook(file);
//		sh = wb.getSheet("Sheet1");
//
//	}
//
//	public String data(int r, int c) {
//		XSSFRow ro = sh.getRow(r);
//		XSSFCell ce = ro.getCell(c);
//		CellType ct = ce.getCellType();
//		switch (ct) {
//		case NUMERIC:
//			double d = ce.getNumericCellValue();
//			return String.valueOf(d);
//
//		case STRING:
//			return ce.getStringCellValue();
//		}
//
//		return null;
//	}
//
//}
	
public class ExcelReadUtility {
		public void ExcelReadUtilities() throws IOException{
		//Path of the excel file
		FileInputStream fs = new FileInputStream("D://New folder//Book1.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		Row row3 = sheet.getRow(1);
		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);
		}
		}

