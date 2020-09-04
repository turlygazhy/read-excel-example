package kz;

import kz.entity.Cafe;
import kz.entity.ExcelParsingException;
import kz.entity.ExcelSettings;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws ExcelParsingException {
        ExcelSettings excelSettings = new ExcelSettings('d', 'f', 'l', 0);
        List<Cafe> cafes = ExcelReader.getCafes("/home/user/Desktop/halaldamu/map.xlsx", excelSettings);
        cafes.forEach(System.out::println);
//todo regex \d{2}.\d{5,}
    }

}
