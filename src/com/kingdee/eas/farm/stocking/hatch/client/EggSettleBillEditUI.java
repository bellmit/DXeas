/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider;
import com.kingdee.bos.ctrl.reportone.r1.print.data.R1PrintDataParameter;
import com.kingdee.bos.ctrl.reportone.r1.print.data.R1PrintDataSource;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryInfo;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class EggSettleBillEditUI extends AbstractEggSettleBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(EggSettleBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private boolean isLoadField=false;

	/**
	 * output class constructor
	 */
	public EggSettleBillEditUI() throws Exception
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
		setColHide();
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
	 * 执行结算
	 */
	public void actionExeSettle_actionPerformed(ActionEvent e) throws Exception
	{
		//先对数据进行校验
		storeFields();
		//执行结算
		/*  IObjectValue info = (IObjectValue) StockingHatchFacadeFactory.getRemoteInstance().exeEggSettle(this.editData);
       this.setDataObject(info);
       loadFields();
       initOldData(this.editData);
		setSave(true);
		setSaved(true);
       if(this.oprtState.equals(OprtState.EDIT)||this.oprtState.equals(OprtState.ADDNEW)) {
	       setSave(false);
		   setSaved(false);
       }*/
		super.actionExeSettle_actionPerformed(e);
		doAfterSave(new ObjectUuidPK(this.editData.getId()));
		MsgBox.showInfo("结算完成");
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		//		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		//		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
	}

	private void initControl() {
		
		kdtEntrys_detailPanel.addRemoveListener(new IDetailPanelListener(){

			public void afterEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
				calTotalAmount();
				UIUtil.apendFootRow(new KDTable[]{kdtEntrys,kdtPriceEntry});
				UIUtil.apendFootRow(kdtEntrys, new String[]{"num"});
			}

			public void beforeEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}});

		//添加合计行
		UIUtil.apendFootRow(new KDTable[]{kdtEntrys,kdtPriceEntry});
		UIUtil.apendFootRow(kdtEntrys, new String[]{"num"});
		UIUtil.setQualityPhaseDisplayFormat(new KDTable[]{kdtEntrys,kdtPriceEntry});
		kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
		kdtEntrys.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				UIUtil.apendFootRow(new KDTable[]{kdtEntrys});
				UIUtil.apendFootRow(kdtEntrys, new String[]{"num"});
			}});
		kdtPriceEntry.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				UIUtil.apendFootRow(new KDTable[]{kdtPriceEntry});
			}});



		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				bizDate_changed();
			}});

		this.kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent arg0) throws Exception {
			}
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				e.getObjectValue().put("sendDate", pkBizDate.getTimestamp());
			}});

		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}});

		eggSource.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setColHide();				
			}
		});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				farmer_changed();
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
		this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_material_OVR1);

		this.kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent e) throws Exception {

			}
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				((EggSettleBillEntryInfo)e.getObjectValue()).setFarmer((FarmersInfo) prmtfarmer.getValue());
			}});
	}


	private void farmer_changed() {
		if(isLoadField) {
			return;
		}
		int colIndex=kdtEntrys.getColumnIndex("farmer");
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			kdtEntrys.getCell(rowIndex, "farmer").setValue(this.prmtfarmer.getValue());
			try {
				kdtEntrys_Changed(rowIndex, colIndex);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		super.kdtEntrys_Changed(rowIndex, colIndex);
		//根据合同和批次带出养殖户和农场
		if(kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				kdtEntrys.getCell(rowIndex, "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farmer"));
				kdtEntrys.getCell(rowIndex, "farm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farm"));
				kdtEntrys.getCell(rowIndex, "farmerGroup").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"farmer").getValue(), "treeid"));
			}
		}
		//根据养殖户带出养殖场
		if(kdtEntrys.getColumnKey(colIndex).equals("farmer")) {
			String farmerID=null;
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null) {
				farmerID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, colIndex).getValue()).getString("id");
			}
			kdtEntrys.getCell(rowIndex, "farm").setValue(StockingComm.getFarmInfoByFarmerID(null,farmerID));
			if(StringUtils.isEmpty(farmerID)) {
				kdtEntrys.getCell(rowIndex, "house").setValue(null);
			}
			if(farmerID!=null&&kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				if(!((IPropertyContainer) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex,"stockingBatch").getValue(), "farmer")).getString("id").equals(farmerID)) {
					kdtEntrys.getCell(rowIndex,"stockingBatch").setValue(null);
				}
			}
		}
		/**
		 * 棚舍带出最近的批次
		 */
		if("house".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())){
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null){
				FarmHouseEntryInfo outHouse = (FarmHouseEntryInfo)kdtEntrys.getCell(rowIndex ,"house").getValue();
				final String sp="\n";
				String sql="select distinct "+sp+
				" t1.FID  breedBatch,"+sp+
				" t4.FID  farmer,"+sp+
				" t6.FID  outFarm,"+sp+
				" t5.Fname_l2"+sp+
				"from "+sp+
				" T_FM_StockingBatch                      t1"+sp+
				"inner join T_FM_StockingBatchHouseEntry  t2 on t1.FID=t2.FParentID"+sp+
				"inner join CT_FM_FarmHouseEntry          t3 on t3.FID=t2.FHouseID"+sp+
				"      and t3.FID='"+outHouse.getId().toString()+"'"+sp+
				"      and t2.FInData=("+sp+
				"select "+sp+
				" max(t2.FIndata)"+sp+
				"from"+sp+
				" T_FM_StockingBatch                      t1"+sp+
				"inner join T_FM_StockingBatchHouseEntry  t2 on t1.FID=t2.FParentID"+sp+
				"inner join CT_FM_FarmHouseEntry          t3 on t3.FID=t2.FHouseID"+sp+
				"      and t3.FID='"+outHouse.getId().toString()+"'"+sp+
				""+sp+
				")"+sp+
				"inner join T_FM_Farmers                  t4 on t4.FID=t1.FFarmerID   "+sp+              
				"inner join T_FM_FarmersTREE              t5 on t5.FID=t4.FTreeID"+sp+
				"inner join T_FM_Farm                     t6 on t6.FID=t1.FFarmID"+sp;

				IRowSet rs;
				try {
					rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
					if(rs.next()){
						kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(rs.getString("breedBatch")==null?null:(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("breedBatch")))));
					}else
						kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(null);
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		//		calPrice(rowIndex,colIndex);
		calEntryWeekAndDayAge(rowIndex, colIndex);
		if("price".equalsIgnoreCase(kdtEntrys.getColumnKey(colIndex))||"qty".equalsIgnoreCase(kdtEntrys.getColumnKey(colIndex))){
			if(kdtEntrys.getCell(rowIndex, "price").getValue()!=null&&kdtEntrys.getCell(rowIndex, "qty").getValue()!=null){
				kdtEntrys.getCell(rowIndex, "amount").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "price").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "qty").getValue())));
			}
		}


		calTotalAmount();
	}
	
	
	/**
	 * 重算总金额
	 */
	private void calTotalAmount() {
		// TODO Auto-generated method stub
		BigDecimal amount=BigDecimal.ZERO;
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			amount=amount.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i, "amount").getValue()));
		txtamount.setValue(amount);
	}

	/**
	 * 获取价格
	 * @param rowIndex
	 * @param colIndex
	 */
	private void calPrice(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(kdtEntrys.getCell(rowIndex, "settleItem").getValue()!=null)
			if(SysContext.getSysContext().getCurrentFIUnit()!=null){
				SettlementItemInfo settleInfo = (SettlementItemInfo)kdtEntrys.getCell(rowIndex, "settleItem").getValue();
				CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
				String str="/*dialect*/select t2.* from CT_FM_EggPriceData  t1";
				str+="\n inner join T_FM_EggPriceDataPriceEntry t2 on t1.FID=t2.FParentID";
				str+="\n and t1.FCompanyID='"+companyInfo.getString("id")+"'";
				str+="\n and to_char(t1.FEffectDate,'yyyy-MM-dd')<='"+sdf.format(new Date())+"'";
				str+="\n and to_char(t1.CFUnEffectDate,'yyyy-MM-dd')>='"+sdf.format(new Date())+"'";
				str+="\n and t2.FSettleItemID='"+settleInfo.getString("id")+"'";
				try {
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
					if(rs.next()){
						kdtEntrys.getCell(rowIndex, "price").setValue(rs.getBigDecimal("FCurrentPrice"));
						if(kdtEntrys.getCell(rowIndex, "qty").getValue()!=null)
							kdtEntrys.getCell(rowIndex, "amount").setValue(rs.getBigDecimal("FCurrentPrice").multiply((BigDecimal)kdtEntrys.getCell(rowIndex, "qty").getValue()));
					}

				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	/**
	 * 设置列的隐藏
	 */
	private void setColHide() {
		if(eggSource.getSelectedIndex()==-1) {
			return;
		}
		if(eggSource.getSelectedItem().equals(EggSourceType.InternalFarm)) {
			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("internalHouse").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(true);
		}else if(eggSource.getSelectedItem().equals(EggSourceType.Purchase)) {
			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalHouse").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(true);
		}else if(eggSource.getSelectedItem().equals(EggSourceType.SubContract)) {
			kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalBatch").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("internalHouse").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("farm").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("house").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(false);
		}
	}

	private void bizDate_changed() {
		int colIndex=kdtEntrys.getColumnIndex("stockingBatch");
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			try {
				calEntryWeekAndDayAge(rowIndex, colIndex);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}

	/**
	 * 计算周龄、日龄
	 * @param rowIndex
	 * @throws BOSException 
	 * @throws DataAccessException 
	 * @throws EASBizException 
	 */
	private void calEntryWeekAndDayAge(int rowIndex,int colIndex) throws DataAccessException, BOSException, EASBizException {
		//计算周龄、日龄
		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("stockingBatch")||kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("sendDate")) {
			if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null&&kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
				Date nowDate=null,inDate=null;
				if(kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {//禽舍不为空
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add("*");
					slor.add("HouseEntry.*");
					StockingBatchInfo batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id")),slor);

					for(int index=0;index<batchInfo.getHouseEntry().size();index++) {
						if(batchInfo.getHouseEntry().get(index).getHouse().getString("id").equals(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id"))) {
							inDate=batchInfo.getHouseEntry().get(index).getInData();
							break;
						}
					}
					//申请周龄
					if(kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
						nowDate=(Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}
					//当前周龄
					/*if(pkBizDate.getValue()!=null) {
						nowDate=pkBizDate.getTimestamp();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}*/
				}else{
					inDate=(Date) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "inDate");
					//当前周龄
					if(pkBizDate.getValue()!=null) {
						nowDate=pkBizDate.getTimestamp();
					}
					/*if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}*/
					//申请周龄
					if(kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
						nowDate=(Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue();
					}
					if(nowDate!=null&&inDate!=null) {
						int[] weekDays = StockingComm.getBreedWeekAndDay(nowDate,inDate);
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(weekDays[0]+"周"+weekDays[1]);
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(weekDays[0]>0?(weekDays[0]-1)*7+weekDays[1]-1:0);
					}else {
						kdtEntrys.getCell(rowIndex, "weekAge").setValue("0周0");
						kdtEntrys.getCell(rowIndex, "dayAge").setValue(0);
					}
				}
			}
		}
	}


	/**
	 * 开始编辑
	 * @param e
	 */
	private void kdteditStarted(KDTEditEvent e) {
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEntrys.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("house")) {
			//			KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "farm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			}
			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID);
			//养殖场过滤
			StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
			//棚舍过滤
			HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,false);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		}
	}

	/**
	 * 设置过滤条件
	 */
	private void setFilter() {
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
	}	

	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		if(eggSource.getSelectedItem().equals(EggSourceType.SubContract)) {
			for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
				if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()==null) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录，放养养殖批次不能为空！");
					SysUtil.abort();
				}
				if(kdtEntrys.getCell(rowIndex, "farmer").getValue()==null) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖户不能为空！");
					SysUtil.abort();
				}
				if(kdtEntrys.getCell(rowIndex, "farm").getValue()==null) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖场不能为空！");
					SysUtil.abort();
				}
				if(kdtEntrys.getCell(rowIndex, "farm").getValue()!=null&&(Boolean)UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "farm").getValue(), "isHouseManager")&&kdtEntrys.getCell(rowIndex, "house").getValue()==null) {
					MsgBox.showWarning("第"+(rowIndex+1)+"行分录，养殖场启用棚舍管理，棚舍不能为空！");
					SysUtil.abort();
				}
			}
		}
	}
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		vo.setInt("eggSource", EggSourceType.SUBCONTRACT_VALUE);
	}

	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		super.actionPrint_actionPerformed(e);
	}

	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
