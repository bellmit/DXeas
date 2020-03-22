/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class StockingBatchListUI extends AbstractStockingBatchListUI
{
	private static final Logger logger = CoreUIObject.getLogger(StockingBatchListUI.class);

	/**
	 * output class constructor
	 */
	public StockingBatchListUI() throws Exception
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
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		try{
			super.actionRemove_actionPerformed(e);
		}catch(BOSException e1){
			MsgBox.showError(e1.getMessage());
			SysUtil.abort();
		}
	}

	/**
	 * output tblMain_tableClicked method
	 */
	protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
	{
		super.tblMain_tableClicked(e);
	}


	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory.getRemoteInstance();
	}

	/**
	 * output getTreeInterface method
	 */
	protected ITreeBase getTreeInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.basedata.StockingBatchTreeFactory.getRemoteInstance();
	}

	/**
	 * output getGroupEditUIName method
	 */
	protected String getGroupEditUIName()
	{
		return com.kingdee.eas.farm.stocking.basedata.client.StockingBatchTreeEditUI.class.getName();
	}

	/**
	 * output getQueryFieldName method
	 */
	protected String getQueryFieldName()
	{
		return "treeid.id";
	}

	/**
	 * output getKeyFieldName method
	 */
	protected String getKeyFieldName()
	{
		return "id";
	}

	/**
	 * output getRootName method
	 */
	protected String getRootName()
	{
		return "批次信息";
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo();

		return objectValue;
	}

	@Override
	protected boolean isIgnoreCUFilter() {
			return true;
	}


	//设置组织隔离
	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		FilterInfo filter = new FilterInfo();
		CompanyOrgUnitInfo companyFI = SysContext.getSysContext().getCurrentFIUnit();
		if(companyFI == null){
			MsgBox.showInfo("当前组织不是财务组织,无法进行相关操作!");
			SysUtil.abort();
		}

		if(!companyFI.isIsBizUnit()){
			MsgBox.showInfo("当前登录组织为虚体组织,请切换到实体组织进行相关操作");
			SysUtil.abort();
		}
		filter.getFilterItems().add(new FilterItemInfo("company.id", companyFI.getId().toString(), CompareType.EQUALS));

		//修改为库存组织可查看下面所有养殖场记录
		StorageOrgUnitInfo storageInfo = SysContext.getSysContext().getCurrentStorageUnit();
		Set ids=new HashSet<String>();
		ids.add("yusheID");
		if(!storageInfo.isIsCompanyOrgUnit()){
			String id=storageInfo.getId().toString();
			String sql="select distinct t1.fid from T_FM_StockingBatch t1 inner join T_FM_Farm t2 on t1.FFarmID=t2.fid where t2.FStorageOrgUnitID='"+id+"' ";
			try {
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
				while(rs.next()){
					ids.add(rs.getString("fid"));
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			filter.getFilterItems().add(new FilterItemInfo("id", ids, CompareType.INCLUDE));
			return filter;
		}
		return filter;
	}

	@Override
	protected boolean isIgnoreTreeCUFilter() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);
		this.btnAddNew.setVisible(false);
		menuBiz.setVisible(true);
		menuBiz.setEnabled(true);

		this.btnCreateToCostObject.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					UIContext uiContext = new UIContext(this);
					IUIWindow uiWindow = null ;
					// UIFactoryName.MODEL 为弹出模式
					uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.farm.stocking.basedata.client.CreateCostObjectUI", uiContext, null,OprtState.VIEW);
					//开始展现UI
					uiWindow.show();
					actionRefresh_actionPerformed(null);
				}catch(Exception err) {
					err.printStackTrace();
				}
			}});
	}


	@Override
	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.tblMain_tableSelectChanged(e);
		String baseStatus = null;
		if(StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus") != null){
			baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus").toString();
			if(baseStatus.equals("启用")) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}else if(baseStatus.equals("核准")) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			}else{
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}else{

		}
	}


	@Override
	public void actionRecalQty_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		IStockingBreedDaily remoteInstance = StockingBreedDailyFactory.getRemoteInstance();
		for(int i=0;i<selIDs.length;i++){
			remoteInstance.recalStockingByBatchID(selIDs[i]);
		}
		super.actionRecalQty_actionPerformed(e);
	}

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}


	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCancelCancel_actionPerformed(e);
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
			return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
			prepareCancel(null).callHandler();
		}
		cancelCancel();
		actionRefresh_actionPerformed(e);
	}


}