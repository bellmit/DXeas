/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.appframework.databinding.DataBinder;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardCollection;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedStandardFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.FeeSendPerson;
import com.kingdee.eas.farm.stocking.basedata.FeeSendPersonInfo;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberCollection;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberFactory;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarmers;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillInfo;
import com.kingdee.eas.farm.stocking.processbizill.IBatchContract;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.rpt.StockingDailyOrderTypeEnum;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.eas.wlhlcomm.impl.DetailPanelBackListener;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class FodderApplyBillEditUI extends AbstractFodderApplyBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FodderApplyBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private FeeSendPersonInfo personInfo = null;//送料人
	private FeedWithHisNumberInfo feedWithHisNumberInfo = null;//饲料编号
	/**
	 * output class constructor
	 */
	public FodderApplyBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	public void loadFields()
	{
		super.loadFields(); 

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
		return com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new Date());
		objectValue.setBeginDate(new Date());
		objectValue.setEndDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setPeriod(DateUtilsComm.getCurrentPeriodInfo());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setTechnician(SysContext.getSysContext().getCurrentUserInfo().getPerson());
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
			FodderApplyBillEntryInfo entryInfo,entryInfoClone;
			for(String farmerID:list) {
				farmerInfo=iffs.getFarmersInfo(new ObjectUuidPK(farmerID));

				entryInfo=new FodderApplyBillEntryInfo();
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
					if(bInfo.isIsAllOut()||bInfo.getAllOutDate()!=null)
						continue;
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
						//默认千克
						entryInfo.setUnit(MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("gw5fUwEOEADgAAsRwKgSOFuCXFc=")));
						entryInfo.setUnitQty(StockingComm.getUnitQty(null, curCompanyID, entry.getKey().getString("id")));
						if(map.size()==1) {
							break;
						}else{
							//非最后一行不添加
							if(index<map.size()) {
								entryInfoClone=(FodderApplyBillEntryInfo) entryInfo.clone();
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
		curStorageOrgUnitID=StockingClientComm.checkAndGetStorageOrgUnitID();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();


		ActionListener[] lsAddNewLine = kdtEntrys_detailPanel.getAddNewLineButton().getListeners(ActionListener.class);
		for(int i=0;i<lsAddNewLine.length;i++)
			kdtEntrys_detailPanel.getAddNewLineButton().removeActionListener(lsAddNewLine[i]);


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sql = "where isCancelCancel=1 and beginDate<=('" + sdf.format(new Date()) + "') and endDate>=('" + sdf.format(new Date()) + "')";
		FeedWithHisNumberCollection coll = FeedWithHisNumberFactory.getRemoteInstance().getFeedWithHisNumberCollection(sql);
		if(coll.size()>0)
			feedWithHisNumberInfo=coll.get(0);
		//设置物料编号
		if(coll.size()>0){
			feedWithHisNumberInfo=coll.get(0);
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add("*");
			slor.add("num1.*");
			slor.add("num2.*");
			slor.add("num3.*");
			slor.add("num4.*");
			slor.add("num5.*");
			slor.add("num6.*");
			slor.add("num7.*");
			feedWithHisNumberInfo = FeedWithHisNumberFactory.getRemoteInstance().getFeedWithHisNumberInfo(new ObjectUuidPK(feedWithHisNumberInfo.getId()),slor );
			if(feedWithHisNumberInfo.getNum1() != null){
				kdtEntrys.getHeadRow(0).getCell("num1Feed").setValue(feedWithHisNumberInfo.getNum1().getName());
			}if(feedWithHisNumberInfo.getNum2() != null){
				kdtEntrys.getHeadRow(0).getCell("num2Feed").setValue(feedWithHisNumberInfo.getNum2().getName());
			}if(feedWithHisNumberInfo.getNum3() != null){
				kdtEntrys.getHeadRow(0).getCell("num3Feed").setValue(feedWithHisNumberInfo.getNum3().getName());
			}if(feedWithHisNumberInfo.getNum4() != null){
				kdtEntrys.getHeadRow(0).getCell("num4Feed").setValue(feedWithHisNumberInfo.getNum4().getName());
			}if(feedWithHisNumberInfo.getNum5() != null){
				kdtEntrys.getHeadRow(0).getCell("num5Feed").setValue(feedWithHisNumberInfo.getNum5().getName());
			}if(feedWithHisNumberInfo.getNum5() != null){
				kdtEntrys.getHeadRow(0).getCell("num6Feed").setValue(feedWithHisNumberInfo.getNum6().getName());
			}if(feedWithHisNumberInfo.getNum5() != null){
				kdtEntrys.getHeadRow(0).getCell("num7Feed").setValue(feedWithHisNumberInfo.getNum7().getName());
			}
		}


		kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				kdtEntrys.addRow();
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "sendDate").setValue(pkbeginDate.getValue());
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "currentQty").setValue(0);
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "sendPerson").setValue(personInfo);
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "feedNum").setValue(feedWithHisNumberInfo);
				
				MeasureUnitInfo unitInfo;
				try {
					unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("gw5fUwEOEADgAAsRwKgSOFuCXFc="));
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "unit").setValue(unitInfo); //gw5fUwEOEADgAAsRwKgSOFuCXFc=
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			
			}});


		ActionListener[] lsInsertLine = kdtEntrys_detailPanel.getInsertLineButton().getListeners(ActionListener.class);
		for(int i=0;i<lsInsertLine.length;i++)
			kdtEntrys_detailPanel.getInsertLineButton().removeActionListener(lsInsertLine[i]);


		kdtEntrys_detailPanel.getInsertLineButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = 1;
				if(KDTableUtil.getSelectedRow(kdtEntrys)!=null)
					row=KDTableUtil.getSelectedRow(kdtEntrys).getRowIndex();
				kdtEntrys.addRow(row);
				kdtEntrys.getCell(row, "sendDate").setValue(pkbeginDate.getValue());
				kdtEntrys.getCell(row, "currentQty").setValue(0);
				kdtEntrys.getCell(row, "sendPerson").setValue(personInfo);
				kdtEntrys.getCell(row, "feedNum").setValue(feedWithHisNumberInfo);


			}});
	}

	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		//重新设置送料公司的Query
		final KDBizPromptBox kdtEntrys_sendCompany_PromptBox = new KDBizPromptBox();
		kdtEntrys_sendCompany_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");
		kdtEntrys_sendCompany_PromptBox.setVisible(true);
		kdtEntrys_sendCompany_PromptBox.setEditable(true);
		kdtEntrys_sendCompany_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_sendCompany_PromptBox.setEditFormat("$number$");
		kdtEntrys_sendCompany_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_sendCompany_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendCompany_PromptBox);
		this.kdtEntrys.getColumn("sendCompany").setEditor(kdtEntrys_sendCompany_CellEditor);





		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		setFilter();

		
		kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){

			
			public void afterEvent(DetailPanelEvent e) throws Exception {
				// TODO Auto-generated method stub
//				FodderApplyBillEntryInfo entry=(FodderApplyBillEntryInfo)e.getObjectValue();
//				MeasureUnitInfo unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("nCBM/O7FRYOeCy1OtFJQn1uCXFc=")); 
//				entry.setUnit(unitInfo);
			}

			
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				// TODO Auto-generated method stub
//				FodderApplyBillEntryInfo entry=(FodderApplyBillEntryInfo)e.getObjectValue();
//				MeasureUnitInfo unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("nCBM/O7FRYOeCy1OtFJQn1uCXFc=")); 
//				entry.setUnit(unitInfo);
			}
			
		});
		
		
		kdtEntrys_detailPanel.addAddListener(new DetailPanelBackListener(){
			
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				// TODO Auto-generated method stub
				super.beforeEvent(e);
//				FodderApplyBillEntryInfo entry=(FodderApplyBillEntryInfo)e.getObjectValue();
//				MeasureUnitInfo unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("nCBM/O7FRYOeCy1OtFJQn1uCXFc=")); 
//				entry.setUnit(unitInfo);				
			}
		});
		kdtEntrys_detailPanel.addInsertListener(new DetailPanelBackListener(){
			
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				// TODO Auto-generated method stub
				super.beforeEvent(e);
//				FodderApplyBillEntryInfo entry=(FodderApplyBillEntryInfo)e.getObjectValue();
//				MeasureUnitInfo unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("nCBM/O7FRYOeCy1OtFJQn1uCXFc=")); 
//				entry.setUnit(unitInfo);			
			}
		});
		
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);
			}});

		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				kdteditStopped(e);
			}
			public void editStarted(KDTEditEvent e) {
				kdteditStarted(e);
			}});

	}

	private void kdteditStopped(KDTEditEvent e) {
		// TODO Auto-generated method stub
		int colIndex = e.getColIndex();
		int rowIndex = e.getRowIndex();


		if(kdtEntrys.getColumnKey(e.getColIndex()).equals("sendPerson"))
			if(e.getValue()!=null)
				personInfo=(FeeSendPersonInfo) e.getValue();
		if(kdtEntrys.getColumn(colIndex).getKey().equals("batchContract")||kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")){
			kdtEntrys.getCell(e.getRowIndex(), "house").setValue(null);
		}
		//合同带出批次养殖户等信息
		if(kdtEntrys.getColumn(colIndex).getKey().equals("batchContract")) {
			if(e.getValue()==null){
				kdtEntrys.getCell(rowIndex, "farm").setValue(null);
				kdtEntrys.getCell(rowIndex, "farmer").setValue(null);
				kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(null);
			}else{
				BatchContractInfo batchContractInfo = (BatchContractInfo)e.getValue();
				try {
					kdtEntrys.getCell(rowIndex, "farm").setValue(batchContractInfo.getFarm()==null?null:FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(batchContractInfo.getFarm().getString("id"))));
					kdtEntrys.getCell(rowIndex, "farmer").setValue(batchContractInfo.getFarmer()==null?null:FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(batchContractInfo.getFarmer().getString("id"))));
					kdtEntrys.getCell(rowIndex, "stockingBatch").setValue(batchContractInfo.getStockingBatch()==null?null:StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchContractInfo.getStockingBatch().getString("id"))));
					kdtEntrys.getCell(rowIndex, "hatchDate").setValue(batchContractInfo.getStockingBatch()==null?null:StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchContractInfo.getStockingBatch().getString("id"))).getInDate());

					if(pkbeginDate.getValue()!=null&&kdtEntrys.getCell(rowIndex, "hatchDate").getValue()!=null){

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String beginString = sdf.format(pkbeginDate.getValue());
						Date beginDate = sdf.parse(beginString);
						int[] result = StockingComm.getBreedWeekAndDay(beginDate,(Date)kdtEntrys.getCell(rowIndex, "hatchDate").getValue());
						int week=result[0];
						int weekDay=result[1];
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(week+"周"+weekDay);
					}

					kdtEntry_calCurrentQty(rowIndex);

				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		//根据饲料编号自动带出四个物料
		if(kdtEntrys.getColumn(colIndex).getKey().equals("feedNum")) {

			if(kdtEntrys.getCell(e.getRowIndex(), "feedNum").getValue() != null){

				
				
				FeedWithHisNumberInfo bappBillInfo = null;
				try {
					bappBillInfo = FeedWithHisNumberFactory.getRemoteInstance().getFeedWithHisNumberInfo(new ObjectUuidPK(((FeedWithHisNumberInfo) kdtEntrys.getCell(e.getRowIndex(), "feedNum").getValue()).getId()));
					MeasureUnitInfo unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK("nCBM/O7FRYOeCy1OtFJQn1uCXFc=")); 
					kdtEntrys.getCell(e.getRowIndex(), "unit").setValue(unitInfo); //nCBM/O7FRYOeCy1OtFJQn1uCXFc=
				} catch (EASBizException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (BOSException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//设置物料
				MaterialInfo matInfo = null;
				try {
					if(bappBillInfo.getNum1() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(bappBillInfo.getNum1().getId()));
						kdtEntrys.getHeadRow(0).getCell("num1Feed").setValue(matInfo.getName());
					}if(bappBillInfo.getNum2() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(bappBillInfo.getNum2().getId()));
						kdtEntrys.getHeadRow(0).getCell("num2Feed").setValue(matInfo.getName());
					}if(bappBillInfo.getNum3() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(bappBillInfo.getNum3().getId()));
						kdtEntrys.getHeadRow(0).getCell("num3Feed").setValue(matInfo.getName());
					}if(bappBillInfo.getNum4() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(bappBillInfo.getNum4().getId()));
						kdtEntrys.getHeadRow(0).getCell("num4Feed").setValue(matInfo.getName());
					}if(bappBillInfo.getNum5() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(bappBillInfo.getNum5().getId()));
						kdtEntrys.getHeadRow(0).getCell("num5Feed").setValue(matInfo.getName());
					}if(bappBillInfo.getNum6() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(bappBillInfo.getNum6().getId()));
						kdtEntrys.getHeadRow(0).getCell("num6Feed").setValue(matInfo.getName());
					}if(bappBillInfo.getNum7() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(bappBillInfo.getNum7().getId()));
						kdtEntrys.getHeadRow(0).getCell("num7Feed").setValue(matInfo.getName());
					}


				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}


		//批次带出合同养殖户等信息
		if(kdtEntrys.getColumn(colIndex).getKey().equals("stockingBatch")) {
			if(e.getValue()==null){
				kdtEntrys.getCell(rowIndex, "farm").setValue(null);
				kdtEntrys.getCell(rowIndex, "farmer").setValue(null);
				kdtEntrys.getCell(rowIndex, "batchContract").setValue(null);
			}else{
				StockingBatchInfo batchContractInfo = (StockingBatchInfo)e.getValue();
				try {
					kdtEntrys.getCell(rowIndex, "farm").setValue(batchContractInfo.getFarm()==null?null:FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(batchContractInfo.getFarm().getString("id"))));
					kdtEntrys.getCell(rowIndex, "farmer").setValue(batchContractInfo.getFarmer()==null?null:FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(batchContractInfo.getFarmer().getString("id"))));
					kdtEntrys.getCell(rowIndex, "batchContract").setValue(batchContractInfo.getBatchContract()==null?null:BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(batchContractInfo.getBatchContract().getString("id"))));


					kdtEntrys.getCell(rowIndex, "hatchDate").setValue(batchContractInfo.getInDate());

					if(pkbeginDate.getValue()!=null&&kdtEntrys.getCell(rowIndex, "hatchDate").getValue()!=null){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String beginString = sdf.format(pkbeginDate.getValue());
						Date beginDate = sdf.parse(beginString);
						int dayAge=0;//DateUtilsComm.getDiffBetweenTwoDays((Date)kdtEntrys.getCell(rowIndex, "hatchDate").getValue(),beginDate);
						//						kdtEntrys.getCell(rowIndex, "weekAge").setValue((dayAge/7+1)+"周"+(dayAge%7));

						int[] result = StockingComm.getBreedWeekAndDay(beginDate,(Date)kdtEntrys.getCell(rowIndex, "hatchDate").getValue());
						int week=result[0];
						int weekDay=result[1];
						kdtEntrys.getCell(rowIndex, "weekAge").setValue(week+"周"+weekDay);


						BreedStandardCollection coll = BreedStandardFactory.getRemoteInstance().getBreedStandardCollection("where BreedData='"+batchContractInfo.getBreedData().getString("id")+"' and BaseStatus=3");
						if(coll.size()>0){
							BreedStandardEntryCollection collEntry = BreedStandardEntryFactory.getRemoteInstance().getBreedStandardEntryCollection("where week="+(dayAge/7+1)+" and Days="+(dayAge%7+1)+" and parent='"+coll.get(0).getString("id")+"'");
							if(collEntry.size()>0)
								kdtEntrys.getCell(rowIndex, "feedStdDaily").setValue(collEntry.get(0).getHenQtyPerday());
						}
					}
					kdtEntry_calCurrentQty(rowIndex);

				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}


		if(kdtEntrys.getColumnKey(colIndex).equals("material")&&kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
			kdtEntrys.getCell(rowIndex, "unitQty").setValue(StockingComm.getUnitQty(null, curCompanyID, ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id")));
		}
	}
	private void kdtEntry_calCurrentQty(int rowIndex) throws BOSException {
		// TODO Auto-generated method stub
		//计算存栏
		if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null){
			StockingBatchInfo batchInfo = (StockingBatchInfo)kdtEntrys.getCell(rowIndex, "stockingBatch").getValue();
			BigDecimal totalQty = (batchInfo.getTotalQty()==null?BigDecimal.ZERO:batchInfo.getTotalQty());
			BigDecimal allDeathQty=BigDecimal.ZERO;

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			StockingBreedDailyCollection coll = StockingBreedDailyFactory.getRemoteInstance().getStockingBreedDailyCollection("where StockingBatch='"+batchInfo.getString("id")+"'"+(pkbeginDate.getValue()==null?"":(" and bizDate<{"+(sdf.format((Date)pkbeginDate.getValue())+"}"))));
			for(int i=0;i<coll.size();i++)
				for(int j=0;j<coll.get(i).getAssEntrys().size();j++){
					allDeathQty=allDeathQty.add(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getDeathQty()));
					allDeathQty=allDeathQty.add(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getCullQty()));
					allDeathQty=allDeathQty.add(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getFemaleCullQty()));
					allDeathQty=allDeathQty.add(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getFemaleDeathQty()));
					allDeathQty=allDeathQty.add(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getMarkedQty()));
					allDeathQty=allDeathQty.add(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getFemaleMarketed()));
					allDeathQty=allDeathQty.subtract(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getAdjustQty()));
					allDeathQty=allDeathQty.subtract(UIRuleUtil.getBigDecimal(coll.get(i).getAssEntrys().get(j).getAdjustFemaleQty()));
				}
			kdtEntrys.getCell(rowIndex, "currentQty").setValue(totalQty.subtract(allDeathQty));
		}
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
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")
				||key.equals("batchContract")||key.equals("house")) {
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

			//棚舍过滤
			if(kdtEntrys.getColumnKey(e.getColIndex()).equals("house")){
				String batchID="";
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

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
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
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()==null&&this.kdtEntrys.getCell(rowIndex, "batchContract").getValue()==null) {
			//	MsgBox.showWarning("第"+(rowIndex+1)+"行分录，批次和合同不能同时为空！");
				//SysUtil.abort();
			}
		}
	}
	@Override
	protected void setTableToSumField() {
		// TODO Auto-generated method stub
		setTableToSumField(kdtEntrys,new String[]{"qty","bagQty","num1Feed","num2Feed","num3Feed","num4Feed","num5Feed","num6Feed","num7Feed"});
	}
	@Override
	protected void setTableToSumField(KDTable arg0, String[] arg1) {
		// TODO Auto-generated method stub
		super.setTableToSumField(arg0, arg1);
	}

}