package CSV;
import java.io.File;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.entity.Room;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class Writer {


    public Map<String, Object[]> makeTable(List<Room> rooms) {
        Map<String, Object[]> empinfo = new TreeMap<>();
         empinfo.put("0", new Object[] {"id","Мест","Цена","Статус","Звезд","Занят?"});
        int i = 1;
        for (Room room : rooms) {
            empinfo.put(i+"", new Object[]{room.getId(),room.getCapacity(), room.getPriceRoom(), room.getStatusRoom().toString(),
                    room.getStars(),room.isBusy()? "Yes" : "No"});
            i++;
        }
        return empinfo;
    }

    public void writeTest(List<Room> rooms,String path) throws Exception {

        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(" Room Info ");

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        Map<String, Object[]> empinfo = makeTable(rooms);

        //Iterate over data and write to sheet
        Set<String> keyid = empinfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = empinfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(obj.toString());
            }
        }
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File(path));
        workbook.write(out);
        out.close();
    }

}

