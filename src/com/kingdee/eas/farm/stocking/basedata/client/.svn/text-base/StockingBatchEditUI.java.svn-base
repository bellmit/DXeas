/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.assistant.CORelatedType;
import com.kingdee.eas.basedata.assistant.CalculateModeEnum;
import com.kingdee.eas.basedata.assistant.CostObject;
import com.kingdee.eas.basedata.assistant.CostObjectEntryInfo;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroup;
import com.kingdee.eas.basedata.assistant.CostObjectGroupFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.ICostObject;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class StockingBatchEditUI extends AbstractStockingBatchEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(StockingBatchEditUI.class);
	private String curCompanyID;
	private BaseSysSettingInfo sysSetting;
	/**
	 * output class constructor
	 */
	public StockingBatchEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
		setHouseEntryHide();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.StockingBatchTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setInDate(new Date());
		return objectValue;
	}



	/**
	 * 删除的时候添加校验，已经在养殖日报中存在的，不允许删除
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception,BOSException {
		// TODO Auto-generated method stub
		try{
			super.actionRemove_actionPerformed(arg0);
		}catch(BOSException e){
			MsgBox.showError(e.getMessage());
			SysUtil.abort();
		}
	}



	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		initControl();
	}


	private void initControl() throws Exception {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.btnAddNew.setVisible(false);
		sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				company_changed(e);
			}});

		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				//setFarmFiler();
				//StockingClientComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
			}});
		prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setHouseFilter();
				setHouseEntryHide();
			}});
		//检查是否具有初始化权限
		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
			this.txtinitBalanceAmount.setEnabled(true);
			this.txtinitMargin.setEnabled(true);
			this.txtinitLoanMargin.setEnabled(true);
			this.txtinitAllEggQty.setEnabled(true);
			this.txtinitFertilizeEggQty.setEnabled(true);
			this.txtinitQcEggQty.setEnabled(true);
		}catch(Exception err) {
			this.txtinitBalanceAmount.setEnabled(false);
			this.txtinitMargin.setEnabled(false);
			this.txtinitLoanMargin.setEnabled(false);
			this.txtinitAllEggQty.setEnabled(false);
			this.txtinitFertilizeEggQty.setEnabled(false);
			this.txtinitQcEggQty.setEnabled(false);
		}

		//棚舍信息
		KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox.setEditFormat("$name$");
		kdtEntrys_material_PromptBox.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kdtHouseEntry.getColumn("house").setEditor(kdtEntrys_material_CellEditor);
		ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
		kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtHouseEntry.getColumn("house").setRenderer(kdtEntrys_material_OVR);

		//setFilter();

		// prmteggCostItem		
		this.prmteggCostItem.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
		this.prmteggCostItem.setEditable(true);		
		this.prmteggCostItem.setDisplayFormat("$name$");		
		this.prmteggCostItem.setEditFormat("$number$");		
		this.prmteggCostItem.setCommitFormat("$number$");		
		this.prmteggCostItem.setRequired(false);


	}
	/**
	 * 设置批次信息隐藏与否
	 */
	private void setHouseEntryHide() {
		boolean isExists=false;
		if(kDTabbedPane1.getComponentAt(kDTabbedPane1.getTabCount()-1).getName().equalsIgnoreCase("kDPanelHouseEntry")){
			isExists=true;
		}
		if(prmtfarm.getValue()==null) {
			if(isExists) {
				kDTabbedPane1.removeTabAt(kDTabbedPane1.getTabCount()-1);
			}
		}else{
			try {
				if((Boolean) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "isHouseManager")) {
					if(!isExists) {
						kDTabbedPane1.add("棚舍明细",kDPanelHouseEntry);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
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
		((KDBizPromptBox) kdtHouseEntry.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
	}
	/**
	 * 公司改变
	 */
	private void company_changed(DataChangeEvent e) {
		try {
			if(e.getNewValue()!=null) {
				curCompanyID=((CompanyOrgUnitInfo) e.getNewValue()).getString("id");
			}else{
				curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	private void setFilter() throws Exception {
		StockingClientComm.setCostObjectFilter(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(curCompanyID)), this.prmtcostItem);
		StockingClientComm.setFarmerFilter(this.prmtfarmer, curCompanyID,false);
		//合同过滤
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		ev.setFilter(filter);
		prmtbatchContract.setEntityViewInfo(ev);

		setFarmFiler();
	}


	private void setFarmFiler() {
		String farmerID=null;
		if(this.prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) this.prmtfarmer.getValue()).getString("id");
		}
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<editData.getHouseEntry().size();i++){
			if(UIRuleUtil.getDateValue(kdtHouseEntry.getCell(i, "inData").getValue())==null){
				MsgBox.showWarning("入雏日期不能为空！");
				SysUtil.abort();
			}
		}

		//		//---------------育雏期-------
		//		//校验该批次育雏期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//		String sq1 = "select t1.fid broodCostObject from T_BD_CostObject     t1  " +
		//		" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid" +
		//		" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID" +
		//		" inner join T_FM_StockingBatch t4 on t4.fnumber =t1.FBatchNumber" +
		//		" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.CFBroodMaterialID=t3.fid" +
		//		" where t4.fnumber='"+editData.getNumber()+"'";
		//		ISQLExecutor executor1 = SQLExecutorFactory.getRemoteInstance(sq1);
		//		IRowSet rs1 = executor1.executeSQL();	
		//		String broodid = null;
		//		CostObjectInfo broodObject = null;
		//		if(rs1.next()){
		//			broodid = rs1.getString("broodCostObject");
		//			broodObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(broodid));
		//			editData.setBroodCostObject(broodObject);
		//		}else{
		//			produceBroodCostObject();
		//		}
		//
		//
		//		//---------------育成期-----
		//		//校验该批次育成期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//		String sq2 = "select t1.fid broodCostObject from T_BD_CostObject     t1  " +
		//		" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid" +
		//		" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID" +
		//		" inner join T_FM_StockingBatch t4 on t4.fnumber =t1.FBatchNumber" +
		//		" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.FBridMaterialID=t3.fid" +
		//		" where t4.fnumber='"+editData.getNumber()+"'";
		//		ISQLExecutor executor2 = SQLExecutorFactory.getRemoteInstance(sq2);
		//		IRowSet rs2 = executor2.executeSQL();	
		//		String breedid = null;
		//		CostObjectInfo breedObject = null;
		//		if(rs2.next()){
		//			breedid = rs2.getString("broodCostObject");
		//			breedObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(breedid));
		//			editData.setCostItem(breedObject);
		//		}else{
		//			produceBreedCostObject();
		//		}
		//
		//		//------------预产期--------------
		//		//校验该批次预产期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//		String sq3 = "select t1.fid broodCostObject from T_BD_CostObject     t1  " +
		//		" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid" +
		//		" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID" +
		//		" inner join T_FM_StockingBatch t4 on t4.fnumber =t1.FBatchNumber" +
		//		" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.CFPreEggMaterialID=t3.fid" +
		//		" where t4.fnumber='"+editData.getNumber()+"'";
		//		ISQLExecutor executor3 = SQLExecutorFactory.getRemoteInstance(sq3);
		//		IRowSet rs3 = executor3.executeSQL();	
		//		String preEggid = null;
		//		CostObjectInfo preEggObject = null;
		//		if(rs3.next()){
		//			preEggid = rs3.getString("broodCostObject");
		//			preEggObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(preEggid));
		//			editData.setPreCostObject(preEggObject);
		//		}else{
		//			producePreEggCostObject();
		//		}
		//		
		//		//批次的前8位
		//		String costNum = editData.getNumber().substring(0,8);
		//		
		//		
		//		//---------产蛋期--------
		//		//校验该批次产蛋期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//		String sq4 = "/*dialect*/  select distinct  t1.fid broodCostObject from T_BD_CostObject     t1  " +
		//		" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid" +
		//		" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID" +
		//		" inner join T_FM_StockingBatch t4 on  substr(t4.fnumber,0,8) = substr(t1.FBatchNumber,0,8)" +
		//		" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.CFEggMaterialID=t3.fid" +
		//		" where  substr(t4.fnumber,0,8)='"+costNum+"'";
		//		ISQLExecutor executor4 = SQLExecutorFactory.getRemoteInstance(sq4);
		//		IRowSet rs4 = executor4.executeSQL();	
		//		String Eggid = null;
		//		CostObjectInfo EggObject = null;
		//		if(rs4.next()){
		//			Eggid = rs4.getString("broodCostObject");
		//			EggObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(Eggid));
		//			editData.setEggCostItem(EggObject);
		//		}else{
		//			produceEggCostObject();
		//		}
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.actionCancelCancel.setEnabled(true);
		this.actionEdit.setEnabled(false);
	}

	//创建产蛋期成本对象
	private void produceEggCostObject() throws BOSException {
		// TODO Auto-generated method stub
		//获取批次名称
		String batchNum = editData.getNumber();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息产蛋期物料
		MaterialInfo eggMatInfo = null;
		//成本对象
		ICostObject iCostObject = null;
		//产蛋期,种蛋期成本对象分组
		String eggObjectGroupid = "ISxtCxmlRI6UedcfrsoGhsw5rkg=";
		CostObjectGroupInfo eggObjectGroup = null;

		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getRemoteInstance();
			//产蛋期
			eggObjectGroup = CostObjectGroupFactory.getRemoteInstance().getCostObjectGroupInfo(new ObjectUuidPK(eggObjectGroupid));
			//财务组织
			companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(editData.getCompany().getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(editData.getBreedData().getId().toString()));
			//产蛋期物料
			if(breedDataInfo.getEggMaterial() != null){
				eggMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getEggMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的产蛋期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置产蛋成本对象编码名称
		String eggCostObjectN = batchNum.substring(0,8)+eggMatInfo.getName().toString();

		//----------------------------------产蛋期--------------------------------------
		//产蛋期成本对象表头
		CostObjectInfo eggCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo eggEntryCostObjectInfo = new CostObjectEntryInfo();

		eggCostObjectInfo.setId(BOSUuid.create(eggCostObjectInfo.getBOSType()));

		//名称
		eggCostObjectInfo.setName(eggCostObjectN);
		//编码
		eggCostObjectInfo.setNumber(eggCostObjectN);
		//批次
		eggCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		eggCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		eggCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		eggCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		eggCostObjectInfo.setRelatedId(eggMatInfo.getId());//物料id
		eggCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
		eggCostObjectInfo.setRelatedName(eggMatInfo.getName());
		eggCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
		eggCostObjectInfo.setStdProductID(eggMatInfo);//关联物料

		//分录
		eggEntryCostObjectInfo.setIsMainProduct(true);
		eggEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		eggEntryCostObjectInfo.setRelatedID(eggMatInfo.getId());
		eggEntryCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
		eggEntryCostObjectInfo.setRelatedName(eggMatInfo.getName());
		eggCostObjectInfo.getEntries().add(eggEntryCostObjectInfo);

		try {
			//产蛋期成本对象保存
			iCostObject.save(eggCostObjectInfo);

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CostObjectInfo eggObject = null;


		if(eggCostObjectInfo.getId() != null){
			try {
				eggObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(eggCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setEggCostItem(eggObject);
		}else{
			throw new BOSException("产蛋期成本对象没有生成！");
		}







	}
	/**
	 * 创建预产期成本对象
	 * @throws BOSException 
	 */
	private void producePreEggCostObject() throws BOSException {
		// TODO Auto-generated method stub
		//获取批次名称
		String batchNum = editData.getNumber();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息预产期物料
		MaterialInfo preEggMatInfo = null;
		//成本对象
		ICostObject iCostObject = null;
		//产蛋期,种蛋期成本对象分组
		String eggObjectGroupid = "ISxtCxmlRI6UedcfrsoGhsw5rkg=";
		CostObjectGroupInfo eggObjectGroup = null;
		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getRemoteInstance();
			//产蛋期
			eggObjectGroup = CostObjectGroupFactory.getRemoteInstance().getCostObjectGroupInfo(new ObjectUuidPK(eggObjectGroupid));
			//财务组织
			companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(editData.getCompany().getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(editData.getBreedData().getId().toString()));
			//预产期物料
			if(breedDataInfo.getPreEggMaterial() != null){
				preEggMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getPreEggMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的预产期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置预产成本对象编码名称
		String preEggCostObjectN = batchNum+"-"+preEggMatInfo.getName().toString();
		//----------------------------------预产期--------------------------------------
		//预产期成本对象表头
		CostObjectInfo preCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo preEntryCostObjectInfo = new CostObjectEntryInfo();

		preCostObjectInfo.setId(BOSUuid.create(preCostObjectInfo.getBOSType()));

		//名称
		preCostObjectInfo.setName(preEggCostObjectN);
		//编码
		preCostObjectInfo.setNumber(preEggCostObjectN);
		//批次
		preCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		preCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		preCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		preCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		preCostObjectInfo.setRelatedId(preEggMatInfo.getId());//物料id
		preCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
		preCostObjectInfo.setRelatedName(preEggMatInfo.getName());
		preCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
		preCostObjectInfo.setStdProductID(preEggMatInfo);//关联物料

		//分录
		preEntryCostObjectInfo.setIsMainProduct(true);
		preEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		preEntryCostObjectInfo.setRelatedID(preEggMatInfo.getId());
		preEntryCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
		preEntryCostObjectInfo.setRelatedName(preEggMatInfo.getName());
		preCostObjectInfo.getEntries().add(preEntryCostObjectInfo);


		try {
			//预产期成本对象保存
			iCostObject.save(preCostObjectInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CostObjectInfo preObject = null;
		if(preCostObjectInfo.getId() != null){
			try {
				preObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(preCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setPreCostObject(preObject);
		}else{
			throw new BOSException("预产期成本对象没有生成！");
		}
	}
	/**
	 * 创建育成期成本对象
	 * @throws BOSException 
	 */
	private void produceBreedCostObject() throws BOSException {
		// TODO Auto-generated method stub
		//获取批次名称
		String batchNum = editData.getNumber();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;

		//获取品种信息育成期物料
		MaterialInfo breedMatInfo = null;

		//成本对象
		ICostObject iCostObject = null;

		//育成期、预产期成本对象分组
		String broodObjectGroupid = "xZ4+MUw2QA6VSzS9nkSsYsw5rkg=";
		CostObjectGroupInfo broodObjectGroup = null;


		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getRemoteInstance();
			//育成期、预产期成本对象分组
			broodObjectGroup = CostObjectGroupFactory.getRemoteInstance().getCostObjectGroupInfo(new ObjectUuidPK(broodObjectGroupid));

			//财务组织
			companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(editData.getCompany().getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(editData.getBreedData().getId().toString()));
			//育成期物料
			if(breedDataInfo.getBridMaterial() != null){
				breedMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBridMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的育成期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置育成成本对象编码名称
		String breedCostObjectN = batchNum+"-"+breedMatInfo.getName().toString();




		//----------------------------------育成期--------------------------------------
		//育成期成本对象表头
		CostObjectInfo breedCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo breedEntryCostObjectInfo = new CostObjectEntryInfo();

		breedCostObjectInfo.setId(BOSUuid.create(breedCostObjectInfo.getBOSType()));

		//名称
		breedCostObjectInfo.setName(breedCostObjectN);
		//编码
		breedCostObjectInfo.setNumber(breedCostObjectN);
		//批次
		breedCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		breedCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		breedCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		breedCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		breedCostObjectInfo.setRelatedId(breedMatInfo.getId());//物料id
		breedCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
		breedCostObjectInfo.setRelatedName(breedMatInfo.getName());
		breedCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
		breedCostObjectInfo.setStdProductID(breedMatInfo);//关联物料

		//分录
		breedEntryCostObjectInfo.setIsMainProduct(true);
		breedEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		breedEntryCostObjectInfo.setRelatedID(breedMatInfo.getId());
		breedEntryCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
		breedEntryCostObjectInfo.setRelatedName(breedMatInfo.getName());
		breedCostObjectInfo.getEntries().add(breedEntryCostObjectInfo);


		try {
			//育成期成本对象保存
			iCostObject.save(breedCostObjectInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		CostObjectInfo breedObject = null;


		if(breedCostObjectInfo.getId() != null){
			try {
				breedObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(breedCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setCostItem(breedObject);
		}else{
			throw new BOSException("育成期成本对象没有生成！");
		}



	}
	/**
	 * 创建育雏期成本对象
	 * @throws BOSException 
	 */
	private void produceBroodCostObject() throws BOSException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		//获取批次名称
		String batchNum = editData.getNumber();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息育雏期物料
		MaterialInfo broodMatInfo = null;

		//成本对象
		ICostObject iCostObject = null;

		//育成期、预产期成本对象分组
		String broodObjectGroupid = "xZ4+MUw2QA6VSzS9nkSsYsw5rkg=";
		CostObjectGroupInfo broodObjectGroup = null;


		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getRemoteInstance();
			//育成期、预产期成本对象分组
			broodObjectGroup = CostObjectGroupFactory.getRemoteInstance().getCostObjectGroupInfo(new ObjectUuidPK(broodObjectGroupid));

			//财务组织
			companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(editData.getCompany().getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(editData.getBreedData().getId().toString()));
			//育雏期物料
			if(breedDataInfo.getBroodMaterial() != null){
				broodMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBroodMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的育雏期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置育雏成本对象编码名称
		String broodCostObjectN = batchNum+"-"+broodMatInfo.getName().toString();



		//----------------------------------育雏期--------------------------------------
		//育雏期成本对象表头
		CostObjectInfo broodCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo broodEntryCostObjectInfo = new CostObjectEntryInfo();

		broodCostObjectInfo.setId(BOSUuid.create(broodCostObjectInfo.getBOSType()));

		//名称
		broodCostObjectInfo.setName(broodCostObjectN);
		//编码
		broodCostObjectInfo.setNumber(broodCostObjectN);
		//批次
		broodCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		broodCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		broodCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		broodCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		broodCostObjectInfo.setRelatedId(broodMatInfo.getId());//物料id
		broodCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
		broodCostObjectInfo.setStdProductID(broodMatInfo);//关联物料

		//分录
		broodEntryCostObjectInfo.setIsMainProduct(true);
		broodEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		broodEntryCostObjectInfo.setRelatedID(broodMatInfo.getId());
		broodEntryCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodEntryCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.getEntries().add(broodEntryCostObjectInfo);

		try {
			//育雏期成本对象保存
			iCostObject.save(broodCostObjectInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CostObjectInfo broodObject = null;
		if(broodCostObjectInfo.getId() != null){
			try {
				broodObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(broodCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setBroodCostObject(broodObject);
		}else{
			throw new BOSException("育雏期成本对象没有生成！");
		}
	}
	/**
	 * 生成成本对象，并将成本对象反写进批次信息里面
	 */
	//	private void produceCostObject() throws BOSException {
	//		// TODO Auto-generated method stub
	//		//获取批次名称
	//		String batchNum = editData.getNumber();
	//		//获取品种信息
	//		BreedDataInfo breedDataInfo = null;
	//		//获取财务组织
	//		CompanyOrgUnitInfo companyInfo = null;
	//		//获取品种信息育雏期物料
	//		MaterialInfo broodMatInfo = null;
	//		//获取品种信息育成期物料
	//		MaterialInfo breedMatInfo = null;
	//		//获取品种信息预产期物料
	//		MaterialInfo preEggMatInfo = null;
	//		//获取品种信息产蛋期物料
	//		MaterialInfo eggMatInfo = null;
	//		//成本对象
	//		ICostObject iCostObject = null;
	//
	//		//育成期、预产期成本对象分组
	//		String broodObjectGroupid = "xZ4+MUw2QA6VSzS9nkSsYsw5rkg=";
	//		CostObjectGroupInfo broodObjectGroup = null;
	//		//产蛋期,种蛋期成本对象分组
	//		String eggObjectGroupid = "ISxtCxmlRI6UedcfrsoGhsw5rkg=";
	//		CostObjectGroupInfo eggObjectGroup = null;
	//
	//		try {
	//			//成本对象保存
	//			iCostObject = CostObjectFactory.getRemoteInstance();
	//			//育成期、预产期成本对象分组
	//			broodObjectGroup = CostObjectGroupFactory.getRemoteInstance().getCostObjectGroupInfo(new ObjectUuidPK(broodObjectGroupid));
	//			//产蛋期
	//			eggObjectGroup = CostObjectGroupFactory.getRemoteInstance().getCostObjectGroupInfo(new ObjectUuidPK(eggObjectGroupid));
	//
	//			//财务组织
	//			companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(editData.getCompany().getId().toString()));
	//			//品种资料
	//			breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(editData.getBreedData().getId().toString()));
	//			//育雏期物料
	//			if(breedDataInfo.getBroodMaterial() != null){
	//				broodMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBroodMaterial().getId().toString()));
	//			}else{
	//				throw new BOSException("品种资料的育雏期物料没有设置！");
	//			}
	//			//育成期物料
	//			if(breedDataInfo.getBridMaterial() != null){
	//				breedMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBridMaterial().getId().toString()));
	//			}else{
	//				throw new BOSException("品种资料的育成期物料没有设置！");
	//			}
	//			//预产期物料
	//			if(breedDataInfo.getPreEggMaterial() != null){
	//				preEggMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getPreEggMaterial().getId().toString()));
	//			}else{
	//				throw new BOSException("品种资料的预产期物料没有设置！");
	//			}
	//			//产蛋期物料
	//			if(breedDataInfo.getEggMaterial() != null){
	//				eggMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getEggMaterial().getId().toString()));
	//			}else{
	//				throw new BOSException("品种资料的产蛋期物料没有设置！");
	//			}
	//		} catch (EASBizException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (BOSException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		//设置育雏成本对象编码名称
	//		String broodCostObjectN = batchNum+"-"+broodMatInfo.getName().toString();
	//		//设置育成成本对象编码名称
	//		String breedCostObjectN = batchNum+"-"+breedMatInfo.getName().toString();
	//		//设置预产成本对象编码名称
	//		String preEggCostObjectN = batchNum+"-"+preEggMatInfo.getName().toString();
	//		//设置产蛋成本对象编码名称
	//		String eggCostObjectN = batchNum+"-"+eggMatInfo.getName().toString();
	//
	//
	//
	//		//----------------------------------育雏期--------------------------------------
	//		//育雏期成本对象表头
	//		CostObjectInfo broodCostObjectInfo = new CostObjectInfo();
	//		//分录
	//		CostObjectEntryInfo broodEntryCostObjectInfo = new CostObjectEntryInfo();
	//
	//		broodCostObjectInfo.setId(BOSUuid.create(broodCostObjectInfo.getBOSType()));
	//
	//		//名称
	//		broodCostObjectInfo.setName(broodCostObjectN);
	//		//编码
	//		broodCostObjectInfo.setNumber(broodCostObjectN);
	//		//批次
	//		broodCostObjectInfo.setBatchNumber(batchNum);
	//		//财务组织
	//		broodCostObjectInfo.setCompany(companyInfo);
	//		//关联类型--产品
	//		broodCostObjectInfo.setRelatedType(CORelatedType.Product);
	//		//成本计算方法--分批法
	//		broodCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
	//		broodCostObjectInfo.setRelatedId(broodMatInfo.getId());//物料id
	//		broodCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
	//		broodCostObjectInfo.setRelatedName(broodMatInfo.getName());
	//		broodCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
	//		broodCostObjectInfo.setStdProductID(broodMatInfo);//关联物料
	//
	//		//分录
	//		broodEntryCostObjectInfo.setIsMainProduct(true);
	//		broodEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
	//		broodEntryCostObjectInfo.setRelatedID(broodMatInfo.getId());
	//		broodEntryCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
	//		broodEntryCostObjectInfo.setRelatedName(broodMatInfo.getName());
	//		broodCostObjectInfo.getEntries().add(broodEntryCostObjectInfo);
	//
	//		//----------------------------------育成期--------------------------------------
	//		//育成期成本对象表头
	//		CostObjectInfo breedCostObjectInfo = new CostObjectInfo();
	//		//分录
	//		CostObjectEntryInfo breedEntryCostObjectInfo = new CostObjectEntryInfo();
	//
	//		breedCostObjectInfo.setId(BOSUuid.create(breedCostObjectInfo.getBOSType()));
	//
	//		//名称
	//		breedCostObjectInfo.setName(breedCostObjectN);
	//		//编码
	//		breedCostObjectInfo.setNumber(breedCostObjectN);
	//		//批次
	//		breedCostObjectInfo.setBatchNumber(batchNum);
	//		//财务组织
	//		breedCostObjectInfo.setCompany(companyInfo);
	//		//关联类型--产品
	//		breedCostObjectInfo.setRelatedType(CORelatedType.Product);
	//		//成本计算方法--分批法
	//		breedCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
	//		breedCostObjectInfo.setRelatedId(breedMatInfo.getId());//物料id
	//		breedCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
	//		breedCostObjectInfo.setRelatedName(breedMatInfo.getName());
	//		breedCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
	//		breedCostObjectInfo.setStdProductID(breedMatInfo);//关联物料
	//
	//		//分录
	//		breedEntryCostObjectInfo.setIsMainProduct(true);
	//		breedEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
	//		breedEntryCostObjectInfo.setRelatedID(breedMatInfo.getId());
	//		breedEntryCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
	//		breedEntryCostObjectInfo.setRelatedName(breedMatInfo.getName());
	//		breedCostObjectInfo.getEntries().add(breedEntryCostObjectInfo);
	//
	//		//----------------------------------预产期--------------------------------------
	//		//预产期成本对象表头
	//		CostObjectInfo preCostObjectInfo = new CostObjectInfo();
	//		//分录
	//		CostObjectEntryInfo preEntryCostObjectInfo = new CostObjectEntryInfo();
	//
	//		preCostObjectInfo.setId(BOSUuid.create(preCostObjectInfo.getBOSType()));
	//
	//		//名称
	//		preCostObjectInfo.setName(preEggCostObjectN);
	//		//编码
	//		preCostObjectInfo.setNumber(preEggCostObjectN);
	//		//批次
	//		preCostObjectInfo.setBatchNumber(batchNum);
	//		//财务组织
	//		preCostObjectInfo.setCompany(companyInfo);
	//		//关联类型--产品
	//		preCostObjectInfo.setRelatedType(CORelatedType.Product);
	//		//成本计算方法--分批法
	//		preCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
	//		preCostObjectInfo.setRelatedId(preEggMatInfo.getId());//物料id
	//		preCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
	//		preCostObjectInfo.setRelatedName(preEggMatInfo.getName());
	//		preCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
	//		preCostObjectInfo.setStdProductID(preEggMatInfo);//关联物料
	//
	//		//分录
	//		preEntryCostObjectInfo.setIsMainProduct(true);
	//		preEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
	//		preEntryCostObjectInfo.setRelatedID(preEggMatInfo.getId());
	//		preEntryCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
	//		preEntryCostObjectInfo.setRelatedName(preEggMatInfo.getName());
	//		preCostObjectInfo.getEntries().add(preEntryCostObjectInfo);
	//
	//		//----------------------------------产蛋期--------------------------------------
	//		//产蛋期成本对象表头
	//		CostObjectInfo eggCostObjectInfo = new CostObjectInfo();
	//		//分录
	//		CostObjectEntryInfo eggEntryCostObjectInfo = new CostObjectEntryInfo();
	//
	//		eggCostObjectInfo.setId(BOSUuid.create(eggCostObjectInfo.getBOSType()));
	//
	//		//名称
	//		eggCostObjectInfo.setName(eggCostObjectN);
	//		//编码
	//		eggCostObjectInfo.setNumber(eggCostObjectN);
	//		//批次
	//		eggCostObjectInfo.setBatchNumber(batchNum);
	//		//财务组织
	//		eggCostObjectInfo.setCompany(companyInfo);
	//		//关联类型--产品
	//		eggCostObjectInfo.setRelatedType(CORelatedType.Product);
	//		//成本计算方法--分批法
	//		eggCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
	//		eggCostObjectInfo.setRelatedId(eggMatInfo.getId());//物料id
	//		eggCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
	//		eggCostObjectInfo.setRelatedName(eggMatInfo.getName());
	//		eggCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
	//		eggCostObjectInfo.setStdProductID(eggMatInfo);//关联物料
	//
	//		//分录
	//		eggEntryCostObjectInfo.setIsMainProduct(true);
	//		eggEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
	//		eggEntryCostObjectInfo.setRelatedID(eggMatInfo.getId());
	//		eggEntryCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
	//		eggEntryCostObjectInfo.setRelatedName(eggMatInfo.getName());
	//		eggCostObjectInfo.getEntries().add(eggEntryCostObjectInfo);
	//
	//		try {
	//			//育雏期成本对象保存
	//			iCostObject.save(broodCostObjectInfo);
	//			//育成期成本对象保存
	//			iCostObject.save(breedCostObjectInfo);
	//			//预产期成本对象保存
	//			iCostObject.save(preCostObjectInfo);
	//			//产蛋期成本对象保存
	//			iCostObject.save(eggCostObjectInfo);
	//
	//		} catch (EASBizException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (BOSException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//
	//		CostObjectInfo broodObject = null;
	//		CostObjectInfo breedObject = null;
	//		CostObjectInfo preObject = null;
	//		CostObjectInfo eggObject = null;
	//
	//		if(broodCostObjectInfo.getId() != null){
	//			try {
	//				broodObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(broodCostObjectInfo.getId()));
	//			} catch (EASBizException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//			editData.setBroodCostObject(broodObject);
	//		}else{
	//			throw new BOSException("育雏期成本对象没有生成！");
	//		}
	//
	//		if(breedCostObjectInfo.getId() != null){
	//			try {
	//				breedObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(breedCostObjectInfo.getId()));
	//			} catch (EASBizException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//			editData.setCostItem(breedObject);
	//		}else{
	//			throw new BOSException("预产期成本对象没有生成！");
	//		}
	//
	//
	//		if(preCostObjectInfo.getId() != null){
	//			try {
	//				preObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(preCostObjectInfo.getId()));
	//			} catch (EASBizException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//			editData.setPreCostObject(preObject);
	//		}else{
	//			throw new BOSException("预产期成本对象没有生成！");
	//		}
	//
	//		if(eggCostObjectInfo.getId() != null){
	//			try {
	//				eggObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(eggCostObjectInfo.getId()));
	//			} catch (EASBizException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//			editData.setEggCostItem(eggObject);
	//		}else{
	//			throw new BOSException("产蛋期成本对象没有生成！");
	//		}
	//
	//	}





	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
			checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if (objectValue != null)
			{
				try
				{
					String id = this.idList.getID(this.idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				}
				catch (Throwable E) {
				}
			}
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");


		this.editData.setBaseStatus(null);

		setDataObject(this.editData);
		//		loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		//		super.beforeStoreFields(arg0);
		/*BigDecimal qty=this.txtbatchQty.getBigDecimalValue();
		BigDecimal femaleQty=this.txtfemaleQty.getBigDecimalValue();
		if(qty==null) {
			qty=BigDecimal.ZERO;
		}
		if(femaleQty==null) {
			femaleQty=BigDecimal.ZERO;
		}
		if(qty.signum()<=0&&femaleQty.signum()<=0) {
			MsgBox.showWarning("公禽数量和不亲");
		}*/
		if(prmtfarm.getValue()!=null&&(Boolean)UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(),"isHouseManager")&&kdtHouseEntry.getRowCount()<=0) {//sysSetting.isIsHouseManager()
			MsgBox.showWarning("该养殖场已启用棚舍管理，棚舍明细不能为空！");
			SysUtil.abort();
		}
	}



}