/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SettleBillListUI extends AbstractSettleBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SettleBillListUI.class);
    
    /**
     * output class constructor
     */
    public SettleBillListUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		actionImportData.setVisible(true);
		actionExportData.setVisible(true);
		btnGetMonthSum.setIcon(EASResource.getIcon("imgTbtn_get"));
		btnGetMonthSum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					exeMonthQuery();
				} catch (BOSException err) {
					handleException(err);
				}
			}});
	}

	/**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionView_actionPerformed
     */
    public void actionView_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionView_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionRefresh_actionPerformed
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRefresh_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionQuery_actionPerformed
     */
    public void actionQuery_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQuery_actionPerformed(e);
    }

    /**
     * output actionImportData_actionPerformed
     */
    public void actionImportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionImportData_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionExportData_actionPerformed
     */
    public void actionExportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportData_actionPerformed(e);
    }

    /**
     * output actionToExcel_actionPerformed
     */
    public void actionToExcel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToExcel_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionPublishReport_actionPerformed
     */
    public void actionPublishReport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPublishReport_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionQueryScheme_actionPerformed
     */
    public void actionQueryScheme_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQueryScheme_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionCopyTo_actionPerformed
     */
    public void actionCopyTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyTo_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionSendSmsMessage_actionPerformed
     */
    public void actionSendSmsMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendSmsMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actoinViewSignature_actionPerformed
     */
    public void actoinViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actoinViewSignature_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output actionTDPrint_actionPerformed
     */
    public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrint_actionPerformed(e);
    }

    /**
     * output actionTDPrintPreview_actionPerformed
     */
    public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrintPreview_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.settle.SettleBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.settle.SettleBillInfo objectValue = new com.kingdee.eas.custom.taihe.settle.SettleBillInfo();
		
        return objectValue;
    }
    @Override
	protected FilterInfo getDefaultFilterForQuery() {
		String companyID="";
		FilterInfo filter=new FilterInfo();
		if(SysContext.getSysContext().getCurrentFIUnit()!=null) {
			companyID=SysContext.getSysContext().getCurrentFIUnit().getLongNumber();
			filter.getFilterItems().add(new FilterItemInfo("company.id","select fid from t_org_company where flongnumber like '"+companyID+"%'",CompareType.INNER));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		}
		return filter;
	}
    
    protected boolean isNeedQuickQueryFilter() {
    	return true;
    }

	@Override
	protected void refresh(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.refresh(e);
	}
	
	
    
	/**
	 * 执行月度查询
	 * @throws BOSException 
	 */
	private void exeMonthQuery() throws BOSException {
		List<String> sumFieldList = getFieldSumList();
		if(sumFieldList==null||sumFieldList.size()<=0){
			return;
		}
		String[] sumFields=new String[sumFieldList.size()];
		sumFields=sumFieldList.toArray(sumFields);
		
		EntityViewInfo ev = (EntityViewInfo) this.mainQuery.clone();
		FilterItemInfo fi;
		Calendar cal= Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		

		FilterItemCollection fic = (FilterItemCollection) ev.getFilter().getFilterItems().clone();
		HashMap<String,Date> tempMap=new HashMap<String,Date>();
		String tempDateStr;
		try{
			//获取每个月日期最大值
			for(int index=0;index<fic.size();index++) {
				fi=fic.get(index);
				if(fi.getPropertyName().equalsIgnoreCase("bizDate")){
					if(fi.getCompareValue() instanceof String) {
						cal.setTime(sdf.parse(fi.getCompareValue().toString()));
					}else if (fi.getCompareValue() instanceof Date){
						cal.setTime((Date) fi.getCompareValue());
					}else if(fi.getCompareValue() instanceof Timestamp) {
						cal.setTime((Timestamp) fi.getCompareValue());
					}else {
						continue;
					}
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					
					tempDateStr=sdf.format(cal.getTime()).substring(0,7);
					if(!tempMap.containsKey(tempDateStr)) {
						tempMap.put(tempDateStr, cal.getTime());
					}else {
						if(tempMap.get(tempDateStr).before(cal.getTime())) {
							tempMap.put(tempDateStr, cal.getTime());
						}
					}
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		
		
		String[] maskArray=ev.getFilter().getMaskString().split(" ");
		ArrayList<String> tempL=new ArrayList<String>(Arrays.asList(maskArray));
		try {
			int addIndex=0;
			Date orgDate;
			CompareType orgCompareType;
			for(int index=0;index<fic.size();index++) {
				fi=fic.get(index);
				if(fi.getPropertyName().equalsIgnoreCase("bizDate")){
					if(fi.getCompareValue() instanceof String) {
						cal.setTime(sdf.parse(fi.getCompareValue().toString()));
					}else if (fi.getCompareValue() instanceof Date){
						cal.setTime((Date) fi.getCompareValue());
					}else if(fi.getCompareValue() instanceof Timestamp) {
						cal.setTime((Timestamp) fi.getCompareValue());
					}else {
						continue;
					}
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					
					//原始日期
					orgDate=cal.getTime();
					//原始对比类型
					orgCompareType=fi.getCompareType();
					tempDateStr=sdf.format(orgDate).substring(0,7);
					
					cal.set(Calendar.DAY_OF_MONTH, 1);
					fi=new FilterItemInfo("bizDate",cal.getTime(),CompareType.GREATER_EQUALS);
					ev.getFilter().getFilterItems().set(index+addIndex, fi);
					//是当前
					for(int j=0;j<tempL.size();j++) {
						if(tempL.get(j).equals("#"+String.valueOf(index))){
							tempL.add(j, "(");
							tempL.add(j+2, ")");
							tempL.add(j+2, "#X");
							tempL.add(j+2, "AND");
							break;
						}
					}
					if(orgCompareType.equals(CompareType.GREATER)||orgCompareType.equals(CompareType.GREATER_EQUALS)) {
						//原始日期就是最大日期
						if(orgDate.equals(tempMap.get(tempDateStr))) {
							//小于月末
							cal.add(Calendar.MONTH, 1);
							fi=new FilterItemInfo("bizDate",cal.getTime(),CompareType.LESS);
						}else {
							//小于最大日期
							cal.setTime(tempMap.get(tempDateStr));
							cal.add(Calendar.DAY_OF_MONTH, 1);
							fi=new FilterItemInfo("bizDate",cal.getTime(),CompareType.LESS);
						}
					}else  {
						//小于最大日期
						cal.setTime(tempMap.get(tempDateStr));
						cal.add(Calendar.DAY_OF_MONTH, 1);
						fi=new FilterItemInfo("bizDate",cal.getTime(),CompareType.LESS);
					}
					ev.getFilter().getFilterItems().insertObject(index+addIndex, fi);
					addIndex=addIndex+1;
				}
			}
			String maskStr="";
			int maskIndex=0;
			for(int index=0;index<tempL.size();index++) {
				if(tempL.get(index).contains("#")) {
					maskStr+=" #"+maskIndex++;;
				}else {
					maskStr+=" "+tempL.get(index);
				}
			}
			ev.getFilter().setMaskString(maskStr);
			
			IQueryExecutor exec =  getQueryExecutor(this.mainQueryPK,ev);
			IRowSet rs = exec.executeQuery();
			HashMap<String,BigDecimal> sumFieldesValue=new HashMap<String, BigDecimal>();
			String field;
			BigDecimal tempDecimal;
			while(rs.next()) {
				for(int index=0;index<sumFields.length;index++) {
					field=sumFields[index];
					if(!sumFieldesValue.containsKey(field)) {
						sumFieldesValue.put(field, BigDecimal.ZERO);
					}
					tempDecimal=rs.getBigDecimal(field);
					if(tempDecimal!=null) {
						sumFieldesValue.put(field,sumFieldesValue.get(field).add(tempDecimal));
					}
				}
			}
			appendMonthFootRow(tblMain, sumFields, sumFieldesValue);
		}catch(Exception err) {
			err.printStackTrace();
		}
		
	}
	
	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
	 */  
	public void appendMonthFootRow(KDTable table, String fields[],Map sumValue) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
//		Map sumValue = new HashMap();  
		// 利用getRowCount得到的行可能不正确  
		int count = table.getRowCount();  
		if(count == 0){
			count = table.getRowCount1();
		}
		if(count == 0){
			count = table.getRowCount3();
		}
//		for (int i = 0; i < fields.length; i++) {  
//			sumValue.put(fields[i], new BigDecimal("0.00"));  
//		} 
		
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}
		if(footManager.getFootRow(1)!=null) {
			footRow=footManager.getFootRow(1);
		}
		if (footRow == null) {  
			footRow = footManager.addFootRow(1);  
		}  
		// 设置合计行显示样式  
		//String colFormat = "%{0.00}f";  
		
		String colFormat = "%{0:00}f";  

		String total = "月累计";  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(50);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}  

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			DecimalFormat df1 = new DecimalFormat("###,###.##");
			footRow.getCell(fields[i]).setValue(df1.format(sumValue.get(fields[i])));  
		}  
		
	}
	
}