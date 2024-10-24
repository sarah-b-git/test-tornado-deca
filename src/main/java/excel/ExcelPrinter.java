package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelPrinter {

    private XSSFWorkbook workbook;
    private String excelName;

    public ExcelPrinter(String name) throws IOException {
        workbook = new XSSFWorkbook();
        excelName = name;
    }

    public void add(Object[][] data, String sheetName) {

        XSSFSheet sheet = workbook.createSheet(sheetName);

        int rowCount = 0;

        for (Object[] aBook : data) {
            Row row = sheet.createRow(rowCount);
            rowCount++;
            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount);
                columnCount++;

                if (field instanceof String) {
                    cell.setCellValue((String) field);

                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);

                } else if (field instanceof Double) {
                    cell.setCellValue((Double) field);

                }
            }
        }
    }

    public void write() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String timeStamp = LocalDateTime.now().format(formatter);
        FileOutputStream out = new FileOutputStream(excelName + timeStamp + ".xlsx");
        workbook.write(out);
        workbook.close();
    }

}
