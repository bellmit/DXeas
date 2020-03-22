/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarmers;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BasePriceBean;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.IBatchContract;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class FodderReceiveBillEditUI extends AbstractFodderReceiveBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FodderReceiveBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private BaseSysSettingInfo sysSetting;
	private WarehouseInfo wareHouseInfo=null;

	/**
	 * output class constructor
	 */
	public FodderReceiveBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	public void loadFields()
	{
		isLoadField=true;
		super.loadFields(); 
		isLoadField=false;
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
		UITools.apendFootRow(kdtEntrys, new String[]{"receiveQty","confirmQty","bagQty","amount"});

		//仓库
		if(prmtstorageOrgUnit.getValue()!=null){
			curStorageOrgUnitID=((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id");
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
			ev.setFilter(filter);
			((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
		}
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
		return com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		try {
			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
			String companyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
			ArrayList<String> list=StockingComm.getFarmersByPerson(null, companyID);
			FarmInfo farmInfo;
			FarmersInfo farmerInfo;
			String batchID,farmID,contractID;
			IStockingBatch ibs = StockingBatchFactory.getRemoteInstance();
			StockingBatchInfo bInfo;
			IBatchContract ics = BatchContractFactory.getRemoteInstance();
			IFarmers iffs = FarmersFactory.getRemoteInstance();
			HashMap<MaterialInfo,BigDecimal> map;
			FodderReceiveBillEntryInfo entryInfo,entryInfoClone;
			ArrayList<BasePriceBean> priceList;
			for(String farmerID:list) {
				farmerInfo=iffs.getFarmersInfo(new ObjectUuidPK(farmerID));

				entryInfo=new FodderReceiveBillEntryInfo();
				farmInfo=StockingComm.getFarmInfoByFarmerID(null, farmerID);
				farmID=null;
				if(farmInfo!=null) {
					farmInfo.getString("id");
				}
				batchID = StockingComm.getLastStockingBatch(null, farmerID, farmID);

				entryInfo.setFarmer(farmerInfo);
				entryInfo.setFarm(farmInfo);
				if(StringUtils.isNotEmpty(batchID)) {
					bInfo=ibs.getStockingBatchInfo(new ObjectUuidPK(batchID));
					entryInfo.setStockingBatch(bInfo);
					contractID=StockingComm.getContractIDByBatchID(null, batchID);
					if(StringUtils.isNotEmpty(contractID)) {
						entryInfo.setBatchContract(ics.getBatchContractInfo(new ObjectUuidPK(contractID)));
					}

					int[] weekAndDay=StockingComm.getBreedWeekAndDay(new java.util.Date(), bInfo.getInDate());
					int index=1;
					map=StockingComm.getBreedFodderStandard(null, companyID, bInfo.getBreedData().getString("id"), weekAndDay[0], weekAndDay[1]);
					for (Map.Entry<MaterialInfo,BigDecimal> entry : map.entrySet()) {  
						entryInfo.setMaterial(entry.getKey());
						entryInfo.setMaterialName(entry.getKey().getName());
						entryInfo.setModel(entry.getKey().getModel());
						entryInfo.setUnit(entry.getKey().getBaseUnit());
						entryInfo.setUnitQty(StockingComm.getUnitQty(null, curCompanyID, entry.getKey().getString("id")));
						entryInfo.setWarehouse(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID,entry.getKey().getString("id")));

						//合同不为空，带出基本价格
						if(StringUtils.isNotBlank(contractID)) {
							priceList = StockingComm.getBasePrice(null,StockingComm.PRRICE_OUT_TYPE,contractID,entry.getKey().getString("id"),entry.getKey().getBaseUnit().getString("id"));
							if(priceList!=null&&priceList.size()>0) {
								entryInfo.setBasePrice(priceList.get(0).getBasePrice());
								entryInfo.setReceivePrice(priceList.get(0).getBasePrice());
							}
						}

						if(map.size()==1) {
							break;
						}else{
							//非最后一行不添加
							if(index<map.size()) {
								entryInfoClone=(FodderReceiveBillEntryInfo) entryInfo.clone();
								objectValue.getEntrys().add(entryInfoClone);
							}
						}
						index++;
					}
				}
				objectValue.getEntrys().add(entryInfo);
			}

		}catch(Exception err) {
			err.printStackTrace();
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
		chkisInit.setVisible(false);
		contvoucherNum.setVisible(true);
		txtvoucherNum.setVisible(true);
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

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		//仓库
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);

		setFilter();

		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);
			}});
		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}});
		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
			this.chkisInit.setVisible(true);
		}catch(Exception err) {
			this.chkisInit.setVisible(false);
		}


		final KDBizPromptBox kdtEntrys_driver_PromptBox = new KDBizPromptBox();
		kdtEntrys_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
		kdtEntrys_driver_PromptBox.setVisible(true);
		kdtEntrys_driver_PromptBox.setEditable(true);
		kdtEntrys_driver_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_driver_PromptBox.setEditFormat("$drivername$");
		kdtEntrys_driver_PromptBox.setCommitFormat("$drivername$");
		KDTDefaultCellEditor kdtEntrys_driver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_driver_PromptBox);
		this.kdtEntrys.getColumn("driver").setEditor(kdtEntrys_driver_CellEditor);
		ObjectValueRender kdtEntrys_driver_OVR = new ObjectValueRender();
		kdtEntrys_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
		this.kdtEntrys.getColumn("driver").setRenderer(kdtEntrys_driver_OVR);
		kdtEntrys_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtEntrys_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_driver_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_driver_PromptBox_F7ListUI));
					kdtEntrys_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_driver_PromptBox.setSelector(kdtEntrys_driver_PromptBox_F7ListUI);
				}
			}
		});
		kdtEntrys_detailPanel.getAddNewLineButton().addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "warehouse").setValue(wareHouseInfo);
			}});
		kdtEntrys_detailPanel.getInsertLineButton().addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				KDTableUtil.getSelectedRow(kdtEntrys).getCell("warehouse").setValue(wareHouseInfo);
			}});
	}

	/**
	 * 批次改变
	 * 带出基本价格
	 * @throws Exception 
	 */
	private void batch_changed(DataChangeEvent e) throws Exception {
		String batchID=null;
		if(e.getNewValue()!=null) {
			batchID=((PropertyContainer) e.getNewValue()).getString("id");
		}
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			//设置基础价格
			StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));//触发单价事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
		}
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
		KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
		KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
		KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
		KDBizPromptBox prmtContract = (KDBizPromptBox) this.kdtEntrys.getColumn("batchContract").getEditor().getComponent();

		//批次过滤
		StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,null,null);
		//养殖户过滤
		StockingClientComm.setFarmerFilter(prmtFarmer, curCompanyID);
		//养殖场过滤
		StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, null);
		//合同过滤
		StockingClientComm.setBatchContractFilter(prmtContract, curCompanyID,null,null);
	}

	/**
	 * 开始编辑
	 * @param e
	 */
	@SuppressWarnings("unchecked")
	private void kdteditStarted(KDTEditEvent e) {
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEntrys.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("batchContract")||key.equals("house")) {
			//			KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			KDBizPromptBox prmtContract = (KDBizPromptBox) this.kdtEntrys.getColumn("batchContract").getEditor().getComponent();
			String farmerID=null,farmID=null;
			if(this.kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
			}
			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID);
			//养殖场过滤
			StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
			StockingClientComm.setBatchContractFilter(prmtContract, curCompanyID,farmerID,farmID);


			String batchID = "";
			//棚舍过滤
			if(kdtEntrys.getCell(e.getRowIndex(), "stockingBatch").getValue()!=null)
				batchID=((StockingBatchInfo)kdtEntrys.getCell(e.getRowIndex(), "stockingBatch").getValue()).getString("id");
			HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,true);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		}
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

		if(kdtEntrys.getColumn(colIndex).getKey().equals("batchContract")) {
			//根据合同带出批次
			String contractID =null;
			if(kdtEntrys.getCell(rowIndex, "batchContract").getValue()!=null){
				contractID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "batchContract").getValue()).getString("id");
			}
			String	batchID=StockingComm.getBatchIDByContractID(null,contractID);
			if(StringUtils.isNotEmpty(batchID)&&!batchID.equalsIgnoreCase(StockingComm.IsExistMutiStockingBatch)) {
				kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchID)));
			}else{
				kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(null);
			}
		}

		if(kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")) {
			//根据批次带出合同
			String batchID=null;
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null){
				batchID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
			String	contractID=StockingComm.getContractIDByBatchID(null,batchID);
			if(StringUtils.isNotEmpty(contractID)) {
				kdtEntrys.getCell(rowIndex, "batchContract").setValue(BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(contractID)));
			}else{
				kdtEntrys.getCell(rowIndex, "batchContract").setValue(null);
			}
		}
		//根据合同和批次带出养殖户和农场
		if(kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")||kdtEntrys.getColumn(colIndex).getKey().equals("batchContract")) {
			String contractID =null;
			if(kdtEntrys.getCell(rowIndex, "batchContract").getValue()!=null){
				contractID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "batchContract").getValue()).getString("id");
			}
			if(StringUtils.isNotEmpty(contractID)) {
				SelectorItemCollection slorslor=new SelectorItemCollection();
				slorslor.add(new SelectorItemInfo("farmer.*"));
				slorslor.add(new SelectorItemInfo("farm.*"));
				BatchContractInfo contractInfo = BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(contractID),slorslor);
				kdtEntrys.getCell(rowIndex, "farmer").setValue(contractInfo.getFarmer());
				kdtEntrys.getCell(rowIndex, "farm").setValue(contractInfo.getFarm());
			}

			setBreedStage(rowIndex,colIndex);
			Date inDate;
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null){
				inDate=((StockingBatchInfo)kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getInDate();
				if(pkBizDate.getValue()!=null){
					int dayAge=DateUtilsComm.getDiffBetweenTwoDays(inDate,(Date)pkBizDate.getValue());
					kdtEntrys.getCell(rowIndex, "weekAge").setValue((dayAge/7+1)+"周"+(dayAge%7+1));
				}
			}

		}



		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")||kdtEntrys.getColumn(colIndex).getKey().equals("unit")||kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")||kdtEntrys.getColumn(colIndex).getKey().equals("batchContract")) {	
			//设置基础价格
			String contractID=null;
			if(kdtEntrys.getCell(rowIndex, "batchContract").getValue()!=null){
				contractID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "batchContract").getValue()).getString("id");
			}
			if(contractID!=null) {
				StockingClientComm.setEntryBasePriceByContractID(StockingComm.PRRICE_OUT_TYPE, contractID, kdtEntrys.getRow(rowIndex));
			}else{
				kdtEntrys.getCell(rowIndex,"receivePrice").setValue(BigDecimal.ZERO);
			}
			//触发单价事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
		}
		//根据数量处罚确认数量事件
		if(kdtEntrys.getColumn(colIndex).getKey().equals("receiveQty")) {	
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("confirmQty").getColumnIndex());
			kdtEntrys.getCell(rowIndex, kdtEntrys.getColumn("confirmQty").getColumnIndex()).setValue(kdtEntrys.getCell(rowIndex, "receiveQty").getValue());
			//			if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue()).compareTo(BigDecimal.ZERO)<>0)
			//				kdtEntrys.getCell(rowIndex, "unitQty")
		}
		//单包重
		if(kdtEntrys.getColumnKey(colIndex).equals("material")&&kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
			kdtEntrys.getCell(rowIndex, "unitQty").setValue(StockingComm.getUnitQty(null, curCompanyID, ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id")));
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("unitQty").getColumnIndex());
		}
		if(kdtEntrys.getColumnKey(colIndex).equals("unitQty")){
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receiveQty").getColumnIndex());
		}
		//根据养殖户带出养殖场
		if(kdtEntrys.getColumnKey(colIndex).equals("farmer")) {
			String farmerID=null;
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null) {
				farmerID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, colIndex).getValue()).getString("id");
			}
			kdtEntrys.getCell(rowIndex, "farm").setValue(StockingComm.getFarmInfoByFarmerID(null,farmerID));
		}
		if(colIndex!=kdtEntrys.getColumn("confirmQty").getColumnIndex())
			kdtEntrys.getCell(rowIndex, kdtEntrys.getColumn("confirmQty").getColumnIndex()).setValue(kdtEntrys.getCell(rowIndex, "receiveQty").getValue());
		UITools.apendFootRow(kdtEntrys, new String[]{"receiveQty","confirmQty","bagQty","amount"});

		if(kdtEntrys.getColumnIndex("warehouse")==colIndex)
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null)
				wareHouseInfo=(WarehouseInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();

		calAmount(rowIndex);
	}

	/**
	 * 计算金额
	 * @param rowIndex
	 */
	private void calAmount(int rowIndex) {
		// TODO Auto-generated method stub
		BigDecimal amount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receiveQty").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receivePrice").getValue()));
		kdtEntrys.getCell(rowIndex, "amount").setValue(amount.compareTo(BigDecimal.ZERO)==0?null:amount);
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
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()==null&&this.kdtEntrys.getCell(rowIndex, "batchContract").getValue()==null) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，批次和合同不能同时为空！");
				SysUtil.abort();
			}
		}
	}
	/**
	 * 设置当前阶段
	 */
	private void setBreedStage(int rowIndex,int colIndex) {
		if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
			try {
				Date date=((Date) (pkBizDate.getValue())!=null?((Date)pkBizDate.getValue()):(new Date()));
				if(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "breedDate")!=null&&!((Date)UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "breedDate")).after(date)) {
					kdtEntrys.getCell(rowIndex, "currentBreedState").setValue(FarmStageEnum.breed);
				}
				if(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "matureDate")!=null&&!((Date)UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "matureDate")).after(date)) {
					kdtEntrys.getCell(rowIndex, "currentBreedState").setValue(FarmStageEnum.eggs);
				}
				if(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "breedDate")==null&&UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "matureDate")==null) {
					kdtEntrys.getCell(rowIndex, "currentBreedState").setValue(FarmStageEnum.brood);
				}
			}catch(Exception err) {

			}
		}else{
			kdtEntrys.getCell(rowIndex, "currentBreedState").setValue(FarmStageEnum.brood);
		}
	}

}