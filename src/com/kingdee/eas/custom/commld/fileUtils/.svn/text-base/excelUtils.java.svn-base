package com.kingdee.eas.custom.commld.fileUtils;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import jxl.read.biff.BiffException;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.swing.KDFileChooser;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.attachment.util.Resrcs;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.client.CoreUI;
import com.kingdee.eas.tools.datatask.DIETemplateFactory;
import com.kingdee.eas.tools.datatask.DIETemplateInfo;
import com.kingdee.eas.tools.datatask.core.TaskExternalException;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

public class excelUtils {


	public static final String xlsFile_value="xls";//xls格式文件
	public static final String xlsxFile_value="xlsx";//xlsx格式文件
	/**
	 * 导出到xlsx文件
	 * @param path               需要导出的文件的路径
	 * @param sheetName          sheet页的名称
	 * @param sheetHeadTitle     sheet页表头行,字段的集合
	 * @throws EASBizException
	 * @throws IOException
	 */
	public static void exportXLSX(String path,String sheetName,String[] array) throws EASBizException, IOException {
		// TODO Auto-generated method stub

		//创建XSSFWorkbook对象
		XSSFWorkbook wb = new XSSFWorkbook();
		//创建XSSFSheet对象
		if(sheetName==null||sheetName.equals(""))
			sheetName="sheet1";
		XSSFSheet sheet = wb.createSheet(sheetName);


		sheet.setDefaultColumnWidth((short) 15); //设置表格默认宽度为15


		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);


