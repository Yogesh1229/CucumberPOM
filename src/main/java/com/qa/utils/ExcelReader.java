package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public List<Map<String, String>> getData(String filePath, String fileName, String sheetName, Integer rowNumber)
			throws IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		List<Map<String, String>> excelData = new ArrayList<>();
		Map<String, String> rowData = new HashMap<>();
		for (int j = 0; j < row.getLastCellNum(); j++) {
			String key = sheet.getRow(0).getCell(j).getStringCellValue();
			String value = sheet.getRow(rowNumber).getCell(j).getStringCellValue();
			rowData.put(key, value);
		}

		excelData.add(rowData);

		return excelData;
	}

}
