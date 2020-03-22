/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.AbstractObjectValue;
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
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.MaleOrFemaleEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class BreedSeedBillEditUI extends AbstractBreedSeedBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BreedSeedBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private BaseSysSettingInfo sysSetting;
	private boolean isHouseManager=false;

	/**
	 * output class constructor
	 */
	public BreedSeedBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	public void loadFields()
	{
		isLoadField=true;
		DataChangeListener[] ls = prmtbatchContract.getListeners(DataChangeListener.class);
		for(int index=0;index<ls.length;index++) {
			prmtbatchContract.removeDataChangeListener(ls[index]);
		}
		super.loadFields(); 
		for(int index=0;index<ls.length;index++) {
			prmtbatchContract.addDataChangeListener(ls[index]);
		}
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
		setFilter();
		setEntryHouseFilter();
		//        UITools.apendFootRow(kdtEntrys, new String[]{"receiveQty","lossQty","supplementQty","allReceiveQty","confirmQty"});
	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}


	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		beforeSubmit();
		super.actionSubmit_actionPerformed(e);
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
		return com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new java.util.Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
//		try {
//			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
//		}catch(Exception err) {
//
//		}

		objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		
		objectValue.setBillStatus(BillBaseStatusEnum.ADD);
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
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
		super.onLoad();
	}

	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.prmthouse.setRequired(true);
		if(sysSetting.isIsHouseManager()) {
			this.conthouse.setVisible(true);
		}else{
			this.conthouse.setVisible(false);
		}

		this.pkBizDate.setDatePattern("yyyy-MM-dd");

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

		
		if (this.sex.getSelectedItem().equals(com.kingdee.eas.farm.stocking.basedata.app.sex.male)) {
			kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(false);
		} else if(this.sex.getSelectedItem().equals(com.kingdee.eas.farm.stocking.basedata.app.sex.female)){
			kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(true);
		}else{
			kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(false);
		}
		
		
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
				setHouseFilter();
			}});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(!isLoadField) {
					StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
				}
				setContractByFarmerFarm();
				setFilter();
				setHouseFilter();
				setEntryHouseFilter();
			}});
		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setContractByFarmerFarm();
				setHouseFilter();
				setEntryHouseFilter();
			}});

		this.prmtbreedData.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				breedDataChanged(e);
			}});

		/*this.prmtbatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub

			}});*/

		this.sex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbsex_changed(e);
			}

			
		});
		
		
		this.txtstockingBatchNum.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {

			}
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(!isLoadField) {
					String number=null;
					number=txtstockingBatchNum.getText();
					prmtstockingBatch.setValue(StockingComm.getStockingBatchByNumber(null, curCompanyID, number));
					txtstockingBatchNum.setText(number);	
				}
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

		kdtEntrys.getColumn("receiveQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("lossQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("supplementQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("allReceiveQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("confirmQty").getStyleAttributes().setNumberFormat("#");
		
		kdtEntrys.getColumn("henQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("cockQty").getStyleAttributes().setNumberFormat("#");
		

		((KDFormattedTextField)kdtEntrys.getColumn("receiveQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("lossQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("supplementQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("allReceiveQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("confirmQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("henQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("cockQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		//棚舍信息
		KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox.setEditFormat("$name$");
		kdtEntrys_material_PromptBox.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor);
		ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
		kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR);

	}
	
	private void cmbsex_changed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (this.sex.getSelectedItem().equals(com.kingdee.eas.farm.stocking.basedata.app.sex.male)) {
			kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(false);
		} else if(this.sex.getSelectedItem().equals(com.kingdee.eas.farm.stocking.basedata.app.sex.female)){
			kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(true);
		}else{
			kdtEntrys.getColumn("henQty").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("cockQty").getStyleAttributes().setHided(false);
		}
	}
	/**
	 * 通过养殖户、养殖场设置合同
	 */
	private void setContractByFarmerFarm() {
		isLoadField=true;
		if(prmtbatchContract.getValue()!=null) {
			if(prmtfarmer.getValue()==null||prmtfarm.getValue()==null) {
				prmtbatchContract.setValue(null);
			}else {
				try {
					String farmerID=((PropertyContainer) UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "farmer")).getString("id");
					String farmID=((PropertyContainer) UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "farm")).getString("id");
					if(!farmerID.equals(((PropertyContainer) prmtfarmer.getValue()).getString("id"))||!farmID.equals(((PropertyContainer) prmtfarm.getValue()).getString("id"))) {
						prmtbatchContract.setValue(null);
					}
				}catch(Exception err) {
					err.printStackTrace();
				}
			}

		}
		setEntryHouseFilter();
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
	 * 品种资料改变
	 * @param e
	 */
	private void breedDataChanged(DataChangeEvent e) {
		if(isLoadField) {
			return;
		}

		if(this.kdtEntrys.getRowCount()<=0) {
			if( e.getNewValue()!=null) {
				try {
					BatchContractInfo cInfo=null;
					if(prmtbatchContract.getValue()!=null) {
						cInfo=BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(((PropertyContainer) prmtbatchContract.getValue()).getString("id")));
					}
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add(new SelectorItemInfo("*"));
					slor.add(new SelectorItemInfo("SeedEntry.*"));
					slor.add(new SelectorItemInfo("SeedEntry.material.*"));
					slor.add(new SelectorItemInfo("SeedEntry.material.baseUnit.*"));
					BigDecimal qty,lossQty;
					BreedDataInfo info=  BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(((AbstractCoreBaseInfo) e.getNewValue()).getId()),slor); 
					for(int index=0;index<info.getSeedEntry().size();index++) {
						IRow row = kdtEntrys.addRow();
						qty=BigDecimal.ZERO;
						if(cInfo!=null) {
							if(info.getSeedEntry().get(index).getMaleOrFemale()!=null) {
								//公
								if(info.getSeedEntry().get(index).getMaleOrFemale().equals(MaleOrFemaleEnum.male)) {
									qty=cInfo.getBreedQty();
								}else if(info.getSeedEntry().get(index).getMaleOrFemale().equals(MaleOrFemaleEnum.female)) {
									//母
									qty=cInfo.getFemaleBreedQty();
								}else{
									if(cInfo.getFemaleBreedQty()!=null) {
										qty=cInfo.getFemaleBreedQty();
									}
									qty=qty.add(cInfo.getBreedQty()==null?BigDecimal.ZERO:cInfo.getBreedQty());
								}
							}else {
								if(cInfo.getFemaleBreedQty()!=null) {
									qty=cInfo.getFemaleBreedQty();
								}
								qty=qty.add(cInfo.getBreedQty()==null?BigDecimal.ZERO:cInfo.getBreedQty());
							}
//							row.getCell("receiveQty").setValue(qty);
//							lossQty=qty.multiply(new BigDecimal(0.05)).setScale(0, BigDecimal.ROUND_HALF_UP);
//							row.getCell("lossQty").setValue(lossQty);
//							row.getCell("confirmQty").setValue(qty);
//							row.getCell("allReceiveQty").setValue(qty.add(lossQty));
						}

						//触发数量事件，带出金额
						row.getCell("material").setValue(info.getSeedEntry().get(index).getMaterial());
						//触发物事件，带出计量单位、仓库、单价、金额
						kdtEntrys_Changed(row.getRowIndex(), kdtEntrys.getColumn("material").getColumnIndex());
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}


	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);

		BigDecimal receiveQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receiveQty").getValue());
		//路损数量
		BigDecimal lossQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"lossQty").getValue());
		//另补数量
		BigDecimal supplementQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"supplementQty").getValue());
		//公禽数量
		BigDecimal henQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"cockQty").getValue());
		//母禽数量
		BigDecimal cockQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"henQty").getValue());
		
		//kdtEntrys.getCell(rowIndex,"allReceiveQty").setValue(receiveQty.subtract(lossQty).add(supplementQty));
		kdtEntrys.getCell(rowIndex,"allReceiveQty").setValue(henQty.add(cockQty));
		
		BigDecimal receivePrice = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receivePrice").getValue());
		receiveQty = henQty.add(cockQty);
		kdtEntrys.getCell(rowIndex,"amount").setValue(receiveQty.multiply(receivePrice));
		
		
		//路损保留整数
