/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseCollection;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class CTransFodderBillEditUI extends AbstractCTransFodderBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CTransFodderBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private SystemSettingInfo sysSetting;
	private WarehouseInfo wareHouseInfo=null;
	/**
	 * output class constructor
	 */
	public CTransFodderBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	public void loadFields()
	{
		actionCopy.setVisible(false);
		actionCopy.setEnabled(true);
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
		UITools.apendFootRow(kdtEntrys, new String[]{"transQty","orderAmount","bagQty","amount"});


		//仓库
		if(prmtstorageOrgUnit.getValue()!=null){
			curStorageOrgUnitID=((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id");
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
			ev.setFilter(filter);
			((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
			((KDBizPromptBox) this.kdtEntrys.getColumn("orderWarehouse").getEditor().getComponent()).setEntityViewInfo(ev);
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


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		sysSetting = StockingComm.getSystemSettingInfo(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
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


	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		Boolean isSanZhuan=false;
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {

			if(this.kdtEntrys.getCell(rowIndex, "unitQty").getValue()==null||((BigDecimal)this.kdtEntrys.getCell(rowIndex, "unitQty").getValue()).signum()==0){
				isSanZhuan=true;
			}

			BigDecimal transQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "transQty").getValue());
			if(transQty.signum()<=0){
				MsgBox.showWarning("分录第"+(rowIndex+1)+"行转料数量不能为空或小于等于0");
				SysUtil.abort();
			}

			BigDecimal amount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "amount").getValue());
			if(amount.signum()<=0){
				MsgBox.showWarning("分录第"+(rowIndex+1)+"行转出金额不能为空或小于等于0");
				SysUtil.abort();
			}

			BigDecimal orderAmount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "orderAmount").getValue());
			if(orderAmount.signum()<=0){
				MsgBox.showWarning("分录第"+(rowIndex+1)+"行目标领用金额不能为空或小于等于0");
				SysUtil.abort();
			}
		}
//		if(isSanZhuan&&kdtEntrys.getRowCount()>1){
//			MsgBox.showWarning("包含散装料的饲料领用单只能有一行分录!");
//			SysUtil.abort();
//		}
	}

	private void initControl() throws Exception {
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
		((KDBizPromptBox) this.kdtEntrys.getColumn("orderWarehouse").getEditor().getComponent()).setEntityViewInfo(ev);

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
				prmtfarm.setValue(null);
				if(prmtfarmer.getValue()!=null){
					if(!isLoadField) {
						String farmerID=null,farmID=null;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarm);
						ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
						//						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
						ListenerUtil.F7AddDateChangeListener(prmtfarm, listener);
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						isLoadField=false;
					}
				}
				setFilter();
			}});

		this.prmttargetFarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmttargetFarm.setValue(null);
				if(prmttargetFarmer.getValue()!=null){
					if(!isLoadField) {
						String farmerID=null,farmID=null;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmttargetFarm);
						ListenerUtil.F7RemoveDateChangeListener(prmttargetFarm);
						//						StockingComm.setFarmInfoByFarmer(prmttargetFarmer, prmttargetFarm);
						ListenerUtil.F7AddDateChangeListener(prmttargetFarm, listener);
						farmerID=((IPropertyContainer)prmttargetFarmer.getValue()).getString("id");
						//						if(prmttargetFarm.getValue()!=null){
						//							farmID=((IPropertyContainer)prmttargetFarm.getValue()).getString("id");
						//							prmttargetBatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
						//						}	
						isLoadField=false;
					}}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtbatchContract.setValue(null);
				if(prmtfarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarmer);
						ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
						prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
						ListenerUtil.F7AddDateChangeListener(prmtfarmer, listener);
						isLoadField=false;
					}
					
					FarmInfo farmInfo = (FarmInfo)prmtfarm.getValue();
					try {
						farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
						//设置成本中心
						if(farmInfo.getCostCenter() != null){
							CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(farmInfo.getCostCenter().getId()));
							prmtoutCostCenter.setValue(costCenter);
						}
						
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				setFilter();
				
				//设置批次合同
				try {
					if(prmtfarmer.getValue() != null && prmtfarm.getValue() != null){
						String s1 = "/*dialect*/ select t1.fid billid from T_FM_BatchContractBill t1 where t1.CFIsRecSettled = 0 and t1.FFarmerID ='"+((FarmerInfo)prmtfarmer.getValue()).getId()+"' and t1.FFarmID = '"+((FarmInfo)prmtfarm.getValue()).getId()+"'";
						IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
						if(r1.next()){
							String billid = UIRuleUtil.getString(r1.getString("billid"));
							BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(billid));
							prmtbatchContract.setValue(contractInfo);
						}
					}
					prmtbatchContract_Changed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});

		this.prmttargetFarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmttargetBatchContract.setValue(null);
				if(prmttargetFarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmttargetFarmer);
						ListenerUtil.F7RemoveDateChangeListener(prmttargetFarmer);
						prmttargetFarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmttargetFarm));
						ListenerUtil.F7AddDateChangeListener(prmttargetFarmer, listener);
						String farmerID = null;
						isLoadField=false;
					}
					
					FarmInfo farmInfo = (FarmInfo)prmttargetFarm.getValue();
					try {
						farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
						//设置成本中心
						if(farmInfo.getCostCenter() != null){
							CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(farmInfo.getCostCenter().getId()));
							prmtinCostCenter.setValue(costCenter);
						}
						
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				setFilter();
				
				//设置批次合同
				try {
					if(prmttargetFarmer.getValue() != null && prmttargetFarm.getValue() != null){
						String s1 = "/*dialect*/ select t1.fid billid from T_FM_BatchContractBill t1 where t1.CFIsRecSettled = 0 and t1.FFarmerID ='"+((FarmerInfo)prmttargetFarmer.getValue()).getId()+"' and t1.FFarmID = '"+((FarmInfo)prmttargetFarm.getValue()).getId()+"'";
						IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
						if(r1.next()){
							String billid = UIRuleUtil.getString(r1.getString("billid"));
							BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(billid));
							prmttargetBatchContract.setValue(contractInfo);
						}
					}
					targetBatchContract_Changed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});


		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});


		this.prmttargetBatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				targetBatch_changed(e);
			}});

		prmtbatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				try {
					prmtbatchContract_Changed(arg0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});

		prmttargetBatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				try {
					targetBatchContract_Changed(arg0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});


		this.prmtcar.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtcar.getValue()!=null){
					SelectorItemCollection slor =new SelectorItemCollection();
					slor.add("*");
					slor.add("Entry.*");
					slor.add("Entry.driver.*");
					try {
						if(!isLoadField){
							isLoadField=true;
							CarInfo car=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(((IPropertyContainer)prmtcar.getValue()).getString("id")), slor);
							CarEntryCollection carEntry=car.getEntry();
							for(int i=0;i<carEntry.size();i++){
								CarEntryInfo entry =carEntry.get(i);
								if(entry.isIsDefault()){
									prmtdriver.setValue(entry.getDriver());
									break;
								}
							}
							isLoadField=false;
						}
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					prmtdriver.setValue(null);
				}
				setFilter();
			}
		});

		this.prmtdriver.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtdriver.getValue()!=null){
					try {if(!isLoadField){
						isLoadField=true;
						String driverID=((IPropertyContainer)prmtdriver.getValue()).getString("id");
						String sql="select distinct t1.fid fid from CT_PUB_Car t1 inner join T_PUB_CarEntry t2 on t1.fid=t2.fparentid where t2.FDriverID='"+driverID+"' and t1.CFBaseStatus=2";
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
						if(rs.next()){
							CarInfo carInfo=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(rs.getString("fid")));
							prmtcar.setValue(carInfo);
						}
						isLoadField=false;
					}
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
				}
				setFilter();
			}
		});


		final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_material_PromptBox.setEditFormat("$name$");
		kdtEntrys_material_PromptBox.setCommitFormat("$name$;$number$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
		ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
		kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
		this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);


		((KDFormattedTextField)kdtEntrys.getColumn("amount").getEditor().getComponent()).setPrecision(2);
		((KDFormattedTextField)kdtEntrys.getColumn("orderAmount").getEditor().getComponent()).setPrecision(2);
		setFilter();


		Toolkit tk = Toolkit.getDefaultToolkit();  
		tk.addAWTEventListener(new AWTEventListener(){
			public void eventDispatched(AWTEvent event) {
				if (event.getClass() == KeyEvent.class) {  
					// 被处理的事件是键盘事件.  
					KeyEvent keyEvent = (KeyEvent) event;
					if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
						keyPressed(keyEvent);  
					} else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {  
						//放开时你要做的事情  
						keyReleased(keyEvent);  
					}  
				} 		
			}	
			private void keyPressed(KeyEvent event) {}
			private void keyReleased(KeyEvent event) {
				int code = event.getKeyCode();
				if(event.isControlDown()&&code==KeyEvent.VK_DOWN &&!oprtState.equalsIgnoreCase("view"))
				{
					kdtEntrys.addRow();
				}	
			}
		}, AWTEvent.KEY_EVENT_MASK);  

	}



	public void prmtbatchContract_Changed(DataChangeEvent arg0) throws Exception {
		if(prmtbatchContract.getValue()!=null){
			String contractID=((IPropertyContainer) prmtbatchContract.getValue()).getString("id");
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("person.*");
			slor.add("batch.*");
			slor.add("settlementPolicy.*");
			BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(contractID),slor );
			//			prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
			prmtperson.setValue(contractInfo.getPerson());
			
			//设置成本中心
			if(contractInfo.getCostCenter() != null){
				CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(contractInfo.getCostCenter().getId()));
				prmtoutCostCenter.setValue(costCenter);
			}
			
			
			prmtbreedData.setValue(contractInfo.getBreedData());
			checkKdtEntry(contractInfo.getSettlementPolicy());
			String batchID=StockingComm.getBatchIDByContractID(null, contractID);
			isLoadField=true;
			if(StringUtils.isNotEmpty(batchID)) {
				this.prmtbatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
			}else {
				this.prmtbatch.setValue(null);
			}
			isLoadField=false;
		}else{
			this.prmtbatch.setValue(null);
			//			prmtsettlePolicy.setValue(null);
			prmtbreedData.setValue(null);
			prmtperson.setValue(null);
			kdtEntrys.removeRows();
		}
		if(kdtEntrys.getRowCount()==0){
			kdtEntrys.addRow();
		}
		setFilter();
	}



	private void checkKdtEntry(SettlePolicyInfo policy) {
		// TODO Auto-generated method stub
		SettlePolicyPriceEntryCollection priceEntrys = policy.getPriceEntry();
		for(int i=kdtEntrys.getRowCount()-1;i>=0;i--){
			if(kdtEntrys.getCell(i, "material").getValue()==null){
				kdtEntrys.removeRow(i);
			}else{
				Boolean isHas=false;
				String materialID=((IPropertyContainer)kdtEntrys.getCell(i, "material").getValue()).getString("id");
				for(int j =0;j<priceEntrys.size();j++){
					try {
						SettlePolicyPriceEntryInfo priceEntry=SettlePolicyPriceEntryFactory.getRemoteInstance().getSettlePolicyPriceEntryInfo(new ObjectUuidPK(priceEntrys.get(j).getId()));
						if(materialID.equals(priceEntry.getMaterial().getId().toString())){
							calPrice(i, materialID);
							calAmount(i);
							isHas=true;
						}
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(!isHas){
					kdtEntrys.removeRow(i);
				}
			}
		}
	}


	public void targetBatchContract_Changed(DataChangeEvent arg0) throws Exception {
		if(prmttargetBatchContract.getValue()!=null){
			String contractID=((IPropertyContainer) prmttargetBatchContract.getValue()).getString("id");
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("person.*");
			slor.add("batch.*");
			slor.add("settlementPolicy.*");
			BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(contractID),slor );
			//			prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
			prmttargetPerson.setValue(contractInfo.getPerson());
			
			//设置成本中心
			if(contractInfo.getCostCenter() != null){
				CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(contractInfo.getCostCenter().getId()));
				prmtinCostCenter.setValue(costCenter);
			}
			
			prmttargetBreedData.setValue(contractInfo.getBreedData());
			checkKdtEntry(contractInfo.getSettlementPolicy());
			String batchID=StockingComm.getBatchIDByContractID(null, contractID);
			isLoadField=true;
			if(StringUtils.isNotEmpty(batchID)) {
				this.prmttargetBatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
			}else {
				this.prmttargetBatch.setValue(null);
			}
			isLoadField=false;
		}else{
			this.prmttargetBatch.setValue(null);
			//			prmtsettlePolicy.setValue(null);
			prmtperson.setValue(null);
			prmttargetBreedData.setValue(null);
		}
		setFilter();
	}

	/**
	 * 批次改变
	 */
	private void batch_changed(DataChangeEvent e) {
		isLoadField=true;
		if(e.getNewValue()!=null) {
			try {
				pkinDate.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "inDate"));
				txtbatchQty.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "femaleQty"));
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (BOSException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}		
		}else{
			pkinDate.setValue(null);
			txtbatchQty.setValue(null);
		}
		isLoadField=false;
	}

	/**
	 * 目标批次改变
	 */
	private void targetBatch_changed(DataChangeEvent e) {
		isLoadField=true;
		if(e.getNewValue()!=null) {
			try {
				pktargetIndate.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "inDate"));
				txttargetBatchQty.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "femaleQty"));
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (BOSException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}		
		}else{
			pktargetIndate.setValue(null);
			txttargetBatchQty.setValue(null);
		}
		isLoadField=false;
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
		editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		//        editData.setNumber(null);
		//		editData.setFarmer(null);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		//		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		//		editData.setPerson(null);
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;

		setMakeRelations(null);

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
		((KDBizPromptBox) this.kdtEntrys.getColumn("orderWarehouse").getEditor().getComponent()).setEntityViewInfo(ev);
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
		String farmerID="";
		String farmID="";
		farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		farmID=prmtfarm.getValue()==null?"":((FarmInfo)prmtfarm.getValue()).getId().toString();
		String targetFarmerID="";
		String targetFarmID="";
		targetFarmerID=prmttargetFarmer.getValue()==null?"":((FarmerInfo)prmttargetFarmer.getValue()).getId().toString();
		targetFarmID=prmttargetFarm.getValue()==null?"":((FarmInfo)prmttargetFarm.getValue()).getId().toString();

		//批次过滤
		StockingComm.setStockingBatchFilter(prmtbatch,curCompanyID,farmerID,farmID,true,false);
		StockingComm.setStockingBatchFilter(prmttargetBatch,curCompanyID,targetFarmerID,targetFarmID,true,false);
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		StockingComm.setFarmerFilter(prmttargetFarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);
		StockingComm.setFarmFilter(prmttargetFarm, curCompanyID, targetFarmerID,true);
		//合同过滤
		StockingComm.setBatchContractFilter(prmtbatchContract, curCompanyID,farmerID,farmID,true,true);
		StockingComm.setBatchContractFilter(prmttargetBatchContract, curCompanyID,targetFarmerID,targetFarmID,true,true);

		//物料过滤
		KDBizPromptBox material  = (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent();
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		FilterInfo filter2=new FilterInfo();
		String policyID;
		if(prmtbatchContract.getValue()!=null){
			try {
				if(UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")!=null){
					policyID = ((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")).getId().toString();
					filter=StockingComm.getMaterialFilter(null, policyID, SettleItemType.FODDER_VALUE);
				}
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                        
		}else{
			filter.getFilterItems().add(new FilterItemInfo("id","",CompareType.EQUALS));
		}

		//		if(prmttargetBatchContract.getValue()!=null){
		//			try {
		//				if(UIRuleUtil.getProperty((IObjectValue) prmttargetBatchContract.getValue(), "settlementPolicy")!=null){
		//					policyID = ((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmttargetBatchContract.getValue(), "settlementPolicy")).getId().toString();
		//					filter2=StockingComm.getMaterialFilter(null, policyID, SettleItemType.FODDER_VALUE);
		//				}
		//			} catch (DataAccessException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			} catch (BOSException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}                        
		//		}else{
		//			filter2.getFilterItems().add(new FilterItemInfo("id","",CompareType.EQUALS));
		//		}
		//
		//		for(int i=0;i<filter2.getFilterItems().size();i++){
		//			filter.getFilterItems().add(filter2.getFilterItems().get(i));	
		//		}	
		ev.setFilter(filter);
		material.setEntityViewInfo(ev);

		//车辆过滤
		String driverID=prmtdriver.getValue()==null?null:((IPropertyContainer)prmtdriver.getValue()).getString("id");
		StockingComm.setCarFilter(prmtcar, curCompanyID,driverID);
		//司机过滤
		String carID=prmtcar.getValue()==null?null:((IPropertyContainer)prmtcar.getValue()).getString("id");
		StockingComm.setDriverFilter(prmtdriver, curCompanyID, carID);
	}

	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);

		//根据数量处罚确认数量事件
		if(kdtEntrys.getColumn(colIndex).getKey().equals("transQty")) {	
			if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue()).signum()!=0){
				if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "transQty").getValue())
						.remainder(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue())).signum()!=0){
					MsgBox.showWarning("有单包重的物料转料数量必须填入包重的整数倍");
					kdtEntrys.getCell(rowIndex, "transQty").setValue(null);
					return;					
				}
				kdtEntrys.getCell(rowIndex,"bagQty").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "transQty").getValue())
						.divide(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue()),0,RoundingMode.HALF_UP));
			}
		}
		//单包重
		if(kdtEntrys.getColumnKey(colIndex).equals("material")&&kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
			kdtEntrys.getCell(rowIndex, "unitQty").setValue(StockingComm.getUnitQty(null, curCompanyID, ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id")));
		}
		if ("bagQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex,"transQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"unitQty").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"bagQty").getValue())));
		}
		UITools.apendFootRow(kdtEntrys, new String[]{"transQty","orderAmount","bagQty","amount"});

		if(kdtEntrys.getColumnIndex("warehouse")==colIndex)
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null)
				wareHouseInfo=(WarehouseInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();

		if(kdtEntrys.getColumnIndex("orderWarehouse")==colIndex)
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null)
				wareHouseInfo=(WarehouseInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();

		if("material".equals(kdtEntrys.getColumnKey(colIndex))){
			if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null){
				String materialID = ((IPropertyContainer)kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
				calPrice(rowIndex, materialID);
				MaterialInventoryInfo mivInfo= StockingComm.getDefaultWarehouseDataByMaterial(null, curStorageOrgUnitID, materialID);
				if(mivInfo!=null){
					kdtEntrys.getCell(rowIndex, "warehouse").setValue(mivInfo.getDefaultWarehouse());
					kdtEntrys.getCell(rowIndex, "orderWarehouse").setValue(mivInfo.getDefaultWarehouse());
				}
			}else{
				kdtEntrys.getCell(rowIndex, "unitQty").setValue(null);
				kdtEntrys.getCell(rowIndex, "transQty").setValue(null);
				kdtEntrys.getCell(rowIndex, "bagQty").setValue(null);
			}
			//			calAveragePrice(rowIndex, materialID);
		}
		calAmount(rowIndex);

	}

	/**
	 * 计算价格
	 * @param rowIndex
	 * @param materialID
	 */
	private void calPrice(int rowIndex, String materialID) {	
		String  policyID="";
		try {
			if(prmtbatchContract.getValue()!=null){
				policyID=((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")).getId().toString();
				BigDecimal price = StockingComm.getBasePrice(null, policyID, materialID);
				kdtEntrys.getCell(rowIndex, "basePrice").setValue(price);
			}

			if(prmttargetBatchContract.getValue()!=null){
				policyID=((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmttargetBatchContract.getValue(), "settlementPolicy")).getId().toString();
				BigDecimal price = StockingComm.getBasePrice(null, policyID, materialID);
				kdtEntrys.getCell(rowIndex, "orderBasePrice").setValue(price);
			}

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 计算金额
	 * @param rowIndex
	 */
	private void calAmount(int rowIndex) {
		// TODO Auto-generated method stub
		BigDecimal amount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "transQty").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "basePrice").getValue())).setScale(2,RoundingMode.HALF_UP);
		kdtEntrys.getCell(rowIndex, "amount").setValue(amount.compareTo(BigDecimal.ZERO)==0?null:amount);
		BigDecimal orderAmount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "transQty").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "orderBasePrice").getValue())).setScale(2,RoundingMode.HALF_UP);
		kdtEntrys.getCell(rowIndex, "orderAmount").setValue(orderAmount.compareTo(BigDecimal.ZERO)==0?null:orderAmount);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		curStorageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");

		//设置默认出库组织
		StorageOrgUnitInfo stoInfo;
		try {
			stoInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK("o9EOw3APRTafTJbDp4e4ssznrtQ="));
			objectValue.setStorageOrgUnit(stoInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return objectValue;
	}

}