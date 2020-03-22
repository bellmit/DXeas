/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.service.job.wrapper.SqlExecutor;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicy;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class MarginUnlockBillEditUI extends AbstractMarginUnlockBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MarginUnlockBillEditUI.class);

	/**
	 * output class constructor
	 */
	public MarginUnlockBillEditUI() throws Exception
	{
		super();
	}
	private boolean isLoadField=false;


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setUITitle("占用保证金解锁单");
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		setFilter();
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);

		for(int i=0;i<kdtEntrys.getColumnCount();i++){
			kdtEntrys.getColumn(i).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		}

		prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent areg0) {
				setFilter();
			}	
		});

		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent areg0) {
				if(prmtfarmer.getValue()!=null){
					try {
						SelectorItemCollection slor =new SelectorItemCollection();
						slor.add("*");
						FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(((IPropertyContainer)prmtfarmer.getValue()).getString("id")), slor);				
						txttotalMargin.setValue(farmer.getTotalMargin());
						txtoccupyMargin.setValue(farmer.getOccupyMargin());
						txtenableMargin.setValue(farmer.getEnableMargin());
						for(int i=kdtEntrys.getRowCount()-1;i>=0;i--){
							if(kdtEntrys.getCell(i, "batchContract").getValue()!=null){
								String batchContracID=UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(i, "batchContract").getValue(), "id").toString();
								BatchContractBillInfo batchContractBillInfo=BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContracID));
								if(!batchContractBillInfo.getFarmer().getId().toString().equals(farmer.getId().toString())){
									kdtEntrys.removeRow(i);
									IRow row = kdtEntrys.addRow();
									row.getCell("isUnlockInit").setValue(false);
								}
							}else{
								kdtEntrys.removeRow(i);
								IRow row = kdtEntrys.addRow();
								row.getCell("isUnlockInit").setValue(false);	
								kdtEntrys.getColumn("batchContract").getStyleAttributes().setLocked(false);
							}
						}

					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}else{
					txttotalMargin.setValue(null);
					txtoccupyMargin.setValue(null);
					txtenableMargin.setValue(null);
				}	
				setFilter();
			}	
		});

		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				int rowIndex=e.getRowIndex();
				int colIndex=e.getColIndex();
				kdtEntrys_changed(rowIndex,colIndex);
				super.editValueChanged(e);
			}
		});
	}

	private void kdtEntrys_changed(int rowIndex,int colIndex) {
		// TODO Auto-generated method stub
		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("batchContract")){
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null){
				try {
					kdtEntrys.getCell(rowIndex, "mMargin").setValue(null);
					kdtEntrys.getCell(rowIndex, "sMargin").setValue(null);
					kdtEntrys.getCell(rowIndex, "isUnlockInit").setValue(false);
					kdtEntrys.getCell(rowIndex, "unlockAmt").setValue(null);
					kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(null);
					kdtEntrys.getCell(rowIndex, "farm").setValue(null);
					kdtEntrys.getCell(rowIndex, "breedData").setValue(null);
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add("*");
					slor.add("marginPolicy.*");
					slor.add("farm.*");
					slor.add("breedData.*");
					String batchContracID=UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, colIndex).getValue(), "id").toString();
					BatchContractBillInfo batchContractBillInfo=BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContracID),slor);
					if(batchContractBillInfo.getBatch()!=null){
						String batchID=batchContractBillInfo.getBatch().getId().toString();
						BatchInfo batchInfo=BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID));
						kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(batchInfo);
					}
					BigDecimal qty=BigDecimal.ZERO;
					if(batchContractBillInfo.getActualFemaleQty()!=null){
						qty=batchContractBillInfo.getActualFemaleQty();
					}else{
						qty=batchContractBillInfo.getFemaleBreedQty();
					}
					kdtEntrys.getCell(rowIndex, "farm").setValue(batchContractBillInfo.getFarm());
					kdtEntrys.getCell(rowIndex, "breedData").setValue(batchContractBillInfo.getBreedData());
					kdtEntrys.getCell(rowIndex, "batchQty").setValue(qty);
					MarginPolicyInfo policy=batchContractBillInfo.getMarginPolicy();
					kdtEntrys.getCell(rowIndex, "mMargin").setValue(qty.multiply(policy.getMinMargin()==null?BigDecimal.ZERO:policy.getMinMargin()));
					kdtEntrys.getCell(rowIndex, "sMargin").setValue(qty.multiply(policy.getSingleMargin()==null?BigDecimal.ZERO:policy.getSingleMargin()));
					kdtEntrys.getCell(rowIndex, "actualUsedMargin").setValue(UIRuleUtil.getBigDecimal(batchContractBillInfo.getUsedMargin()).subtract(UIRuleUtil.getBigDecimal(batchContractBillInfo.getUnlockMargin())));
					kdtEntrys_changed(rowIndex, kdtEntrys.getColumnIndex("isUnlockInit"));
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(null);
				kdtEntrys.getCell(rowIndex, "unlockAmt").setValue(null);
				kdtEntrys.getCell(rowIndex, "batchQty").setValue(null);
				kdtEntrys.getCell(rowIndex, "actualInDate").setValue(null);
				kdtEntrys.getCell(rowIndex, "mMargin").setValue(null);
				kdtEntrys.getCell(rowIndex, "sMargin").setValue(null);
				kdtEntrys.getCell(rowIndex, "farm").setValue(null);
				kdtEntrys.getCell(rowIndex, "breedData").setValue(null);
				kdtEntrys.getCell(rowIndex, "actualUsedMargin").setValue(null);
			}
		}

		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("isUnlockInit")){
			if(prmtfarmer.getValue()==null){
				MsgBox.showWarning("解锁保证金不能大于初始化占用金额!");
				kdtEntrys.getCell(rowIndex, "isUnlockInit").setValue(false);
				return;
			}
			if(UIRuleUtil.getBooleanValue(kdtEntrys.getCell(rowIndex, "isUnlockInit").getValue())){
				kdtEntrys.getCell(rowIndex, "batchContract").setValue(null);
				kdtEntrys.getColumn("batchContract").getStyleAttributes().setLocked(true);
				kdtEntrys_changed(rowIndex, kdtEntrys.getColumnIndex("batchContract"));
				BigDecimal[] margin=getInitOccupyMargin(((IPropertyContainer)prmtfarmer.getValue()).getString("id"));
				BigDecimal occupyMargin=margin[0];
				BigDecimal unLockedOpMargin=margin[1];		
				kdtEntrys.getCell(rowIndex, "initOccupyMargin").setValue(occupyMargin);
				kdtEntrys.getCell(rowIndex, "unLockedOpMargin").setValue(unLockedOpMargin);
				kdtEntrys.getCell(rowIndex, "enableOccupyMargin").setValue(occupyMargin.subtract(unLockedOpMargin));
			}else{
				kdtEntrys.getCell(rowIndex, "initOccupyMargin").setValue(null);
				kdtEntrys.getCell(rowIndex, "unLockedOpMargin").setValue(null);
				kdtEntrys.getCell(rowIndex, "enableOccupyMargin").setValue(null);
				kdtEntrys.getColumn("batchContract").getStyleAttributes().setLocked(false);
			}
		}

		BigDecimal usedAmt=kdtEntrys.getCell(rowIndex, "actualUsedMargin").getValue()==null?BigDecimal.ZERO:(BigDecimal)kdtEntrys.getCell(rowIndex, "actualUsedMargin").getValue();
		BigDecimal unlockAmt=kdtEntrys.getCell(rowIndex, "unlockAmt").getValue()==null?BigDecimal.ZERO:(BigDecimal)kdtEntrys.getCell(rowIndex, "unlockAmt").getValue();
		BigDecimal enableOccupyMargin=kdtEntrys.getCell(rowIndex, "enableOccupyMargin").getValue()==null?BigDecimal.ZERO:(BigDecimal)kdtEntrys.getCell(rowIndex, "initOccupyMargin").getValue();
		if(!UIRuleUtil.getBooleanValue(kdtEntrys.getCell(rowIndex, "isUnlockInit").getValue())){
			if(unlockAmt.compareTo(usedAmt)>0){
				MsgBox.showWarning("解锁保证金不能大于可解锁占用保证金!");
				kdtEntrys.getCell(rowIndex, "unlockAmt").setValue(null);
				return;
			}
		}else{
			if(unlockAmt.compareTo(enableOccupyMargin)>0){
				MsgBox.showWarning("解锁保证金不能大于可解锁初始化占用金额!");
				kdtEntrys.getCell(rowIndex, "unlockAmt").setValue(null);
				return;
			}
		}
		BigDecimal restAmt=usedAmt.subtract(unlockAmt);
		BigDecimal batchQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "batchQty").getValue());
		if(batchQty.signum()!=0){
			kdtEntrys.getCell(rowIndex, "restSingleMargin").setValue(restAmt.divide(batchQty,2,RoundingMode.HALF_UP));
		}else{
			kdtEntrys.getCell(rowIndex, "restSingleMargin").setValue(null);
		}

	}

	private BigDecimal[] getInitOccupyMargin(String farmerID) {
		// TODO Auto-generated method stub
		String sql="select sum(isnull(CFOccupyMargin,0)) occupyMargin,sum(isnull(cfunLockedOpMargin,0)) unLockedOpMargin from CT_FM_MarginInitBill t1 inner join  CT_FM_MarginInitBillEntry t2 on t2.fparentid=t1.fid where t1.CFBillStatus='4' and t2.CFFarmerID='"+farmerID+"'";
		BigDecimal[] margin=new BigDecimal[2];
		BigDecimal occupyMargin=BigDecimal.ZERO;
		BigDecimal unLockedOpMargin=BigDecimal.ZERO;
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			if(rs.next()){
				occupyMargin=rs.getBigDecimal("occupyMargin")==null?BigDecimal.ZERO:rs.getBigDecimal("occupyMargin");
				unLockedOpMargin=rs.getBigDecimal("unLockedOpMargin")==null?BigDecimal.ZERO:rs.getBigDecimal("unLockedOpMargin");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		margin[0]=occupyMargin;
		margin[1]=unLockedOpMargin;
		return margin;
	}

	private void setFilter() {
		String companyID=null;
		if(this.prmtFICompany.getValue()!=null) {
			companyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
		}
		String farmerID="xxx";
		if(this.prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) this.prmtfarmer.getValue()).getString("id");
		}
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, companyID,false);

		//批次合同过滤
		setBatchContractFilter((KDBizPromptBox)kdtEntrys.getColumn("batchContract").getEditor().getComponent(), companyID, farmerID, null);

		//批次过滤
		StockingComm.setBatchFilter((KDBizPromptBox)kdtEntrys.getColumn("stockingBatch").getEditor().getComponent(), companyID, farmerID, null);
	}

	//批次合同过滤
	private  void setBatchContractFilter(KDBizPromptBox prmtContract,
			String curCompanyID, String farmerID, String farmID) {
		// TODO Auto-generated method stub
		prmtContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractForBZJQuery");		
		prmtContract.setVisible(true);		
		prmtContract.setEditable(true);		
		prmtContract.setDisplayFormat("$number$");		
		prmtContract.setEditFormat("$number$");		
		prmtContract.setCommitFormat("$number$");		
		prmtContract.setRequired(true);
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));

		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("canUnlockMargin",0,CompareType.GREATER));

		filter.getFilterItems().add(new FilterItemInfo("farmer.id",StringUtils.isBlank(farmerID)?"%%":farmerID,CompareType.LIKE));								
		filter.getFilterItems().add(new FilterItemInfo("farm.id",StringUtils.isBlank(farmID)?"%%":farmID,CompareType.LIKE));

		evi.setFilter(filter);
		prmtContract.setEntityViewInfo(evi);
	}

	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);

		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		kdtEntrys.getColumn("isUnlockInit").setEditor(kdtEntrys_Status_CellEditor); 

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
	protected void beforeStoreFields(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(e);
		int initNum=0;
		for(int i=kdtEntrys.getRowCount()-1;i>=0;i--){
			if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i, "unlockAmt").getValue()).signum()<=0){
				MsgBox.showWarning("解锁金额必须大于0");
				SysUtil.abort();
			}
			if(UIRuleUtil.getBooleanValue(kdtEntrys.getCell(i, "isUnlockInit").getValue())){
				initNum++;
			}
			if( kdtEntrys.getCell(i, "batchContract").getValue()!=null){
				String curID=UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(i, "batchContract").getValue(), "id").toString();
				for(int j=i+1;j<kdtEntrys.getRowCount();j++){
					if( kdtEntrys.getCell(j, "batchContract").getValue()!=null){
						String nextID=UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(j, "batchContract").getValue(), "id").toString();
						if(curID.equals(nextID)){
							MsgBox.showWarning("分录第"+(i+1)+"行批次合同与第"+(j+1)+"行批次合同重复!");
							SysUtil.abort();
						}
					}
				}
			}
		}
		if(initNum>1){
			MsgBox.showWarning("初始化解锁只能建一行分录");
			SysUtil.abort();
		}
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.getEntrys().add(new MarginUnlockBillEntryInfo());
		return objectValue;
	}

}