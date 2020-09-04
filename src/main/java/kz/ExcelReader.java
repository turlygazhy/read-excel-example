package kz;

import kz.entity.Cafe;
import kz.entity.ExcelParsingException;
import kz.entity.ExcelSettings;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {//todo somewhere need to write that file should be xlsx

    public static List<Cafe> getCafes(String filePath, ExcelSettings excelSettings) throws ExcelParsingException {
        List<Cafe> result = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));   //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            int numberOfSheets = wb.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = wb.getSheetAt(i);     //creating a Sheet object to retrieve object
                Iterator<Row> itr = sheet.iterator();    //iterating over excel file
                while (itr.hasNext()) {
                    Row row = itr.next();
                    String name = getCellInfo(row, excelSettings.getNameColumnIndex());
                    String type = getCellInfo(row, excelSettings.getTypeColumnIndex());
                    String link = getCellInfo(row, excelSettings.getLinkColumnIndex());
                    if (link.contains("google.com")) {
                        result.add(new Cafe(name, type, link));
                    }
                }
            }
            return result;
        } catch (Exception e) {
            throw new ExcelParsingException(e);
        }
    }

    private static String getCellInfo(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            return "";
        }
        return cell.getStringCellValue();
    }
}