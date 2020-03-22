/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.IBreedFacade;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;

/**
 * output class name
 */
public class CommecialChikenApplyFodderEditUI extends AbstractCommecialChikenApplyFodderEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CommecialChikenApplyFodderEditUI.class);
    
    /**
     * output class constructor
     */
    public CommecialChikenApplyFodderEditUI() throws Exception
    {
        super();
        this.setUITitle("要料计划");
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
			this.actionGenNextBill.setEnabled(false);
			this.btnGenNextBill.setEnabled(false);
		}else {
			if(this.getOprtState().equals("EDIT")){
				checkCanEdit();
				
			}
			// 初始界面数据
			initData();
		}
		
		 // 设置默认当前库存组织所有鸡舍信息
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        if(currStorageOrgInfo == null){
        	MsgBox.showInfo("当前未在任何库存组织中，不能进行新增养殖日报操作");
        	SysUtil.abort();
        }
        // 更新库存组织
        setStorageOrgUnit(currStorageOrgInfo);
        
        
        
     // 
    	final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedMaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        
        
        F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this, kdtEntrys_material_PromptBox);
        FilterInfo materialFI = new FilterInfo();
//        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020102%",CompareType.LIKE));
        
        //TODO 20190425 macheng add 暂时屏蔽物料过滤条件
//        if(currStorageOrgInfo.getName().indexOf("育成") >= 0 || currStorageOrgInfo.getName().indexOf("产蛋") >= 0 ){
//        	materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020101%",CompareType.LIKE));
//        }else{
//        	materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020102%",CompareType.LIKE));
//        }
        // 设置物料过滤条件
		m7.setBaseFilter(materialFI);
		kdtEntrys_material_PromptBox.setSelector(m7);
		kdtEntrys_material_PromptBox.setEditFormat("$number$");
		kdtEntrys_material_PromptBox.setCommitFormat("$number$");
		kdtEntrys_material_PromptBox.setRequired(true);
		
		
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtFodderPlanEntrys.getColumn("fodderMaterial").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderPlanEntrys.getColumn("fodderMaterial").setRenderer(kdtEntrys_material_OVR);
	}
    /**
     * 根据编辑数据初始化 界面内容
     * @throws BOSException 
     * @throws EASBizException 
     */
    private void initData() throws BOSException, EASBizException{
    	
    	// TODO
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
        towerFI.getFilterItems().add(new FilterItemInfo("storageOrg.id",orgInfo.getId().toString(),CompareType.EQUALS));
        towerEvi.setFilter(towerFI);
        // 设置物料过滤条件
        //tower_PromptBox.setEntityViewInfo(towerEvi);
		
		
        KDTDefaultCellEditor kdtFodderEntrys_tower_CellEditor = new KDTDefaultCellEditor(tower_PromptBox);
        this.kdtFodderPlanEntrys.getColumn("fodderTower").setEditor(kdtFodderEntrys_tower_CellEditor);
        ObjectValueRender kdtFodderEntrys_tower_OVR = new ObjectValueRender();
        kdtFodderEntrys_tower_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderPlanEntrys.getColumn("fodderTower").setRenderer(kdtFodderEntrys_tower_OVR);
        
        // 设置 成本对象过滤条件
        EntityViewInfo view = new EntityViewInfo();
        FilterInfo filterInfo = new FilterInfo();
        filterInfo.getFilterItems().add(new FilterItemInfo("description","%"+orgInfo.getName()+"%",CompareType.LIKE));
//		filterInfo.getFilterItems().add(new FilterItemInfo("StorageOrgUnit.name",orgInfo.getName(),CompareType.EQUALS));
		if(orgInfo.getName().indexOf("育成") < 0 && orgInfo.getName().indexOf("产蛋") < 0){
			filterInfo.getFilterItems().add(new FilterItemInfo("isForbiden",Boolean.FALSE,CompareType.EQUALS));
		}
		
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","商品鸡%",CompareType.LIKE));
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","商品鸡苗%",CompareType.NOTLIKE));
//		filterInfo.setMaskString("(#0 or #1) and #2 and #3");
		if(orgInfo.getName().indexOf("育成") < 0 && orgInfo.getName().indexOf("产蛋") < 0){
			filterInfo.setMaskString("#0 and #1");
		}
//		else{
//			filterInfo.setMaskString("#0 or #1");
//		}
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","",CompareType.LIKE));
		SorterItemInfo sortItem = new SorterItemInfo("number");
		sortItem.setSortType(SortType.DESCEND);
		view.getSorter().add(sortItem);
		view.setFilter(filterInfo);
		
		 // prmtcostObject		
        this.prmtcostObject.setQueryInfo("com.kingdee.eas.farm.breed.layegg.app.F7AllCostObjectQuery");	
        
//        this.prmtcostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        this.prmtcostObject.setEditable(true);		
        this.prmtcostObject.setDisplayFormat("$name$");		
        this.prmtcostObject.setEditFormat("$number$");		
        this.prmtcostObject.setCommitFormat("$number$");		
        this.prmtcostObject.setRequired(true);
		//this.prmtcostObject.setEntityViewInfo(view);
        
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
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
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
        return com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo objectValue = new com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{
				
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

}