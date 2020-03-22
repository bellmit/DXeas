/**
 * output package name
 */
package com.kingdee.eas.farm.breed.brood.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
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
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.ChikenType;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.IBreedFacade;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetEntryCollection;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetEntryInfo;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetInfo;
import com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryInfo;
import com.kingdee.eas.farm.breed.brood.BroodDailyEntryInfo;
import com.kingdee.eas.farm.breed.brood.BroodDailyFacadeFactory;
import com.kingdee.eas.farm.breed.brood.BroodDailyFactory;
import com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryInfo;
import com.kingdee.eas.farm.breed.brood.BroodDailyInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchEntryDetailInfo;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory;
import com.kingdee.eas.framework.client.CoreBillEditUI;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class BroodDailyEditUI extends AbstractBroodDailyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BroodDailyEditUI.class);
    
    private Map<String,BreedBatchEntryDetailInfo> batchEntryDetailInfos;
   
    // 日期监听
    DataChangeListener bizDateListener ;
    /**
     * output class constructor
     */
    public BroodDailyEditUI() throws Exception
    {
        super();
        
        // f7初始化
        f7Init();
//        // 批次显示名称
//		this.prmtbreedBatch.setDisplayFormat("$costObject.name$");		
//        this.prmtbreedBatch.setEditFormat("$costObject.name$");	
    }
    
    
    
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
		}else if(this.getOprtState().equals("EDIT")){
			checkCanEdit();
			
		}
		 // 设置默认当前库存组织所有鸡舍信息
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        if(currStorageOrgInfo == null){
        	MsgBox.showInfo("当前未在任何库存组织中，不能进行新增养殖日报操作");
        	SysUtil.abort();
        }
        // 更新库存组织
        setStorageOrgUnit(currStorageOrgInfo);
		
	}

    /**
     * 校验当前组织是否是单据创建组织，如果不是，提示消息中断操作
     */
    private void checkCanEdit(){
    	StorageOrgUnitInfo cu = SysContext.getSysContext().getCurrentStorageUnit();
		StorageOrgUnitInfo billCU = this.editData.getStoOrg();
		
		if(billCU != null){
			if(!cu.getId().toString().equals(billCU.getId().toString())){
				MsgBox.showWarning("当前组织不是单据创建组织，不能修改单据");
				SysUtil.abort();
			}
		}
    }
    /**
     * 编辑前校验单据是否在创建组织；
     */
    @Override
    public void actionEdit_actionPerformed(ActionEvent e)throws Exception{
    	checkCanEdit();
    	super.actionEdit_actionPerformed(e);
    }

	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
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



	/**
     * f7初始化
     */
    private void f7Init(){
    	// 饲喂 分录
    	final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedMaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        
        
        F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this, kdtEntrys_material_PromptBox);
        FilterInfo materialFI = new FilterInfo();
        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020101%",CompareType.LIKE));
        materialFI.getFilterItems().add(new FilterItemInfo("number","02-000001",CompareType.EQUALS));
        materialFI.setMaskString("#0 or #1");
        // 设置物料过滤条件
		m7.setBaseFilter(materialFI);
		kdtEntrys_material_PromptBox.setSelector(m7);
		kdtEntrys_material_PromptBox.setEditFormat("$number$");
		kdtEntrys_material_PromptBox.setCommitFormat("$number$");
		kdtEntrys_material_PromptBox.setRequired(true);
		
		
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        
        // 免疫 分录
    	final KDBizPromptBox kdtImmuneEntrys_material_PromptBox = new KDBizPromptBox();
    	kdtImmuneEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedMaterialBaseInfoQuery");
    	kdtEntrys_material_PromptBox.setVisible(true);
    	kdtImmuneEntrys_material_PromptBox.setEditable(true);
    	kdtImmuneEntrys_material_PromptBox.setDisplayFormat("$number$");
    	kdtImmuneEntrys_material_PromptBox.setEditFormat("$number$");
    	kdtImmuneEntrys_material_PromptBox.setCommitFormat("$number$");
        
        
        F7MaterialSimpleSelector immuneF7 = new F7MaterialSimpleSelector(this, kdtImmuneEntrys_material_PromptBox);
        FilterInfo immuneFI = new FilterInfo();
        immuneFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","01!0103%",CompareType.LIKE));
        // 设置物料过滤条件
        immuneF7.setBaseFilter(immuneFI);
        kdtImmuneEntrys_material_PromptBox.setSelector(immuneF7);
        kdtImmuneEntrys_material_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_material_PromptBox.setCommitFormat("$number$");
        kdtImmuneEntrys_material_PromptBox.setRequired(true);
		
		
        KDTDefaultCellEditor kdtImmuneEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_material_PromptBox);
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setEditor(kdtImmuneEntrys_material_CellEditor);
        ObjectValueRender kdtImmueEntrys_material_OVR = new ObjectValueRender();
        kdtImmueEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setRenderer(kdtImmueEntrys_material_OVR);
        
        
        EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.Brood.getValue(),CompareType.EQUALS));
        CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
        filter.getFilterItems().add(new FilterItemInfo("CU.id",cuInfo.getId().toString(),CompareType.EQUALS));
        
        // 设置默认当前库存组织所有鸡舍信息
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",currStorageOrgInfo.getId().toString(),CompareType.EQUALS));
        evi.setFilter(filter);
        
        SorterItemCollection sorter = new SorterItemCollection();
        SorterItemInfo sortItem = new SorterItemInfo("bizDate");
        sortItem.setSortType(SortType.DESCEND);
        sorter.add(sortItem);
        evi.setSorter(sorter);
        
        //this.prmtbreedBatch.setEntityViewInfo(evi);
        
        
        
        
        // 要料计划 
        
        this.kdtFodderEntrys.getColumn("fodderMaterial").setEditor(kdtEntrys_material_CellEditor);
        this.kdtFodderEntrys.getColumn("fodderMaterial").setRenderer(kdtEntrys_material_OVR);
        
        
    	final KDBizPromptBox tower_PromptBox = new KDBizPromptBox();
    	tower_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7WarehouseQuery");
    	tower_PromptBox.setVisible(true);
    	tower_PromptBox.setEditable(true);
    	tower_PromptBox.setDisplayFormat("$number$");
    	tower_PromptBox.setEditFormat("$number$");
    	tower_PromptBox.setCommitFormat("$number$");
        
        
    	
    	EntityViewInfo towerEvi = new EntityViewInfo();
        FilterInfo towerFI = new FilterInfo();
