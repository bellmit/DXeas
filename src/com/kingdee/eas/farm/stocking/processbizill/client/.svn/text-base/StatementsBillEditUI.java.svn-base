/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum;
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
import com.kingdee.util.StringUtils;

/**
 * output class name
 */
public class StatementsBillEditUI extends AbstractStatementsBillEditUI {
	private static final Logger logger = CoreUIObject.getLogger(StatementsBillEditUI.class);
	private String curStorageOrgUnitID;// 当前库存组织
	private String curCompanyID;// 当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;// 库存组织
	private boolean isLoadField=false;
	
	
	
	/**
	 * output class constructor
	 */
	public StatementsBillEditUI() throws Exception {
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	public void loadFields() {
		DataChangeListener[] ls = this.prmtstockingBatch.getListeners(DataChangeListener.class);
		for (int i = 0; i < ls.length; i++) {
			this.prmtstockingBatch.removeDataChangeListener(ls[i]);
		}
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		for (int i = 0; i < ls.length; i++) {
			this.prmtstockingBatch.addDataChangeListener(ls[i]);
		}

		if (this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
			this.actionBtnExeCal.setEnabled(false);
		} else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
			this.actionBtnExeCal.setEnabled(true);
		} else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
			this.actionBtnExeCal.setEnabled(true);
		}

		UITools.apendFootRow(kdtEntrys, new String[]{"amount","actualCost"});
		UITools.apendFootRow(kdtEggEntry, new String[]{"amount","number"});
		UITools.apendFootRow(kdtRewardsEntry, new String[]{"amount"});
		UITools.apendFootRow(kdtOtherEntry, new String[]{"amount"});
		UITools.apendFootRow(kdtHandEntry, new String[]{"amount"});

		setColMerger(this.kdtEntrys,2,2);
		setColMerger(this.kdtEggEntry,2,2);

