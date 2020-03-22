/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillFactory;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class DrugReceptionBillEditUI extends AbstractDrugReceptionBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(DrugReceptionBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private KDWorkButton showInventory;
	private boolean isLoadField=false;
	private BaseSysSettingInfo sysSetting;

	/**
	 * output class constructor
	 */
	public DrugReceptionBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	public void loadFields()
	{
		DataChangeListener[] ls = this.prmtstockingBatch.getListeners(DataChangeListener.class);
		for(int i=0;i<ls.length;i++) {
			this.prmtstockingBatch.removeDataChangeListener(ls[i]);
		}
		isLoadField=true;
		super.loadFields(); 
		isLoadField=false;

		for(int i=0;i<ls.length;i++) {
			this.prmtstockingBatch.addDataChangeListener(ls[i]);
		}

		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}

		setEntryInv();
		setBreedStage();

		//仓库
		try {
			if(prmtstorageOrgUnit.getValue()!=null)
				curStorageOrgUnitID=(UIRuleUtil.getProperty((IObjectValue) prmtstorageOrgUnit.getValue(), "ID")).toString();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
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

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setNowBreedState(FarmStageEnum.breed);
		try {
			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
		}catch(Exception err) {

		}
		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		curStorageOrgUnitID=sysSetting.getDefaultStorageOrgUnit().getString("id");
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
	}

	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);

		this.prmtbatchContract.setRequired(true);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");



		setFilter();

		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(!isLoadField) {
					StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
					StockingClientComm.setBatchByFarmerFarm(curCompanyID, prmtstockingBatch, prmtfarmer, prmtfarm);
					setBreedStage();
				}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.prmtstockingBatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});


		final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_material_PromptBox.setEditFormat("$name$");
		kdtEntrys_material_PromptBox.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
		ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
		kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
	}

	/**
	 * 批次改变
	 * 带出基本价格
	 */
	private void batch_changed(DataChangeEvent e) {
		if(isLoadField) {
			return;
		}
		isLoadField=true;
		String batchID=null;
		if(e.getNewValue()!=null) {
			batchID=((PropertyContainer) e.getNewValue()).getString("id");
		}

		try {
			this.prmtfarmer.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "farmer"));
			this.prmtfarm.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "farm"));
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			//设置基础价格
			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
			//触发单价事件，带出金额
			try {
				kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		String contractID=StockingComm.getContractIDByBatchID(null, batchID);
		if(StringUtils.isNotEmpty(contractID)) {
			//			isLoadField=true;
			try {
				this.prmtbatchContract.setValue(BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(contractID)));
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			//			isLoadField=false;
		}else{
			this.prmtbatchContract.setValue(null);
		}
		isLoadField=false;
		setBreedStage();
	}

	@Override
	public void prmtbatchContract_Changed() throws Exception {
		if(isLoadField) {
			return;
		}
		String contractID=null;
		if(prmtbatchContract.getValue()!=null) {
			contractID=((IPropertyContainer) prmtbatchContract.getValue()).getString("id");
			super.prmtbatchContract_Changed();
		}
		String batchID=StockingComm.getBatchIDByContractID(null, contractID);
		isLoadField=true;
		if(StringUtils.isNotEmpty(batchID)&&!batchID.equalsIgnoreCase(StockingComm.IsExistMutiStockingBatch)) {
			this.prmtstockingBatch.setValue(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchID)));
		}else {
			this.prmtstockingBatch.setValue(null);
		}
		isLoadField=false;
	}
	private void storageOrgUnit_changed(DataChangeEvent e){
		if(e.getNewValue()==null) {
			curStorageOrgUnitID=null;
		}else{
			curStorageOrgUnitID=((PropertyContainer) this.prmtstorageOrgUnit.getValue()).getString("id");
			try {
				orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
				f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
				f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
			} catch (EASBizException e1) {
				e1.printStackTrace();
			} catch (BOSException e1) {
				e1.printStackTrace();
			}
		}
		//仓库
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);

	}

	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}

		//人员过滤
		//		StockingClientComm.makeApplierF7(this.prmtperson, companyID, this, false);
		//批次过滤
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		StockingClientComm.setStockingBatchFilter(prmtstockingBatch,curCompanyID,farmerID,farmID);
		this.prmtstockingBatch.setRequired(false);
		//养殖户过滤
		StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID);
		//养殖场过滤
		StockingClientComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID);
		//合同过滤
		StockingClientComm.setBatchContractFilter(prmtbatchContract, curCompanyID, farmerID, farmID);
	}
	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")) {			
			//设置仓库
			if(kdtEntrys.getCell(rowIndex,"material").getValue()!=null) {
				kdtEntrys.getCell(rowIndex,"warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, ((PropertyContainer) kdtEntrys.getCell(rowIndex,"material").getValue()).getString("id")));
			}

		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")||kdtEntrys.getColumn(colIndex).getKey().equals("unit")) {	
			//设置基础价格
			String batchID=null;
			if(prmtstockingBatch.getValue()!=null){
				batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
			}
			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
			//触发单价事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("receiveQty")) {	
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("confirmQty").getColumnIndex());
		}

		if(kdtEntrys.getColumnKey(colIndex).equals("material")||kdtEntrys.getColumnKey(colIndex).equals("unit")||kdtEntrys.getColumnKey(colIndex).equals("warehouse")) {
			String storageOrgUnitID=null,materialID=null,unitID=null,warehouseID=null;
			if(prmtstorageOrgUnit.getValue()!=null) {
				storageOrgUnitID=((IPropertyContainer) prmtstorageOrgUnit.getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
				materialID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "unit").getValue()!=null) {
				unitID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "unit").getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "warehouse").getValue()!=null) {
				warehouseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "warehouse").getValue()).getString("id");
			}

			kdtEntrys.getCell(rowIndex, "inventory").setValue(StockingComm.getNowInventory(null, storageOrgUnitID, materialID, unitID, warehouseID));
		}
	}

	/**
	 * 设置分录及时库存
	 */
	private void setEntryInv() {
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			String storageOrgUnitID=null,materialID=null,unitID=null,warehouseID=null;
			if(prmtstorageOrgUnit.getValue()!=null) {
				storageOrgUnitID=((IPropertyContainer) prmtstorageOrgUnit.getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
				materialID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "unit").getValue()!=null) {
				unitID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "unit").getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "warehouse").getValue()!=null) {
				warehouseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "warehouse").getValue()).getString("id");
			}

			kdtEntrys.getCell(rowIndex, "inventory").setValue(StockingComm.getNowInventory(null, storageOrgUnitID, materialID, unitID, warehouseID));

		}
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState()))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try
			{
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
			}
			catch(Throwable E) { }
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBillStatus(BillBaseStatusEnum.ADD);
		//        editData.setNumber(null);
		editData.setFarmer(null);
		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();

		setMakeRelations(null);
	}

	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
	}

	/**
	 * 设置当前阶段
	 */
	private void setBreedStage() {
		if(prmtstockingBatch.getValue()!=null) {
			try {
				Date date=((Date) (pkBizDate.getValue())!=null?((Date)pkBizDate.getValue()):(new Date()));
				if(UIRuleUtil.getProperty((IObjectValue) prmtstockingBatch.getValue(), "breedDate")!=null&&!((Date)UIRuleUtil.getProperty((IObjectValue) prmtstockingBatch.getValue(), "breedDate")).after(date)) {
					nowBreedState.setSelectedItem(FarmStageEnum.breed);
				}
				if(UIRuleUtil.getProperty((IObjectValue) prmtstockingBatch.getValue(), "matureDate")!=null&&!((Date)UIRuleUtil.getProperty((IObjectValue) prmtstockingBatch.getValue(), "matureDate")).after(date)) {
					this.nowBreedState.setSelectedItem(FarmStageEnum.eggs);
				}
				if(UIRuleUtil.getProperty((IObjectValue) prmtstockingBatch.getValue(), "breedDate")==null&&UIRuleUtil.getProperty((IObjectValue) prmtstockingBatch.getValue(), "matureDate")==null) {
					this.nowBreedState.setSelectedItem(FarmStageEnum.brood);
				}
			}catch(Exception err) {

			}
		}else{
			this.nowBreedState.setSelectedItem(FarmStageEnum.brood);
		}
	}

	/**
	 * 生成下游单据标志
	 */
	@Override
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCreateTo_actionPerformed(e);
		if(editData.getId()==null)
			return;
		MaterialReqBillInfo materialReqBillInfo;
		//校验生成领料出库单
		ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "500AB75E");
		if(destObejctIDs.size()>0)
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_DrugReceptionBill set FIsHasMaterial=1 where fid='"+editData.getString("id")+"'");

		StockTransferBillInfo stockTransferBillInfo;
		//校验生成库存调拨单
		destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "2239F30A");
		if(destObejctIDs.size()>0)
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_DrugReceptionBill set FIsHasTrans=1 where fid='"+editData.getString("id")+"'");
		UIUtil.refreshEditUI(this);
	}

}