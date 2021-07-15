
import org.apache.commons.collections4.MapUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        int marks = 0;
        Map<Double, Integer> studentResultMap = new HashMap<>();

        FileInputStream studentsresultsstream = new FileInputStream("C:\\Users\\YEMBAR VIMALA\\OneDrive\\Desktop\\Responses.xlsx");
        XSSFWorkbook workbook1 = new XSSFWorkbook(studentsresultsstream);
        XSSFSheet worksheet1 = workbook1.getSheet("Sheet1");

        if (worksheet1 != null) {

            int rowCount1 = worksheet1.getPhysicalNumberOfRows();

            FileInputStream keyInputStream = new FileInputStream("C:\\Users\\YEMBAR VIMALA\\OneDrive\\Desktop\\Result1.xlsx");
            XSSFWorkbook workbook2 = new XSSFWorkbook(keyInputStream);
            XSSFSheet worksheet2 = workbook2.getSheet("Sheet2");


                int rowCount2 = worksheet2.getPhysicalNumberOfRows();

                for (int i = 1; i < rowCount2; i++) {
                    XSSFRow row1 = worksheet2.getRow(i);

                        int physicalNumberOfCellsInResultRow = row1.getPhysicalNumberOfCells();
                        for (int j = 0; j < physicalNumberOfCellsInResultRow; j++) {

                            XSSFCell resultForQuestionI = row1.getCell(j);
                            if (resultForQuestionI != null && resultForQuestionI.getCellType().equals(CellType.STRING)) {
                                String resultStringForQuestion = resultForQuestionI.getStringCellValue();

                                for (int k = 1; k < rowCount1; k++) {
                                    XSSFRow studentRow = worksheet2.getRow(k);
                                    XSSFCell enrollmentCell = studentRow.getCell(2);

                                    if (enrollmentCell != null) {
                                        double studentEnrollmentNr = enrollmentCell.getNumericCellValue();
                                        XSSFCell cell = studentRow.getCell(j + 4);

                                        if (cell != null) {
                                            String studentEntry = cell.getStringCellValue();
                                            if (studentEntry.equals(resultStringForQuestion)) {
                                                if (studentResultMap.containsKey(studentEnrollmentNr)) {
                                                    Integer marksOfCurrentStudent = studentResultMap.get(studentEnrollmentNr);
                                                    marksOfCurrentStudent = marksOfCurrentStudent + 4;
                                                    studentResultMap.replace(studentEnrollmentNr, marksOfCurrentStudent);
                                                } else {
                                                    studentResultMap.put(studentEnrollmentNr, marks + 4);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            MapUtils.debugPrint(System.out, "studentMap", studentResultMap);
                        }
                    }
                }
            }
        }

