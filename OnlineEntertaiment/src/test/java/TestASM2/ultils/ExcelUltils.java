 package TestASM2.ultils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExcelUltils {
	public static final String CHORME_DRIVER_SRC = System.getProperty("user.dir")+ "/test-resources/Driver/chromedriver.exe";
	public static final String DATA_SRC = System.getProperty("user.dir") + "/test-resources/Data/";
	public static final String IMG_SRC = System.getProperty("user.dir") + "/test-resources/Img/";

	public static XSSFWorkbook getworkbook(String filePath) throws IOException { // Qua getworkbook trước
		File src = new File(filePath); // Lấy File từ đường dân
		if (!src.exists()) {
			throw new IOException("Không tồn tại file với đường dẫn: " + filePath);
		}
		FileInputStream fis = new FileInputStream(src); // Chuyển File sang FileInputstream
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // Tạo đõi tượng workbook
		fis.close(); // đóng kết női
		return workbook;
	}

	public static XSSFSheet getSheet(XSSFWorkbook workbook, String sheetName) { // Lây sheet
		XSSFSheet sheet = workbook.getSheet(sheetName); // sheetName là tên đặt trong file Excel
		if (sheet == null) {
			throw new NullPointerException("Sheet " + sheetName + "không tồn tại, thêm dữ liệu thết bại!");
		}
		return sheet;
	}

	public static CellStyle getRowStyle(XSSFWorkbook workbook) {
		CellStyle rowStyle = workbook.createCellStyle();

		rowStyle.setAlignment(HorizontalAlignment.CENTER);
		rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		rowStyle.setWrapText(true);

		return rowStyle;

	}

	public static String getCellValue(XSSFSheet sheet, int row, int column) {
		String returnValue;
		XSSFCell cell = sheet.getRow(row).getCell(column);
		try {
			if (cell.getCellType() == CellType.STRING) {
				returnValue = cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC) {
				returnValue = String.format("%.0f", cell.getNumericCellValue());
			} else {
				returnValue = "";
			}
		} catch (Exception e) {
			returnValue = "";
		}
		return returnValue;
	}
	
	// chup img
	public static void takescreenShot(WebDriver driver, String outputSrc) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(outputSrc)); // outputSrc đường dẫn
	}

	public static Object[][] readSheetData(XSSFSheet sheet) {
		int rows = sheet.getPhysicalNumberOfRows(); // Tong so row
		int columns = sheet.getRow(0).getLastCellNum(); // Tong so column

		Object[][] data = new Object[rows - 1][columns]; // tao mang 2 chieu
		// rows = -1 la de chua` hang cho title, code bat dau tu hang 2 tro di trong
		// excel
		for (int row = 1; row < rows; row++) { // row = 1 tuong ung voi hang so 2 trong excel
			for (int col = 0; col < columns; col++) {
				data[row - 1][col] = ExcelUltils.getCellValue(sheet, row, col);
			}
		}
		return data;
	}

	
	//Ve~ img
	public static void writeImage(String image, Row row, Cell cell, XSSFSheet sheet) throws IOException {
		InputStream is = new FileInputStream(image);
		byte[] bytes = IOUtils.toByteArray(is);
		int pictureID = sheet.getWorkbook().addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);

		is.close();

		XSSFDrawing drawing = sheet.createDrawingPatriarch();

		ClientAnchor anchor = new XSSFClientAnchor();

		anchor.setCol1(cell.getColumnIndex());
		anchor.setRow1(row.getRowNum());
		anchor.setCol2(cell.getColumnIndex() + 1);
		anchor.setRow2(row.getRowNum() + 1);

		drawing.createPicture(anchor, pictureID);
	}

	public static void export(String outputSrc, XSSFWorkbook workbook) throws IOException {
		FileOutputStream out = new FileOutputStream(outputSrc);
		workbook.write(out);
		out.close();
	}
}
