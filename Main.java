
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
            int marks = 0;
//        String excelfilepath = ".\\src\\result.xlsx";
//        FileInputStream fileInputStream = new FileInputStream(excelfilepath);
//
//        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//        XSSFSheet sheet = workbook.getSheet("Sheet1");
//
//        Iterator iterator = sheet.iterator();
//
//        while(iterator.hasNext())
//        {
//            XSSFRow row = (XSSFRow) iterator.next();
//            Iterator celliterator =row.cellIterator();
//
//            while(celliterator.hasNext())
//            {
//               XSSFCell cell= (XSSFCell) celliterator.next();
//
//                switch(cell.getCellType())
//                {
//                   case STRING:
//                       System.out.print(cell.getStringCellValue());
//                       break;
//                   case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                       break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//                }System.out.print(" | ");
//            }
//        }
        FileInputStream fileInputStream1 = new FileInputStream(".\\src\\result.xlsx");
        XSSFWorkbook workbook1 = new XSSFWorkbook(fileInputStream1);
        XSSFSheet worksheet1 = workbook1.getSheet("Sheet1");
        int rowCount1 = worksheet1.getPhysicalNumberOfRows();

        FileInputStream fileInputStream2 = new FileInputStream(".\\src\\Key.xlsx");
        XSSFWorkbook workbook2 = new XSSFWorkbook(fileInputStream2);
        XSSFSheet worksheet2 = workbook2.getSheet("Sheet2");
        int rowCount2 = worksheet2.getPhysicalNumberOfRows();

        if (rowCount1==rowCount2) {
            for (int i = 1; i < rowCount1; i++){
                XSSFRow row1 = worksheet1.getRow(i);
                XSSFRow row2 = worksheet2.getRow(i);

                String Question1 = "";
                XSSFCell Q1 = row1.getCell(0);
                if (Q1 != null) {
                    Q1.setCellType(CellType.STRING);
                    Question1 = Q1.getStringCellValue();
                }

                String Key1 = "";
                XSSFCell K1 = row2.getCell(0);
                if (K1 != null) {
                    K1.setCellType(CellType.STRING);
                    Key1 = K1.getStringCellValue();
                }

                String Question2 = "";
                XSSFCell Q2 = row1.getCell(0);
                if (Q2 != null) {
                    Q2.setCellType(CellType.STRING);
                    Question2 = Q2.getStringCellValue();
                }

                String Key2 = "";
                XSSFCell K2 = row2.getCell(0);
                if (K2 != null) {
                    K2.setCellType(CellType.STRING);
                    Key2 = K2.getStringCellValue();
                }

            }
        }

        if(worksheet1.getRow(16) == worksheet2.getRow(24))
            marks = marks + 4;
            System.out.println("marks are " + marks);

        if(worksheet1.getRow(10) == worksheet2.getRow(12))
            marks = marks + 4;
            System.out.println("marks are " + marks);
    }

}
