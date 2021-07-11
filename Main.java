
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

                String question = "";
                XSSFCell question1 = row1.getCell(0);
                if (question1 != null) {
                    question1.setCellType(CellType.STRING);
                    question = question1.getStringCellValue();
                }

                String key = "";
                XSSFCell key1 = row2.getCell(0);
                if (key1 != null) {
                    key1.setCellType(CellType.STRING);
                    key = key1.getStringCellValue();
                }
            }
        }

        if(worksheet1.getRow(5) == worksheet2.getRow(2)) {
            marks = marks + 4 ;
            System.out.println("Marks = " + marks);
        }
    }

}
