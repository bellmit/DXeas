package com.kingdee.eas.wlhlcomm.excel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.util.AbortException;
import com.kingdee.eas.util.client.MsgBox;


/**
 * Excel��ȡutil
 * jdk1.5���߸��Ͱ汾  ��Ҫ ���⵼��jar��
 * jsr173_1.0_api
 *  
 * @author Administrator
 * 
 * 
 */
public class ExcelReadUtil {

	public static String FileFullName = "FILENAME";
	public static String ExcelValues = "ExcelValues";
	public static String XLS = "xls";
	public static String XLSX = "xlsx";
	
	

	/**
     * �������� 
     * ����Excel��ִ�е��������
     * ���map��keyΪ�кţ���1��ʼ��valueΪÿ�ж�Ӧ��  ��ֵmap��
     * �ڲ�map��keyΪ�к� ��1��ʼ���ڲ�map��valueΪ��Ӧ��Ԫ���ֵ��������String��double��Boolean��null
     */
	public static Map<Integer,Map<Integer,Object>> getExcelData(){
		
		UIContext uiContext = new UIContext();
		IUIWindow window = null;
		try{
			String openType = UIFactoryName.MODEL;
			String oprtState = OprtState.ADDNEW;
			
			window = UIFactory.createUIFactory(openType).create("com.kingdee.eas.wlhlcomm.client.ReadExcelUI", uiContext, null, oprtState);
			window.show();
			
			Map paramMap  = window.getUIObject().getUIContext();
			if(paramMap.containsKey(ExcelReadUtil.FileFullName) && paramMap.get(ExcelReadUtil.FileFullName) != null){
				// ����Excel��ִ�е�����������map��keyΪ�кţ���1��ʼ���ڲ�map��keyΪ�к� ��1��ʼ���ڲ�map��valueΪ��Ӧ��Ԫ���ֵ��������String��double��Boolean��null
				Map<Integer,Map<Integer,Object>> excelValues = (Map<Integer, Map<Integer, Object>>) paramMap.get(ExcelReadUtil.ExcelValues);
				// ����map���ݼ� �������� 
				return excelValues;
			}
		}catch(AbortException ae){
			MsgBox.showInfo(ae.getCause().getMessage());
			
		}catch(UIException uie){
//			logger.er
			if(uie != null && uie.getCause() != null && !AbortException.class.equals(uie.getCause().getClass()) ){
				MsgBox.showInfo(uie.getCause().getMessage());
			}
			
//			logger.error(uie.getCause(),uie);
//			SysUtil.abort();
		}
		
		return null;
	}
	/**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public static Map<Integer,Map<Integer,Object>> readExcel(String path) throws IOException {
        if (path == null || StringUtils.isBlank(path)){
            return null;
        } else {
        	String postfix=path.substring(path.lastIndexOf(".")+1);
            if (StringUtils.isNotBlank(postfix)) {
                if (XLS.equals(postfix)) {
                    return readXls(path);
                } else if (XLSX.equals(postfix)) {
                    return readXlsx(path);
                }
            }
        }
        return null;
    }

    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    public static Map<Integer,Map<Integer,Object>> readXlsx(String path) throws IOException {
    	
    	InputStream is = new FileInputStream(path);
    	BufferedInputStream in = new BufferedInputStream(is);
    	XSSFWorkbook hssfWorkbook = new XSSFWorkbook(path);
        // �����
        Map<Integer,Map<Integer,Object>> resultMap = new HashMap<Integer, Map<Integer,Object>>();

        // ֻ֧��һ��ҳǩ
        XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        if (hssfSheet == null) {
            return resultMap;
        }
        // Read the Row
        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
        	XSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow != null) {
                int colNum = hssfRow.getLastCellNum();
                Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
                // ����ŵ�MAP
                for(int i = 0; i < colNum; i++){
                	XSSFCell cell = hssfRow.getCell(i);
                	if(cell != null){
                		Object cellValue = null;
                		switch(cell.getCellType()){
	                		case XSSFCell.CELL_TYPE_BOOLEAN:
	                			cellValue = cell.getBooleanCellValue();break;
	                		case XSSFCell.CELL_TYPE_NUMERIC:
	                			cellValue = cell.getNumericCellValue();break;
	                		case XSSFCell.CELL_TYPE_STRING:
	                			cellValue = cell.getStringCellValue();break;
	                		case XSSFCell.CELL_TYPE_FORMULA:
	                			cellValue = cell.getNumericCellValue();break;
	                			default :
	                				cellValue = null;
                		}
                		// ������Map
                		rowValues.put(i+1, cellValue);
                	}
                }
                // �洢
                resultMap.put(rowNum+1, rowValues);
            }
//            }
        }
        return resultMap;
        
    }

    /**
     * ��ȡ
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @return
     * @throws IOException
     */
    public static Map<Integer,Map<Integer,Object>> readXls(String path) throws IOException {
        
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        // �����
        Map<Integer,Map<Integer,Object>> resultMap = new HashMap<Integer, Map<Integer,Object>>();
//        Map<Integer,Map<Integer,Object>> resultMap = new ExcelReadUtil
        // Read the Sheet
//        for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            if (hssfSheet == null) {
                return resultMap;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
	                int colNum = hssfRow.getLastCellNum();
	                Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
	                // ����ŵ�MAP
	                for(int i = 0; i <= colNum; i++){
	                	HSSFCell cell = hssfRow.getCell(i);
	                	if(cell != null){
	                		Object cellValue = null;
	                		switch(cell.getCellType()){
		                		case HSSFCell.CELL_TYPE_BOOLEAN:
		                			cellValue = cell.getBooleanCellValue();break;
		                		case HSSFCell.CELL_TYPE_NUMERIC:
		                			cellValue = cell.getNumericCellValue();break;
		                		case HSSFCell.CELL_TYPE_STRING:
		                			cellValue = cell.getStringCellValue();break;
		                		case HSSFCell.CELL_TYPE_FORMULA:
		                			cellValue = cell.getNumericCellValue();break;
		                			default :
		                				cellValue = null;
	                		}
	                		// ������Map
	                		rowValues.put(i+1, cellValue);
	                		
	                	}
	                }
	                // �洢
	                resultMap.put(rowNum, rowValues);
                }
              
                
//            }
        }
        return resultMap;
    }

}