//		super.actionPrintPreview_actionPerformed(e);
		ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
//        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        
        MyDataProvider data=new MyDataProvider((String) idList.get(0));
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}

	public class MyDataProvider extends AbstractPrintDataProvider 
	{
		private String id;
		public MyDataProvider(String id) {
			this.id=id;
		}
		public IRowSet getData(R1PrintDataSource dataSource) throws Exception
		{
			IRowSet rowset=null;
			if("EgggSettleBillPrintQuery".equals(dataSource.getId())) 
			{
				//可能会以选中数据的ID做过滤条件查数据
				//构造RowSet
				StringBuffer sql=new StringBuffer();
				sql.append(" select 'test20170704' number,'2017-07-04' bizDate from dual")
				.append(" ")
				;
				rowset=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
	 			return rowset;
			}
			else if("EggSettleEntryPrintQuery".equals(dataSource.getId()))
			{
				R1PrintDataParameter parm = dataSource.getAssociateParameter(); 
				String parmValue = null;//参数值 
				if(parm != null) 
				{
					parmValue = parm.getValue().toString(); 
				}
				//以参数值为过滤条件取数据，构造RowSet……
				
				
	 			return rowset;
			} 
			else if("EggSettleDetailPrintQuery".equals(dataSource.getId()))
			{
				R1PrintDataParameter parm = dataSource.getAssociateParameter(); 
				String parmValue = null;//参数值 
				if(parm != null) 
				{
					parmValue = parm.getValue().toString(); 
				}
				StringBuffer sql=new StringBuffer();
				sql.append(" select 'test' materialName,1 qty,2 price from dual")
				.append(" ")
				;
				rowset=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				//以参数值为过滤条件取数据，构造RowSet……
	 			return rowset;
			} 
			return null;
		}
	}

	
}