//		if ("receiveQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
//			kdtEntrys.getCell(rowIndex,"lossQty").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"lossQty").getValue()).setScale(0,BigDecimal.ROUND_HALF_UP));
//			kdtEntrys_Changed(rowIndex,kdtEntrys.getColumnIndex("lossQty"));
//		}

		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")) {
			//设置仓库
			if(kdtEntrys.getCell(rowIndex,"material").getValue()!=null) {
				kdtEntrys.getCell(rowIndex,"warehouse").setValue(StockingComm.getDefaultWarehouseByMaterial(null, curStorageOrgUnitID, ((PropertyContainer) kdtEntrys.getCell(rowIndex,"material").getValue()).getString("id")));
			}
		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")
				|| kdtEntrys.getColumn(colIndex).getKey().equals("unit")) {	
			//设置基础价格
			if(prmtbatchContract.getValue()!=null) {
				StockingClientComm.setEntryBasePriceByContractID(StockingComm.PRRICE_OUT_TYPE,((PropertyContainer) prmtbatchContract.getValue()).getString("id"),kdtEntrys.getRow(rowIndex));
			}else {
				String batchID=null;
				if(prmtstockingBatch.getValue()!=null){
					batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
				}
				StockingClientComm.setEntryBasePriceByBatchID(StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
			}
//			//触发单价事件，带出金额
//			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
		}
	}



	@Override
	protected void setFieldsNull(AbstractObjectValue obj) {
		// TODO Auto-generated method stub
		super.setFieldsNull(obj);
	}
	@Override
	public void prmtstockingBatch_Changed() throws Exception {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		super.prmtstockingBatch_Changed();
		if(prmtstockingBatch.getValue()!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("house.*");
			slor.add("breedData.*");
			StockingBatchInfo batchInfo=StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((AbstractCoreBaseInfo) prmtstockingBatch.getValue()).getId()),slor);
			isLoadField=true;
			this.prmtfarmer.setValue(batchInfo.getFarmer());
			this.prmtfarm.setValue(batchInfo.getFarm());
			isLoadField=true;
			//带出合同
			String contractID=StockingComm.getContractIDByBatchID(null, ((PropertyContainer) prmtstockingBatch.getValue()).getString("id"));
			if(StringUtils.isNotEmpty(contractID)) {
				try {
					this.prmtbatchContract.setValue(BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(contractID)));
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}else{
				this.prmtbatchContract.setValue(null);
				this.prmtbreedData.setValue(batchInfo.getBreedData());
			}
			isLoadField=false;
		}

	}
	@Override
	public void prmtbatchContract_Changed() throws Exception {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		super.prmtbatchContract_Changed();
		if(prmtbatchContract.getValue()!=null) {
			BatchContractInfo info=(BatchContractInfo) prmtbatchContract.getValue();
			if(info.getStockingBatch()!=null) {
				this.prmtstockingBatch.setValue(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId())));

			}else{
				if(info.getBreedData()!=null) {
					if(info.getBreedData()!=null) {
						this.prmtbreedData.setValue(BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(info.getBreedData().getId())));
					}
				}else{
					this.prmtbreedData.setValue(null);
				}
			}
		}else{
			this.prmtstockingBatch.setValue(null);
			this.prmtbreedData.setValue(null);
		}
		String contractID=null;
		if(this.prmtbatchContract.getValue()!=null) {
			contractID=((PropertyContainer) this.prmtbatchContract.getValue()).getString("id");
		}
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			//设置基础价格
			StockingClientComm.setEntryBasePriceByContractID(StockingComm.PRRICE_OUT_TYPE,contractID,kdtEntrys.getRow(rowIndex));
			//触发单价事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
		}
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
		String farmerID=null,farmID=null,houseID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		if(prmthouse.getValue()!=null) {
			houseID=((IPropertyContainer) prmthouse.getValue()).getString("id");
		}
		StockingClientComm.setStockingBatchFilter(prmtstockingBatch,curCompanyID,farmerID,farmID,houseID);
		prmtstockingBatch.setRequired(false);
		//养殖户过滤
		StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingClientComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID);

		//合同过滤
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		ev.setFilter(filter);
		prmtbatchContract.setEntityViewInfo(ev);
	}

	/**
	 * 设置棚舍过滤条件
	 */
	private void setHouseFilter() {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("parent.baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		if(this.prmtfarm.getValue()!=null) {
			filter.getFilterItems().add(new FilterItemInfo("parent.id",((IPropertyContainer) this.prmtfarm.getValue()).getString("id"),CompareType.EQUALS));
		}
		ev.setFilter(filter);
		this.prmthouse.setEntityViewInfo(ev);
	}

	/**
	 * 设置棚舍过滤条件
	 */
	private void setEntryHouseFilter() {
		if(kdtEntrys.getColumn("house")==null) {
			return;
		}
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("parent.baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		String farmID=null;
		if(this.prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) this.prmtfarm.getValue()).getString("id");
		}
		filter.getFilterItems().add(new FilterItemInfo("parent.id",farmID,CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox)kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);

		isHouseManager=false;
		if(prmtfarm.getValue()==null) {
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(true);
		}else{
			try {
				if((Boolean) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "isHouseManager")) {
					kdtEntrys.getColumn("house").getStyleAttributes().setHided(false);
					isHouseManager=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
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
		//        editData.setFarmer(null);
		editData.setBizDate(new java.util.Date());
		editData.setStockingBatch(null);
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
		//		if(sysSetting.isIsHouseManager()&&prmthouse.getValue()==null) {
		//			MsgBox.showWarning("棚舍不能为空！");
		//			SysUtil.abort();
		//		}
		
		//保存钱检验批次合同是否必录
		FarmInfo farmInfo = null;
		if(editData.getFarm() != null){
			farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(editData.getFarm().getId()));
			if("养户放养".equalsIgnoreCase(farmInfo.getFarmType().toString())){
				if(editData.getBatchContract() == null){
					MsgBox.showWarning("养殖场类别为养户放养，批次合不允许为空！");
					SysUtil.abort();
				}
			}
		}
			
		
		
		if(isHouseManager){//sysSetting.isIsHouseManager()
			ArrayList<String> list=new ArrayList<String>();
			String houseID,materialID;
			for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
				if(kdtEntrys.getCell(rowIndex, "house").getValue()==null) {
					MsgBox.showWarning("已启用批次管理，分录第+"+(rowIndex+1)+"行棚舍不能为空！");
					SysUtil.abort();
				}else{
					houseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
					materialID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
					if(list.contains(houseID+"||"+materialID)) {
						MsgBox.showWarning("分录第"+(rowIndex+1)+"行棚舍+物料重复！");
						SysUtil.abort();
					}else{
						list.add(houseID+"||"+materialID);
					}
				}
			}
		}
	}

	/***
	 * 提交前校验
	 * @throws Exception 
	 */
	private void beforeSubmit() throws Exception{
		this.verifyInput(null);

		//判断养殖场类别，如果是 养殖场的养殖场类别是  等于养护放养    批次合同必填
		FarmInfo farmInfo = null;
		if(editData.getFarm() != null){
			farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(editData.getFarm().getId()));

			if("养户放养".equalsIgnoreCase(farmInfo.getFarmType().toString())){
				String batchID=StockingComm.getBatchIDByContractID(null, ((IPropertyContainer) prmtbatchContract.getValue()).getString("id"));
				if(StringUtils.isNotBlank(batchID)) {
					if(batchID.equalsIgnoreCase(StockingComm.IsExistMutiStockingBatch)) {
						if(MsgBox.showConfirm2("当前合同已经被其他批次多个批次引用，是否继续领出？")==MsgBox.OK) {

						}else{
							SysUtil.abort();
						}
					}else{
						IStockingBatch iss = StockingBatchFactory.getRemoteInstance();
						StockingBatchInfo batchInfo = iss.getStockingBatchInfo(new ObjectUuidPK(batchID));
						if(!batchInfo.getNumber().trim().equals(this.txtstockingBatchNum.getText().trim())) {
							if(MsgBox.showConfirm2("当前合同已经被其他批次引用("+batchInfo.getNumber()+")，是否继续领出？")==MsgBox.OK) {

							}else{
								SysUtil.abort();
							}
						}
					}
				}
			}



		}

	}

}