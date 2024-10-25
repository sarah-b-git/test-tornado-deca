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
        String[] headers = {"Name", "Deca 100m", "Deca 400m", "Deca 1500m", "Deca 110m Hurdles",
                "Deca Long Jump", "Deca High Jump", "Deca Pole Vault",
                "Deca Discus Throw", "Deca Javelin Throw", "Deca Shot Put",
                "Hep 200m", "Hep 800m", "Hep 100m Hurdles",
                "Hep High Jump", "Hep Long Jump", "Hep Shot Put",
                "Hep Javelin Throw", "Total Score"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        int rowCount = 1;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss");
        String timeStamp = formatter.format(LocalDateTime.now());
        FileOutputStream out = new FileOutputStream(excelName + timeStamp + ".xlsx");
        workbook.write(out);
        workbook.close();
    }

}
