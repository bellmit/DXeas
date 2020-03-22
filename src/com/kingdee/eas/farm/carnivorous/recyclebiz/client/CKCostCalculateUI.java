/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.service.job.wrapper.SqlExecutor;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.workflow.report.IProcessInstanceListUIFacade.InitData;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostCalFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CKCostCalculateUI extends AbstractCKCostCalculateUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKCostCalculateUI.class);

	/**
	 * output class constructor
	 */
	public CKCostCalculateUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUI();
		initData();
	}

	private void initUI() throws Exception {
		// TODO Auto-generated method stub
		setUITitle("商品代成本计算");
		// prmtCompany		
		prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
		prmtCompany.setEditable(true);		
		prmtCompany.setDisplayFormat("$name$");		
		prmtCompany.setEditFormat("$number$");		
		prmtCompany.setCommitFormat("$number$");		
		prmtCompany.setRequired(true);
		setOrgF7(prmtCompany, OrgType.getEnum("Company"));
		// prmtperiod		
		this.prmtPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
		this.prmtPeriod.setEditable(true);		
		this.prmtPeriod.setDisplayFormat("$number$");		
		this.prmtPeriod.setEditFormat("$number$");		
		this.prmtPeriod.setCommitFormat("$number$");		
		this.prmtPeriod.setRequired(true);
		for (int i = 0; i < this.toolBar.getComponents().length; i++) {
			this.toolBar.getComponent(i).setVisible(false);
		}

		kdtEntrys.getStyleAttributes().setLocked(true);
	}

	protected void setOrgF7(KDBizPromptBox f7,OrgType orgType) throws Exception
	{
		NewOrgUnitFilterInfoProducer oufip = new NewOrgUnitFilterInfoProducer(orgType);
		oufip.getModel().setIsCUFilter(true);
		f7.setFilterInfoProducer(oufip);
	}

	private void initData() {
		// TODO Auto-generated method stub
		prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		try {
			prmtPeriod.setValue(DateUtilsComm.getUpperPeriodInfo(DateUtilsComm.getCurrentPeriodInfo()));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String companyID=((IPropertyContainer)prmtCompany.getValue()).getString("id");
		PeriodInfo period = StockingComm.getPeriodFromCloseAccount(null, companyID);
		if(period!=null){
			prmtPeriod.setValue(period);
		}
	}

	private void verifyInput() {
		// TODO Auto-generated method stub
		if(prmtCompany.getValue()==null){
			MsgBox.showWarning("公司未填写!");
			SysUtil.abort();
		}
		if(prmtPeriod.getValue()==null){
			MsgBox.showWarning("期间未填写!");
			SysUtil.abort();
		}	
	}

	@Override
	protected void btnCostCal_actionPerformed(ActionEvent e) throws Exception {
		verifyInput();
		dealWork();
		execQuery();
	}
	@Override
	protected void btnExit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		actionExitCurrent_actionPerformed(e);
	}

	@Override
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		verifyInput();
		execQuery();
	}

	private void execQuery() {
		String companyID=((IPropertyContainer)prmtCompany.getValue()).getString("id");
		String periodID=((IPropertyContainer)prmtPeriod.getValue()).getString("id");
		kdtEntrys.removeRows();
		try {
			PeriodInfo period=PeriodFactory.getRemoteInstance().getPeriodInfo(new ObjectUuidPK(periodID));
			StringBuffer sqlBuf = new StringBuffer();sqlBuf.append(" /*dialect*/ ")
			.append(" SELECT   t.breedData breedData,  ")
			.append(" sum(t.CFSeedCost) CFSeedCost,  ")
			.append(" sum(t.CFFodderCost) CFFodderCost, ")
			.append(" sum(t.CFDrugCost) CFDrugCost , ")
			.append(" sum(t.CFAllocateAmt) CFAllocateAmt, ")
			.append(" sum(t.CFDyFee) CFDyFee, ")
			.append(" sum(t.otherMatCost) otherMatCost, ")
			.append(" sum(peCost) peCost  ")
			.append(" FROM (select t2.fname_l2 breedData,  ")
			.append(" sum(CFSeedCost) CFSeedCost,  ")
			.append(" sum(CFFodderCost) CFFodderCost, ")
			.append(" sum(CFDrugCost) CFDrugCost , ")
			.append(" sum(CFAllocateAmt) CFAllocateAmt, ")
			.append(" sum(CFDyFee) CFDyFee, ")
			.append(" sum(CFOtherMatCost) otherMatCost, ")
			.append(" 0 peCost  ")
			.append(" from CT_FM_CKSettleBill t1 ")
			.append(" inner join T_FM_BreedData t2 on t1.CFBreedDataID=t2.fid ")
			.append(" where CFBillStatus in (4,7)  ")
			.append(" and t1.CFPeriodID = '"+period.getId()+"' ")
			.append(" and t1.CFFICompanyID='"+companyID+"' ")
			.append(" group by t2.fname_l2 ").append(" union all  ")
			.append(" SELECT  ").append(" t2.fname_l2 breedData,  ")
			.append(" 0 CFSeedCost,  ").append(" 0 CFFodderCost, ")
			.append(" 0 CFDrugCost , ").append(" 0 CFAllocateAmt, ")
			.append(" 0 CFDyFee, 0 CFOtherMatCost, ").append(" sum(cfpecost) pecost ")
			.append(" FROM CT_FM_CKPECostbill t1 ")
			.append(" inner join T_FM_BreedData t2 on t1.CFBreedDataID=t2.fid ")
			.append(" inner join  T_BD_Period t3 on t3.fid=t1.CFPeriodID ")
			.append(" where t1.CFFICompanyID='"+companyID+"' ")
			.append(" and t3.fid = '"+period.getId()+"' ")
			.append(" group by  t2.fname_l2)t  ")
			.append(" group by t.breedData ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			while(rs.next()){
				IRow row = kdtEntrys.addRow();
				row.getCell("breedData").setValue(rs.getString("breedData"));
				row.getCell("seedCost").setValue(rs.getBigDecimal("CFSeedCost"));
				row.getCell("fodderCost").setValue(rs.getBigDecimal("CFFodderCost"));
				row.getCell("drugCost").setValue(rs.getBigDecimal("CFDrugCost"));
				row.getCell("allocateAmt").setValue(rs.getBigDecimal("CFAllocateAmt"));
				row.getCell("dyFee").setValue(rs.getBigDecimal("CFDyFee"));
				row.getCell("peCost").setValue(rs.getBigDecimal("pecost"));
				row.getCell("otherMatCost").setValue(rs.getBigDecimal("otherMatCost"));
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	private void dealWork() throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		final String companyID=((IPropertyContainer)prmtCompany.getValue()).getString("id");
		final String periodID=((IPropertyContainer)prmtPeriod.getValue()).getString("id");
		boolean isClosed = CKCloseAccountFacadeFactory.getRemoteInstance().checkIsClosed(companyID, periodID);
		if(!isClosed){

			if(MsgBox.showConfirm2("本期未关账是否继续？")!=MsgBox.YES){
				SysUtil.abort();
			}
		}

		if(MsgBox.showConfirm2("即将执行所选期间的成本计算操作,耗时较长,是否继续?")!=MsgBox.YES){
			SysUtil.abort();
		}
		LongTimeDialog dialog = new LongTimeDialog( (Frame) SwingUtilities.getWindowAncestor(this)); 
		dialog.setLongTimeTask(new ILongTimeTask() {
			public Object exec() throws Exception { 
				Object obj = "sunx"; 
				// 查询的数据赋值与表格 
				CKCostCalFacadeFactory.getRemoteInstance().calCost(companyID, periodID);
				return obj; 
			} 

			public void afterExec(Object result) throws Exception {
				MsgBox.showInfo("成本计算完成！"); 
			} 
		}); 
		Component[] cps=dialog.getContentPane().getComponents(); 
		for(Component cp:cps){ 
			if(cp instanceof JLabel){ 
				((JLabel) cp).setText("成本计算执行中......."); 
			} 
		} 
		dialog.show(); 		
	}
}