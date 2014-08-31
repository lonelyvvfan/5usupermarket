package cs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import cs.entity.Order;

public class ReadXls {
	private InputStream excelFile;
	private List<Order> orderList;
	public List<Order> readXlsToList(File target)throws Exception{
		orderList = new ArrayList<Order>();
		excelFile = new FileInputStream(target);
		//Workbook wb = new HSSFWorkbook(excelFile);
		Workbook wb = null;
        try {
            wb = create(excelFile);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 0; i < rowNum; i++) {
			Order order = new Order();
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for (int j = 0; j < cellNum; j++) {
				Cell cell = row.getCell(j);
				String cellValue = null;
				switch (cell.getCellType()) { // �ж�excel��Ԫ�����ݵĸ�ʽ�����������ת�����Ա������ݿ�
				case 0:
					cellValue = String
							.valueOf((int) cell.getNumericCellValue());
					break;
				case 1:
					cellValue = cell.getStringCellValue();
					break;
				case 2:
					cellValue = String
							.valueOf((int) cell.getNumericCellValue());
					break;
				case 3:
					cellValue = cell.getStringCellValue();
					break;
				case 4:
					cellValue = cell.getStringCellValue();
					break;
				}
				cellValue.trim();
				System.out.println(cellValue);
				switch (j) {// ͨ���������ж϶�Ӧ������ֶ�
				case 0:
				//	order.setOrderDate(cellValue);
					break;
				case 1:
				//	order.setOrderSP(cellValue);
					break;
				case 2:
				//	order.setDestination(cellValue);
					break;
				case 3:
				//	order.setCarnumber(cellValue);
					break;
				case 4:
				//	order.setSelfcode(cellValue);
					break;
				case 5:
				//	order.setCigarette(cellValue);
					break;
				case 6:
				//	order.setQuantity(Integer.valueOf(cellValue));
					break;
				}
			}
			orderList.add(order);
		}
		return orderList;
	}
	
	public static Workbook create(InputStream in) throws     
			IOException, InvalidFormatException{
        if (!in.markSupported()) {
            in = new PushbackInputStream(in, 8);
        }
        if (POIFSFileSystem.hasPOIFSHeader(in)) {
            return new HSSFWorkbook(in);
        }
        if (POIXMLDocument.hasOOXMLHeader(in)) {
            return new XSSFWorkbook(OPCPackage.open(in));
        }
        System.out.println("���excel�汾Ŀǰpoi��������");
        throw new IllegalArgumentException("���excel�汾Ŀǰpoi��������");
   }

}
