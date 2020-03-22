/**
 * output package name
 */
package com.kingdee.eas.custom.wages.farm.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.wages.getWorkmonthFacadeFactory;
import com.kingdee.eas.custom.wages.farm.WagesFarmOrganFactory;
import com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo;
import com.kingdee.eas.custom.wages.food.BasicPostFoodFactory;
import com.kingdee.eas.custom.wages.food.BasicPostFoodInfo;
import com.kingdee.eas.custom.wages.food.WageFoodOrganFactory;
import com.kingdee.eas.custom.wages.food.WageFoodOrganInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.sun.xml.bind.util.Which;

/**
 * output class name
 */
public class MonthBillFarmEditUI extends AbstractMonthBillFarmEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MonthBillFarmEditUI.class);
    
    /**
     * output class constructor
     */
    public MonthBillFarmEditUI() throws Exception
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
    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.food.client.AbstractMonthFoodBillEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onShow();
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
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
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
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
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
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
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
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
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
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
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
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
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
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
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
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output actionUnaudit_actionPerformed
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnaudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取本季度所有需要发放工资的人员信息
	 */
    public void actionGetPerson_actionPerformed(ActionEvent e) throws Exception
    {
    	super.actionGetPerson_actionPerformed(e);
		if(pkbegindate.getValue()==null||pkenddate.getValue()==null){
			MsgBox.showWarning("请先选择核算期间！");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//((KDComboBox)kdtEntrys.getColumn("meteunit").getEditor().getComponent()).setSelectedItem(UnitOfMetering.OUTPUT_VALUE);
		IRowSet rs = getExeQueryRowSet();
		kdtEntrys.removeRows();
		PersonInfo p = new PersonInfo();
		PositionInfo pt = new PositionInfo();
		WagesFarmOrganInfo  winfo = new WagesFarmOrganInfo();
		while(rs.next()){
			kdtEntrys.addRow();
			int month = 0;
			String id = rs.getString("personid"); //ID  
			IObjectPK pk = new ObjectStringPK(id); //主键 
			p = PersonFactory.getRemoteInstance().getPersonInfo(pk);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "person").setValue(p);
			String pid = rs.getString("positionid"); //ID  
			IObjectPK pk1 = new ObjectStringPK(pid); //主键 
			pt = PositionFactory.getRemoteInstance().getPositionInfo(pk1);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "position").setValue(pt);
			String wid = rs.getString("formcompany"); //ID  
			IObjectPK pk2 = new ObjectStringPK(wid); //主键 
			winfo = WagesFarmOrganFactory.getRemoteInstance().getWagesFarmOrganInfo(pk2);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "company").setValue(winfo);
			
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "banknumber").setValue(rs.getString("banknumber"));
			if(rs.getString("timeofentry")==null){
				//Date timeofentry = format.parse(rs.getString("timeofentry"));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "timeofentry").setValue(new Date());
				String date = format.format(new Date());
				month = getWorkmonthFacadeFactory.getRemoteInstance().getworkmonth(date);
			}else{
				Date timeofentry = format.parse(rs.getString("timeofentry"));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "timeofentry").setValue(timeofentry);
				month = getWorkmonthFacadeFactory.getRemoteInstance().getworkmonth(rs.getString("timeofentry"));
			}
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "attendanceday").setValue(rs.getString("Attendanceday"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "personnumber").setValue(rs.getString("personcard"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "actualattenday").setValue(rs.getString("Actualattendance"));
			//kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "jgzbx").setValue(rs.getString("jkzbx"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "postwages").setValue(rs.getString("PostSalary"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "basicwages").setValue(rs.getString("Basicwages"));
			//月补助和节假日补助
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Holidayallow").setValue(rs.getString("Yearsub"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "MonthSubsidy").setValue(rs.getString("Monthsub"));
			
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "batchamount").setValue(rs.getString("batchamount"));	
			//计件工资
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "jjgz").setValue(rs.getString("jjgz"));
			//考核工资
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "assessmentwages").setValue(rs.getString("Assesswages"));
			//工龄工资
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "agewages").setValue(rs.getString("Rzhpbkh"));
//			if(month<24&&month>=12){
//				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "agewages").setValue("100");
//			}else if(month<36&&month>=24){
//				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "agewages").setValue("150");
//			}else if(month<48&&month>=36){
//				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "agewages").setValue("200");
//			}else if(month<60&&month>=48){
//				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "agewages").setValue("250");
//			}else if(month>=60){
//				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "agewages").setValue("300");
//			}else{
//				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "agewages").setValue("0");
//			}
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "wsgjl").setValue("0");
			//kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "timewages").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "overtimeH").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "nightwages").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "fybl").setValue(rs.getString("EpidemicSub"));
			//日综合考核
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Dailyevaluation").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Dailevadeduction").setValue(rs.getString("Rzhpbkhkk"));

			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "wsgjl").setValue(rs.getString("Wsgjl"));
			//考勤工资 （实际出勤-应出勤） 基本工资
			BigDecimal assessmentwages = new BigDecimal(rs.getString("Actualattendance"));
			assessmentwages = assessmentwages.subtract(new BigDecimal(rs.getString("Attendanceday")));
			BigDecimal Basicwages = new BigDecimal(rs.getString("Basicwages"));
			String monthday = getWorkmonthFacadeFactory.getRemoteInstance().getDaySub(pkbegindate.getText(), pkenddate.getText());
			//System.out.println(kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Dailyevaluation").getValue().toString());
			//System.out.println(kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "fybl").getValue().toString());
			Basicwages = Basicwages.add(new BigDecimal(kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Dailyevaluation").getValue().toString()));
			Basicwages = Basicwages.add(new BigDecimal(kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "fybl").getValue().toString()));
			Basicwages = Basicwages.divide(new BigDecimal(monthday),2,BigDecimal.ROUND_HALF_UP);
			assessmentwages = assessmentwages.multiply(Basicwages);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "checkworkwages").setValue(assessmentwages);
			
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "recruitwages").setValue(rs.getString("recruitwages"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "qualitydebit").setValue(rs.getString("qualitydebit"));			
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "notificationwages").setValue(rs.getString("notificationwages"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "repairmonth").setValue("0");
			//kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "jgzbx").setValue(rs.getString("jkzbx"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "persontax").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Deductedloss").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Accidentinsurance").setValue(rs.getString("Accidentinsurance"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "adjustAmount").setValue(rs.getString("adjustAmount"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "yj").setValue(rs.getString("yj"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "subsidywages").setValue("0");
			
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Accidentinsurance").setValue(rs.getString("CFDkywx"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Deductedloss").setValue(rs.getString("CFFk"));
			
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "timewages").setValue(rs.getString("Timeamount"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "socialsecurity").setValue(rs.getString("Gryjf"));

		}	
    }
    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取本季度所有需要发放工资的人员信息SQL
	 */
    private IRowSet getExeQueryRowSet() throws BOSException {
//    	String id = this.prmtWageOrganization.getData().toString();
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t3.FName_l2 name,").append(sp);
		sql.append("t3.FID personid,").append(sp);
		sql.append("t18.FID formcompany,").append(sp);
		sql.append("t3.FNumber personnumber,").append(sp);
		sql.append("t3.Fidcardno personcard,").append(sp);
		sql.append("t1.CFPostSalary PostSalary,").append(sp);
		sql.append("t1.CFFrompositionID FrompositionID,").append(sp);
		sql.append("nvl(t1.CFBasicwages,0) Basicwages,").append(sp);
		sql.append("t1.CFMonthSubsidy MonthSubsidy,").append(sp);
		sql.append("t1.CFHolidayallow Holidayallow,").append(sp);
		sql.append("nvl(t1.CFEpidemicSub,0) EpidemicSub,").append(sp);
		sql.append("t14.FName_l2 positionname,").append(sp);
		sql.append("t14.FID positionid,").append(sp);
		sql.append("t14.FNumber positionnumber,").append(sp);
		sql.append("t5.银行卡号  banknumber,").append(sp);
		sql.append("to_char(t5.入职日期,'yyyy-MM-dd')  timeofentry,").append(sp);
		sql.append("nvl(t6.招聘奖励,0) recruitwages,").append(sp);
		sql.append("nvl(t6.健康证报销,0) jkzbx,").append(sp);
		sql.append("nvl(t7.奖罚金额,0) notificationwages,").append(sp);
		sql.append("nvl(t8.扣款金额,0) qualitydebit,").append(sp);
		sql.append("nvl(t9.调整金额,0) adjustAmount,").append(sp);
		sql.append("nvl(t4.Attendanceday,0) Attendanceday,").append(sp);
		sql.append("nvl(t4.Actualattendance,0) Actualattendance,").append(sp);
		sql.append("t4.Late Late,").append(sp);
		sql.append("t4.Privite Privite,").append(sp);
		sql.append("t4.Sickleave Sickleave,").append(sp);
		sql.append("t4.Businesstravel Businesstravel,").append(sp);
		//计件工资
		sql.append("nvl(t12.Payamount,0) jjgz,").append(sp);
		sql.append("nvl(t12.Wsgjl,0) Wsgjl,").append(sp);
		sql.append("nvl(t12.CFYj,0) yj,").append(sp);
		//考勤工资
		sql.append("nvl(t13.Assesswages,0) Assesswages,").append(sp);
		//综合评比考核
		//计件工资
		sql.append("nvl(t15.Rzhpbkh,0) Rzhpbkh,").append(sp);
		sql.append("nvl(t15.Rzhpbkhkk,0) Rzhpbkhkk,").append(sp);
		sql.append("nvl(t15.CFDkywx,0) CFDkywx,").append(sp);
		sql.append("nvl(t15.CFFk,0) CFFk,").append(sp);
		sql.append("nvl(t15.CFMonthsub,0) Monthsub,").append(sp);
		sql.append("nvl(t15.CFYearsub,0) Yearsub,").append(sp);
		sql.append("nvl(t15.CFBatchWage,0) batchamount,").append(sp);
		//工时工资
		sql.append("nvl(t16.CFSumwages,0) Timeamount,").append(sp);
		//代扣社保
		sql.append("nvl(t11.CFGryjf,0) Gryjf,").append(sp);
		sql.append("(case when nvl(t11.CFGryjf,0)=0 then 27 else 0 end) Accidentinsurance").append(sp);
		sql.append("from ").append(sp);
		sql.append("CT_FAR_BasicPostFarm t1").append(sp);
		sql.append("inner join CT_FAR_BasicPostFarmEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("inner join T_BD_Person t3 on t3.FID = t2.CFPersonID").append(sp);
		
		//sql.append("inner join T_BD_Person t3 on t3.FID = t2.CFPersonID").append(sp);
		sql.append("inner join CT_FAR_WagesFarmOrgan t18 on t18.FID = t1.CFFrompositionID").append(sp);
		sql.append("left join (select t2.CFPersonID personid,t2.CFAttendanceday Attendanceday,t2.CFActualattendance Actualattendance,t2.CFLate Late,t2.CFPrivite Privite,t2.CFSickleave Sickleave,t2.CFBusinesstravel Businesstravel from ").append(sp);
		sql.append("CT_FAR_TAttendFarmRecord t1 ").append(sp);
		sql.append("inner join CT_FAR_TAttendFarmRecordEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t4 on t4.personid = t2.CFPersonID").append(sp);
		sql.append("left join ( select t2.CFPersonID fid,t2.CFPerson 员工姓名,t2.CFPersonnumber 员工编码,t2.CFBankcard 银行卡号,t2.CFEnterdate 入职日期   from  CT_WAG_WagesPersonInfo t1").append(sp);
		sql.append("inner join CT_WAG_WagesPersonInfoEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append(") t5 on t5.fid = t2.CFPersonID").append(sp);
		sql.append("left join ( select t2.CFPersonID fid,t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,t2.CFAmount 招聘奖励,t2.CFHealthCar 健康证报销   from  CT_WAG_HRwages t1").append(sp);
		sql.append("inner join CT_WAG_HRwagesEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t6 on t6.fid = t2.CFPersonID").append(sp);
		sql.append("left join ( select t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,sum(t2.CFAmount) 奖罚金额   from  CT_WAG_Qualityawardticket t1").append(sp);
		sql.append("inner join CT_WAG_QualityawardticketEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber").append(sp);
		sql.append(") t7 on t7.员工id = t2.CFPersonID").append(sp);
		sql.append("left join ( select t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,sum(t2.CFAmount) 扣款金额   from  CT_WAG_ProControlWithhold t1").append(sp);
		sql.append("inner join CT_WAG_ProControlWithholdEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber").append(sp);
		sql.append(") t8 on t8.员工id = t2.CFPersonID").append(sp);
		//调整金额
		sql.append("left join ( select t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,sum(t2.CFAmount) 调整金额   from  CT_FAR_AdjustFarmmoney t1").append(sp);
		sql.append("inner join CT_FAR_AdjustFarmmoneyEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber").append(sp);
		sql.append(") t9 on t9.员工id = t2.CFPersonID").append(sp);
		
		sql.append("inner join CT_FAR_WagesFarmOrgan t10 on t10.FID = t1.CFFrompositionID").append(sp);
		sql.append("left join (select t7.fbizdate,t8.CFperson,t8.CFDwjn,t8.CFGryjf,t8.CFPersonnumber from CT_WAG_EmploySecurity t7").append(sp);
		sql.append("inner join CT_WAG_EmploySecurityEntry t8 on t8.FParentID = t7.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t7.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t7.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t11 on t11.CFPersonnumber = t3.FNumber").append(sp);
		sql.append("left join (").append(sp);
		sql.append("select").append(sp);
		sql.append("t2.CFPersonID personid,").append(sp);
		sql.append("t2.CFWsgjl Wsgjl,").append(sp);
		sql.append("t2.CFYj CFYj,").append(sp);
		sql.append("t2.CFPayamount Payamount").append(sp);
		sql.append("from CT_FAR_MotorcadePayroll t1").append(sp);
		sql.append("inner join CT_FAR_MotorcadePayrollEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t12 on t12.personid = t2.CFPersonID").append(sp);
		sql.append("left join (").append(sp);
		sql.append("select").append(sp);
		sql.append("t2.CFPersonID personid,").append(sp);
		sql.append("t2.CFAssesswages Assesswages").append(sp);
		sql.append("from CT_FAR_HatchAssess t1").append(sp);
		sql.append("inner join CT_FAR_HatchAssessEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t13 on t13.personid = t2.CFPersonID").append(sp);
		sql.append("inner join T_ORG_Position t14 on t14.FID = t1.CFPositionID").append(sp);
		sql.append("inner join T_ORG_Admin t17 on t17.FID = t14.FAdminOrgUnitID").append(sp);
		sql.append("left join (").append(sp);
		sql.append("select").append(sp);
		sql.append("t2.CFPersonID,").append(sp);
		sql.append("t2.CFDkywx CFDkywx,").append(sp);
		sql.append("t2.CFFk CFFk,").append(sp);
		//sql.append("t2.CFFybt CFFybt,").append(sp);
		sql.append("t2.CFRzhpbkh Rzhpbkh,").append(sp);
		sql.append("t2.CFMonthsub CFMonthsub,").append(sp);
		sql.append("t2.CFYearsub CFYearsub,").append(sp);
		sql.append("t2.CFBatchWage CFBatchWage,").append(sp);
		sql.append("t2.CFRzhpbkhkk Rzhpbkhkk").append(sp);
		sql.append("from CT_FAR_FarmRating t1").append(sp);
		sql.append("inner join CT_FAR_FarmRatingEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t15 on t15.CFPersonID =  t2.CFPersonID").append(sp);
		
		sql.append("left join (").append(sp);
		sql.append("select t2.CFPersonID,t2.CFSumwages from CT_FAR_MaintenTeam t1").append(sp);
		sql.append("inner join CT_FAR_MaintenTeamEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t16 on t16.CFPersonID =  t2.CFPersonID").append(sp);
		
		sql.append("order by t17.FNumber").append(sp);
    	System.out.println(sql.toString());
		IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
    }

    /**
     * output actionWagecalculation_actionPerformed
     */
    public void actionWagecalculation_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.TEMPORARILYSAVED)) {
			super.actionWagecalculation_actionPerformed(e);
			MsgBox.showWarning("计算完成！");
			refreshCurPage();
    	}else{
    		commUtils.giveUserTipsAndRetire("只能在保存状态下计算！");
    	}
		refreshCurPage();
    }
    /**
	 * output actionSubmit_actionPerformed
	 * 刷新操作
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}  

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.farm.MonthBillFarmFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo objectValue = new com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        return objectValue;
    }

}