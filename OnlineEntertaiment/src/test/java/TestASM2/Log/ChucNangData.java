package TestASM2.Log;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TestASM2.ultils.ExcelUltils;

public class ChucNangData extends TestData implements Log<ChucNangData> {
	private String username;
	private String password;
	private String fullname;
	private String email;
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void writeLog(String src, String sheetName, Set<ChucNangData> logs) throws IOException {
		XSSFWorkbook workbook = ExcelUltils.getworkbook(src);
		XSSFSheet sheet = ExcelUltils.getSheet(workbook, sheetName);
		// đống này xử lý việc ghi tiếp dữ liệu từ hàng cuối cùng của dữ liệu hiện tại
		int startRow = 0, lastRow = sheet.getPhysicalNumberOfRows(); // lastRow bảng hàng cući cùng /
		if (lastRow < startRow)
			lastRow = startRow; // SỬ DỤNG lastROw
		// hàm tiện ích tạo đổi tuượng rowstyle đã được thiét lập sản các giá trị
		CellStyle rowStyle = ExcelUltils.getRowStyle(workbook);

		// duyệt qua bộ dừ liệu
		for (ChucNangData log : logs) {

			Row row = sheet.createRow(lastRow);

			row.setHeightInPoints(60);
			row.setRowStyle(rowStyle);
			log.writeDataRow(log, row, sheet);	
			lastRow++;
		}
		ExcelUltils.export(src, workbook);
	}

	@Override
	public void writeDataRow(ChucNangData log, Row row, XSSFSheet sheet) throws IOException {
		// TODO Auto-generated method stub
		CellStyle globallStyle = row.getRowStyle();
		Cell cell;
		cell = row.createCell(0); // Cell thứ 0
		cell.setCellValue(log.getUsername());
		cell.setCellStyle(globallStyle);

		cell = row.createCell(1);
		cell.setCellValue(log.getPassword());
		cell.setCellStyle(globallStyle);
		
		cell = row.createCell(2);
		cell.setCellValue(log.getFullname());
		cell.setCellStyle(globallStyle);

		cell = row.createCell(3);
		cell.setCellValue(log.getEmail());
		cell.setCellStyle(globallStyle);

		writeTestData(4, row, sheet);
	}

}
