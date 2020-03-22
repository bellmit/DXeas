/**
 * output package name
 */
package com.kingdee.eas.custom.stockprice.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.EventListener;
import jxl.read.biff.BiffException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;


import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.attachment.util.Resrcs;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.ICurrency;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.fileUtils.excelUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.tools.datatask.client.FileSelector;
import com.kingdee.eas.tools.datatask.core.TaskExternalException;
import com.kingdee.eas.tools.datatask.export.ExternalExcelDataWriter;
import com.kingdee.eas.tools.datatask.export.ExternalExcelDataWriter2007;
import com.kingdee.eas.tools.datatask.export.IExternalDataWriter;
import com.kingdee.eas.tools.datatask.util.GlobalFunction;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDFileChooser;
import com.kingdee.bos.ctrl.swing.KDProgressBar;

/**
 * output class name
 */
@SuppressWarnings("serial")
public class BasePriceOfOtherCompanyEditUI extends AbstractBasePriceOfOtherCompanyEditUI
{
	@SuppressWarnings("unused")
	private static final Logger logger = CoreUIObject.getLogger(BasePriceOfOtherCompanyEditUI.class);


	int errorRow=0;//出错行数
	int remindTimes=0;//提醒次数
	private IExternalDataWriter writer = null;

	/**
	 * output class constructor
	 */
	public BasePriceOfOtherCompanyEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyInfo objectValue = new com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBillStatus(com.kingdee.eas.custom.stockprice.billStatus.save);
		objectValue.setBizDate(new Date());
		objectValue.setEffectDate(new Date());
		return objectValue;
	}

	/**
	 * 用户可以一次性选择基本价格维护单上所有的物料，从而只维护价格
	 */
	@Override
	public void actionGetAllMaterial_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		String str = "select t2.fid fid,t3.fid baseUnitID from T_SD_MaterialBasePrice t1 inner join T_BD_Material t2  on t2.fid=t1.FMaterialID";
		str+=" inner join T_BD_MeasureUnit t3 on t2.FBaseUnit=t3.fid order by t2.fnumber";
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
		if(rs.size()==0){
			MsgBox.showInfo("未获取到基本价格维护单据上的物料信息");
			SysUtil.abort();

		}
		kdtEntrys.removeRows();
		IMaterial materialInstance = MaterialFactory.getRemoteInstance();

		//获得币种：CNY
		String strCurrency = "select fid from t_bd_Currency where fnumber='BB01' or fname_l2='人民币'";
		IRowSet rsCurrency = SQLExecutorFactory.getRemoteInstance(strCurrency).executeSQL();
		CurrencyInfo CNY=null;
		if(rsCurrency.next())
			CNY = CurrencyFactory.getRemoteInstance().getCurrencyInfo(new ObjectUuidPK(rsCurrency.getString("fid")));

		IMeasureUnit IMeasureUnit = MeasureUnitFactory.getRemoteInstance();
		while(rs.next()){
			MaterialInfo material = materialInstance.getMaterialInfo(new ObjectUuidPK(rs.getString("fid")));
			kdtEntrys.addRow();

			//物料基本信息
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "material").setValue(material);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "materialNum").setValue(material.getNumber());
			//			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "model").setValue(material.getModel());

			//基本计量单位
			MeasureUnitInfo measureUnit = IMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("baseUnitID")));
			if(measureUnit==null)    		
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "unit").getStyleAttributes().setLocked(false);
			else    			
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "unit").setValue(measureUnit);

			//规格型号
			if(material.getModel()!=null)
				if(!material.getModel().equals(""))
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "model").setValue(material.getModel());

			//币别
			if(CNY==null)
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "currency").getStyleAttributes().setLocked(false);
			else
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "currency").setValue(CNY);
		}
		super.actionGetAllMaterial_actionPerformed(e);
	}
	/**
	 * 导出模板到excel
	 */
	@Override
	public void actionExpModel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub	
		FileSelector fselector = new FileSelector(this, "SAVE");
		fselector.setDefFileName("其他公司价格导入模板");
		fselector.show();
		if (fselector.isCanceled())
		{
			SysUtil.abort();
		}

		String path= fselector.getData().toString();
		if(path==null)
			return;
		String fileType = GlobalFunction.getFileExtension(path);
		if (this.writer == null) {
			if ("xls".equals(fileType))
			{
				this.writer = new ExternalExcelDataWriter();
				this.writer.setLocacle(SysContext.getSysContext().getLocale());
			}
			else if ("xlsx".equals(fileType)) {
				this.writer = new ExternalExcelDataWriter2007();
				this.writer.setLocacle(SysContext.getSysContext().getLocale()); 
				((ExternalExcelDataWriter2007)this.writer).setExportTemplate(true);
			} 
			else{
				throw  new EASBizException(new NumericExceptionSubItem("001","导出的文件必须是.xls或.xlsx文件"));
			}
		}
		String sheetName = "其他公司价格导入模板";
		if (StringUtils.isEmpty(sheetName)) {
			sheetName = "sheet" ;
		}


		//.xlsx文件
		if (this.writer instanceof ExternalExcelDataWriter2007) {
			((ExternalExcelDataWriter2007)this.writer).setSheetName(sheetName);
			exportXLSX(path);
		}
		//.xls文件
		if (this.writer instanceof ExternalExcelDataWriter) {
			((ExternalExcelDataWriter)this.writer).setSheetName(sheetName);
			exportXLS(path);
		}

	}



	/**
	 * 导出到xls文件
	 * @param path
	 * @throws EASBizException
	 * @throws IOException
	 */
	private void exportXLS(String path) throws EASBizException, IOException {
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

		String[] array={"物料编码","物料名称","规格型号","基本计量单位","币别","价格"};
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
	 * 导出到xlsx文件
	 * @param path
	 * @throws EASBizException
	 * @throws IOException
	 */
	private void exportXLSX(String path) throws EASBizException, IOException {
		// TODO Auto-generated method stub

		//创建XSSFWorkbook对象
		XSSFWorkbook wb = new XSSFWorkbook();
		//创建XSSFSheet对象
		XSSFSheet sheet = wb.createSheet("其他公司产品价格导入模板");


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

		String[] array={"物料编码","物料名称","规格型号","基本计量单位","币别","价格"};
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
	 * 从excel导入分录信息
	 */
	@Override
	public void actionImpExcel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		actionImpEntity();
		super.actionImpExcel_actionPerformed(e);
	}


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kdtEntrys.getColumn("material").setWidth(180);
		kdtEntrys.getColumn("price").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("unit").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
		kdtEntrys.getColumn("currency").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);


		setMaterialFilter();
		setUIFormat();
	}

	/**
	 * 设置界面格式
	 */
	private void setUIFormat() {
		// TODO Auto-generated method stub
		btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		unAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		btnCreateFrom.setVisible(false);
		btnMultiapprove.setVisible(false);
		btnAddLine.setVisible(false);
		btnInsertLine.setVisible(false);
		btnRemoveLine.setVisible(false);
		btnAuditResult.setVisible(false);
		btnTraceDown.setVisible(false);
		btnTraceUp.setVisible(false);

		this.setUITitle("外部公司价格");
		pkBizDate.setEnabled(false);
	}
	/**
	 * 设置分录物料的过滤条件
	 */
	private void setMaterialFilter() {
		// TODO Auto-generated method stub
		Component obj = kdtEntrys.getColumn("material").getEditor().getComponent();
		if(obj instanceof KDBizPromptBox){
			KDBizPromptBox f7 = (KDBizPromptBox)obj;
			f7.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");
			EntityViewInfo evi=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("number","02-%",CompareType.LIKE));
			//			filter.getFilterItems().add(new FilterItemInfo("adminCU.id","at4AAAAAAHDM567U",CompareType.EQUALS));
			evi.setFilter(filter);
			f7.setEntityViewInfo(evi);
		}
	}
	/*
	 * 导入分录
	 * @see 
	 */
	public void actionImpEntity() throws Exception {
		File file  = null;
		File retFile = null;
		KDFileChooser fc = new KDFileChooser(System.getProperty("user.home"));
		fc.setFileSelectionMode(0);
		fc.setMultiSelectionEnabled(false);
		int retVal = fc.showOpenDialog(this);
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
			return;
		}
		impExcel(filePath);
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
	private void impExcel(String filePath) throws BOSException, BiffException, IOException, TaskExternalException, EASBizException {
		//获取文件的扩展名
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());


		InputStream stream = new FileInputStream(filePath);
		HSSFWorkbook hssfWorkBook;
		XSSFWorkbook xssfWorkBook ;

		// Read excel file
		if (fileType.equals("xls")) {
			hssfWorkBook = new HSSFWorkbook(stream);
			if(hssfWorkBook.getNumberOfSheets()>1&&remindTimes==0)
				showConfirmDialog("当前excel包含多个页签,系统将导入第一个页签的内容,确定吗");
			readExcelEndWithXLS(hssfWorkBook);
		} else if (fileType.equals("xlsx")) {
			xssfWorkBook= new XSSFWorkbook(stream);
			if(xssfWorkBook.getNumberOfSheets()>1&&remindTimes==0)
				showConfirmDialog("当前excel包含多个页签,系统将导入第一个页签的内容,确定吗");
			readExcelEndWithXlsx(xssfWorkBook);

		} else {
			MsgBox.showInfo("仅支持扩展名为xls和xlsx格式的文件");
		}
	}


	class entry{
		String materialNum;
		String materialName;
		String unit;
		String model;
		String currency;
		BigDecimal price;
	}

	/**
	 * 读取.xls文件
	 * @param xssfWorkBook
	 * @throws TaskExternalException 
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void readExcelEndWithXlsx(XSSFWorkbook xssfWorkBook) throws TaskExternalException, EASBizException, BOSException {
		// TODO Auto-generated method stub

		entry entry = new entry();


		int rows=1;
		XSSFSheet xssfSheet = xssfWorkBook.getSheetAt(0);

		if(errorRow>0){
			int n=JOptionPane.showConfirmDialog(null, "点击是从"+String.valueOf(errorRow+1)+"行继续导入，点否重新导入，点取消则取消导入","Confirm",JOptionPane.YES_NO_CANCEL_OPTION);
			if(n==JOptionPane.YES_OPTION){}
			else if(n==JOptionPane.NO_OPTION){
				errorRow=1;
				kdtEntrys.removeRows();
			}
			else if(n==JOptionPane.CANCEL_OPTION){
				SysUtil.abort();
			}
		}
		if(errorRow==0)
			errorRow=1;
		//忽略第一行表头文件  

		ICurrency ICurrency = CurrencyFactory.getRemoteInstance();
		IMeasureUnit IMeasureUnit = MeasureUnitFactory.getRemoteInstance();
		IMaterial IMaterial = MaterialFactory.getRemoteInstance();


		for(int i=errorRow;i<=xssfSheet.getLastRowNum();i++){
			for(int j=0;j<6;j++){

				valiateDateType(i,j,xssfSheet.getRow(i).getCell(j));
				if(j==0){
					entry.materialNum = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(j==1)
					entry.materialName = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==2)
					entry.model = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==3)
					entry.unit = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==4)
					entry.currency = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==5)
					entry.price =new BigDecimal(String.valueOf(xssfSheet.getRow(i).getCell(j).getNumericCellValue()));
			}
			valiacte(entry,i,ICurrency,IMeasureUnit,IMaterial);
			rows++;
		}
	}
	/**
	 *校验单元格数据是否为空  或者 数据格式是否正确
	 * @param xssfSheet  xlsx格式
	 * @param i     行号-1
	 * @param cell  单元格
	 * @throws EASBizException 
	 */
	private void valiateDateType( int i,int j, XSSFCell cell) throws EASBizException {
		// TODO Auto-generated method stub
		if(j==0){
			if(3==cell.getCellType())
				throwEASBizException(i, "编码字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "编码格式错误");
		}
		else if(j==1){
			if(3==cell.getCellType())
				throwEASBizException(i, "名称字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "名称格式错误");
		}
		else if(j==2){
			if(3==cell.getCellType())
				throwEASBizException(i, "规格型号字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "规格型号格式错误");
		}
		else if(j==3){
			if(3==cell.getCellType())
				throwEASBizException(i, "计量单位字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "计量单位格式错误");
		}
		else if(j==4){
			if(3==cell.getCellType())
				throwEASBizException(i, "币别字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "币别格式错误");
		}
		else if(j==5){
			if(3==cell.getCellType())
				throwEASBizException(i, "价格字段为空");
			if(0!=cell.getCellType())
				throwEASBizException(i, "编码格式错误");
		}
	}


	private void valiateDateType(int i, int j, HSSFCell cell) throws EASBizException {
		// TODO Auto-generated method stub
		if(j==0){
			if(3==cell.getCellType())
				throwEASBizException(i, "编码字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "编码格式错误");
		}
		else if(j==1){
			if(3==cell.getCellType())
				throwEASBizException(i, "名称字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "名称格式错误");
		}
		else if(j==2){
			if(3==cell.getCellType())
				throwEASBizException(i, "规格型号字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "规格型号格式错误");
		}
		else if(j==3){
			if(3==cell.getCellType())
				throwEASBizException(i, "计量单位字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "计量单位格式错误");
		}
		else if(j==4){
			if(3==cell.getCellType())
				throwEASBizException(i, "币别字段为空");
			if(1!=cell.getCellType())
				throwEASBizException(i, "币别格式错误");
		}
		else if(j==5){
			if(3==cell.getCellType())
				throwEASBizException(i, "价格字段为空");
			if(0!=cell.getCellType())
				throwEASBizException(i, "编码格式错误");
		}
	}


	/**
	 * 校验导入的数据是否有问题
	 * 没有的话  分录增加该行数据
	 * @param material 
	 * @param measureUnit 
	 * @param currency 
	 */
	private void valiacte(entry entry,int i, ICurrency currency, IMeasureUnit measureUnit, IMaterial material) throws TaskExternalException, EASBizException {
		// TODO Auto-generated method stub
		kdtEntrys.addRow();
		IRow IRow = kdtEntrys.getRow(kdtEntrys.getRowCount()-1);
		try {
			//物料编码
			CoreBaseCollection coll =material.getCollection(" where number='"+entry.materialNum+"'");
			if(coll.size()==0){
				throwEASBizException(i,"找不到编码为"+entry.materialNum+"的物料");
			}else
				IRow.getCell("materialNum").setValue(entry.materialNum);

			//名称
			coll = MaterialFactory.getRemoteInstance().getCollection(" where name='"+entry.materialName+"'");
			if(coll.size()==0){
				throwEASBizException(i,"找不到名称为"+entry.materialName+"的物料");
			}

			//物料
			coll = material.getCollection(" where number='"+entry.materialNum+"' and name='"+entry.materialName+"'");
			if(coll.size()==0){
				throwEASBizException(i,"物料编码与名称不匹配");
			}else
				IRow.getCell("material").setValue((MaterialInfo)coll.get(0));

			//规格型号
			String str = " where number='"+entry.materialNum+"' and name='"+entry.materialName+"'";
			//			coll = material.getCollection( );
			if(entry.model!=null)
				if(!entry.model.equals(""))
					str+=" and model='"+entry.model+"'";
			coll = material.getCollection(str);
			if(coll.size()==0){
				throwEASBizException(i,"物料编码与规格型号不匹配");
			}else
				IRow.getCell("model").setValue(entry.model);

			//基本计量单位
			coll = measureUnit.getCollection(" where name='"+entry.unit+"'");
			if(coll.size()==0){
				throwEASBizException(i,"找不到名称为"+entry.unit+"的计量单位");
			}
			else
				IRow.getCell("unit").setValue((MeasureUnitInfo) coll.get(0));

			//币别
			coll = currency.getCollection(" where name='"+entry.currency+"'");
			if(coll.size()==0){
				throwEASBizException(i,"找不到名称为"+entry.currency+"的币别");
			}else
				IRow.getCell("currency").setValue((CurrencyInfo) coll.get(0));

			//价格
			IRow.getCell("price").setValue(entry.price);

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 抛出异常
	 * @param i                    行号-1
	 * @param error                错误提示
	 * @throws EASBizException
	 */
	public void throwEASBizException(int i,String error) throws EASBizException{
		errorRow=i;
		kdtEntrys.removeRow(kdtEntrys.getRowCount()-1);
		throw new EASBizException(new NumericExceptionSubItem("001","第"+String.valueOf(i+1)+"行出错;出错原因："+error));
	}
	/**
	 * 读取.xlsx文件
	 * @param hssfWorkBook
	 * @throws TaskExternalException 
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void readExcelEndWithXLS(HSSFWorkbook hssfWorkBook) throws TaskExternalException, EASBizException, BOSException {
		// TODO Auto-generated method stub
		entry entry = new entry();


		int rows=1;
		HSSFSheet xssfSheet = hssfWorkBook.getSheetAt(0);

		if(errorRow>0){
			int n=JOptionPane.showConfirmDialog(null, "点击是从"+String.valueOf(errorRow+1)+"行继续导入，点否重新导入，点取消则取消导入","Confirm",JOptionPane.YES_NO_CANCEL_OPTION);
			if(n==JOptionPane.YES_OPTION){}
			else if(n==JOptionPane.NO_OPTION){
				errorRow=1;
				kdtEntrys.removeRows();
			}
			else if(n==JOptionPane.CANCEL_OPTION){
				SysUtil.abort();
			}
		}
		if(errorRow==0)
			errorRow=1;


		ICurrency ICurrency = CurrencyFactory.getRemoteInstance();
		IMeasureUnit IMeasureUnit = MeasureUnitFactory.getRemoteInstance();
		IMaterial IMaterial = MaterialFactory.getRemoteInstance();


		//忽略第一行表头文件  
		for(int i=errorRow;i<=xssfSheet.getLastRowNum();i++){
			for(int j=0;j<6;j++){

				if(j==0){
					valiateDateType(i,j,xssfSheet.getRow(i).getCell(j));
					entry.materialNum = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(j==1)
					entry.materialName = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==2)
					entry.model = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==3)
					entry.unit = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==4)
					entry.currency = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				else if(j==5)
					entry.price =new BigDecimal(String.valueOf(xssfSheet.getRow(i).getCell(j).getNumericCellValue()));
			}
			valiacte(entry,i, ICurrency, IMeasureUnit, IMaterial);
			rows++;
		}
	}

	/**
	 * 弹出确定框，是则继续，否则退出
	 * @param string        提示消息
	 * remindTimes          仅提示一次
	 */
	private void showConfirmDialog(String string) {
		// TODO Auto-generated method stub
		if(MsgBox.showConfirm2(this, string)!=0)
			SysUtil.abort();
		remindTimes=1;
	}



	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
	}





	/**
	 * 单据状态变化后刷新界面
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		reloadData();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		reloadData();
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		reloadData();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		reloadData();
	}

	//	public class ProgressBar implements ActionListener, ChangeListener {
	//
	//	    JFrame frame = null;
	//
	//	    JProgressBar progressbar;
	//
	//	    JLabel label;
	//
	//	    Timer timer;
	//
	//	    JButton b;
	//
	//	 
	//
	//	    public ProgressBar() {
	//
	//	       frame = new JFrame("进度条简单示例");
	//
	//	       frame.setBounds(100, 100, 400, 130);
	//
	//	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//
	//	       frame.setResizable(false);
	//
	//	       Container contentPanel = frame.getContentPane();
	//
	//	       label = new JLabel("点击运行按钮开始", JLabel.CENTER);
	//
	//	       progressbar = new JProgressBar();
	//
	//	       progressbar.setOrientation(JProgressBar.HORIZONTAL);
	//
	//	       progressbar.setMinimum(0);
	//
	//	       progressbar.setMaximum(100);
	//
	//	       progressbar.setValue(0);
	//
	//	       progressbar.setStringPainted(true);
	//
	//	       progressbar.addChangeListener(this);
	//
	//	       progressbar.setPreferredSize(new Dimension(300, 20));
	//
	//	       progressbar.setBorderPainted(true);
	//
	//	       progressbar.setBackground(Color.pink);
	//
	//	 
	//
	//	       JPanel panel = new JPanel();
	//
	//	       b = new JButton("运行");
	//
	//	       b.setForeground(Color.blue);
	//
	//	       b.addActionListener(this);
	//
	//	       panel.add(b);
	//
	//	       timer = new Timer(100, this);
	//
	//	       contentPanel.add(panel, BorderLayout.NORTH);
	//
	//	       contentPanel.add(label, BorderLayout.CENTER);
	//
	//	       contentPanel.add(progressbar, BorderLayout.SOUTH);
	//
	//	       // frame.pack();
	//
	//	       frame.setVisible(true);
	//
	//	    }
	//
	//	 
	//
	//	    public void actionPerformed(ActionEvent e) {
	//
	//	       if (e.getSource() == b) {
	//
	//	           timer.start();
	//
	//	       }
	//
	//	       if (e.getSource() == timer) {
	//
	//	           int value = progressbar.getValue();
	//
	//	           if (value < 100)
	//
	//	              progressbar.setValue(++value);
	//
	//	           else {
	//
	//	              timer.stop();
	//
	//	              frame.dispose();
	//
	//	           }
	//
	//	       }
	//
	//	 
	//
	//	    }
	//
	//	 
	//
	//	    public void stateChanged(ChangeEvent e1) {
	//
	//	       int value = progressbar.getValue();
	//
	//	       if (e1.getSource() == progressbar) {
	//
	//	           label.setText("目前已完成进度：" + Integer.toString(value) + "%");
	//
	//	           label.setForeground(Color.blue);
	//
	//	       }
	//
	//	 
	//
	//	    }
	//

}