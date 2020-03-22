package com.kingdee.eas.custom.purchasebudget.client;

import java.awt.Component;
import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.appframework.databinding.DataBinder;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.StringUtils;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.cp.cpmm.client.PurchaseBillEditUI;
import com.kingdee.eas.custom.purchasebudget.PurBudgetEntryFactory;
import com.kingdee.eas.custom.purchasebudget.PurBudgetEntryInfo;
import com.kingdee.eas.custom.purchasebudget.PurBudgetInfo;
import com.kingdee.eas.custom.purchasebudget.billStatus;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.scm.im.inv.client.StockTransferBillEditUI;
import com.kingdee.eas.scm.sm.pur.PurOrder;
import com.kingdee.eas.scm.sm.pur.PurOrderEntry;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryFactory;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.scm.sm.pur.client.PurOrderEditUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

public class PurOrderClientDep {

	protected static String purOrgUnitID="";
	protected static int periodNum;
	public static void PurOrderOnloadSetting(final UIParam param){
		final KDTable kdTable = param.getKDTable("kdtEntries");


		KDBizPromptBox kdtEntrys_period_PromptBox = new KDBizPromptBox();
		kdtEntrys_period_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");
		kdtEntrys_period_PromptBox.setVisible(true);
		kdtEntrys_period_PromptBox.setEditable(true);
		kdtEntrys_period_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_period_PromptBox.setEditFormat("$number$");
		kdtEntrys_period_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_period_CellEditor = new KDTDefaultCellEditor(kdtEntrys_period_PromptBox);
		kdTable.getColumn("period").setEditor(kdtEntrys_period_CellEditor);
		ObjectValueRender kdtEntrys_period_OVR = new ObjectValueRender();
		kdtEntrys_period_OVR.setFormat(new BizDataFormat("$number$"));
		kdTable.getColumn("period").setRenderer(kdtEntrys_period_OVR);


		KDBizPromptBox kdtEntrys_budgetRow_PromptBox = new KDBizPromptBox();
		kdtEntrys_budgetRow_PromptBox.setQueryInfo("com.kingdee.eas.custom.purchasebudget.app.purBudgetEntryQuery");
		kdtEntrys_budgetRow_PromptBox.setVisible(true);
		kdtEntrys_budgetRow_PromptBox.setEditable(true);
		kdtEntrys_budgetRow_PromptBox.setDisplayFormat("$material$");
		kdtEntrys_budgetRow_PromptBox.setEditFormat("$material$");
		kdtEntrys_budgetRow_PromptBox.setCommitFormat("$material$");
		KDTDefaultCellEditor kdtEntrys_BudgetRow_CellEditor = new KDTDefaultCellEditor(kdtEntrys_budgetRow_PromptBox);
		kdTable.getColumn("budgetRow").setEditor(kdtEntrys_BudgetRow_CellEditor);
		ObjectValueRender kdtEntrys_budgetRow_OVR = new ObjectValueRender();
		kdtEntrys_budgetRow_OVR.setFormat(new BizDataFormat("$material$"));
		kdTable.getColumn("budgetRow").setRenderer(kdtEntrys_budgetRow_OVR);


		kdTable.addKDTEditListener(new KDTEditListener(){

			@Override
			public void editCanceled(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void editStarted(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				if("budgetRow".equals(kdTable.getColumn(arg0.getColIndex()).getKey())){
					if(param.getKDBizPromptBox("prmtPurchaseOrgUnit").getValue()==null){
						MsgBox.showInfo("采购组织不能为空");
						SysUtil.abort();
					}
					else
						purOrgUnitID=((PurchaseOrgUnitInfo)param.getKDBizPromptBox("prmtPurchaseOrgUnit").getValue()).getNumber();
					if(kdTable.getCell(arg0.getRowIndex(), "period").getValue()==null){
						MsgBox.showInfo("会计期间不能为空");
						SysUtil.abort();
					}else
						periodNum=((PeriodInfo)kdTable.getCell(arg0.getRowIndex(), "period").getValue()).getNumber();


					Component obj = kdTable.getColumn("budgetRow").getEditor().getComponent();
					KDBizPromptBox f7 = null;
					if(obj instanceof KDBizPromptBox)
						f7=(KDBizPromptBox)obj;
					f7.setEntityViewInfo(getEntityViewInfo(purOrgUnitID,periodNum));
				}

			}

			/**
			 * 设置
			 * @param purOrgUnitID
			 * @param periodNum
			 * @return
			 */
			private EntityViewInfo getEntityViewInfo(String purOrgUnitID,
					int periodNum) {
				// TODO Auto-generated method stub
				EntityViewInfo evi=new EntityViewInfo();
				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("period.number",periodNum,CompareType.EQUALS));
				filterInfo.getFilterItems().add(new FilterItemInfo("company.number",purOrgUnitID,CompareType.EQUALS));
				filterInfo.getFilterItems().add(new FilterItemInfo("parent.billStatus",billStatus.AUDIT_VALUE,CompareType.EQUALS));
				evi.setFilter(filterInfo);
				return evi;
			}

			@Override
			public void editStarting(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void editStopping(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void editValueChanged(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}});
	}


	/*
	 *设置selector
	 */
	public static SelectorItemCollection afterGetSelectors(SelectorItemCollection  sic)
	{
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.period.*"));
		}
		else{
			sic.add(new SelectorItemInfo("entries.period.id"));
			sic.add(new SelectorItemInfo("entries.period.number"));
		}
		return sic;
	}
	/**
	 * 单据加载时加载预算行
	 * @param param
	 * @throws SQLException 
	 * @throws BOSException 
	 */
	public void setPurOrderEntryPurBudgetInfo(UIParam param) throws BOSException, SQLException{



		PurOrderEditUI ui = (PurOrderEditUI) param.getUI();
		KDTable kdTable = param.getKDTable("kdtEntries");
		PurOrderInfo info = (PurOrderInfo) ui.getEditData();
		PurOrderEntryInfo entryInfo =null;
		PurBudgetEntryInfo pbBudgetEntryInfo=null;
		for(int i=0;i<info.getEntries().size();i++){
			entryInfo = info.getEntries().get(i);
			if(entryInfo.getId()!=null){
				pbBudgetEntryInfo=getBudgetRowInfo(entryInfo.getId().toString());
				kdTable.getCell(i, "budgetRow").setValue(pbBudgetEntryInfo);
			}
		}
	}


	/**
	 * 根据采购订单的分录id获取预算分录行的info
	 * @param string
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private PurBudgetEntryInfo getBudgetRowInfo(String purOrderEntryID) throws BOSException, SQLException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("select CFBudgetRowID from T_SM_PurOrderEntry ");
		sb.append(" where fid='").append(purOrderEntryID).append("'");
		sb.append(" and CFBudgetRowID is not null");

		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
		if(rs.next()){
			CoreBaseCollection coll = PurBudgetEntryFactory.getRemoteInstance().getCollection("where ID='"+rs.getString("CFBudgetRowID")+"'");
			if(coll.size()>0)
				return (PurBudgetEntryInfo)coll.get(0);
		}
		return null;
	} 
}
