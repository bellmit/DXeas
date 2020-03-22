/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Component;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.freechart.ui.Align;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.stocking.processbizill.CreateReconciliationBillFacadeFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class CarryoverUI extends AbstractCarryoverUI
{
	private static final Logger logger = CoreUIObject.getLogger(CarryoverUI.class);

	/**
	 * output class constructor
	 */
	public CarryoverUI() throws Exception
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

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.toolBar.setVisible(false);
		this.prmtPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
		this.prmtPeriod.setDisplayFormat("$number$");		
		this.prmtPeriod.setEditFormat("$number$");
		this.prmtPeriod.setCommitFormat("$number$");
		this.prmtPeriod.setValue(DateUtilsComm.getUpperPeriodInfo(DateUtilsComm.getCurrentPeriodInfo()));
		final CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
		btnConfirm.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				if(prmtPeriod.getValue()==null)
					commUtils.giveUserTipsAndRetire("请填写期间");
				PeriodInfo periodInfo = (PeriodInfo)prmtPeriod.getValue();
				int n=MsgBox.showConfirm2("将"+companyInfo.getName()+periodInfo.getNumber()+"期未发生业务的对账单转至当前期间，确认请点击是");
				if(n==0){
					ArrayList<String> StatementOfAccountID=getBillIDFromLastMonth(periodInfo,DateUtilsComm.getNextPeriodInfo(null, periodInfo),companyInfo);
					if(StatementOfAccountID.size()>0){
						n=MsgBox.showConfirm2("有"+StatementOfAccountID.size()+"张结算单本期未发生业务，是否结转");
						if(n==0){
							carryover(StatementOfAccountID,DateUtilsComm.getNextPeriodInfo(null, periodInfo));
						}
					}
				}
			}
		});
	}

	/**
	 * 结转
	 * @param statementOfAccountID
	 * @param periodInfo 
	 */
	protected void carryover(ArrayList<String> statementOfAccountID, PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		JSONObject json=new JSONObject();
		json.put("list", statementOfAccountID);
		json.put("period", periodInfo.getString("id"));
		try {
			String carryoverSettleBill = CreateReconciliationBillFacadeFactory.getRemoteInstance().CarryoverSettleBill(json.toString());
			MsgBox.showInfo("结转完成");
			destroyWindow();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询待结转信息
	 * @param periodInfo
	 * @param periodInfo2
	 * @param companyInfo 
	 * @return
	 */
	private ArrayList<String> getBillIDFromLastMonth(PeriodInfo periodInfo,PeriodInfo periodInfo2, CompanyOrgUnitInfo companyInfo) {
		// TODO Auto-generated method stub
		ArrayList<String> resultArrayList = new ArrayList<String>();


		StringBuffer sb=new StringBuffer();
		//		sb.append("select").append("\n")
		//		.append("t1.FID").append("\n")
		//		.append( "from ").append("\n")
		//		.append( "CT_FM_StatementOfAccount           t1").append("\n")
		//		.append("inner join T_BD_Period     t2 on t2.FID=t1.CFPeriodsID").append("\n")
		//		.append("and t2.FID='").append(periodInfo.getString("id")).append("'").append("\n")
		//		.append("	and t1.CFClosingBalance is not null").append("\n")
		//		.append("	and t1.CFClosingBalance>0").append("\n")
		//		.append("	left  join T_BD_Period     t3 on t3.FID=t1.CFPeriodsID").append("\n")
		//		.append("	and t3.FID='").append(periodInfo2.getString("id")).append("'").append("\n")
		//		.append("		where t3.FID is null").append("\n")
		//		.append("		and t1.CFFIUnitID='").append(companyInfo.getString("id")).append("'\n");


		sb.append("select").append("\n")
		.append("t1.FID").append("\n")
		.append("from ").append("\n")
		.append("CT_FM_StatementOfAccount           t1").append("\n")
		.append("inner join T_BD_Period     t2 on t2.FID=t1.CFPeriodsID").append("\n")
		.append("and t2.FID='").append(periodInfo.getString("id")).append("'").append("\n")
		.append("	and t1.CFClosingBalance is not null").append("\n")
		.append("	and t1.CFClosingBalance>0").append("\n")
		.append("left  join ").append("\n")
		.append("(select").append("\n")
		.append("t1.CFFarmerID").append("\n")
		.append("from ").append("\n")
		.append("CT_FM_StatementOfAccount           t1").append("\n")
		.append("inner join T_BD_Period             t3 on t3.FID=t1.CFPeriodsID").append("\n")
		.append("	and t3.FID='").append(periodInfo2.getString("id")).append("'").append("\n")
		.append("	and t1.CFFIUnitID='").append(companyInfo.getString("id")).append("'\n")
		.append(") tt on tt.CFFarmerID= t1.CFFarmerID").append("\n")
		.append("where tt.CFFarmerID is null").append("\n")
		.append("   and t1.CFFIUnitID='").append(companyInfo.getString("id")).append("'\n");


		System.out.println(sb.toString());
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			while(rs.next()){
				resultArrayList.add(rs.getString("FID"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultArrayList;
	}
	@Override
	protected IObjectValue createNewData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadFields() {
		// TODO Auto-generated method stub
		super.loadFields();
		btnConfirm.requestFocus();
		btnConfirm.requestFocus(true);
	}

	@Override
	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}