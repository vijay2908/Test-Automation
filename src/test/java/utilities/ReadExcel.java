package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] readExcel() throws Exception {
		File f = new File("C:\\Users\\vijay\\Downloads\\Book1.xlsx");
		FileInputStream in = new FileInputStream(f);
		XSSFWorkbook book = new XSSFWorkbook(f);
		XSSFSheet sheet = book.getSheetAt(0);
		String[][] tab = null;
		tab = new String[sheet.getLastRowNum() + 1][2];

		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			tab[i][0] = sheet.getRow(i).getCell(0).getStringCellValue();
			tab[i][1] = sheet.getRow(i).getCell(1).getStringCellValue();

		}
		return tab;
	}
}