//        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020102%",CompareType.LIKE));
        towerFI.getFilterItems().add(new FilterItemInfo("name","%料塔%",CompareType.LIKE));
        towerFI.getFilterItems().add(new FilterItemInfo("storageOrg.id",currStorageOrgInfo.getId().toString(),CompareType.EQUALS));
        towerEvi.setFilter(towerFI);
        // 设置物料过滤条件
//		m7.setBaseFilter(towerFI);
        //tower_PromptBox.setEntityViewInfo(towerEvi);
		
		
        KDTDefaultCellEditor kdtFodderEntrys_tower_CellEditor = new KDTDefaultCellEditor(tower_PromptBox);
        this.kdtFodderEntrys.getColumn("fodderTower").setEditor(kdtFodderEntrys_tower_CellEditor);
        ObjectValueRender kdtFodderEntrys_tower_OVR = new ObjectValueRender();
        kdtFodderEntrys_tower_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderEntrys.getColumn("fodderTower").setRenderer(kdtFodderEntrys_tower_OVR);
        
        
    }
    
    
    
    /**
     * 设置 库存组织信息到 控件中并且 更新相关过滤条件
     * @param orgInfo
     */
    private void setStorageOrgUnit(StorageOrgUnitInfo orgInfo){
    	if(this.prmtstoOrg.getValue() == null){
    		this.prmtstoOrg.setValue(orgInfo);
    	}
    	
    	// 更新各个分录中仓库的 过滤条件
    	 // 仓库添加过滤条件
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(orgInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("chickenFarm.id",orgInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("chickenFarm.id","",CompareType.EQUALS));
		}
		filterInfo.getFilterItems().add(new FilterItemInfo("name","%鸡舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseQuery");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);
        // 饲喂信息
        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 水电信息
//        this.kdtWEEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 燃料信息
//        this.kdtFuelEntrys.getColumn("henhouse").setEditor(kdtEntrys_warehouse_CellEditor);
        // 疫苗信息
        this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        // 其他信息
        this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        
        
        
        
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	// 养殖批次
    	DataChangeListener[] dl = this.prmtbreedBatch.getListeners(DataChangeListener.class);
    	for(int i=0;i<dl.length;i++){
    		this.prmtbreedBatch.removeDataChangeListener(dl[i]);
    	}
    	removeListener();
        super.loadFields();
        addListener();
        // 养殖批次
        for(int i=0;i<dl.length;i++){
    		this.prmtbreedBatch.addDataChangeListener(dl[i]);
    	}
        
    }

    
    /**
     * 移除监听
     */
    private void removeListener(){
    	// 业务日期
    	if(bizDateListener != null){
    		this.pkBizDate.removeDataChangeListener(bizDateListener);
    		bizDateListener = null;
    	}
    }
    /**
     * 添加监听
     */
    private void addListener(){
    	// 业务日期
    	bizDateListener = new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkBizDate_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        };
    	this.pkBizDate.addDataChangeListener(bizDateListener);
    	
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
        return BroodDailyFactory.getRemoteInstance();
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
        BroodDailyInfo objectValue = new BroodDailyInfo();
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
        //   默认当前库存组织
        objectValue.setStoOrg(currStorageOrgInfo);
        // 更新库存组织
        setStorageOrgUnit(currStorageOrgInfo);
        
