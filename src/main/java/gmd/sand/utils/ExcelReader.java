
package gmd.sand.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private Workbook workbook;

	public ExcelReader(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		this.workbook = new XSSFWorkbook(fis);
	}

	public String getCellData(String sheetName, int rowNum, int colNum) {
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		return cellToString(cell);
	}

	public List<List<String>> getSheetData(String sheetName) {
		List<List<String>> data = new ArrayList<>();
		Sheet sheet = workbook.getSheet(sheetName);
		for (Row row : sheet) {
			List<String> rowData = new ArrayList<>();
			for (Cell cell : row) {
				rowData.add(cellToString(cell));
			}
			data.add(rowData);
		}
		return data;
	}

	private String cellToString(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "";
		}
	}

	public void close() throws IOException {
		workbook.close();
	}
}
