/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseCollection;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;

import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelCollection;
import com.kingdee.eas.farm.breed.BreedModelEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelFactory;
import com.kingdee.eas.farm.breed.BreedModelImmuneEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelImmuneEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetCollection;
import com.kingdee.eas.farm.breed.BreedStoorgSetFactory;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.ChikenType;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.IBreedFacade;
import com.kingdee.eas.farm.breed.business.BusinessBreedFacadeFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderFactory;
import com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderFodderPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo;
import com.kingdee.eas.farm.breed.business.IBusinessBreedFacade;
import com.kingdee.eas.farm.breed.comm.BatchTowerInhouseDetail;
import com.kingdee.eas.farm.breed.comm.BatchTowerInhouseInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchEntryDetailInfo;
import com.kingdee.eas.farm.breed.comm.BreedDaily;
import com.kingdee.eas.farm.breed.comm.CCSendFodderStandard;
import com.kingdee.eas.farm.breed.comm.CCSendFodderStandardDetail;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.client.CoreBillEditUI;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class CommecialChilkenDailyEditUI extends AbstractCommecialChilkenDailyEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CommecialChilkenDailyEditUI.class);
	// 批次入栏日期
	private Map<String,Date> batchEncoopDates;
	// 批次明细
	private Map<String,BreedBatchEntryDetailInfo> batchEntryDetailInfos;

	// 日期监听
	DataChangeListener bizDateListener ;
	/**
	 * output class constructor
	 */
	public CommecialChilkenDailyEditUI() throws Exception
	{
		super();
		f7Init();
	}


	/**
	 * 
	 */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));


		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
			this.actionGenNextBill.setEnabled(false);
			this.btnGenNextBill.setEnabled(false);
		}else {
			if(this.getOprtState().equals("EDIT")){
				//				checkCanEdit();
			}

		}

		// 设置默认当前库存组织所有鸡舍信息
		StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStorageOrgInfo == null){
			MsgBox.showInfo("当前未在任何库存组织中，不能进行新增养殖日报操作");
			SysUtil.abort();
		}
		this.kdtAssEntrys.getColumn("days").getStyleAttributes().setLocked(true);
		this.kdtAssEntrys.getColumn("breedingStock").getStyleAttributes().setLocked(true);


		initData();

	}

	/**
	 * 编辑前校验单据是否在创建组织；
	 */
	@Override
	public void actionEdit_actionPerformed(ActionEvent e)throws Exception{

		if (this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}

		super.actionEdit_actionPerformed(e);
	}
	/**
	 * 根据编辑数据初始化 界面内容
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void initData() throws BOSException, EASBizException{

		//业务日期添加监听事件
		pkBizDate.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				BatchInfo newValue = (BatchInfo) prmtbreedBatch.getValue();

				Date newDate = (Date) e.getNewValue();

				Date oldDate = (Date) e.getOldValue();

				if(newDate != null && oldDate != null && newDate.equals(oldDate)){
					return;
				}
				if(newValue != null){
					// 清空分录  更新新选中的批次信息 重新设置分录数据
					kdtEntrys.removeRows();
					kdtAssEntrys.removeRows();
					kdtImmuneEntrys.removeRows();
					kdtFodderPlanEntrys.removeRows();
					editData.getEntrys().clear();
					editData.getAssEntrys().clear();
					editData.getImmuneEntrys().clear();
					// 根据批次信息和 对应的 养殖规范设置分录信息
					try {
						setAllEntryInfos(newValue);
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});




		//批次添加监听事件
		this.prmtbreedBatch.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub

				try{
					BatchInfo oldValue = (BatchInfo) e.getOldValue();
					BatchInfo newValue = (BatchInfo) e.getNewValue();
					// 值为空 则清空分录
					if(newValue == null){
						kdtEntrys.removeRows();
						kdtAssEntrys.removeRows();
						kdtImmuneEntrys.removeRows();
						txtdays.setValue(0);
						editData.getEntrys().clear();
						editData.getAssEntrys().clear();
						editData.getImmuneEntrys().clear();
						editData.setDays(0);
						// 
						batchEncoopDates = new HashMap<String, Date>();
					}else if(oldValue != null && newValue.getId().toString().equals(oldValue.getId().toString())){
						return;
					}else{
						// 清空分录  更新新选中的批次信息 重新设置分录数据
						kdtEntrys.removeRows();
						kdtAssEntrys.removeRows();
						kdtImmuneEntrys.removeRows();
						kdtFodderPlanEntrys.removeRows();
						editData.getEntrys().clear();
						editData.getAssEntrys().clear();
						editData.getImmuneEntrys().clear();
						txtdays.setValue(0);
						editData.setDays(0);
						// 根据批次信息和 对应的 养殖规范设置分录信息
						setAllEntryInfos(newValue);
					}
				}catch(FarmException fe){
					MsgBox.showError(fe.getMessage());
					SysUtil.abort();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


	}

	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {

		//计算只耗料
		calcOneFeed();

		// 空栏期不校验 批次  和 养殖信息分录
		if(this.chkisHenhouseEmpty.isSelected()){
			if(this.kdtEntrys.getRowCount() > 0){
				MsgBox.showInfo("空栏期不能填写饲喂信息分录");
				SysUtil.abort();
			}
			if(this.kdtImmuneEntrys.getRowCount() > 0){
				MsgBox.showInfo("空栏期不能填写环控信息分录");
				SysUtil.abort();
			}
			if(this.kdtAssEntrys.getRowCount() > 0){
				MsgBox.showInfo("空栏期不能填写免疫信息分录");
				SysUtil.abort();
			}
		}else{
			String breedLog = this.txtbreedLog.getText();
			if(breedLog != null){
				int length = breedLog.length();
				if(length > 2000){
					MsgBox.showInfo("养殖日志字数不能大于2000");
					SysUtil.abort();
				}
			}
			super.beforeStoreFields(arg0);
		}
	}


	/**
	 * 计算只耗料
	 */
	private void calcOneFeed() {
		// TODO Auto-generated method stub

		Map<String,BigDecimal> assMap = new HashMap<String,BigDecimal>();
		BigDecimal allQty = BigDecimal.ZERO;
		if(kdtAssEntrys.getRowCount() > 0){
			FarmHouseEntryInfo houseInfo = null;
			for(int i=0,size = kdtAssEntrys.getRowCount();i<size;i++){
				if(kdtAssEntrys.getCell(i,"henhouse").getValue() != null){//公司自养
					houseInfo = (FarmHouseEntryInfo) kdtAssEntrys.getCell(i,"henhouse").getValue();
					BigDecimal qty = new BigDecimal( kdtAssEntrys.getCell(i,"breedingStock").getValue().toString());
					assMap.put(houseInfo.getId().toString(), qty);
				}else{//公司放养
					allQty = new BigDecimal( kdtAssEntrys.getCell(i,"breedingStock").getValue().toString());
				}
			}
		}

		if(kdtEntrys.getRowCount() > 0){
			FarmHouseEntryInfo houseInfo = null;
			BigDecimal feedQty = BigDecimal.ZERO;
			for(int i = 0,size = kdtEntrys.getRowCount();i<size;i++){
				if(kdtEntrys.getCell(i,"henhouse").getValue() != null){//公司自养
					houseInfo = (FarmHouseEntryInfo) kdtEntrys.getCell(i,"henhouse").getValue();//棚舍
					BigDecimal dailyQtyAll = (BigDecimal) kdtEntrys.getCell(i,"dailyQtyAll").getValue();
					if(UIRuleUtil.isNull(dailyQtyAll)){ 
						MsgBox.showWarning("日喂料量不能为空！");
						SysUtil.abort();
					}
					Set<String> keySet = assMap.keySet();//先获取map集合的所有键的Set集合
					Iterator<String> it = keySet.iterator();//有了Set集合，就可以获取其迭代器。
					while(it.hasNext()){
						String key = it.next();
						if(key.equalsIgnoreCase(houseInfo.getId().toString())){
							BigDecimal qty = assMap.get(key);
							if(qty.compareTo(BigDecimal.ZERO)  == 0){
								kdtEntrys.getCell(i,"averageWeight").setValue(BigDecimal.ZERO);	
							}else{
								kdtEntrys.getCell(i,"averageWeight").setValue(dailyQtyAll.divide(qty,2,BigDecimal.ROUND_HALF_UP));
							}
							break;
						}
					}
				}else{//公司放养
					feedQty = new BigDecimal(kdtEntrys.getCell(i,"dailyQtyAll").getValue().toString());
					kdtEntrys.getCell(i,"averageWeight").setValue(feedQty.divide(allQty,2,BigDecimal.ROUND_HALF_UP));
				}
			}

		}



	}


	/**
	 * f7初始化
	 */
	private void f7Init(){

		//棚舍设置query
		//饲喂信息棚舍设置
		final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
		kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.carviousFarmHouseQuery");
		kdtEntrys_henhouse_PromptBox.setVisible(true);
		kdtEntrys_henhouse_PromptBox.setEditable(true);
		kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
		kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);
		this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);

		//养殖信息棚舍设置
		this.kdtAssEntrys.checkParsed();
		final KDBizPromptBox kdtAssEntrys_henhouse_PromptBox = new KDBizPromptBox();
		kdtAssEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.carviousFarmHouseQuery");
		kdtAssEntrys_henhouse_PromptBox.setVisible(true);
		kdtAssEntrys_henhouse_PromptBox.setEditable(true);
		kdtAssEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
		kdtAssEntrys_henhouse_PromptBox.setEditFormat("$number$");
		kdtAssEntrys_henhouse_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtAssEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_henhouse_PromptBox);
		this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtAssEntrys_henhouse_CellEditor);
		ObjectValueRender kdtAssEntrys_henhouse_OVR = new ObjectValueRender();
		kdtAssEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
		this.kdtAssEntrys.getColumn("henhouse").setRenderer(kdtAssEntrys_henhouse_OVR);

		//免疫信息棚舍设置
		final KDBizPromptBox kdtImmuneEntrys_henhouse_PromptBox = new KDBizPromptBox();
		kdtImmuneEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.carviousFarmHouseQuery");
		kdtImmuneEntrys_henhouse_PromptBox.setVisible(true);
		kdtImmuneEntrys_henhouse_PromptBox.setEditable(true);
		kdtImmuneEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
		kdtImmuneEntrys_henhouse_PromptBox.setEditFormat("$number$");
		kdtImmuneEntrys_henhouse_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtImmuneEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_henhouse_PromptBox);
		this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtImmuneEntrys_henhouse_CellEditor);
		ObjectValueRender kdtImmuneEntrys_henhouse_OVR = new ObjectValueRender();
		kdtImmuneEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
		this.kdtImmuneEntrys.getColumn("henhouse").setRenderer(kdtImmuneEntrys_henhouse_OVR);

	}




	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return CommecialChilkenDailyFactory.getRemoteInstance();
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
	 * @throws BOSException 
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		CommecialChilkenDailyInfo objectValue = new CommecialChilkenDailyInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
		this.baseStatus.setSelectedItem(BillBaseStatusEnum.ADD);
		this.baseStatus.setSelectedIndex(1);
		objectValue.setBizDate(new Date());
		// 设置默认当前库存组织所有鸡舍信息
		StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStorageOrgInfo == null){
			MsgBox.showInfo("当前未在任何库存组织中，不能进行新增养殖日报操作");
			SysUtil.abort();
		}
		//默认当前库存组织
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		this.prmtcompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}
	/**
	 * output applyDefaultValue method
	 */
	protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));

	}



	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}

		refreshCurPage();

	}

	private void refreshCurPage() throws Exception {
		// TODO Auto-generated method stub
		if (editData.getId() != null) {
			BOSUuid pk = editData.getId();
			super.doAfterSave(new ObjectUuidPK(editData.getId()));
			editData.setId(pk);
		}else{
			this.loadData();
		}
	}


	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("只能反审核处于审核状态的批次");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("反审核完成");
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
		refreshCurPage();
		this.btnEdit.setEnabled(true);
	}



	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{

				// 校验分录 转栏量 之和应为0
				int allTransQty = 0;
				for(int i = 0; i < this.kdtAssEntrys.getRowCount(); i++){

					Integer currDay = (Integer) this.kdtAssEntrys.getCell(i, "days").getValue();
					if(currDay == null) currDay = Integer.parseInt("0");
					// 周期小于最低饲喂周期则提示不能完全出栏
					Boolean isMarketed = (Boolean) this.kdtAssEntrys.getCell(i, "isMarketed").getValue();

					// 计算 转栏量
					Integer transQty = (Integer) this.kdtAssEntrys.getCell(i, "transQty").getValue();
					allTransQty = allTransQty + (transQty==null?0:transQty.intValue());


					// 计算 存栏量
					Integer death = (Integer) this.kdtAssEntrys.getCell(i, "cullAndDeath").getValue();
					int deathInt = (death == null? 0 :death.intValue());

					Integer market = (Integer) this.kdtAssEntrys.getCell(i, "marketQty").getValue();
					int marketQty = (market == null? 0 :market.intValue());

					Integer breedingStock = (Integer) this.kdtAssEntrys.getCell(i, "breedingStock").getValue();
					int breedingStockQty = (breedingStock == null? 0 :breedingStock.intValue());

					if(breedingStockQty < 0){
						MsgBox.showWarning("环控分录中，存栏量不能为负数");
						SysUtil.abort();
					}
					int allqty = breedingStock + market;
					if(allqty < 0){
						MsgBox.showWarning("日报中环控分录[存栏量]和[出栏量]之和不能小于0，如果该鸡舍还未进鸡，请删除该条分录");
						SysUtil.abort();
					}

				}
				if(allTransQty != 0){
					MsgBox.showWarning("当天所有鸡舍转栏量之和 不为0，请检查转栏量数据");
					SysUtil.abort();
				}


				super.actionSubmit_actionPerformed(e);

			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}


		}else{
			MsgBox.showWarning("只能提交未审核的单据");
			SysUtil.abort();
		}
	}


	/**
	 * 根据选中的养殖批次信息设置分录信息
	 * 更新入栏明细
	 * @param newValue
	 * @throws BOSException 
	 */
	private void setAllEntryInfos(BatchInfo batchInfo) throws BOSException {
		if(batchInfo != null){
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date bizDate = this.pkBizDate.getSqlDate();
				//获取批次详细信息
				IBreedFacade breedFacade = BreedFacadeFactory.getRemoteInstance();
				batchInfo = BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchInfo.getId()));


				//根据批次信息获取饲喂规范，通过品种资料获取
				BreedModelInfo breedModelInfo = null;
				String s2 = "/*dialect*/ select t1.fid breedDataid from CT_FM_BreedModel t1 where t1.CFHouseType = 3 and t1.CFCompanyID = '"+SysContext.getSysContext().getCurrentFIUnit().getId()+"'   and t1.CFBreedDataID = '"+batchInfo.getBreedData().getId()+"'";
				IRowSet r2 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s2);
				String breedDataid = null;
				if(r2.next()){
					breedDataid = r2.getString("breedDataid");
					breedModelInfo = BreedModelFactory.getRemoteInstance().getBreedModelInfo(new ObjectUuidPK(breedDataid));
				}else{
					MsgBox.showWarning("请先维护饲喂规范！");
					SysUtil.abort();
				}

				//设置周日龄
				int[] result = StockingComm.getspBreedWeekAndDay(bizDate, batchInfo.getInDate());
				int week=result[0];
				int weekDay=result[1];

				this.txtweek.setValue(week);
				this.txtday.setValue(weekDay);

				//纯日龄
				int allDay=((week-1)*7+weekDay);
				if(allDay<0) {
					allDay=0;
				}


				//根据批次信息判自动带出养殖场，再判断是否带出养殖户
				FarmInfo farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(batchInfo.getFarm().getId()));
				//自动带出养殖场
				prmtfarm.setValue(farmInfo);
				//养殖场类型--如果是公司自养需要自动带出养殖户
				FarmerInfo farmerInfo = null;
				if(farmInfo.getFarmType().equals(StockingFarmTypeEnum .company)){
					String farmerid = null;
					String s1 = "/*dialect*/ select t1.fid farmerid from CT_FM_Farmer t1 inner join CT_FM_FarmerFarmEntry t2 on t2.fparentid = t1.fid" +
					" inner join CT_FM_Farm t3 on t3.fid = t2.FFarmID where t3.fid = '"+farmInfo.getId()+"'";
					IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
					if(r1.next()){
						farmerid = r1.getString("farmerid");
					}
					farmerInfo = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerid));
					prmtfarmer.setValue(farmerInfo);


					//如果养殖类别是  公司自养，需要添加分录
					//设置饲喂信息分录
					fillentry(true,batchInfo,breedModelInfo);

					//设置养殖信息分录
					fillAssEntry(true,batchInfo,breedModelInfo);

					//设置免疫分录
					fillImmuneEntry(true,batchInfo,breedModelInfo);

				}else{

					//如果养殖类别是  公司自养，需要添加分录
					//设置饲喂信息分录
					fillentry(false,batchInfo,breedModelInfo);

					//设置养殖信息分录
					fillAssEntry(false,batchInfo,breedModelInfo);

					//设置免疫分录
					fillImmuneEntry(false,batchInfo,breedModelInfo);

				}

			}catch(EASBizException e){
				throw new BOSException(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 设置免疫信息分录
	 * @param b 是否是公司自养
	 * @param allDay 纯日龄
	 * @param weekDay 
	 * @param batchInfo 批次信息
	 * @param breedModelInfo2 饲喂规范
	 */
	private void fillImmuneEntry(boolean b, BatchInfo batchInfo,BreedModelInfo breedModelInfo) {
		// TODO Auto-generated method stub

		try {
			//如果是公司自养，需要新增分录行(按照批次信息的棚舍信息行数增加)，
			if(b){
				if(batchInfo.getHouseEntry().size() > 0){
					BatchHouseEntryCollection batchHouseEntryColl = batchInfo.getHouseEntry();
					BatchHouseEntryInfo entryInfo = null;
					FarmHouseEntryInfo houseInfo = null;
					int allDay = 0;
					BreedModelImmuneEntryInfo immuneEntryInfo = null;
					MaterialInfo materialInfo = null;
					MeasureUnitInfo immuneUnit = null;
					for(int i=0,size = batchInfo.getHouseEntry().size();i<size;i++){
						entryInfo = batchHouseEntryColl.get(i);

						//鸡舍
						houseInfo = FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryInfo(new ObjectUuidPK(entryInfo.getHouse().getId()));

						//根据分录里面的入雏日期获取纯日龄
						int[] result = StockingComm.getspBreedWeekAndDay(pkBizDate.getSqlDate(), entryInfo.getInDate());
						allDay = (result[0]-1)*7+result[1];

						//根据周龄，日龄获取免疫规范
						immuneEntryInfo = getImmuneStand(result[0],result[1],breedModelInfo);


						//饲喂规范的免疫信息分录--疫苗
						materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(immuneEntryInfo.getImmuneMaterial().getId()));
						if(immuneEntryInfo != null){
							//疫苗的计量单位
							immuneUnit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(immuneEntryInfo.getUnit().getId()));

							//新增饲喂信息分录
							this.kdtImmuneEntrys.addRow();
							this.kdtImmuneEntrys.getCell(i, "henhouse").setValue(houseInfo);
							this.kdtImmuneEntrys.getCell(i, "henhouseName").setValue(houseInfo.getName());
							this.kdtImmuneEntrys.getCell(i, "vaccineMaterial").setValue(materialInfo);
							this.kdtImmuneEntrys.getCell(i, "vaccineUnit").setValue(immuneUnit);
							this.kdtImmuneEntrys.getCell(i, "days").setValue(allDay);
						}
					}
				}
			}else{//只新增一行
				//根据分录里面的入雏日期获取纯日龄

				int[] result = StockingComm.getBreedWeekAndDay(pkBizDate.getSqlDate(), batchInfo.getInDate());
				int allDay = (result[0]-1)*7+result[1];
				BreedModelImmuneEntryInfo immuneEntryInfo = getImmuneStand(result[0],result[1],breedModelInfo);
				MaterialInfo materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(immuneEntryInfo.getImmuneMaterial().getId()));

				//疫苗的计量单位
				MeasureUnitInfo immuneUnit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(immuneEntryInfo.getUnit().getId()));

				//新增饲喂信息分录
				this.kdtImmuneEntrys.addRow();
				this.kdtImmuneEntrys.getCell(0, "vaccineMaterial").setValue(materialInfo);
				this.kdtImmuneEntrys.getCell(0, "days").setValue(allDay);
				this.kdtImmuneEntrys.getCell(0, "vaccineUnit").setValue(immuneUnit);

			}

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 *根据周日龄获取饲喂规范烦人免疫信息分录
	 * @param i
	 * @param j
	 * @param breedModelInfo
	 * @return
	 */
	private BreedModelImmuneEntryInfo getImmuneStand(int week, int day, BreedModelInfo breedModelInfo) {
		// TODO Auto-generated method stub

		String s1 = "/*dialect*/ select t2.fid breedModelEntryid from CT_FM_BreedModel t1" +
		" inner join CT_FM_BreedModelImmuneEntrys t2 on t2.FParentID = t1.fid" +
		" where t1.fid = '"+breedModelInfo.getId()+"' and t2.CFWeek <="+week+" and t2.CFDays <="+day+" and t2.CFWeekTo >= "+week+" and t2.CFDayTo >="+day;
		IRowSet r1;
		BreedModelImmuneEntryInfo breedModelEntryInfo = null;
		try {
			r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
			String breedModelEntryid = null;
			if(r1.next()){
				breedModelEntryid = r1.getString("breedModelEntryid");
				breedModelEntryInfo = BreedModelImmuneEntryFactory.getRemoteInstance().getBreedModelImmuneEntryInfo(new ObjectUuidPK(breedModelEntryid));
				return breedModelEntryInfo;
			}

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return breedModelEntryInfo;



	}


	/**
	 * 设置养殖信息分录
	 * @param b 是否是公司自养
	 * @param allDay 纯日龄
	 * @param weekDay 
	 * @param batchInfo 批次信息
	 * @param breedModelInfo2 饲喂规范
	 */
	private void fillAssEntry(boolean b, BatchInfo batchInfo,BreedModelInfo breedModelInfo) {

		try {
			//如果是公司自养，需要新增分录行(按照批次信息的棚舍信息行数增加)，
			if(b){
				if(batchInfo.getHouseEntry().size() > 0){
					BatchHouseEntryCollection batchHouseEntryColl = batchInfo.getHouseEntry();
					BatchHouseEntryInfo entryInfo = null;
					FarmHouseEntryInfo houseInfo = null;
					int allDay = 0;
					for(int i=0,size = batchInfo.getHouseEntry().size();i<size;i++){
						entryInfo = batchHouseEntryColl.get(i);

						//鸡舍
						houseInfo = FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryInfo(new ObjectUuidPK(entryInfo.getHouse().getId()));

						//根据分录里面的入雏日期获取纯日龄
						int[] result = StockingComm.getspBreedWeekAndDay(pkBizDate.getSqlDate(), entryInfo.getInDate());
						allDay = (result[0]-1)*7+result[1];

						//计算业务日期之前的累计死亡淘汰
						BigDecimal passQty = calcStockQty(houseInfo,batchInfo);
						//批次信息的入雏数量(棚舍信息的公禽数量)
						BigDecimal inQty = entryInfo.getMaleQty();
						//新增饲喂信息分录
						this.kdtAssEntrys.addRow();
						this.kdtAssEntrys.getCell(i, "henhouse").setValue(houseInfo);
						this.kdtAssEntrys.getCell(i, "henhouseName").setValue(houseInfo.getName());
						this.kdtAssEntrys.getCell(i, "days").setValue(allDay);
						this.kdtAssEntrys.getCell(i, "breedingStock").setValue(inQty.subtract(passQty));
					}
				}
			}else{//只新增一行
				//根据分录里面的入雏日期获取纯日龄

				int[] result = StockingComm.getBreedWeekAndDay(pkBizDate.getSqlDate(), batchInfo.getInDate());
				int allDay = (result[0]-1)*7+result[1];
				//计算业务日期之前的累计死亡淘汰
				BigDecimal passQty = calcStockQty(null,batchInfo);
				//批次信息的入雏数量(棚舍信息的公禽数量)
				BigDecimal inQty = batchInfo.getFemaleQty();

				//新增饲喂信息分录
				this.kdtAssEntrys.addRow();
				this.kdtAssEntrys.getCell(0, "days").setValue(allDay);//日龄
				this.kdtAssEntrys.getCell(0, "breedingStock").setValue(inQty.subtract(passQty));//存栏

			}

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	/**
	 * 计算存栏量
	 * @param houseInfo 
	 * @param batchInfo 
	 */
	private BigDecimal calcStockQty(FarmHouseEntryInfo houseInfo, BatchInfo batchInfo) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer s1 = new StringBuffer();
		s1.append("/*dialect*/ select sum(t2.CFCullAndDeath) cullAndDeath, sum(t2.CFMarketQty)    markQty,sum(t2.CFTransQty) transQty");
		s1.append(" from CT_FM_CommecialChilkenDaily  t1 inner join CT_FM_CommecialCDAE t2 on t2.fparentid = t1.fid");
		s1.append(" where t1.CFBreedBatchID = '");
		s1.append(batchInfo.getId());
		s1.append("'");
		s1.append(" and t1.FBizDate < { d '");
		s1.append(sdf.format(pkBizDate.getValue()));
		s1.append("'}");
		if(houseInfo != null){
			s1.append(" and t2.CFHenhouseID = '");
			s1.append(houseInfo.getId());
			s1.append("'");
		}
		if(editData.getId() != null){
			s1.append(" and t1.fid != '");
			s1.append(editData.getId());
			s1.append("'");
		}
		BigDecimal allPass = BigDecimal.ZERO;
		BigDecimal cullAndDeath = BigDecimal.ZERO;
		BigDecimal markQty = BigDecimal.ZERO;
		BigDecimal transQty = BigDecimal.ZERO;
		IRowSet r1;
		try {
			r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1.toString());
			if(r1.next()){
				cullAndDeath = UIRuleUtil.getBigDecimal(r1.getBigDecimal("cullAndDeath"));
				markQty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("markQty"));
				transQty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("transQty"));
				allPass = cullAndDeath.add(markQty).subtract(transQty);
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allPass;


	}


	/**
	 * 设置饲喂信息分录
	 * @param b 是否是公司自养
	 * @param allDay 纯日龄
	 * @param weekDay 
	 * @param batchInfo 批次信息
	 * @param breedModelInfo2 饲喂规范
	 */
	private void fillentry(boolean b, BatchInfo batchInfo,BreedModelInfo breedModelInfo) {
		// TODO Auto-generated method stub

		try {
			//如果是公司自养，需要新增分录行(按照批次信息的棚舍信息行数增加)，
			if(b){
				if(batchInfo.getHouseEntry().size() > 0){
					BatchHouseEntryCollection batchHouseEntryColl = batchInfo.getHouseEntry();
					BatchHouseEntryInfo entryInfo = null;
					FarmHouseEntryInfo houseInfo = null;
					int allDay = 0;
					BreedModelEntryInfo breedModelEntryInfo = null;
					MaterialInfo materialInfo = null;
					for(int i=0,size = batchInfo.getHouseEntry().size();i<size;i++){
						entryInfo = batchHouseEntryColl.get(i);

						//鸡舍
						houseInfo = FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryInfo(new ObjectUuidPK(entryInfo.getHouse().getId()));

						//根据分录里面的入雏日期获取纯日龄
						int[] result = StockingComm.getspBreedWeekAndDay(pkBizDate.getSqlDate(), entryInfo.getInDate());
						allDay = (result[0]-1)*7+result[1];

						//根据周龄，日龄获取饲喂规范
						breedModelEntryInfo = getFeedStand(result[0],result[1],breedModelInfo);

						if(breedModelEntryInfo != null){
							//饲喂规范的母禽料(部分公母)
							materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedModelEntryInfo.getMaterial().getId()));

							//新增饲喂信息分录
							this.kdtEntrys.addRow();
							this.kdtEntrys.getCell(i, "henhouse").setValue(houseInfo);
							this.kdtEntrys.getCell(i, "henhouseName").setValue(houseInfo.getName());
							this.kdtEntrys.getCell(i, "material").setValue(materialInfo);
							this.kdtEntrys.getCell(i, "materialName").setValue(materialInfo.getName());
							this.kdtEntrys.getCell(i, "materialModel").setValue(materialInfo.getModel());
							this.kdtEntrys.getCell(i, "days").setValue(allDay);
							this.kdtEntrys.getCell(i, "standardFeedQty").setValue(breedModelEntryInfo.getQtyPerday());

						}
					}
				}
			}else{//只新增一行
				//根据分录里面的入雏日期获取纯日龄

				int[] result = StockingComm.getBreedWeekAndDay(pkBizDate.getSqlDate(), batchInfo.getInDate());
				int allDay = (result[0]-1)*7+result[1];
				BreedModelEntryInfo breedModelEntryInfo = getFeedStand(result[0],result[1],breedModelInfo);
				MaterialInfo materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedModelEntryInfo.getMaterial().getId()));
				//新增饲喂信息分录
				this.kdtEntrys.addRow();
				this.kdtEntrys.getCell(0, "material").setValue(materialInfo);
				this.kdtEntrys.getCell(0, "materialName").setValue(materialInfo.getName());
				this.kdtEntrys.getCell(0, "days").setValue(allDay);
				this.kdtEntrys.getCell(0, "standardFeedQty").setValue(breedModelEntryInfo.getQtyPerday());

			}

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据周龄，日龄获取饲喂规范
	 * @param i
	 * @param j
	 * @param breedModelInfo2
	 * @return 
	 */
	private BreedModelEntryInfo getFeedStand(int week, int day, BreedModelInfo breedModelInfo) {
		// TODO Auto-generated method stub

		String s1 = "/*dialect*/ select t2.fid breedModelEntryid from CT_FM_BreedModel t1" +
		" inner join CT_FM_BreedModelEntrys t2 on t2.FParentID = t1.fid" +
		" where t1.fid = '"+breedModelInfo.getId()+"' and t2.CFWeek <="+week+" and t2.CFWeekDay <="+day+" and t2.CFWeekTo >= "+week+" and t2.CFDayTo >="+day;
		IRowSet r1;
		BreedModelEntryInfo breedModelEntryInfo = null;
		try {
			r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
			String breedModelEntryid = null;
			if(r1.next()){
				breedModelEntryid = r1.getString("breedModelEntryid");
				breedModelEntryInfo = BreedModelEntryFactory.getRemoteInstance().getBreedModelEntryInfo(new ObjectUuidPK(breedModelEntryid));
				return breedModelEntryInfo;
			}

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return breedModelEntryInfo;
	}

	/**
	 * output kdtEntrys_Changed(int rowIndex,int colIndex) method
	 */
	public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
	{

		if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

		}

		if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex,"materialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));
		}
	}


	/**
	 * output getSelectors method
	 */
	public SelectorItemCollection getSelectors()
	{
		SelectorItemCollection sic = super.getSelectors();
		return sic;
	}


	/**
	 * 
	 * 填入死淘后自动计算
	 * output kdtAssEntrys_Changed(int rowIndex,int colIndex) method
	 */
	public void kdtAssEntrys_Changed(int rowIndex,int colIndex) throws Exception
	{

		BatchInfo batchInfo = BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(((BatchInfo)prmtbreedBatch.getValue()).getId()));
		FarmHouseEntryInfo  houseInfo = (FarmHouseEntryInfo) kdtAssEntrys.getCell(rowIndex, "henhouse").getValue();
		//当日死淘
		BigDecimal cullAndDeath = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "cullAndDeath").getValue());
		//当日出栏
		BigDecimal marketQty = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "marketQty").getValue());
		//当日转栏
		BigDecimal tranQty = UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "transQty").getValue());


		//计算业务日期之前的累计死亡淘汰
		BigDecimal passQty = calcStockQty(houseInfo,batchInfo);

		//获取入雏数量
		FarmInfo farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(batchInfo.getFarm().getId()));
		//如果养殖场类型是 公司自养，分棚舍，取分录的入雏数量
		BigDecimal inQty = BigDecimal.ZERO;
		if(farmInfo.getFarmType().equals(StockingFarmTypeEnum .company)){
			String s1 = "/*dialect*/ select t2.CFMaleQty inQty from T_FM_Batch t1 inner join CT_FM_BatchHouseEntry t2 on t2.fparentid = t1.fid" +
			" where t1.fid = '"+batchInfo.getId()+"' and t2.CFHouseID = '"+houseInfo.getId()+"'";
			IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
			if(r1.next()){
				inQty = r1.getBigDecimal("inQty");
			}
		}else{
			inQty = batchInfo.getFemaleQty();
		}

		//设置存栏量
		kdtAssEntrys.getCell(rowIndex, "breedingStock").setValue(inQty.subtract(cullAndDeath).subtract(marketQty).subtract(passQty).add(tranQty));

	}



	/**
	 * 免疫分录更新
	 */
	@Override
	public void kdtImmuneEntrys_Changed(int rowIndex, int colIndex)
	throws Exception {
		//		if ("henhouse".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
		//
		//			// 带出名称
		//			kdtImmuneEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));
		//
		//			if(kdtImmuneEntrys.getCell(rowIndex, colIndex).getValue() != null){
		//				HenhouseInfo henhouseInfo = (HenhouseInfo) kdtImmuneEntrys.getCell(rowIndex, colIndex).getValue();
		//
		//				// 计算日龄
		//				BatchInfo batchInfo = null;//(BreedBatchInfo) this.prmtbreedBatch.getValue();
		//				if(batchInfo != null){
		//					batchInfo = BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchInfo.getId().toString()));
		//					for(int i = 0; batchInfo != null && batchInfo.getHouseEntry() != null && i < batchInfo.getHouseEntry().size(); i++){
		//						BatchHouseEntryInfo entryInfo = batchInfo.getHouseEntry().get(i);
		//						if(entryInfo != null){
		//							Date incoopDate = entryInfo.getInDate();
		//							if(incoopDate == null){
		//								entryInfo = BatchHouseEntryFactory.getRemoteInstance().getBatchHouseEntryInfo(new ObjectUuidPK(entryInfo.getId().toString()));
		//
		//								incoopDate = entryInfo.getInDate();
		//							}
		//							Date bizDate = this.pkBizDate.getSqlDate();
		//							if(incoopDate != null && bizDate != null && henhouseInfo.getId().toString().equals(entryInfo.getHouse().getId().toString())){
		//								// 获得日龄
		//								int entryDays = DateCommon.dateDiff(incoopDate, bizDate);
		//
		//								kdtImmuneEntrys.getCell(rowIndex,"days").setValue(entryDays);
		//							}
		//						}
		//					}
		//
		//				}
		//			}
		//		}


	}


	/**
	 * 显示执行结果
	 * @param result
	 * @throws UIException 
	 */
	public void showGennextBillResult(CoreBillEditUI ui,List<ExecBotpResultInfo> result) throws UIException{
		UIContext uiContext = new UIContext(ui);
		uiContext.put("resultInfos", result);

		IUIWindow window = null;
		window = UIFactory.createUIFactory(UIFactoryName.NEWWIN).create("com.kingdee.eas.farm.breed.client.ExecBotpResultUI", uiContext, null, OprtState.ADDNEW);
		window.show();
	}


}