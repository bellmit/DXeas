/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType;
import com.kingdee.eas.farm.carnivorous.recyclebiz.client.AbstractCCarSendBillListUI.ActionBatchSubmit;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class CCarSendBillEditUI extends AbstractCCarSendBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CCarSendBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private CompanyOrgUnitInfo company;
	private boolean isLoadField=false;
	private F7ContextManager f7Manager;
	/**
	 * output class constructor
	 */
	public CCarSendBillEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		company=SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
	}
	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		pkarriveTime.setTimeEnabled(true);
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
	}

	private void initControl() {
		// TODO Auto-generated method stub
		this.prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();			
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarmer.getValue()!=null){
					if(!isLoadField) {
						isLoadField=true;
						String farmerID=null,farmID=null;
						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						try {
							FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerID));
							txtfarmerPhone.setText(farmer.getMobileTel());
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(prmtfarm.getValue()!=null){
							farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
						}	
						isLoadField=false;
					}}else{
						prmtfarm.setValue(null);
						txtfarmerPhone.setText(null);
					}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
						isLoadField=false;
					}
					String farmerID = null;
					if(prmtfarmer.getValue()!=null){
						String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						try {
							FarmInfo  farm=FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmID));
							txtfarmAddress.setText(farm.getAddress());
							farmType.setSelectedItem(farm.getFaemsType());
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));

					}
				}else{
					prmtbatchContract.setValue(null);
					txtfarmAddress.setText(null);
					farmType.setSelectedItem(null);
				}
				setFilter();
			}});

		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});

		prmtbatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					prmtbatchContract_Changed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});

		saleType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				prmtcustomer.setValue(null);
				setFilter();
			}
		});

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
		/**
		 * 日期添加监听事件
		 */
		pkBizDate.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				infoQuery();
			}

		});

		setFilter();
	}

	/**
	 * 根据每个批次日龄计算出栏批次（标准出栏计划43~47日龄）
	 */
	protected void infoQuery() {
		// TODO Auto-generated method stub

		//根据财务组织获取批次信息
		if(prmtFICompany.getValue() != null && pkBizDate.getValue() != null){
			try {
				CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) prmtFICompany.getValue();
				String s1 = "/*dialect*/ select t1.fid  batchid,t1.FFarmID FFarmID,t1.FFarmerID FFarmerID,t1.FInDate FInDate, " +
				" t2.FAddress address, t3.FMobileTel mobileTel,t1.FFemaleQty inQty" +
				" from T_FM_Batch t1 inner join CT_FM_Farm t2 on t2.fid = t1.FFarmID inner join CT_FM_Farmer t3 on t3.fid = t1.FFarmerID where t1.FCompanyID ='"+companyInfo.getId()+"'";
				IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
				String batchid = null;
				String FFarmID = null;
				String FFarmerID = null;
				String address = null;
				String mobileTel = null;
				Date FInDate = null;
				BigDecimal inQty = BigDecimal.ZERO;
				while(r1.next()){
					batchid = UIRuleUtil.getString(r1.getString("batchid"));
					FFarmID = UIRuleUtil.getString(r1.getString("FFarmID"));
					FFarmerID = UIRuleUtil.getString(r1.getString("FFarmerID"));
					address = UIRuleUtil.getString(r1.getString("address"));
					mobileTel = UIRuleUtil.getString(r1.getString("mobileTel"));
					FInDate = UIRuleUtil.getDateValue(r1.getDate("FInDate"));
					inQty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("inQty"));
					//根据上苗日期和业务日期计算纯日龄
					int days = calDays((Date)pkBizDate.getValue(), FInDate);
					if(days >= 43 && days <= 47){
						kdtEntry.removeRows();
						IRow row = kdtEntry.addRow();
						BatchInfo batchInfo = BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchid));
						FarmerInfo farmerInfo = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(FFarmerID));
						FarmInfo farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(FFarmID));

						row.getCell("farmer").setValue(farmerInfo);
						row.getCell("farm").setValue(farmInfo);
						row.getCell("farmAddress").setValue(address);
						row.getCell("farmerTele").setValue(mobileTel);
						row.getCell("batch").setValue(batchInfo);
						row.getCell("inDate").setValue(FInDate);
						row.getCell("inQty").setValue(inQty);
						row.getCell("days").setValue(days);
					}

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
	}
	/**
	 * 根据上苗日期和业务日期计算纯日龄
	 * @param value
	 * @param inDate
	 * @throws EASBizException 
	 */
	private int calDays(Date bizDate, Date batchDate) throws EASBizException {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		cal.setTime(bizDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		bizDate=cal.getTime();

		cal.setTime(batchDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		batchDate=cal.getTime();

		if(bizDate.getTime()<batchDate.getTime()) {
			throw new EASBizException(new NumericExceptionSubItem("001","当前业务日期小于批次入栏日期"));
		}
		long timeDiff=bizDate.getTime()-batchDate.getTime();

		long diffDays=timeDiff/(1000*60*60*24);
		return (int) diffDays;
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
			prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
			prmtbreedData.setValue(contractInfo.getBreedData());
			prmtperson.setValue(contractInfo.getPerson());
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
			prmtsettlePolicy.setValue(null);
			prmtperson.setValue(null);
			prmtbreedData.setValue(null);
		}
		setFilter();
	}

	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtFICompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
			try {
				company=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(curCompanyID));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}else{
			curCompanyID=null;
		}
		f7Manager.registerBizCustomerF7(prmtcustomer, null, null, company);

		String farmerID="";
		String farmID="";

		farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		farmID=prmtfarm.getValue()==null?"":((FarmInfo)prmtfarm.getValue()).getId().toString();

		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);
		//合同过滤
		StockingComm.setBatchContractFilter(prmtbatchContract, curCompanyID,farmerID,farmID,true,true);
		//客户过滤
		StockingComm.setCustomerFilterBySale(prmtcustomer, saleType.getSelectedItem()==null?null:(SaleBizType) saleType.getSelectedItem());
		//车辆过滤
		String driverID=prmtdriver.getValue()==null?null:((IPropertyContainer)prmtdriver.getValue()).getString("id");
		StockingComm.setCarFilter(prmtcar, curCompanyID,driverID);
		//司机过滤
		String carID=prmtcar.getValue()==null?null:((IPropertyContainer)prmtcar.getValue()).getString("id");
		StockingComm.setDriverFilter(prmtdriver, curCompanyID, carID);
	}


	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
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


	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

}