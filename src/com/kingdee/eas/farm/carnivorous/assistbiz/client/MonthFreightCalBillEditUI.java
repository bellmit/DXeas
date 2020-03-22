/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.assistbiz.client;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.assistbiz.MonthFreightCalBillInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class MonthFreightCalBillEditUI extends AbstractMonthFreightCalBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MonthFreightCalBillEditUI.class);

	/**
	 * output class constructor
	 */
	public MonthFreightCalBillEditUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUIStatus();
		DataChangeListener listener=new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setMonthData();
			}			
		};
		prmtFICompany.addDataChangeListener(listener);
		prmtcustomer.addDataChangeListener(listener);
		prmtbreedData.addDataChangeListener(listener);
		prmtperiod.addDataChangeListener(listener);
	}

	//不允许编辑编号使用以下
	public void setOprtState(String oprtType){     
		super.setOprtState(oprtType);
		if (STATUS_ADDNEW.equals(this.oprtState)) {
			this.txtNumber.setEnabled(false);
		} else if (STATUS_EDIT.equals(this.oprtState)) {
			this.txtNumber.setEnabled(false);
		} else if (STATUS_VIEW.equals(this.oprtState)) {
			this.txtNumber.setEnabled(false);
		}
	} 

	private void setUIStatus() throws Exception {
		// TODO Auto-generated method stub
		if(oprtState.equalsIgnoreCase("view")){
			actionEdit_actionPerformed(null);
		}
		if(editData.getId()!=null){
			prmtFICompany.setEnabled(false);
			prmtcustomer.setEnabled(false);
			prmtbreedData.setEnabled(false);
			prmtperiod.setEnabled(false);
		}
	}

	@Override
	public void actionMonthCal_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		beforeStoreFields(e);
		storeFields();
		String fid=null;
		if(editData.getId()!=null){
			fid=editData.getId().toString();
		}
		String companyID=((IPropertyContainer)prmtFICompany.getValue()).getString("id");
		String periodID=((IPropertyContainer)prmtperiod.getValue()).getString("id");
		String breedDataID=((IPropertyContainer)prmtbreedData.getValue()).getString("id");
		String customerID=((IPropertyContainer)prmtcustomer.getValue()).getString("id");
		Boolean hasMonthFreight = StockingComm.isHasMonthFreight(null, companyID, periodID, breedDataID, customerID, fid);
		if(hasMonthFreight){
			MsgBox.showWarning("已存在同一客户/品种/年月的月运费核算记录,操作失败!");
			SysUtil.abort();
		}

		if(MsgBox.showConfirm2("将进行该客户和品种下的月运费核算,是否继续?")==MsgBox.YES){
			setMonthData();
			LongTimeDialog dialog = new LongTimeDialog((Frame) SwingUtilities.getWindowAncestor(this)); //进度栏
			dialog.setLongTimeTask(new ILongTimeTask(){		
				public void afterExec(Object obj) throws Exception {}
				public Object exec() throws Exception {
					Object obj = "success";  
					com.kingdee.eas.farm.carnivorous.assistbiz.MonthFreightCalBillFactory.getRemoteInstance().monthCal(editData);
					actionSave_actionPerformed(null);
					MsgBox.showInfo("执行成功");	
					loadFields();
					setUIStatus();
					return obj;
				}
			});
			Component[] cps=dialog.getContentPane().getComponents();  
			for(Component cp:cps){  
				if(cp instanceof JLabel){  
					((JLabel) cp).setText("正在执行中，请稍等......");  
				}  
			}  
			dialog.show();  
		}
	}

	private void setMonthData() {
		// TODO Auto-generated method stub
		if(prmtcustomer.getValue()==null||prmtFICompany.getValue()==null||prmtperiod.getValue()==null||prmtbreedData.getValue()==null){
			return;
		}
		try {
			BigDecimal allCarcassWgt=BigDecimal.ZERO,allRecSuttle=BigDecimal.ZERO;
			String breedDataID=((IPropertyContainer)prmtbreedData.getValue()).getString("id");
			String customerID=((IPropertyContainer)prmtcustomer.getValue()).getString("id");
			String companyID=((IPropertyContainer)prmtFICompany.getValue()).getString("id");
			//出肉率系数
			BigDecimal dressingPercent=StockingComm.getDressingPercent(null, companyID, customerID, breedDataID);
			txtfmRateCoe.setValue(dressingPercent);

			String periodID=((IPropertyContainer)prmtperiod.getValue()).getString("id");
			PeriodInfo period =PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(periodID));
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/SELECT sum(nvl(CFCarcassWgt,0)) allCarcassWgt,sum(nvl(CFRecSuttle,0)) allRecSuttle FROM CT_FM_CSlaughterBill  ")
			.append(" where CFBreedDataID='"+breedDataID+"' and CFCustomerID='"+customerID+"' ")
			.append(" and to_char(fbizdate,'yyyyMM')='"+period.getNumber()+"'")
			.append(" and CFFICompanyID='"+companyID+"'")
			.append(" and cfbillStatus=4")
			.append(" group by CFBreedDataID,CFCustomerID "); 
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			if(rs.next()){
				allCarcassWgt=rs.getBigDecimal("allCarcassWgt");
				allRecSuttle=rs.getBigDecimal("allRecSuttle");
				BigDecimal aveFmRate = allRecSuttle.signum()==0?BigDecimal.ZERO:allCarcassWgt.divide(allRecSuttle,10,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
				txtmonthCarcassWgt.setValue(allCarcassWgt);
				txtmonthRecSuttle.setValue(allRecSuttle);
				txtmonthAvgFmRate.setValue(aveFmRate.multiply(dressingPercent).setScale(2,RoundingMode.HALF_UP));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public boolean checkBeforeWindowClosing() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.assistbiz.MonthFreightCalBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.assistbiz.MonthFreightCalBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.assistbiz.MonthFreightCalBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setPeriod(DateUtilsComm.getCurrentPeriodInfo());
		return objectValue;
	}

}