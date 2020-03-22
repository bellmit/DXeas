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


	public static final String xlsFile_value="xls";//xls��ʽ�ļ�
	public static final String xlsxFile_value="xlsx";//xlsx��ʽ�ļ�
	/**
	 * ������xlsx�ļ�
	 * @param path               ��Ҫ�������ļ���·��
	 * @param sheetName          sheetҳ������
	 * @param sheetHeadTitle     sheetҳ��ͷ��,�ֶεļ���
	 * @throws EASBizException
	 * @throws IOException
	 */
	public static void exportXLSX(String path,String sheetName,String[] array) throws EASBizException, IOException {
		// TODO Auto-generated method stub

		//����XSSFWorkbook����
		XSSFWorkbook wb = new XSSFWorkbook();
		//����XSSFSheet����
		if(sheetName==null||sheetName.equals(""))
			sheetName="sheet1";
		XSSFSheet sheet = wb.createSheet(sheetName);


		sheet.setDefaultColumnWidth((short) 15); //���ñ��Ĭ�Ͽ��Ϊ15


		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);


		style.setBorderBottom(XSSFCellStyle.BORDER_THIN); //�±߿�    
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);//��߿�    
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);//�ϱ߿�    
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);//�ұ߿�


		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());



		//����XSSFRow����
		XSSFRow row = sheet.createRow(0);
		row.setHeight((short)400);

		for(int i=0;i<6;i++){
			//����XSSFCell����
			XSSFCell cell=row.createCell(i);
			cell.setCellStyle(style);
			//���õ�Ԫ���ֵ
			cell.setCellValue(array[i]);
		}
		try{
			OutputStream out = new FileOutputStream(path);  
			wb.write(out);
		}catch(Exception e2)
		{
			String errorString="ģ�嵼��ʧ�ܣ�ʧ��ԭ��";
			throw new EASBizException(new NumericExceptionSubItem("001",errorString+e2.getMessage().toString()));
		}
		int n = JOptionPane.showConfirmDialog(null, "ģ�嵼���ɹ�����Ҫ����������ģ��ô����ȷ�������򿪣���ȡ���˳�","ȷ��",JOptionPane.OK_CANCEL_OPTION);
		if(n==JOptionPane.OK_OPTION){
			Runtime.getRuntime().exec("cmd /c start "+path);  
		}else
		{
			SysUtil.abort();
		}
	}


	/**
	 * ������xls�ļ�
	 * @param path
	 * @throws EASBizException
	 * @throws IOException
	 */
	public static void exportXLS(String path,String sheetName,String[] array) throws EASBizException, IOException {
		// TODO Auto-generated method stub

		//����XSSFWorkbook����
		HSSFWorkbook wb = new HSSFWorkbook();
		//����XSSFSheet����
		HSSFSheet sheet = wb.createSheet("������˾��Ʒ�۸���ģ��");


		sheet.setColumnWidth(0,(short) 15); //���ñ��Ĭ�Ͽ��Ϊ15


		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.AQUA.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);


		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //�±߿�    
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//��߿�    
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);//�ϱ߿�    
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);//�ұ߿�


		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setRightBorderColor(HSSFColor.BLACK.index);



		//����XSSFRow����
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short)400);

		for(int i=0;i<array.length;i++){
			//����XSSFCell����
			HSSFCell cell=row.createCell(i);
			cell.setCellStyle(style);
			//���õ�Ԫ���ֵ
			cell.setCellValue(array[i]);
		}
		try{
			OutputStream out = new FileOutputStream(path);  
			wb.write(out);
		}catch(Exception e2)
		{
			String errorString="ģ�嵼��ʧ�ܣ�ʧ��ԭ��";
			throw new EASBizException(new NumericExceptionSubItem("001",errorString+e2.getMessage().toString()));
		}
		int n = JOptionPane.showConfirmDialog(null, "ģ�嵼���ɹ�����Ҫ����������ģ��ô����ȷ�������򿪣���ȡ���˳�","ȷ��",JOptionPane.OK_CANCEL_OPTION);
		if(n==JOptionPane.OK_OPTION){
			Runtime.getRuntime().exec("cmd /c start "+path);  
		}else
		{
			SysUtil.abort();
		}
	}





	/**
	 * ��excel��������
	 * @param filePath
	 * @throws BOSException
	 * @throws BiffException
	 * @throws IOException
	 * @throws TaskExternalException
	 * @throws EASBizException
	 */
	public static Object checkFileType(String filePath) throws BOSException, BiffException, IOException, TaskExternalException, EASBizException {
		//��ȡ�ļ�����չ��
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());


		InputStream stream = new FileInputStream(filePath);
		HSSFWorkbook hssfWorkBook;
		XSSFWorkbook xssfWorkBook ;

		// Read excel file
		if (fileType.equals("xls")) {
			hssfWorkBook = new HSSFWorkbook(stream);
			if(hssfWorkBook.getNumberOfSheets()>1)
				MsgBox.showConfirm2("��ǰexcel�������ҳǩ,ϵͳ�������һ��ҳǩ������,ȷ����");
			return hssfWorkBook;
		} else if (fileType.equals("xlsx")) {
			xssfWorkBook= new XSSFWorkbook(stream);
			if(xssfWorkBook.getNumberOfSheets()>1)
				MsgBox.showConfirm2("��ǰexcel�������ҳǩ,ϵͳ�������һ��ҳǩ������,ȷ����");
			return xssfWorkBook;
		} else {
			MsgBox.showInfo("��֧����չ��Ϊxls��xlsx��ʽ���ļ�");
		}
		return null;
	}




	/**
	 * ѡ���ļ�
	 * @param ui  ԴUI����
	 * @return    excel�ļ���·��
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
	 * У���ļ���ʽ�Ƿ���ȷ
	 * @param filePath �ļ�·��
	 * @param suffix  �ļ���׺���ļ����
	 */
	public static String checkFileType(String filePath, String suffix) {
		// TODO Auto-generated method stub
		if(filePath.indexOf(".")<=0)
			commUtils.giveUserTipsAndRetire("�ļ���ʽ����", "showError");

		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());

		if(suffix.equals("excel"))
			if(!fileType.equals(xlsxFile_value)&&!fileType.equals(xlsFile_value))
				commUtils.giveUserTipsAndRetire("������Ч��excel�ļ�(xls,xlsx)","showError" );
		if(suffix.equals("xls"))
			if(!fileType.equals("xls"))
				commUtils.giveUserTipsAndRetire("������Ч��xls�ļ�","showError" );
		if(suffix.equals("xlsx"))
			if(!fileType.equals("xlsx"))
				commUtils.giveUserTipsAndRetire("������Ч��xlsx�ļ�","showError" );
		return fileType;
	}


	/**
	 * ���ģ�����Ե�����
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
				commUtils.giveUserTipsAndRetire("û���ҵ���Ӧ�ĵ��뵼��ģ��", "showWarning");
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
	 * ��ȡexcel�ļ������ض�ȡ������
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
	 * ��ȡxlsx�ļ�
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
	 * ��ȡxls�ļ�
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

		//��ȡ�ļ�����·��
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
	 * ����һ����Ϊ��ֵ��EXCEL��ȡ��ʽ
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

		//��ȡ�ļ�����·��
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
	 * xlxs �ļ� ����ֵ
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
			for(int i=beginSheet-1;i<xssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?xssfWorkBook.getNumberOfSheets():sheetNum);i++){//��������ҳǩ
				sheetMap.clear();
				XSSFSheet xssfSheet = xssfWorkBook.getSheetAt(i);
				keyMap = new HashMap<Integer, String>();
				for(int j=beginRow-1;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//����������
					Map<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//���������У�û�еĻ�Ĭ��10��
						
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
						else if(xssfSheet.getRow(j).getCell(k).getCellType()==3){//��
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
  * xls �ļ�  ����ֵ
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
			
			for(int i=beginSheet-1;i<hssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?hssfWorkBook.getNumberOfSheets():sheetNum);i++){//��������ҳǩ
				sheetMap.clear();
				HSSFSheet xssfSheet = hssfWorkBook.getSheetAt(i);
				keyMap = new HashMap<Integer, String>();
				for(int j=beginRow;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//����������
					HashMap<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//���������У�û�еĻ�Ĭ��10��
						System.out.println(i+"ҳ"+j+"��"+k+"��");
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
	 * ѡ��һ��excel�ļ�
	 * @return
	 */
	private static String[] selectAExcelFile(Component comp) {
		// TODO Auto-generated method stub
		File file  = null;//�ļ�
		String filePath=null;//�ļ�����·��
		String fileExtensionName="";///�ļ���չ��
		KDFileChooser fc = new KDFileChooser(System.getProperty("user.home"));
		fc.setFileSelectionMode(0);//0---OPEN_DIALOG
		fc.setMultiSelectionEnabled(false);//�ļ���ѡ
		int retVal = fc.showOpenDialog(comp);
		if (retVal == 1)
			SysUtil.abort();

		file=fc.getSelectedFile();


		//У��
		if (!file.exists()) 
			return new String[]{"false",(Resrcs.getString("FileNotExisted"))};
		if (file.length() > 0x3200000L) 
			return new String[]{"false",Resrcs.getString("FileSizeNotAllowed")};
		if(UIRuleUtil.isNull(file))
			return new String[]{"false","û��ѡ��һ���ļ�"};
		//��ȡ����·��
		if(UIRuleUtil.isNotNull(file.getAbsolutePath())||file.getAbsolutePath().length()==0)
			filePath= file.getAbsolutePath();
		else
			return new String []{"false","û��ƥ�䵽�ļ��ľ���·��"};

		//�ļ�����У��
		fileExtensionName=filePath.substring(filePath.lastIndexOf(".")+1, filePath.length());
		if(!StringUtils.isEmpty(fileExtensionName))
			if(!fileExtensionName.endsWith("xls")&&!fileExtensionName.endsWith("xlsx"))
				return new String[]{"false","�ļ�������Ч��excel(.xls��.xlsx)�ļ�"};


		return new String[]{"true",filePath,fileExtensionName};
	}

	/**
	 * ��ȡxls�ļ�
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

			for(int i=beginSheet-1;i<hssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?hssfWorkBook.getNumberOfSheets():sheetNum);i++){//��������ҳǩ
				sheetMap.clear();
				HSSFSheet xssfSheet = hssfWorkBook.getSheetAt(i);
				for(int j=beginRow;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//����������
					HashMap<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//���������У�û�еĻ�Ĭ��10��
						System.out.println(i+"ҳ"+j+"��"+k+"��");
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
	 * ��ȡxlxs
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

			for(int i=beginSheet-1;i<xssfWorkBook.getNumberOfSheets()&&i<(sheetNum==-1?xssfWorkBook.getNumberOfSheets():sheetNum);i++){//��������ҳǩ
				sheetMap.clear();
				XSSFSheet xssfSheet = xssfWorkBook.getSheetAt(i);
				for(int j=beginRow-1;j<=xssfSheet.getLastRowNum()&&j<=(rowNum==-1?xssfSheet.getLastRowNum():rowNum);j++){//����������
					Map<Object,Object> rowMap=new HashMap<Object, Object>();
					for(int k=beginCol-1;k<(colNum==-1?10:colNum);k++){//���������У�û�еĻ�Ĭ��10��
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
						if(xssfSheet.getRow(j).getCell(k).getCellType()==3){//��
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
