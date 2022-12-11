package TestASM2.Log;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import TestASM2.ultils.ExcelUltils;

public class TestData {
	private String action;
	private Date logTime;
	private String testMethod;
	private String expected;
	private String actual;
	private String status;
	private String exception = null;
	private String image = null;

	public String getAction() { 
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getTestMethod() {
		return testMethod;
	}

	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void writeTestData(int Index, Row row, XSSFSheet sheet) throws IOException {
		CreationHelper creationHelper = sheet.getWorkbook().getCreationHelper();
		CellStyle globalStyle = row.getRowStyle();
		Cell cell; // tạo đối tưọng Cell để ghi Data

		cell = row.createCell(Index); // vi trí Column bắt đầu
		cell.setCellValue(getAction());
		cell.setCellStyle(globalStyle);

		cell = row.createCell(Index + 1);
		cell.setCellValue(getLogTime());
		CellStyle datetimestyle = globalStyle;
		datetimestyle.setDataFormat(creationHelper.createDataFormat().getFormat("hh:mm:ss dd-mm-yyyy"));
		cell.setCellStyle(datetimestyle);

		cell = row.createCell(Index + 2);
		cell.setCellValue(getTestMethod());
		cell.setCellStyle(globalStyle);

		cell = row.createCell(Index + 3);
		cell.setCellValue(getExpected());
		cell.setCellStyle(globalStyle);

		cell = row.createCell(Index + 4);
		cell.setCellValue(getActual());
		cell.setCellStyle(globalStyle);

		cell = row.createCell(Index + 5);
		cell.setCellValue(getStatus());
		cell.setCellStyle(globalStyle);

		if (getException() != null) {
			cell = row.createCell(Index + 6);
			cell.setCellValue(getException());
			cell.setCellStyle(globalStyle);
		}
		if (getImage() != null) {
			cell = row.createCell(Index + 7);
			cell.setCellStyle(globalStyle);
			ExcelUltils.writeImage(getImage(), row, cell, sheet);

			cell = row.createCell(Index + 8);
			cell.setCellValue("Link Screenshot");
			cell.setCellStyle(globalStyle);

			XSSFHyperlink hyperlink = (XSSFHyperlink) creationHelper.createHyperlink(HyperlinkType.URL);
			hyperlink.setAddress(getImage().replace("\\", "/"));
			cell.setHyperlink(hyperlink);
		}
	}
}