//        try {
//			setEntryInfos(objectValue,currStorageOrgInfo);
//		} catch (BOSException e) {
//			e.printStackTrace();
//			this.handleException(e);
//			
//		} catch (EASBizException e) {
//			e.printStackTrace();
//			this.handleException(e);
//		}
       
        return objectValue;
    }
    
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
        
    }  
    /**
     * 设置分录信息
     * 
     * 根据 库存组织  获取所有 仓库，然后根据每个仓库的物料设置生成对应分录 添加到所有的分录中
     * 
     * @param info
     * @param orgInfo
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    private BroodDailyInfo setEntryInfos(BroodDailyInfo info,StorageOrgUnitInfo orgInfo) throws BOSException, EASBizException{
    	WarehouseCollection wsInfos = getStorageOrgWarehouseInfos(orgInfo);
    	for(int i = 0; i < wsInfos.size(); i++){
    		WarehouseInfo wsInfo = wsInfos.get(i);
    		// 仓库
    		wsInfo = WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(wsInfo.getId()));
    		// 鸡舍
    		HenhouseInfo henhouseInfo = BreedFacadeFactory.getRemoteInstance().getWarehsHenhouse(wsInfo.getId().toString());
    		
    		if(henhouseInfo != null){
	    		// 逐个分录列表生成分录  保存
	    		// 饲喂分录  
	//    		BroodDailyEntryInfo entryInfo = new BroodDailyEntryInfo();
	//    		entryInfo.setParent(info);
	//    		entryInfo.setWarehouse(wsInfo);
	//    		info.getEntrys().add(entryInfo);
	    		addBreedMaterialEntryInfos(info,henhouseInfo,henhouseInfo.getName());
	    		// 水电信息
//	    		BroodDailyWEEntryInfo weEntryInfo = new BroodDailyWEEntryInfo();
//	    		weEntryInfo.setHenhouse(henhouseInfo);
//	    		weEntryInfo.setHenhouseName(wsInfo.getName());
//	    		weEntryInfo.setParent(info);
//	    		info.getWEEntrys().add(weEntryInfo);
	    		
	    		
	    		// 疫苗信息
//	    		BroodDailyVaccineEntryInfo vaccineEntryInfo = new BroodDailyVaccineEntryInfo();
//	    		vaccineEntryInfo.setParent(info);
//	    		vaccineEntryInfo.setHenhouse(henhouseInfo);
//	    		vaccineEntryInfo.setHenhouseName(wsInfo.getName());
//	    		info.getVaccineEntrys().add(vaccineEntryInfo);
	    		// 其他信息
	    		BroodDailyAssEntryInfo assEntryInfo = new BroodDailyAssEntryInfo();
	    		assEntryInfo.setParent(info);
	    		assEntryInfo.setHenhouse(henhouseInfo);
	    		assEntryInfo.setHenhouseName(henhouseInfo.getName());
	    		info.getAssEntrys().add(assEntryInfo);
	    		
    		}
    	}
    	return info;
    }
    /**
     * 添加饲喂分录
     * 
     * @param info
     * @param orgInfo
     * @param wsInfo
     * @return
     * @throws BOSException 
     */
    private BroodDailyInfo addBreedMaterialEntryInfos(BroodDailyInfo info,HenhouseInfo henhouseinfo,String henhouseName) throws BOSException{
    	if(info != null && henhouseinfo != null){
	    	
	    	boolean addedDefault = false;
	    	// 获取 鸡舍的 育成设置
	    	BroodCoopSetInfo coopSetInfo = (BroodCoopSetInfo) BroodDailyFacadeFactory.getRemoteInstance().getBroodCoopSet(henhouseinfo.getId().toString());	
	    	// 育成鸡舍设置不为空 
	    	if(coopSetInfo != null){
	    		BroodCoopSetEntryCollection entryColl = coopSetInfo.getEntrys();
	    		for(int i = 0; entryColl.size() > 0 && i <entryColl.size(); i++){
	    			BroodCoopSetEntryInfo entryInfo = entryColl.get(i);
	    			MaterialInfo materialInfo = entryInfo.getMaterial();
	    			BigDecimal quantity = entryInfo.getDefaultQuantity();
	    			if(materialInfo != null){
	    				try{
		    				materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(materialInfo.getId()));
			    			BroodDailyEntryInfo dailyEntryInfo = new BroodDailyEntryInfo();
			    			dailyEntryInfo.setParent(info);
			    			dailyEntryInfo.setHenhouse(henhouseinfo);
			    			dailyEntryInfo.setHenhouseName(henhouseName);
			    			dailyEntryInfo.setMaterial(materialInfo);
			    			dailyEntryInfo.setMaterialName(materialInfo.getName());
			    			dailyEntryInfo.setDailyQtyAll(quantity);
			        		info.getEntrys().add(dailyEntryInfo);
			        		
			        		addedDefault = true;
	    				}catch(EASBizException e){
	    					throw new BOSException(e);
	    				}
	    			}
	    		}
	    	}
	    	if(!addedDefault){
	    		BroodDailyEntryInfo dailyEntryInfo = new BroodDailyEntryInfo();
				dailyEntryInfo.setParent(info);
	//			dailyEntryInfo.setWarehouse(wsInfo);
				dailyEntryInfo.setHenhouse(henhouseinfo);
				dailyEntryInfo.setHenhouseName(henhouseName);
	//			dailyEntryInfo.setMaterial(materialInfo);
	//			dailyEntryInfo.setMaterialName(materialInfo.getName());
	//			dailyEntryInfo.setDailyQtyAll(quantity);
	    		info.getEntrys().add(dailyEntryInfo);
	    	}
    	}
    	return info;
    }
    
    /**
     * 根据库存组织获得对应的 仓库信息
     * @param currStorageOrgInfo
     * @return
     * @throws BOSException 
     */
    private WarehouseCollection getStorageOrgWarehouseInfos(StorageOrgUnitInfo orgInfo) throws BOSException{
    	
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(orgInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id",orgInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id","",CompareType.EQUALS));
		}
		filterInfo.getFilterItems().add(new FilterItemInfo("name","%鸡舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
    	return WarehouseFactory.getRemoteInstance().getWarehouseCollection(view);
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
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	/**
     * 重载单据内容
     * @throws Exception 
     * @throws BOSException 
     * @throws EASBizException 
     */
	private void reloadData() throws EASBizException, BOSException, Exception{
		
		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
			
			
		
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
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}


	
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{
				// 判断 入职和离职是否为空，如果为空则提示 是否提交
				int addPerson = this.txtentryPersonQty.getIntegerValue();
				int leavePerson = this.txtleavePersonQty.getIntegerValue();
				
				if(addPerson == 0 || leavePerson == 0){
					if(MsgBox.showConfirm2("当天入职、离职人数存在为0内容，确认提交?") != MsgBox.OK){
						SysUtil.abort();
					}
				}
				
				// 校验周龄和日龄不能 小于1
				int week = this.txtweek.getIntegerValue();
				int day = this.txtweekDay.getIntegerValue();
				if(week == 0){
					MsgBox.showWarning("周龄不能小于1 ");
					SysUtil.abort();
				}else if(week > 100){
					MsgBox.showWarning("周龄不能大于100 ");
					SysUtil.abort();
				}else if(!(day >= 0 && day <8)){
					MsgBox.showWarning("日龄只能处于0到7之间 ");
					SysUtil.abort();
				}else if(week > 1 && day == 0){
					MsgBox.showWarning("只有在第一周允许日龄为0 ");
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
	 * 批次变更时更新分录信息
	 */
	@Override
	protected void prmtbreedBatch_dataChanged(DataChangeEvent e)
			throws Exception {
		try{
			BreedBatchInfo oldValue = (BreedBatchInfo) e.getOldValue();
			BreedBatchInfo newValue = (BreedBatchInfo) e.getNewValue();
			// 值为空 则清空分录
			if(newValue == null){
				this.kdtEntrys.removeRows();
				this.kdtAssEntrys.removeRows();
				this.kdtImmuneEntrys.removeRows();
				this.txtweek.setValue(0);
				this.txtweekDay.setValue(0);
				this.editData.getEntrys().clear();
				this.editData.getAssEntrys().clear();
				this.editData.getImmuneEntrys().clear();
				this.editData.setWeek(0);
				this.editData.setWeekDay(0);
			}else if(oldValue != null && newValue.getId().toString().equals(oldValue.getId().toString())){
				return;
			}else{
				// 清空分录  更新新选中的批次信息 重新设置分录数据
				this.kdtEntrys.removeRows();
				this.kdtAssEntrys.removeRows();
				this.editData.getEntrys().clear();
				this.editData.getAssEntrys().clear();
				this.txtweek.setValue(0);
				this.txtweekDay.setValue(0);
				this.editData.setWeek(0);
				this.editData.setWeekDay(0);
				// 根据批次信息和 对应的 养殖规范设置分录信息
				setAllEntryInfos(newValue);
//				this.setDataObject(this.editData);
//				this.loadFields();
//				// 重新设置完分录后 界面刷新
//				this.loadData();
			}
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
			SysUtil.abort();
		}
		
	}

	/**
	 * 根据选中的养殖批次信息设置分录信息
	 * @param newValue
	 * @throws BOSException 
	 */
	private void setAllEntryInfos(BreedBatchInfo batchInfo) throws BOSException {
		if(batchInfo != null){
			try{
				Date bizDate = this.pkBizDate.getSqlDate();
				// 获取批次详细信息
				IBreedFacade breedFacade = BreedFacadeFactory.getRemoteInstance();
				batchInfo = BreedBatchFactory.getRemoteInstance().getBreedBatchInfo(new ObjectUuidPK(batchInfo.getId()));
				BreedBatchDetailInfo batchDetail = breedFacade.getBreedBatchDetailInfos(batchInfo.getId().toString(), null,bizDate);
				if(batchDetail != null){
					int currWeek = batchDetail.getCurrentWeek();
					this.txtweek.setValue(currWeek);
					this.editData.setWeek(currWeek);
					
					int currDay = batchDetail.getCurrentDay();
					this.txtweekDay.setValue(currDay);
					this.editData.setWeekDay(currDay);
					// 获得养殖规范
					BreedModelInfo modelInfo = batchDetail.getBreedModelInfo();
					// 规范分录
					BreedModelEntryInfo modelEntryInfo = batchDetail.getBreedModelEntryInfo();
					
					// 如果没查到对应的 设置则跳过
//					if(modelEntryInfo == null ) continue;
					BreedBatchEntryCollection entryColl = batchInfo.getEntrys();
					
					// 死淘和 当前只数获得
					batchEntryDetailInfos = batchDetail.getHenhouseBreedingStock(null,bizDate);
					
					// 批次中的分录逐个设置
					for(int i = 0; i < entryColl.size(); i++){
						BreedBatchEntryInfo entryInfo = entryColl.get(i);
						
						BroodDailyEntryInfo dailyEntryInfo = new BroodDailyEntryInfo();
		    			dailyEntryInfo.setParent(this.editData);
		    			HenhouseInfo henhouseInfo = entryInfo.getHenHouse();
		    			henhouseInfo = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(henhouseInfo.getId()));
		    			WarehouseInfo warehsInfo = henhouseInfo.getWarehouse();
		    			if(warehsInfo != null){
		    				warehsInfo = WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(warehsInfo.getId()));
		    				dailyEntryInfo.setHenhouse(henhouseInfo);
			    			dailyEntryInfo.setHenhouseName(henhouseInfo.getName());
		    			}
		    			
		    			// 获得 鸡舍 存栏量详细信息
		    			BreedBatchEntryDetailInfo entryDetailInfo = batchEntryDetailInfos.get(henhouseInfo.getId().toString());
//		    			int henNowQty = entryDetailInfo.getHenNowQty();
//		    			int cockNowQty = entryDetailInfo.getCockNowQty();
		    			int nowQty = 0;
		    			if(entryDetailInfo != null){
		    				nowQty = entryDetailInfo.getNowQty();
		    			}
		    			
		    			
		    			MaterialInfo materialInfo = null;
		    			BigDecimal perQty = new BigDecimal("0");
		    			// 根据批次 分录信息 设置物料和数量
		    			ChikenType chikenType = entryInfo.getChikenType();
		    			if(modelEntryInfo != null){
			    			if(ChikenType.BroodCock.equals(chikenType) ){
			    				materialInfo = modelEntryInfo.getCockMaterial();
			    				perQty = modelEntryInfo.getCockQtyPerday();
			    			}else{
			    				materialInfo = modelEntryInfo.getHenMaterial();
			    				perQty = modelEntryInfo.getHenQtyPerday();
			    			}
		    			}
		    			if(materialInfo != null){
			    			materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(materialInfo.getId()));
			    			dailyEntryInfo.setMaterial(materialInfo);
			    			dailyEntryInfo.setMaterialName(materialInfo.getName());
			    			dailyEntryInfo.setMaterialModel(materialInfo.getModel());
		    			}
		    			
		    			// 数量计算
		    			BigDecimal qtyAll  = perQty.multiply(new BigDecimal(nowQty));
		    			qtyAll = qtyAll.divide(new BigDecimal("1000"),2,RoundingMode.HALF_UP);
		    			
		    			dailyEntryInfo.setDailyQtyAll(qtyAll);
		    			// 饮水量
		    			BigDecimal waterQty = new BigDecimal("0");
		    			if(modelEntryInfo != null && modelEntryInfo.getWaterQty() != null){
		    				
		    				waterQty = modelEntryInfo.getWaterQty().multiply(qtyAll);
		    			}
		    			dailyEntryInfo.setWaterQty(waterQty);
		    			// 
		    			IRow newRow = this.kdtEntrys.addRow();
		    			newRow.getCell("henhouse").setValue(henhouseInfo);
		    			newRow.getCell("henhouseName").setValue(dailyEntryInfo.getHenhouseName());
		    			newRow.getCell("material").setValue(dailyEntryInfo.getMaterial());
		    			newRow.getCell("materialName").setValue(dailyEntryInfo.getMaterialName());
		    			newRow.getCell("materialModel").setValue(dailyEntryInfo.getMaterialModel());
		    			newRow.getCell("dailyQtyAll").setValue(dailyEntryInfo.getDailyQtyAll());
		    			newRow.getCell("waterQty").setValue(dailyEntryInfo.getWaterQty());
		    			
		        		editData.getEntrys().add(dailyEntryInfo);
		        		
		        		
		        		// 其他信息
			    		BroodDailyAssEntryInfo assEntryInfo = new BroodDailyAssEntryInfo();
			    		assEntryInfo.setParent(editData);
			    		assEntryInfo.setHenhouse(henhouseInfo);
			    		if(warehsInfo != null){
			    			assEntryInfo.setHenhouseName(henhouseInfo.getName());
			    		}
			    		if(modelEntryInfo != null){
				    		assEntryInfo.setBreedTime(modelEntryInfo.getBreedTime());
				    		assEntryInfo.setLightingTime(modelEntryInfo.getLightingTime());
				    		assEntryInfo.setTemperatureFrom(modelEntryInfo.getTemperatureFrom());
				    		assEntryInfo.setTemperatureTo(modelEntryInfo.getTemperatureTo());
				    		assEntryInfo.setHumidityFrom(modelEntryInfo.getHumidityFrom());
				    		assEntryInfo.setHumidityTo(modelEntryInfo.getHumidityTo());
				    		assEntryInfo.setBreekingStock(nowQty);
			    		}
			    		editData.getAssEntrys().add(assEntryInfo);
			    		
			    		IRow assNewrow = this.kdtAssEntrys.addRow();
			    		assNewrow.getCell("henhouse").setValue(assEntryInfo.getHenhouse());
			    		assNewrow.getCell("henhouseName").setValue(assEntryInfo.getHenhouseName());
			    		assNewrow.getCell("breedTime").setValue(assEntryInfo.getBreedTime());
			    		assNewrow.getCell("lightingTime").setValue(assEntryInfo.getLightingTime());
			    		assNewrow.getCell("temperatureFrom").setValue(assEntryInfo.getTemperatureFrom());
			    		assNewrow.getCell("temperatureTo").setValue(assEntryInfo.getTemperatureTo());
			    		assNewrow.getCell("humidityFrom").setValue(assEntryInfo.getHumidityFrom());
			    		assNewrow.getCell("humidityTo").setValue(assEntryInfo.getHumidityTo());
			    		assNewrow.getCell("breekingStock").setValue(nowQty);
//			    		// 免疫信息
			    		BroodDailyImmuneEntryInfo immuneEntryInfo  = new BroodDailyImmuneEntryInfo();
			    		immuneEntryInfo.setParent(editData);
			    		immuneEntryInfo.setHenhouse(henhouseInfo);
			    		immuneEntryInfo.setHenhouseName(henhouseInfo.getName());
			    		editData.getImmuneEntrys().add(immuneEntryInfo);

			    		IRow immuneNewrow = this.kdtImmuneEntrys.addRow();
			    		immuneNewrow.getCell("henhouse").setValue(immuneEntryInfo.getHenhouse());
			    		immuneNewrow.getCell("henhouseName").setValue(immuneEntryInfo.getHenhouseName());
					}
					// 
				}
			}catch(EASBizException e){
				throw new BOSException(e);
			}
		}
		
	}

	/**
	 * 业务日期更新时  修改 周龄 日龄
	 */
	protected void pkBizDate_dataChanged(DataChangeEvent e) throws Exception {
		Date bizDate = this.pkBizDate.getSqlDate();
		
		Date newDate = (Date) e.getNewValue();
		
		Date oldDate = (Date) e.getOldValue();
		
		if(newDate != null && oldDate != null && newDate.equals(oldDate)){
			return;
		}
		
		
		if(bizDate != null){
			BreedBatchInfo batchInfo = (BreedBatchInfo) this.prmtbreedBatch.getValue();
			if(batchInfo != null){
				// 更新 周龄日龄
				HashMap weekInfo = BreedFacadeFactory.getRemoteInstance().getBatchWeekages(batchInfo.getId().toString(),bizDate);
				Integer currWeek = (Integer) weekInfo.get("currWeek");
				Integer currDay = (Integer) weekInfo.get("currDay");
				// 设置周龄 日龄
				this.txtweek.setValue(currWeek);
				this.txtweekDay.setValue(currDay);
				
				
				// 清空分录  更新新选中的批次信息 重新设置分录数据
				this.kdtEntrys.removeRows();
				this.kdtAssEntrys.removeRows();
				this.kdtImmuneEntrys.removeRows();
				this.editData.getEntrys().clear();
				this.editData.getAssEntrys().clear();
				this.editData.getImmuneEntrys().clear();
//				this.txtdays.setValue(0);
//				this.editData.setDays(0);
				// 根据批次信息和 对应的 养殖规范设置分录信息
				setAllEntryInfos(batchInfo);
//				this.editData.setWeek(currWeek.intValue());
//				this.editDate.set
			}
		}
	}
    
	 /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
    	SelectorItemCollection sic = super.getSelectors();
//    	sic.add(new SelectorItemInfo("costObject.name"));
    	return sic;
    }
	
    /**
     * 其他分录发生变化 
     * 填入死淘后自动计算是否
     * output kdtAssEntrys_Changed(int rowIndex,int colIndex) method
     */
    @Override
    public void kdtAssEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
  
      if ("henhouse".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
    	  kdtAssEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAssEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));

	  }
	    HenhouseInfo henInfo = (HenhouseInfo) this.kdtAssEntrys.getCell(rowIndex, "henhouse").getValue();
    	
	    // 鸡舍不能为空 同时 批次存在 自动计算 存栏量
    	if(henInfo != null && batchEntryDetailInfos != null ){
    		BreedBatchEntryDetailInfo entryDetailInfo = batchEntryDetailInfos.get(henInfo.getId().toString());
    		if(entryDetailInfo != null){
    			if("isMarketed".equals(this.kdtAssEntrys.getColumn(colIndex).getFieldName())){
    		    	Boolean isMarketed = (Boolean) this.kdtAssEntrys.getCell(rowIndex, "isMarketed").getValue();
    		    	if(isMarketed){
    		    		// 选中全部出栏则将 存栏量全部复制到  出栏量中
    		    		this.kdtAssEntrys.getCell(rowIndex, "marketQty").setValue(this.kdtAssEntrys.getCell(rowIndex, "breekingStock").getValue());
    		    	}
    		    	
    		    }
			    // 母鸡死淘录入
			    if("cullQty".equals(this.kdtAssEntrys.getColumn(colIndex).getFieldName()) || 
			    		"deathQty".equals(this.kdtAssEntrys.getColumn(colIndex).getFieldName()) ||
			    		"marketQty".equals(this.kdtAssEntrys.getColumn(colIndex).getFieldName()) ||
			    		"isMarketed".equals(this.kdtAssEntrys.getColumn(colIndex).getFieldName())){
			    	
	    			int nowqty = entryDetailInfo.getNowQty();
	    			// 计算 存栏量
	    			Integer cull = (Integer) this.kdtAssEntrys.getCell(rowIndex, "cullQty").getValue();
	    			int cullInt = (cull == null? 0 :cull.intValue());
	    			
	    			Integer death = (Integer) this.kdtAssEntrys.getCell(rowIndex, "deathQty").getValue();
	    			int deathInt = (death == null? 0 :death.intValue());
	    			
	    			Integer market = (Integer) this.kdtAssEntrys.getCell(rowIndex, "marketQty").getValue();
	    			int marketQty = (market == null? 0 :market.intValue());
	    			
	    			int stayHenQty = nowqty-cullInt-deathInt-marketQty;
	    			
	    			Object bs = this.kdtAssEntrys.getCell(rowIndex, "breekingStock").getValue();
	    			this.kdtAssEntrys.getCell(rowIndex, "breekingStock").setValue(stayHenQty);
		    		
	    			if(bs != null){
	    				int bsQty = (Integer)bs;
	    				if( stayHenQty == 0 && bsQty != 0){
		    				this.kdtAssEntrys.getCell(rowIndex, "isMarketed").setValue(Boolean.TRUE);
			    			
		    			}
	    			}
	    			
	    		}
			   
			    
	    	}
	    	
	    }	
    }
    
    
    
    /**
     * 饲喂分录分录更新 事件
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
       
	    if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));
		
		}
	
	    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));
		
		}

	    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	kdtEntrys.getCell(rowIndex,"materialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

	    }
    }
    
    /**
     * 生成下游单据
     */
	@Override
	public void actionGenNextBill_actionPerformed(ActionEvent e)
			throws Exception {
		try{
			List<ExecBotpResultInfo> result = BroodDailyFactory.getRemoteInstance().genNextBill(editData);
			if(result != null && result.size() > 0){
				showGennextBillResult(this,result);
			}
			this.setMessageText("生成下游单据完成");
			this.showMessage();
		}catch (FarmException fe) {
			fe.printStackTrace();
			MsgBox.showInfo(fe.getMessage());
		}
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