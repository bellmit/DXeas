/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.CloseStatus;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.sun.syndication.io.FeedException;

/**
 * output class name
 */
public class ConFeedContractEditUI extends AbstractConFeedContractEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(ConFeedContractEditUI.class);
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//组织
	private boolean isLoad=false;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	public ConFeedContractEditUI() throws Exception{
		super();
	}

	/**
	 * output loadFields method
	 */
	public void loadFields(){
		actionCopy.setVisible(false);
		actionCopy.setEnabled(true);
		ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
		ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
		ListenerUtil.F7RemoveDateChangeListenerForDate(pkbeginDate);

        ObjectValueRender kdtFeedEntrys_conFeedPolicy_OVR = new ObjectValueRender();
        kdtFeedEntrys_conFeedPolicy_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFeedEntrys.getColumn("conFeedPolicy").setRenderer(kdtFeedEntrys_conFeedPolicy_OVR);
        
		super.loadFields();
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
		setUIStatus();
		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				if(prmtfarmer.getValue()!=null){
					if(!isLoad){
						isLoad=true;
						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
						SelectorItemCollection slor=new SelectorItemCollection();
						slor.add("*");
						slor.add("farmerType.*");
						slor.add("person.*");
						try {
							FarmerInfo farmer = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(((IPropertyContainer)prmtfarmer.getValue()).getString("id")), slor);
							prmtfarmerType.setValue(farmer.getFarmerType());
							prmtperson.setValue(farmer.getPerson());
							txtidentity.setText(farmer.getIdentity());
							if(prmtfarm.getValue()!=null){
								String gm = (String) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "gm");
								String address = (String) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "address");
								txtgm.setText(gm);
								txtfarmAddress.setText(address);
							}else{
								txtgm.setText(null);
								txtfarmAddress.setText(null);
							}
						} catch (EASBizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BOSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setFeedEntrys();
						isLoad=false;
					}
				}else{
					txtgm.setText(null);
					prmtfarmerType.setValue(null);
					prmtperson.setValue(null);
					txtidentity.setText(null);
					prmtfarm.setValue(null);
				}
				setFilter();
			}
		});

		prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(!isLoad){
					isLoad=true;
					if(prmtfarm.getValue()!=null){
						try {
							prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
							String gm = (String) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "gm");
							String address = (String) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "address");
							txtgm.setText(gm);
							txtfarmAddress.setText(address);
						} catch (DataAccessException e) {
							e.printStackTrace();
						} catch (BOSException e) {
							e.printStackTrace();
						}
					}else{
						txtgm.setText(null);
						txtfarmAddress.setText(null);
					}
					setFeedEntrys();
					isLoad=false;
				}
				setFilter();
			}});

		kdtPolicyEntry.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				kdtPolicyEntry_changed(e.getRowIndex(),e.getColIndex());
				super.editStopped(e);
			}
			@Override
			public void editStarting(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarting(e);
				int colIndex = e.getColIndex();
				int rowIndex = e.getRowIndex();
				if(kdtPolicyEntry.getColumnKey(colIndex).equalsIgnoreCase("isDefault")){
					kdtPolicyEntry.getCell(rowIndex, "isDefault").setValue(true);
					if(UIRuleUtil.getBooleanValue(kdtPolicyEntry.getCell(rowIndex, "isDefault").getValue())){
						for(int i=0;i<kdtPolicyEntry.getRowCount();i++){
							if(i==rowIndex){
								continue;
							}
							kdtPolicyEntry.getCell(i, "isDefault").setValue(false);
						}
					}
				}
			}}
		);

		txtyear.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(txtyear.getIntegerValue()!=null&&pkbeginDate.getValue()!=null){
					try {
						int year=txtyear.getIntegerValue();
						Date beginDate=(Date) pkbeginDate.getValue();
						Calendar cal=Calendar.getInstance();
						cal.setTime(sdf.parse(sdf.format(beginDate)));
						cal.add(Calendar.YEAR, year);
						pkendDate.setValue(cal.getTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		});

		pkbeginDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				if(!isLoad){
					isLoad=true;
					if(txtyear.getIntegerValue()!=null&&pkbeginDate.getValue()!=null){
						try {
							int year=txtyear.getIntegerValue();
							Date beginDate=(Date) pkbeginDate.getValue();
							Calendar cal=Calendar.getInstance();
							cal.setTime(sdf.parse(sdf.format(beginDate)));
							cal.add(Calendar.YEAR, year);
							pkendDate.setValue(cal.getTime());
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					isLoad=false;
				}
			}});

		kdtPolicyEntry_detailPanel.addAddListener(new IDetailPanelListener(){
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				// TODO Auto-generated method stub
				ConFeedContractPolicyEntryInfo objectValue = (ConFeedContractPolicyEntryInfo) e.getObjectValue(); //获取分录对象
				objectValue.setBeginDate(new Date());
			}
			public void afterEvent(DetailPanelEvent arg0) throws Exception {
			}
		});

		txtinitSettledNum.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				txtcurSettledNum.setValue(UIRuleUtil.getIntValue(txtinitSettledNum.getIntegerValue()));
			}
		});
		txtinitSubsidies.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				txtcumulativeSub.setValue(UIRuleUtil.getBigDecimal(txtinitSubsidies.getBigDecimalValue()));
			}
		});
	}


	private void kdtPolicyEntry_changed(int rowIndex, int colIndex) {
		if(kdtPolicyEntry.getColumnKey(colIndex).equalsIgnoreCase("beginDate")||kdtPolicyEntry.getColumnKey(colIndex).equalsIgnoreCase("confeedPolicy")){
			if(kdtPolicyEntry.getCell(rowIndex, "confeedPolicy").getValue()!=null&&kdtPolicyEntry.getCell(rowIndex, "beginDate").getValue()!=null){
				try {
					kdtPolicyEntry.getCell(rowIndex, "year").setValue(null);
					int year=((IPropertyContainer)kdtPolicyEntry.getCell(rowIndex, "confeedPolicy").getValue()).getInt("enableYear");
					String confeedPolicyID = ((IPropertyContainer)kdtPolicyEntry.getCell(rowIndex, "confeedPolicy").getValue()).getString("id");
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add("*");
					slor.add("breed.*");
					ConFeedPolicyInfo policyInfo=ConFeedPolicyFactory.getRemoteInstance().getConFeedPolicyInfo(new ObjectUuidPK(confeedPolicyID),slor);
					kdtPolicyEntry.getCell(rowIndex, "breedData").setValue(policyInfo.getBreed());
					kdtPolicyEntry.getCell(rowIndex, "year").setValue(year);
					Date beginDate=(Date)kdtPolicyEntry.getCell(rowIndex, "beginDate").getValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(sdf.parse(sdf.format(beginDate)));
					cal.add(Calendar.YEAR, year);
					kdtPolicyEntry.getCell(rowIndex, "endDate").setValue(cal.getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (EASBizException e) {
					e.printStackTrace();
				} catch (BOSException e) {
					e.printStackTrace();
				}
			}else{
				kdtPolicyEntry.getCell(rowIndex, "year").setValue(null);
				kdtPolicyEntry.getCell(rowIndex, "breedData").setValue(null);
			}
		}
	}

	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		int defaultRows=0;
		for(int i=0;i<kdtPolicyEntry.getRowCount();i++){
			if(UIRuleUtil.getBooleanValue(kdtPolicyEntry.getCell(i, "isDefault").getValue())){
				defaultRows++;
			}
		}
		if(kdtPolicyEntry.getRowCount()==0||defaultRows!=1){
			MsgBox.showWarning("连养政策必须且只能选择一行为默认政策");
			SysUtil.abort();
		}
		super.beforeStoreFields(arg0);
	}

	private void setUIStatus() {
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
			actionEdit.setEnabled(false);
			actionCancel.setEnabled(true);
			actionSave.setEnabled(false);
			actionSubmit.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
			actionCancelCancel.setEnabled(false);
			actionCancel.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)){
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			actionCancelCancel.setEnabled(true);
			actionEdit.setEnabled(false);
			actionCancel.setEnabled(false);
			actionSave.setEnabled(false);
			actionSubmit.setEnabled(false);
		}else{
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			actionCancelCancel.setEnabled(false);
			actionCancel.setEnabled(false);
			actionEdit.setEnabled(true);
		}
	}

	@Override
	public void actionUpdateFeed_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		beforeStoreFields(e);
		storeFields();
		if(oprtState.equalsIgnoreCase("addnew")){
			MsgBox.showWarning("新增单据不能执行此操作,请先保存/提交单据.");
			SysUtil.abort();
		}
		super.actionUpdateFeed_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("更新完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}


	private void setFeedEntrys() {
		if(editData.getId()==null){
			return;
		}
		kdtFeedEntrys.removeRows();
		if(prmtfarmer.getValue()==null||prmtfarm.getValue()==null){
			return;
		}
		String farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
		String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
		try {
			IBatchContractBill iBatchContractBill = BatchContractBillFactory.getRemoteInstance();
			IConFeedPolicy iConFeedPolicy = ConFeedPolicyFactory.getRemoteInstance();
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" SELECT  t1.fid fid, ")
			.append(" t1.CFConFeedPolicyID CFConFeedPolicyID, ")
			.append(" t1.CFSUBSIDYPRICE subsidyPrice, ")
			.append(" t1.FActualBreedDate actualBreedDate, ")
			.append(" t1.FActualFemaleQty actualFemaleQty, ")
			.append(" t2.CFConFeedSubsidies conFeedSubsidies, ")
			.append(" case when (t1.CFIsRecSettled is null or t1.CFIsRecSettled=0) then  '未结算' ")
			.append(" else  '已结算' end settleStatus, ")
			.append(" t2.CFRecDate recDate, ")
			.append(" t2.CFContractCKWgt contractCKWgt ")
			.append(" FROM T_FM_BatchContractBill t1 ")
			.append(" left join CT_FM_CKSettleBill t2 on (t1.fid=t2.CFBatchContractID and t2.CFBillStatus=4) ")
			.append(" where t1.FBILLSTATUS=4 ")
			.append(" and t1.FFarmerID='"+farmerID+"' and t1.FFarmID='"+farmID+"'")
			.append(" and t1.CFConFeedContractI='"+editData.getId().toString()+"'")
			.append(" order by t1.FBizDate desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			while(rs.next()){
				IRow row = kdtFeedEntrys.addRow();
				BatchContractBillInfo batchContractBill = iBatchContractBill.getBatchContractBillInfo(new ObjectUuidPK(rs.getString("fid")));
				row.getCell("batchContract").setValue(batchContractBill);
				if(rs.getString("CFConFeedPolicyID")!=null){
					ConFeedPolicyInfo conFeedPolicy = iConFeedPolicy.getConFeedPolicyInfo(new ObjectUuidPK(rs.getString("CFConFeedPolicyID")));
					row.getCell("conFeedPolicy").setValue(conFeedPolicy);
				}
				row.getCell("subsidyPrice").setValue(rs.getBigDecimal("subsidyPrice"));
				row.getCell("inDate").setValue(rs.getDate("actualBreedDate"));
				row.getCell("batchQty").setValue(rs.getBigDecimal("actualFemaleQty"));
				row.getCell("recDate").setValue(rs.getDate("recDate"));
				row.getCell("inContractWgt").setValue(rs.getBigDecimal("contractCKWgt"));
				row.getCell("subsidyAmount").setValue(rs.getBigDecimal("conFeedSubsidies"));
				row.getCell("settleStatus").setValue(rs.getString("settleStatus"));
			}
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		if(editData.getId()==null){
			super.actionPre_actionPerformed(e);
		}
	}

	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		super.verifyInput(e);
		if(editData.getBeginDate()!=null&&editData.getEndDate()!=null){
			if(!editData.getBeginDate().before(editData.getEndDate())){
				MsgBox.showWarning("结束日期不能早于开始日期");
				SysUtil.abort();
			}
		}
	}

	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		contCreateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
		contLastUpdateTime.setVisible(true);
		txtgm.setEnabled(false);
		CompanyF7 cf7=new CompanyF7();
		prmtcompany.setSelector(cf7);
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);

		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		kdtPolicyEntry.getColumn("isDefault").setEditor(kdtEntrys_Status_CellEditor); 

		orgInfo = SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Company);
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFilter();
			}});
		setFilter();
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		removeBtnAndLocked(new DetailPanel[]{kdtFeedEntrys_detailPanel});
	}

	private void removeBtnAndLocked(DetailPanel[] detailPanels) {
		for(DetailPanel detailPanel:detailPanels){
			detailPanel.getEntryTable().setEditable(false);
			detailPanel.getAddNewLineButton().setVisible(false);
			detailPanel.getInsertLineButton().setVisible(false);
			detailPanel.getRemoveLinesButton().setVisible(false);
			detailPanel.getEntryTable().getStyleAttributes().setLocked(true); 
		}
	}

	//设置隔离
	private void setFilter() {
		String curCompanyID;
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		Date bizDate=pkBizDate.getValue()==null?null:(Date)pkBizDate.getValue();
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID,true);
		//连养政策过滤
		StockingComm.setConFeedPolicyFilter((KDBizPromptBox)kdtPolicyEntry.getColumn("confeedPolicy").getEditor().getComponent(), curCompanyID, bizDate);	
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception{
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
		setUIStatus();
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
		setUIStatus();
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		objectValue.setBeginDate(new Date());
		return objectValue;
	}

}