		style.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框    
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框    
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框    
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框


		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());



		//创建XSSFRow对象
		XSSFRow row = sheet.createRow(0);
		row.setHeight((short)400);

		for(int i=0;i<6;i++){
			//创建XSSFCell对象
			XSSFCell cell=row.createCell(i);
			cell.setCellStyle(style);
			//设置单元格的值
			cell.setCellValue(array[i]);
		}
		try{
			OutputStream out = new FileOutputStream(path);  
			wb.write(out);
		}catch(Exception e2)
		{
			String errorString="模板导出失败，失败原因：";
			throw new EASBizException(new NumericExceptionSubItem("001",errorString+e2.getMessage().toString()));
		}
		int n = JOptionPane.showConfirmDialog(null, "模板导出成功，需要现在立即打开模板么，点确定立即打开，点取消退出","确定",JOptionPane.OK_CANCEL_OPTION);
		if(n==JOptionPane.OK_OPTION){
			Runtime.getRuntime().exec("cmd /c start "+path);  
		}else
		{
			SysUtil.abort();
		}
	}


	/**
	 * 导出到xls文件
	 * @param path
	 * @throws EASBizException
	 * @throws IOException
	 */
	public static void exportXLS(String path,String sheetName,String[] array) throws EASBizException, IOException {
		// TODO Auto-generated method stub

		//创建XSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建XSSFSheet对象
		HSSFSheet sheet = wb.createSheet("其他公司产品价格导入模板");


		sheet.setColumnWidth(0,(short) 15); //设置表格默认宽度为15


		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.AQUA.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);


		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框


		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setRightBorderColor(HSSFColor.BLACK.index);



		//创建XSSFRow对象
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short)400);

		for(int i=0;i<array.length;i++){
			//创建XSSFCell对象
			HSSFCell cell=row.createCell(i);
			cell.setCellStyle(style);
			//设置单元格的值
			cell.setCellValue(array[i]);
		}
		try{
			OutputStream out = new FileOutputStream(path);  
			wb.write(out);
		}catch(Exception e2)
		{
			String errorString="模板导出失败，失败原因：";
			throw new EASBizException(new NumericExceptionSubItem("001",errorString+e2.getMessage().toString()));
		}
		int n = JOptionPane.showConfirmDialog(null, "模板导出成功，需要现在立即打开模板么，点确定立即打开，点取消退出","确定",JOptionPane.OK_CANCEL_OPTION);
		if(n==JOptionPane.OK_OPTION){
			Runtime.getRuntime().exec("cmd /c start "+path);  
		}else
		{
			SysUtil.abort();
		}
	}





	/**
	 * 从excel导入数据
	 * @param filePath
	 * @throws BOSException
	 * @throws BiffException
	 * @throws IOException
	 * @throws TaskExternalException
	 * @throws EASBizException
	 */
	public static Object checkFileType(String filePath) throws BOSException, BiffException, IOException, TaskExternalException, EASBizException {
		//获取文件的扩展名
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());


		InputStream stream = new FileInputStream(filePath);
		HSSFWorkbook hssfWorkBook;
		XSSFWorkbook xssfWorkBook ;

		// Read excel file
		if (fileType.equals("xls")) {
			hssfWorkBook = new HSSFWorkbook(stream);
			if(hssfWorkBook.getNumberOfSheets()>1)
				MsgBox.showConfirm2("当前excel包含多个页签,系统将导入第一个页签的内容,确定吗");
			return hssfWorkBook;
		} else if (fileType.equals("xlsx")) {
			xssfWorkBook= new XSSFWorkbook(stream);
			if(xssfWorkBook.getNumberOfSheets()>1)
				MsgBox.showConfirm2("当前excel包含多个页签,系统将导入第一个页签的内容,确定吗");
			return xssfWorkBook;
		} else {
			MsgBox.showInfo("仅支持扩展名为xls和xlsx格式的文件");
		}
		return null;
	}




	/**
	 * 选择文件
	 * @param ui  源UI界面
	 * @return    excel文件的路径
	 */
	public static String selectFile(CoreUI ui) {
		// TODO Auto-generated method stub
		File file  = null;
		File retFile = null;
		KDFileChooser fc = new KDFileChooser(System.getProperty("user.home"));
		fc.setFileSelectionMode(0);
		fc.setMultiSelectionEnabled(false);
		int retVal = fc.showOpenDialog(ui);
		if (retVal == 1){
			file = retFile;
			SysUtil.abort();
		}

		file = fc.getSelectedFile();
		if (!file.exists()) {
			MsgBox.showInfo(Resrcs.getString("FileNotExisted"));

		}
		if (file.length() > 0x3200000L) {
			MsgBox.showInfo(Resrcs.getString("FileSizeNotAllowed"));
		} 

		final String filePath = null == file ? "" : file.getAbsolutePath();

		if (null == filePath || "".equals(filePath)) {
			return null;
		}
		return filePath;
	}

	/**
	 * 校验文件格式是否正确
	 * @param filePath 文件路径
	 * @param suffix  文件后缀或文件类别
	 */
	public static String checkFileType(String filePath, String suffix) {
		// TODO Auto-generated method stub
		if(filePath.indexOf(".")<=0)
			commUtils.giveUserTipsAndRetire("文件格式错误", "showError");

		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());

		if(suffix.equals("excel"))
			if(!fileType.equals(xlsxFile_value)&&!fileType.equals(xlsFile_value))
				commUtils.giveUserTipsAndRetire("不是有效的excel文件(xls,xlsx)","showError" );
		if(suffix.equals("xls"))
			if(!fileType.equals("xls"))
				commUtils.giveUserTipsAndRetire("不是有效的xls文件","showError" );
		if(suffix.equals("xlsx"))
			if(!fileType.equals("xlsx"))
				commUtils.giveUserTipsAndRetire("不是有效的xlsx文件","showError" );
		return fileType;
	}


	/**
	 * 获得模板属性的列数
	 * @param templateNumber
	 * @param templateName
	 * @return
	 */
	public static Object getTemplatePropCol(String templateNumber,
			String templateName) {
		// TODO Auto-generated method stub
		try {
			String str="where number='"+templateNumber+"' and name='"+templateName+"'";
			CoreBaseCollection coll = DIETemplateFactory.getRemoteInstance().getCollection(str);
			if(coll.size()==0)
				commUtils.giveUserTipsAndRetire("没有找到对应的导入导出模板", "showWarning");
			else{
				DIETemplateInfo templateInfo = (DIETemplateInfo)coll.get(0);
				return templateInfo;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 读取excel文件并返回读取的数据
	 * @param fileType
	 * @param propCol
	 * @param stream 
	 * @return
	 * @throws IOException 
	 */
	public static HashMap<Object, Object> readExcelFile(String fileType, int propCol, String filePath) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Object,Object> resultMap=new HashMap<Object,Object>();
		if (fileType.equals("xls")) {
			resultMap=readXLSExcelFile(filePath,propCol);
		} else if (fileType.equals("xlsx")) {
			resultMap=readXLSXExcelFile(filePath,propCol);
		}
		return resultMap;
	}


	/**
	 * 读取xlsx文件
	 * @param stream
	 * @param propCol
	 * @throws IOException 
	 */
	private static HashMap<Object,Object> readXLSXExcelFile(String filePath, int propCol) throws IOException {
		// TODO Auto-generated method stub
		int isBreak=0;
		InputStream stream = new FileInputStream(filePath);
		HashMap<Object,Object> returnMap=new HashMap<Object, Object>();
		XSSFWorkbook hssfWorkBook=new XSSFWorkbook(stream);
		Map<Object,Object> sheetMap=new HashMap<Object, Object>();

		for(int i=0;i<hssfWorkBook.getNumberOfSheets();i++){
			sheetMap.clear();
			XSSFSheet xssfSheet = hssfWorkBook.getSheetAt(i);
			for(int j=4;j<=xssfSheet.getLastRowNum();j++){
				Map<Object,Object> rowMap=new HashMap<Object, Object>();
				for(int k=0;k<propCol;k++){
					if(k==0&&(xssfSheet.getRow(j).getCell(k).getStringCellValue()==null||xssfSheet.getRow(j).getCell(k).getStringCellValue().equals(""))){
						isBreak=1;
						break;
					}
					rowMap.put(k, xssfSheet.getRow(j).getCell(k).getStringCellValue());
				} 
				if(rowMap.get(0)!=null)
					sheetMap.put(j, rowMap);
				if(isBreak==1)
					break;
			}
			returnMap.put(xssfSheet.getSheetName(), sheetMap);
			if(isBreak==1)
				break;
		}
		return returnMap;

	}

	/**
	 * 读取xls文件
	 * @param filePath
	 * @param propCol
	 * @return
	 * @throws IOException 
	 */
	private static HashMap<Object,Object> readXLSExcelFile(String filePath, int propCol) throws IOException {
		// TODO Auto-generated method stub
		int isBreak=0;
		InputStream stream = new FileInputStream(filePath);
		HashMap<Object,Object> returnMap=new HashMap<Object, Object>();
		HSSFWorkbook hssfWorkBook=new HSSFWorkbook(stream);
		Map<Object,Object> sheetMap=new HashMap<Object, Object>();

		for(int i=0;i<hssfWorkBook.getNumberOfSheets();i++){
			sheetMap.clear();
			HSSFSheet xssfSheet = hssfWorkBook.getSheetAt(i);
			for(int j=4;j<=xssfSheet.getLastRowNum();j++){
				Map<Object,Object> rowMap=new HashMap<Object, Object>();
				for(int k=0;k<propCol;k++){
					if(k==0&&(xssfSheet.getRow(j).getCell(k).getStringCellValue()==null||xssfSheet.getRow(j).getCell(k).getStringCellValue().equals(""))){
						isBreak=1;
						break;
					}
					rowMap.put(k, xssfSheet.getRow(j).getCell(k).getStringCellValue());
				} 
				if(rowMap.get(0)!=null)
					sheetMap.put(j, rowMap);
				if(isBreak==1)
					break;
			}
			returnMap.put(xssfSheet.getSheetName(), sheetMap);
			if(isBreak==1)
				break;
		}
		return returnMap;

	}
	/**
	 * 
	 * @param sheetNum
	 * @param beginRow
	 * @param rowNum
	 * @param colNum
	 * @param comp
	 * @return
	 */
	public static HashMap<Object, Object> readExcelFile(int beginSheet,int sheetNum,int beginRow,int rowNum,int beginCol,int colNum,Component comp){
		//step1  select a excel file
		HashMap<Object,Object> result=new HashMap<Object, Object>();

		//获取文件绝对路径
		String[] getFilePathSucceed=selectAExcelFile(comp);
		if(!StringUtils.isEmpty(getFilePathSucceed[0]))
			if("false".equalsIgnoreCase(getFilePathSucceed[0]))
				commUtils.giveUserTipsAndRetire(getFilePathSucceed[1], "error");

		if("xls".equalsIgnoreCase(getFilePathSucceed[2]))
			return readXLSExcelFile(getFilePathSucceed[1], beginSheet, sheetNum, beginRow, rowNum, beginCol, colNum);
		if("xlsx".equalsIgnoreCase(getFilePathSucceed[2]))
			return readXLSXExcelFile(getFilePathSucceed[1], beginSheet, sheetNum, beginRow, rowNum, beginCol, colNum);
		return result;
	}
	
	
	/**
	 * 将第一行作为键值的EXCEL读取方式
	 * @param sheetNum
	 * @param beginRow
	 * @param rowNum
	 * @param colNum
	 * @param comp
	 * @return
	 */
	public static HashMap<Object, Object> readExcelFileWithKey(int beginSheet,int sheetNum,int beginRow,int rowNum,int beginCol,int colNum,Component comp){
		//step1  select a excel file
		HashMap<Object,Object> result=new HashMap<Object, Object>();

		//获取文件绝对路径
		String[] getFilePathSucceed=selectAExcelFile(comp);
		if(!StringUtils.isEmpty(getFilePathSucceed[0]))
			if("false".equalsIgnoreCase(getFilePathSucceed[0]))
				commUtils.giveUserTipsAndRetire(getFilePathSucceed[1], "error");

		if("xls".equalsIgnoreCase(getFilePathSucceed[2]))
			return readXLSExcelFileWithKey(getFilePathSucceed[1], beginSheet, sheetNum, beginRow, rowNum, beginCol, colNum);
		if("xlsx".equalsIgnoreCase(getFilePathSucceed[2]))
			return readXLSXExcelFileWithKey(getFilePathSucceed[1], beginSheet, sheetNum, beginRow, rowNum, beginCol, colNum);
		return result;
	}

	/**
	 * xlxs 文件 带键值
	 * @param string
	 * @param beginSheet
	 * @param sheetNum
	 * @param beginRow
	 * @param rowNum
	 * @param beginCol
	 * @param colNum
	 * @return
	 */
	private static HashMap<Object, Object> readXLSXExcelFileWithKey(String filePath, int beginSheet, int sheetNum, int beginRow,
			int rowNum, int beginCol, int colNum) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		HashMap<Object,Object> returnMap=new HashMap<Object, Object>();
		try {
			int isBreak=0;
			InputStream stream = new FileInputStream(filePath);
			XSSFWorkbook xssfWorkBook=new XSSFWorkbook(stream);
			Map<Object,Object> sheetMap=new HashMap<Object, Object>();
			HashMap<Integer, String> keyMap = null;
			for(int i=beginSheet-1;i<xssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?xssfWorkBook.getNumberOfSheets():sheetNum);i++){//遍历所有页签
				sheetMap.clear();
				XSSFSheet xssfSheet = xssfWorkBook.getSheetAt(i);
				keyMap = new HashMap<Integer, String>();
				for(int j=beginRow-1;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//遍历所有行
					Map<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//遍历所有列（没有的话默认10）
						
						if(j == 0){
							keyMap.put(k,xssfSheet.getRow(j).getCell(k).getStringCellValue());
							continue;
						}
						if(xssfSheet.getRow(j).getCell(k) == null)
							continue;
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==1)
							rowMap.put(keyMap.get(k), xssfSheet.getRow(j).getCell(k).getStringCellValue());
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==0){
			                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(xssfSheet.getRow(j).getCell(k))) {     
			                    rowMap.put(keyMap.get(k), xssfSheet.getRow(j).getCell(k).getDateCellValue());
			                }else{
			                	xssfSheet.getRow(j).getCell(k).setCellType(1);
			                    rowMap.put(keyMap.get(k), xssfSheet.getRow(j).getCell(k).getStringCellValue());
			                }  
						}
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==3){//空
							//							rowMap.put(k, xssfSheet.getRow(j).getCell(k).getDateCellValue());
					}
				} 
				if(keyMap.size()>0 && rowMap.get(keyMap.get(0))!=null)
					sheetMap.put(j, rowMap);
			}
			returnMap.put(xssfSheet.getSheetName(), sheetMap);
		}
		stream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return returnMap;

	}

 /**
  * xls 文件  带键值
  * @param string
  * @param beginSheet
  * @param sheetNum
  * @param beginRow
  * @param rowNum
  * @param beginCol
  * @param colNum
  * @return
  */
	private static HashMap<Object, Object> readXLSExcelFileWithKey(String filePath, int beginSheet, int sheetNum, int beginRow,int rowNum, int beginCol, int colNum) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		HashMap<Object,Object> returnMap=new HashMap<Object, Object>();
		try {
			int isBreak=0;
			InputStream stream = new FileInputStream(filePath);
			HSSFWorkbook hssfWorkBook=new HSSFWorkbook(stream);
			HashMap<Object,Object> sheetMap=new HashMap<Object, Object>();

			HashMap<Integer, String> keyMap = null;
			
			for(int i=beginSheet-1;i<hssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?hssfWorkBook.getNumberOfSheets():sheetNum);i++){//遍历所有页签
				sheetMap.clear();
				HSSFSheet xssfSheet = hssfWorkBook.getSheetAt(i);
				keyMap = new HashMap<Integer, String>();
				for(int j=beginRow;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//遍历所有行
					HashMap<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//遍历所有列（没有的话默认10）
						System.out.println(i+"页"+j+"行"+k+"列");
						if(j == 0){
							keyMap.put(k,xssfSheet.getRow(j).getCell(k).getStringCellValue());
							continue;
						}
						if(xssfSheet.getRow(j).getCell(k)==null)
							continue;
						if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_BLANK){

						}
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_BOOLEAN)
							rowMap.put(keyMap.get(k), xssfSheet.getRow(j).getCell(k).getBooleanCellValue());
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_NUMERIC)
							rowMap.put(keyMap.get(k), xssfSheet.getRow(j).getCell(k).getNumericCellValue());
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_STRING)
							rowMap.put(keyMap.get(k), xssfSheet.getRow(j).getCell(k).getStringCellValue());
					} 
					if(rowMap.get(0)!=null){
						sheetMap.put(j, rowMap);
					}
				}
				returnMap.put(xssfSheet.getSheetName(), sheetMap);
				if(isBreak==1)
					break;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	
	}


	/**
	 * 选择一个excel文件
	 * @return
	 */
	private static String[] selectAExcelFile(Component comp) {
		// TODO Auto-generated method stub
		File file  = null;//文件
		String filePath=null;//文件绝对路径
		String fileExtensionName="";///文件拓展名
		KDFileChooser fc = new KDFileChooser(System.getProperty("user.home"));
		fc.setFileSelectionMode(0);//0---OPEN_DIALOG
		fc.setMultiSelectionEnabled(false);//文件单选
		int retVal = fc.showOpenDialog(comp);
		if (retVal == 1)
			SysUtil.abort();

		file=fc.getSelectedFile();


		//校验
		if (!file.exists()) 
			return new String[]{"false",(Resrcs.getString("FileNotExisted"))};
		if (file.length() > 0x3200000L) 
			return new String[]{"false",Resrcs.getString("FileSizeNotAllowed")};
		if(UIRuleUtil.isNull(file))
			return new String[]{"false","没有选择一个文件"};
		//获取绝对路径
		if(UIRuleUtil.isNotNull(file.getAbsolutePath())||file.getAbsolutePath().length()==0)
			filePath= file.getAbsolutePath();
		else
			return new String []{"false","没有匹配到文件的绝对路径"};

		//文件类型校验
		fileExtensionName=filePath.substring(filePath.lastIndexOf(".")+1, filePath.length());
		if(!StringUtils.isEmpty(fileExtensionName))
			if(!fileExtensionName.endsWith("xls")&&!fileExtensionName.endsWith("xlsx"))
				return new String[]{"false","文件不是有效的excel(.xls或.xlsx)文件"};


		return new String[]{"true",filePath,fileExtensionName};
	}

	/**
	 * 读取xls文件
	 * @param filePath
	 * @param propCol
	 * @return
	 * @throws IOException 
	 */
	private static HashMap<Object,Object> readXLSExcelFile(String filePath, int beginSheet,int sheetNum,int beginRow,int rowNum,int beginCol,int colNum) {
		// TODO Auto-generated method stub
		HashMap<Object,Object> returnMap=new HashMap<Object, Object>();
		try {
			int isBreak=0;
			InputStream stream = new FileInputStream(filePath);
			HSSFWorkbook hssfWorkBook=new HSSFWorkbook(stream);
			HashMap<Object,Object> sheetMap=new HashMap<Object, Object>();

			for(int i=beginSheet-1;i<hssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?hssfWorkBook.getNumberOfSheets():sheetNum);i++){//遍历所有页签
				sheetMap.clear();
				HSSFSheet xssfSheet = hssfWorkBook.getSheetAt(i);
				for(int j=beginRow;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//遍历所有行
					HashMap<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//遍历所有列（没有的话默认10）
						System.out.println(i+"页"+j+"行"+k+"列");
						if(xssfSheet.getRow(j).getCell(k)==null)
							continue;
						if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_BLANK){

						}
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_BOOLEAN)
							rowMap.put(k, xssfSheet.getRow(j).getCell(k).getBooleanCellValue());
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_NUMERIC)
							rowMap.put(k, xssfSheet.getRow(j).getCell(k).getNumericCellValue());
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==HSSFCell.CELL_TYPE_STRING)
							rowMap.put(k, xssfSheet.getRow(j).getCell(k).getStringCellValue());
					} 
					if(rowMap.get(0)!=null){
						sheetMap.put(j, rowMap);
					}
				}
				returnMap.put(xssfSheet.getSheetName(), sheetMap);
				if(isBreak==1)
					break;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	}


	/**
	 * 读取xlxs
	 * @param filePath
	 * @param beginSheet
	 * @param sheetNum
	 * @param beginRow
	 * @param rowNum
	 * @param beginCol
	 * @param colNum
	 * @return
	 */
	private static HashMap<Object, Object> readXLSXExcelFile(String filePath,
			int beginSheet, int sheetNum, int beginRow, int rowNum,
			int beginCol, int colNum) {
		// TODO Auto-generated method stub
		HashMap<Object,Object> returnMap=new HashMap<Object, Object>();
		try {
			int isBreak=0;
			InputStream stream = new FileInputStream(filePath);
			XSSFWorkbook xssfWorkBook=new XSSFWorkbook(stream);
			Map<Object,Object> sheetMap=new HashMap<Object, Object>();

			for(int i=beginSheet-1;i<xssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?xssfWorkBook.getNumberOfSheets():sheetNum);i++){//遍历所有页签
				sheetMap.clear();
				XSSFSheet xssfSheet = xssfWorkBook.getSheetAt(i);
				for(int j=beginRow-1;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//遍历所有行
					Map<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//遍历所有列（没有的话默认10）
						if(xssfSheet.getRow(j).getCell(k).getCellType()==1)
							rowMap.put(k, xssfSheet.getRow(j).getCell(k).getStringCellValue());
						if(xssfSheet.getRow(j).getCell(k).getCellType()==0){
			                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(xssfSheet.getRow(j).getCell(k))) {     
			                    rowMap.put(k, xssfSheet.getRow(j).getCell(k).getDateCellValue());
			                }else{
			                	xssfSheet.getRow(j).getCell(k).setCellType(1);
			                    rowMap.put(k, xssfSheet.getRow(j).getCell(k).getStringCellValue());
			                }  
						}
						if(xssfSheet.getRow(j).getCell(k).getCellType()==3){//空
							//							rowMap.put(k, xssfSheet.getRow(j).getCell(k).getDateCellValue());
					}
				} 
				if(rowMap.get(0)!=null)
					sheetMap.put(j, rowMap);
			}
			returnMap.put(xssfSheet.getSheetName(), sheetMap);
		}
		stream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return returnMap;
}
}
