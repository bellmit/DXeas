/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.hr.train.SysCate;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class DrugApplyBillEditUI extends AbstractDrugApplyBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(DrugApplyBillEditUI.class);

	/**
	 * output class constructor
	 */
	public DrugApplyBillEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
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
	 * output MenuItemPCVoucher_actionPerformed method
	 */
	protected void MenuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.MenuItemPCVoucher_actionPerformed(e);
	}

	/**
	 * output menuItemDelPCVoucher_actionPerformed method
	 */
	protected void menuItemDelPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemDelPCVoucher_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.DrugApplyBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		return objectValue;
	}



	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		if(editData.getId()==null)
			super.actionPre_actionPerformed(e);
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			MsgBox.showWarning("单据已经审核或关闭，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(arg0);
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}



	public void actionClose_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据未审核，禁止关闭！");
			SysUtil.abort();
		}
		super.actionClose_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("关闭成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			MsgBox.showWarning("单据尚未关闭，禁止反关闭！");
			SysUtil.abort();
		}
		super.actionUnClose_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反关闭成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		init();


	}
	private void init() {
		// TODO Auto-generated method stub

		KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox.setEditFormat("$name$");
		kdtEntrys_material_PromptBox.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor);

		final KDBizPromptBox kdtEntrys_outSto_PromptBox = new KDBizPromptBox();
		kdtEntrys_outSto_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.storageIsBizUnitQuery");
		kdtEntrys_outSto_PromptBox.setVisible(true);
		kdtEntrys_outSto_PromptBox.setEditable(true);
		kdtEntrys_outSto_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_outSto_PromptBox.setEditFormat("$number$");
		kdtEntrys_outSto_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_outSto_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outSto_PromptBox);
		this.kdtEntrys.getColumn("outSto").setEditor(kdtEntrys_outSto_CellEditor);



		final KDBizPromptBox kdtEntrys_stockingBatch_PromptBox = new KDBizPromptBox();
		kdtEntrys_stockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
		kdtEntrys_stockingBatch_PromptBox.setVisible(true);
		kdtEntrys_stockingBatch_PromptBox.setEditable(true);
		kdtEntrys_stockingBatch_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_stockingBatch_PromptBox.setEditFormat("$number$");
		kdtEntrys_stockingBatch_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_stockingBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingBatch_PromptBox);
		this.kdtEntrys.getColumn("stockingBatch").setEditor(kdtEntrys_stockingBatch_CellEditor);

		//调出组织添加监听事件
		prmtcompany.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				CompanyOrgUnitInfo companyInfo = null;
				if(prmtcompany.getValue() != null){
					companyInfo = (CompanyOrgUnitInfo) prmtcompany.getValue();
					KDBizPromptBox inWareBox = (KDBizPromptBox)kdtEntrys.getColumn("outSto").getEditor().getComponent();
					FilterInfo inWareFilter=new FilterInfo();
					EntityViewInfo inWareevi=new EntityViewInfo();
					inWareFilter.getFilterItems().add(new FilterItemInfo("company.id",companyInfo.getId().toString(),CompareType.EQUALS));
					inWareevi.setFilter(inWareFilter);
					inWareBox.setEntityViewInfo(inWareevi);
				}
			}

		});



		//养殖场添加监听事件
		prmtfarm.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//添加过滤
				setFields();
			}

		});


		//分录添加监听事件
		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				//批次添加监听事件
				if("stockingBatch".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					StockingBatchInfo batchInfo = null;
					if(kdtEntrys.getCell(e.getRowIndex(), "stockingBatch").getValue() != null
							&& pkBizDate.getValue() != null){
						batchInfo = (StockingBatchInfo) kdtEntrys.getCell(e.getRowIndex(), "stockingBatch").getValue();
						try {
							batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId()));

							Date bizDate=((Date)pkBizDate.getValue());
							int[] result = StockingComm.getBreedWeekAndDay(bizDate, batchInfo.getInDate());
							kdtEntrys.getCell(e.getRowIndex(), "week").setValue(result[0]);
							kdtEntrys.getCell(e.getRowIndex(), "day").setValue(result[1]);

						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				//分录的调出仓库按照分录的调出组织过滤
				if("outSto".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					StorageOrgUnitInfo stoInfo = null;
					if(kdtEntrys.getCell(e.getRowIndex(), "outSto").getValue() != null){
						stoInfo = (StorageOrgUnitInfo) kdtEntrys.getCell(e.getRowIndex(), "outSto").getValue();

						KDBizPromptBox adminF7 = (KDBizPromptBox)kdtEntrys.getColumn("outWare").getEditor().getComponent();
						FilterInfo outWareFilter=new FilterInfo();
						EntityViewInfo outWareevi=new EntityViewInfo();
						outWareFilter.getFilterItems().add(new FilterItemInfo("storageOrg.id",stoInfo.getId().toString(),CompareType.EQUALS));
						outWareevi.setFilter(outWareFilter);
						adminF7.setEntityViewInfo(outWareevi);					
					}
				}



			}

		});
	}
	/**
	 * 棚舍和批次添加过滤
	 */
	protected void setFields() {
		// TODO Auto-generated method stub
		FarmInfo farmInfo = null;
		StorageOrgUnitInfo stoInfo = null;
		if(prmtfarm.getValue() != null){
			farmInfo = (FarmInfo) prmtfarm.getValue();
			try {
				farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
				stoInfo = farmInfo.getStorageOrgUnit();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//棚舍根据养殖场过滤
			KDBizPromptBox houseFilter = (KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent();
			FilterInfo filter=new FilterInfo();
			EntityViewInfo evi=new EntityViewInfo();
			filter.getFilterItems().add(new FilterItemInfo("parent.id",farmInfo.getId().toString(),CompareType.EQUALS));
			evi.setFilter(filter);
			houseFilter.setEntityViewInfo(evi);

			//批次根据养殖场过滤
			KDBizPromptBox batchBox = (KDBizPromptBox)this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			FilterInfo batchFilter=new FilterInfo();
			EntityViewInfo batchevi=new EntityViewInfo();
			batchFilter.getFilterItems().add(new FilterItemInfo("farm.id",farmInfo.getId().toString(),CompareType.EQUALS));
			batchevi.setFilter(batchFilter);
			batchBox.setEntityViewInfo(batchevi);



			//分录调入仓库，按照养殖场资料的库存组织过滤
			KDBizPromptBox inWareBox = (KDBizPromptBox)this.kdtEntrys.getColumn("inWare").getEditor().getComponent();
			FilterInfo inWareFilter=new FilterInfo();
			EntityViewInfo inWareevi=new EntityViewInfo();
			inWareFilter.getFilterItems().add(new FilterItemInfo("storageOrg.id",stoInfo.getId().toString(),CompareType.EQUALS));
			inWareevi.setFilter(inWareFilter);
			inWareBox.setEntityViewInfo(inWareevi);

			CompanyOrgUnitInfo companyInfo = null;
			if(prmtcompany.getValue() != null){
				companyInfo = (CompanyOrgUnitInfo) prmtcompany.getValue();
				KDBizPromptBox outStoBox = (KDBizPromptBox)kdtEntrys.getColumn("outSto").getEditor().getComponent();
				FilterInfo outStoFilter=new FilterInfo();
				EntityViewInfo outStoevi=new EntityViewInfo();
				outStoFilter.getFilterItems().add(new FilterItemInfo("company.id",companyInfo.getId().toString(),CompareType.EQUALS));
				outStoevi.setFilter(outStoFilter);
				outStoBox.setEntityViewInfo(outStoevi);
			}else{
				companyInfo = SysContext.getSysContext().getCurrentFIUnit();
				KDBizPromptBox outStoBox = (KDBizPromptBox)kdtEntrys.getColumn("outSto").getEditor().getComponent();
				FilterInfo outStoFilter=new FilterInfo();
				EntityViewInfo outStoevi=new EntityViewInfo();
				outStoFilter.getFilterItems().add(new FilterItemInfo("company.id",companyInfo.getId().toString(),CompareType.EQUALS));
				outStoevi.setFilter(outStoFilter);
				outStoBox.setEntityViewInfo(outStoevi);
			}


		}
	}





}