		settleType_changed();
	}



	@Override
	public void storeFields() {
		super.storeFields();

		/*String companyID=null;
		String batchID=null;
		String contractID=null;
		if(prmtstockingBatch.getValue()!=null) {
			batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
		}
		if(prmtbatchContract.getValue()!=null) {
			contractID=((IPropertyContainer) prmtbatchContract.getValue()).getString("id");
		}
		this.editData.setString("companyID",companyID);
		this.editData.setString("farmerID",((IPropertyContainer) this.prmtfarmer.getValue()).getString("id"));
		this.editData.setString("farmID",((IPropertyContainer) this.prmtfarm.getValue()).getString("id"));
		this.editData.setString("stockingBatchID",batchID);
		this.editData.setString("contractID",contractID);*/

	}

	/**
	 * 设置单元格融合
	 */
	private void setColMerger(KDTable table,int colIndex1,int colIndex2) {
		table.getMergeManager().removeAllMergeBlock();
		try {
			String value,valueKeep=null;
			String value2,valueKeep2=null;
			int rowIndexKeep=0;
			int rowIndexKeep2=0;
			for(int rowIndex=0;rowIndex<table.getRowCount();rowIndex++) {
				if(table.getRow(rowIndex).getCell(colIndex1).getValue()==null) {
					valueKeep=null;
					rowIndexKeep=0;
					continue;
				}
				value=table.getRow(rowIndex).getCell(colIndex1).getValue().toString();
				value2=table.getRow(rowIndex).getCell(colIndex2).getValue().toString();
				if(valueKeep==null){
					valueKeep=value;
					rowIndexKeep=rowIndex;

					valueKeep2=value2;
					rowIndexKeep2=rowIndex;

				}else{
					if(!valueKeep.equals(value)) {
						table.getMergeManager().mergeBlock(rowIndexKeep, colIndex1, rowIndex-1, colIndex1);
						valueKeep=value;
						rowIndexKeep=rowIndex;

						table.getMergeManager().mergeBlock(rowIndexKeep2, colIndex2, rowIndex-1, colIndex2);
						valueKeep2=value2;
						rowIndexKeep2=rowIndex;
					}else{
						if(!valueKeep2.equals(value2)) {
							table.getMergeManager().mergeBlock(rowIndexKeep2, colIndex2, rowIndex-1, colIndex2);
							valueKeep2=value2;
							rowIndexKeep2=rowIndex;
						}
					}
					if(rowIndex==(table.getRowCount()-1)) {
						table.getMergeManager().mergeBlock(rowIndexKeep, colIndex1, rowIndex, colIndex1);
						table.getMergeManager().mergeBlock(rowIndexKeep2, colIndex2, rowIndex, colIndex2);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
		settleType_changed();
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if (!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
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
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if (!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
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
	 * output actionBtnExeCal_actionPerformed
	 */
	public void actionBtnExeCal_actionPerformed(ActionEvent e) throws Exception {
		/*if(this.prmtcompany.getValue()==null) {
			MsgBox.showWarning("财务组织不能为空！");
			SysUtil.abort();
		}
		if(this.prmtstockingBatch.getValue()==null) {
			MsgBox.showWarning("批次不能为空！");
			SysUtil.abort();
		}
		if(this.prmtstockingBatch.getValue()==null) {
			MsgBox.showWarning("批次不能为空！");
			SysUtil.abort();
		}
		if(this.pkbeginDate.getValue()==null) {
			MsgBox.showWarning("开始日期不能为空！");
			SysUtil.abort();
		}
		if(this.pkendDate.getValue()==null) {
			MsgBox.showWarning("结束日期不能为空！");
			SysUtil.abort();
		}*/
		//		actionSave_actionPerformed(e);

		Calendar cal=Calendar.getInstance();

		Date ds = new Date(8453888);

		storeFields();
		if(this.settleType.getSelectedItem().equals(StockingSettlementTypeEnum.byBatch)&&this.prmtstockingBatch.getValue()==null) {
			MsgBox.showWarning("批次不能为空！");
			SysUtil.abort();
		}
		super.actionBtnExeCal_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(this.editData.getId()));
		this.actionEdit.setEnabled(true);
	}

	@Override
	public void actionBreateBill_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionBreateBill_actionPerformed(e);
		if(editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
			HashMap<Object,Object> map = new HashMap<Object,Object>();
			map.put("company", editData.getCompany());
			map.put("period", editData.getPeriod());
			map.put("farmer", editData.getFarmer());
			ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.stocking.processbizill.client.FiltrationUI", map, null, OprtState.ADDNEW);
		}else{
			MsgBox.showInfo("只有审核的单子才允许此操作");
		}
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception {
		return com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table) {

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData() {
		com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext
				.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		try {
			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(
					new ObjectUuidPK(curStorageOrgUnitID)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date nowDate = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		Date beginDate = cal.getTime();
		cal.add(Calendar.MONTH, 1);// 月增加1天
		cal.add(Calendar.DAY_OF_MONTH, -1);// 日期倒数一日,既得到本月最后一天
		Date endDate = cal.getTime();

		objectValue.setBizDate(nowDate);
		objectValue.setBeginDate(beginDate);
		objectValue.setEndDate(endDate);

		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		curStorageOrgUnitID = StockingClientComm.checkAndGetStorageOrgUnitID();
		curCompanyID = SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
		
		
		//设置养殖日报过滤
//		if(pkBizDate.getValue() != null || StringUtils.isEmpty(pkBizDate.getValue().toString())){
			//如果日期不为空，界面加载时为养殖日报添加过滤
			setfieldForStocking();
//		}
		
		//日期添加监听事件
//		p pkBizDate_dataChanged
		
		
		
		
		
		
	}

	
	/**
	 * 为养殖日报添加过滤条件
	 */
	private void setfieldForStocking() {
		// TODO Auto-generated method stub
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date bizdate = (Date) pkBizDate.getValue();
//        String sq = " /*dialect*/  select fid stockingid  from  T_FM_StockingBreedDaily  t1 where to_char(t1.fbizdate,'yyyy-mm-dd')='"+sdf.format(bizdate)+"'";         		
//		
		
		
	}

	
	
	
	
	
	
	
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.pkbeginDate.setDatePattern("yyyy-MM-dd");
		this.pkendDate.setDatePattern("yyyy-MM-dd");

		this.pkbeginDate.setEnabled(false);
		this.pkendDate.setEnabled(false);

		CompanyF7 cf7 = new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		StorageF7 sf7 = new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);

		this.kdtBatchDetail.getStyleAttributes().setLocked(true);
		this.kdtBatchDetail_detailPanel.getAddNewLineButton().setVisible(false);
		this.kdtBatchDetail_detailPanel.getInsertLineButton().setVisible(false);
		this.kdtBatchDetail_detailPanel.getRemoveLinesButton().setVisible(false);

		//		prmtfa.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		//		prmtoutAreas.setVisible(true);
		//		prmtoutAreas.setEditable(true);
		//		prmtoutAreas.setDisplayFormat("$name$");
		//		prmtoutAreas.setEditFormat("$name$");
		//		prmtoutAreas.setCommitFormat("$name$");



		kdtEntrys.getColumn("qty").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("price").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("amount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEggEntry.getColumn("qty").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEggEntry.getColumn("weight").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEggEntry.getColumn("price").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEggEntry.getColumn("amount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtRewardsEntry.getColumn("amount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtOtherEntry.getColumn("amount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtHandEntry.getColumn("amount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);

		kdtEntrys.getColumn("qty").getStyleAttributes().setNumberFormat("#.00");
		kdtEntrys.getColumn("price").getStyleAttributes().setNumberFormat("#.00");
		kdtEntrys.getColumn("amount").getStyleAttributes().setNumberFormat("#.00");
		kdtEggEntry.getColumn("qty").getStyleAttributes().setNumberFormat("#.00");
		kdtEggEntry.getColumn("weight").getStyleAttributes().setNumberFormat("#.00");
		kdtEggEntry.getColumn("price").getStyleAttributes().setNumberFormat("#.00");
		kdtEggEntry.getColumn("amount").getStyleAttributes().setNumberFormat("#.00");
		kdtRewardsEntry.getColumn("amount").getStyleAttributes().setNumberFormat("#.00");
		kdtOtherEntry.getColumn("amount").getStyleAttributes().setNumberFormat("#.00");
		kdtHandEntry.getColumn("amount").getStyleAttributes().setNumberFormat("#.00");

		f7Manager.registerBizMaterialF7((KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null,
				null, orgInfo, false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		setFilter();

		this.prmtcompany.addDataChangeListener(new DataChangeListener() {
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}
		});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener() {
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);
			}
		});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener() {
			public void dataChanged(DataChangeEvent e) {
				setFilter();
				if(!isLoadField) {
					StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
				}
			}
		});

		this.prmtstockingBatch.addDataChangeListener(new DataChangeListener() {
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}
		});
		for(int colIndex=0;colIndex<this.kdtEntrys.getColumnCount();colIndex++) {
			this.kdtEntrys.getColumn(colIndex).setSortable(false);
		}
		this.kdtEntrys.getStyleAttributes().setLocked(true);
		this.kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		this.kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		this.kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);

		this.kdtEggEntry.getStyleAttributes().setLocked(true);
		this.kdtEggEntry_detailPanel.getAddNewLineButton().setVisible(false);
		this.kdtEggEntry_detailPanel.getInsertLineButton().setVisible(false);
		this.kdtEggEntry_detailPanel.getRemoveLinesButton().setVisible(false);


		this.kdtRewardsEntry.getStyleAttributes().setLocked(true);
		this.kdtRewardsEntry_detailPanel.getAddNewLineButton().setVisible(false);
		this.kdtRewardsEntry_detailPanel.getInsertLineButton().setVisible(false);
		this.kdtRewardsEntry_detailPanel.getRemoveLinesButton().setVisible(false);

		this.kdtOtherEntry.getStyleAttributes().setLocked(true);
		this.kdtOtherEntry_detailPanel.getAddNewLineButton().setVisible(false);
		this.kdtOtherEntry_detailPanel.getInsertLineButton().setVisible(false);
		this.kdtOtherEntry_detailPanel.getRemoveLinesButton().setVisible(false);

		this.kdtHandEntry.getStyleAttributes().setLocked(false);
		this.kdtHandEntry.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				if(e.getColIndex()==kdtHandEntry.getColumnIndex("amount")) {
					UITools.apendFootRow(kdtHandEntry, new String[]{"amount"});
					BigDecimal handAmount = txthandAmount.getBigDecimalValue();
					if(handAmount==null) {
						handAmount=BigDecimal.ZERO;
					}
					BigDecimal farmerOrgProfit=txtoriginalFarmerProfit.getBigDecimalValue();
					if(farmerOrgProfit==null) {
						farmerOrgProfit=BigDecimal.ZERO;
					}
					handAmount=(BigDecimal) kdtHandEntry.getFootRow(0).getCell("amount").getValue();
					txthandAmount.setValue(handAmount);
					txtfarmerProfit.setValue(farmerOrgProfit.add(handAmount));
				}
			}});
		this.settleType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				settleType_changed();
			}});
		this.prmtperiod.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				period_chagned();
			}});

		KDBizPromptBox kdtEntrys_material_PromptBox1 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox1.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox1.setVisible(true);
		kdtEntrys_material_PromptBox1.setEditable(true);
		kdtEntrys_material_PromptBox1.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox1.setEditFormat("$name$");
		kdtEntrys_material_PromptBox1.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor1 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox1);
		ObjectValueRender kdtEntrys_material_OVR1 = new ObjectValueRender();
		kdtEntrys_material_OVR1.setFormat(new BizDataFormat("$name$"));
		this.kdtBatchDetail.getColumn("house").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtBatchDetail.getColumn("house").setRenderer(kdtEntrys_material_OVR1);

		addListener();
	}
	/**
	 * 添加监听器
	 */
	private void addListener() {
		txtbreedDataAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtfodderAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtdrugAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtotherMaterialAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtallEggAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtbirdsAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtawardsAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtmarginInterest.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txthandAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
		txtloanInterest.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				calProfit();
			}});
	}

	/**
	 * 计算利润
	 */
	private void calProfit() {
		if(isLoadField) {
			return;
		}
		//收入
		BigDecimal breedDataAmount=this.txtbreedDataAmount.getBigDecimalValue();
		BigDecimal fodderAmount=this.txtfodderAmount.getBigDecimalValue();
		BigDecimal drugAmount=this.txtdrugAmount.getBigDecimalValue();
		BigDecimal otherMaterialAmount=this.txtotherMaterialAmount.getBigDecimalValue();
		BigDecimal loanAmount=this.txtloanInterest.getBigDecimalValue();
		if(breedDataAmount==null) {
			breedDataAmount=BigDecimal.ZERO;
		}
		if(fodderAmount==null) {
			fodderAmount=BigDecimal.ZERO;
		}
		if(drugAmount==null) {
			drugAmount=BigDecimal.ZERO;
		}
		if(otherMaterialAmount==null) {
			otherMaterialAmount=BigDecimal.ZERO;
		}
		if(loanAmount==null) {
			loanAmount=BigDecimal.ZERO;
		}

		//支出
		BigDecimal eggAmount=this.txtallEggAmount.getBigDecimalValue();
		BigDecimal birdAmount=this.txtbirdsAmount.getBigDecimalValue();
		BigDecimal awardAmount=this.txtawardsAmount.getBigDecimalValue();
		BigDecimal marginInterest=this.txtmarginInterest.getBigDecimalValue();

		if(eggAmount==null) {
			eggAmount=BigDecimal.ZERO;
		}
		if(birdAmount==null) {
			birdAmount=BigDecimal.ZERO;
		}
		if(awardAmount==null) {
			awardAmount=BigDecimal.ZERO;
		}
		if(marginInterest==null) {
			marginInterest=BigDecimal.ZERO;
		}
		BigDecimal handAmount=this.txthandAmount.getBigDecimalValue();
		if(handAmount==null) {
			handAmount=BigDecimal.ZERO;
		}

		this.txtoriginalFarmerProfit.setValue((eggAmount.add(birdAmount).add(awardAmount).add(marginInterest).subtract(breedDataAmount)
				.subtract(fodderAmount).subtract(drugAmount).subtract(otherMaterialAmount)).subtract(loanAmount).setScale(2, BigDecimal.ROUND_HALF_UP));

		this.txtfarmerProfit.setValue((eggAmount.add(birdAmount).add(awardAmount).add(marginInterest).add(handAmount).subtract(breedDataAmount)
				.subtract(fodderAmount).subtract(drugAmount).subtract(otherMaterialAmount)).subtract(loanAmount).setScale(2, BigDecimal.ROUND_HALF_UP));

		/**
		 * 计算成本
		 */
		BigDecimal breedDataCost=this.txtbreedDataCost.getBigDecimalValue();
		BigDecimal fodderCost=this.txtfodderAmount.getBigDecimalValue();
		BigDecimal drugCost=this.txtdrugCost.getBigDecimalValue();
		BigDecimal otherMaterialCost=this.txtotherMaterialCost.getBigDecimalValue();

		BigDecimal feeCost=this.txtfeeCostAmount.getBigDecimalValue();
		BigDecimal coProductAmount=this.txtcoProductAmount.getBigDecimalValue();

		BigDecimal arOffsetAmount=this.txtarAmountOffset.getBigDecimalValue();
		BigDecimal faFuCardAmount=this.txtfaFurCardCost.getBigDecimalValue();

		if(breedDataCost==null) {
			breedDataCost=BigDecimal.ZERO;
		}
		if(fodderCost==null) {
			fodderCost=BigDecimal.ZERO;
		}
		if(drugCost==null) {
			drugCost=BigDecimal.ZERO;
		}
		if(otherMaterialCost==null) {
			otherMaterialCost=BigDecimal.ZERO;
		}
		if(feeCost==null) {
			feeCost=BigDecimal.ZERO;
		}
		if(coProductAmount==null) {
			coProductAmount=BigDecimal.ZERO;
		}
		if(arOffsetAmount==null) {
			arOffsetAmount=BigDecimal.ZERO;
		}
		if(faFuCardAmount==null) {
			faFuCardAmount=BigDecimal.ZERO;
		}

		BigDecimal allActualCost=BigDecimal.ZERO;

		allActualCost=eggAmount.add(birdAmount).add(awardAmount).add(breedDataCost).add(fodderCost).add(drugCost).add(otherMaterialCost)
		.add(feeCost).add(faFuCardAmount).subtract(breedDataAmount).subtract(fodderAmount).subtract(drugAmount).subtract(otherMaterialAmount)
		.subtract(arOffsetAmount).subtract(coProductAmount);

		this.txtallActualCost.setValue(allActualCost);
	}

	private void period_chagned() {
		if(isLoadField) {
			return;
		}
		if(this.prmtperiod.getValue()!=null) {
			try {
				Date[] dateRange = StockingComm.getDateRangeByPeriod(null, ((IPropertyContainer) this.prmtcompany.getValue()).getString("id"),  ((IPropertyContainer) this.prmtperiod.getValue()).getString("id"));
				this.pkbeginDate.setValue(dateRange[0]);
				this.pkendDate.setValue(dateRange[1]);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			this.pkbeginDate.setValue(null);
			this.pkendDate.setValue(null);
		}
	}

	private void settleType_changed() {
		//养殖场结算
		if(settleType.getSelectedItem()!=null&&settleType.getSelectedItem().equals(StockingSettlementTypeEnum.byFarm)) {
			this.prmtstockingBatch.setEnabled(false);
			if(prmtstockingBatch.getValue()!=null) {
				prmtstockingBatch.setValue(null);
			}
		}else{
			this.prmtstockingBatch.setEnabled(true);
		}
	}

	/**
	 * 批次改变 带出基本价格
	 */
	private void batch_changed(DataChangeEvent e) {
		if(prmtstockingBatch.getValue()!=null) {
			try {
				this.prmtfarmer.setValue(UIRuleUtil.getProperty((IObjectValue) this.prmtstockingBatch.getValue(), "farmer"));
				this.prmtfarm.setValue(UIRuleUtil.getProperty((IObjectValue) this.prmtstockingBatch.getValue(), "farm"));
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
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
	}

	/**
	 * 设置过滤条件
	 * 
	 * @param companyID
	 */
	private void setFilter() {
		if (this.prmtcompany.getValue() != null) {
			curCompanyID = ((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		} else {
			curCompanyID = null;
		}

		// 人员过滤
		// StockingClientComm.makeApplierF7(this.prmtperson, companyID, this,
		// false);
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		StockingClientComm.setStockingBatchFilter(prmtstockingBatch,curCompanyID,farmerID,farmID);
		// 养殖户过滤
		StockingClientComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		// 养殖场过滤
		StockingClientComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID);
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		// super.actionCopy_actionPerformed(e);
		if (!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if (editData != null && !OprtState.VIEW.equals(getOprtState())) {
			IObjectValue objectValue = (IObjectValue) getUIContext().get("CURRENT.VO");
			if (objectValue != null)
				try {
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				} catch (Throwable E) {
				}
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBillStatus(BillBaseStatusEnum.ADD);
		// editData.setNumber(null);
//		editData.setFarmer(null);
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
		if(settleType.getSelectedItem().equals(StockingSettlementTypeEnum.byBatch)) {
			if(prmtstockingBatch.getValue()==null) {
				MsgBox.showWarning("按批次核算，批次不能为空！");
				SysUtil.abort();
			}
		}


		//				allActualCost=info.getAllEggAmount().add(info.getAwardsAmount()).add(info.getBreedDataCost()).add(info.getFodderCost()).add(info.getDrugCost()).add(info.getOtherMaterialCost())
		//				.add(info.getFeeCostAmount()).subtract(info.getBreedDataAmount()).subtract(info.getFodderAmount()).subtract(info.getDrugAmount()).subtract(info.getOtherMaterialAmount()).add(info.getBirdsAmount())
		//				.subtract(info.getArAmountOffset()).subtract(loanDiff)
		//				.subtract(info.getCoProductAmount());
		//		.add(info.getFaFurCardCost())

		txtallActualCost.setValue(UIRuleUtil.getBigDecimal(txtallEggAmount.getStringValue())
				.add(UIRuleUtil.getBigDecimal(txtawardsAmount.getStringValue()))
				.add(UIRuleUtil.getBigDecimal(txtbreedDataCost.getStringValue()))
				.add(UIRuleUtil.getBigDecimal(txtfodderCost.getStringValue()))
				.add(UIRuleUtil.getBigDecimal(txtdrugCost.getStringValue()))
				.add(UIRuleUtil.getBigDecimal(txtotherMaterialCost.getStringValue()))
				.add(UIRuleUtil.getBigDecimal(txtfeeCostAmount.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtbreedDataCost.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtfodderAmount.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtdrugAmount.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtotherMaterialAmount.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtcoProductAmount.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtbirdsAmount.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtarAmountOffset.getStringValue()))
				.subtract(UIRuleUtil.getBigDecimal(txtloanInterestDiff.getStringValue())));

	}

	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		//结算方式，按养殖户结算
		vo.put("settleType",new Integer(2));
	}


}