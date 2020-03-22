/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.Farm;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class HatchEggReceivingBillEditUI extends AbstractHatchEggReceivingBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(HatchEggReceivingBillEditUI.class);
    
    /**
     * output class constructor
     */
    public HatchEggReceivingBillEditUI() throws Exception
    {
        super();
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
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }
    

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
//    	if(!editData.getBaseStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)&&!editData.getBaseStatus().equals(com.kingdee.eas.farm.hatch.billStatus.save))
//			return;
//    	
    	if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
		{
		MsgBox.showWarning("当前状态下的单据禁止编辑");
		abort();
		}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
		{
		MsgBox.showWarning("当前状态下的单据禁止删除");
		abort();
		}
    	super.actionRemove_actionPerformed(e);
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
        com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        objectValue.setEggSourceType(com.kingdee.eas.farm.hatch.EggSourceType.InternalFarm);
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        objectValue.setBizDate(new Date());  
        
        return objectValue;
    }
    
    /**
     * 页面初始化
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		// 初始化 分录过滤条件
		initEntrysFilter();
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			this.btnAddLine.setEnabled(false);
			this.btnRemoveLine.setEnabled(false);
			this.btnInsertLine.setEnabled(false);
		}
		// 来源类型删除 放养
		this.EggSourceType.removeItem(com.kingdee.eas.farm.hatch.EggSourceType.SubContract);
		//根据库存组织过滤蛋库
		this.prmtkczz.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				StorageOrgUnitInfo info= (StorageOrgUnitInfo) prmtkczz.getValue();
	    		EntityViewInfo view = new EntityViewInfo();
	    		FilterInfo filterInfo = new FilterInfo();
	    		filterInfo.getFilterItems().add(new FilterItemInfo("storageOrg.id",info.getId().toString(),CompareType.EQUALS));   		
	    		view.setFilter(filterInfo);
	    		filterInfo.getFilterItems().add(new FilterItemInfo("WHSTATE", "1",CompareType.EQUALS)); 
	    		filterInfo.setMaskString("#0 and #1");
	    		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("eggWarehouse").getEditor().getComponent(); 
	    		prmtPost.setEntityViewInfo(view);
			}});
		
		//StorageOrgUnitInfo info1= (StorageOrgUnitInfo) prmtkczz.getValue();
		EntityViewInfo view1 = new EntityViewInfo();
		FilterInfo filterInfo1 = new FilterInfo();
		filterInfo1.getFilterItems().add(new FilterItemInfo("name","种鸡%",CompareType.LIKE));   		
		view1.setFilter(filterInfo1);
		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("stockingFarmer").getEditor().getComponent(); 
		prmtPost.setEntityViewInfo(view1);
		
		KDBizPromptBox prmtPost1 = (KDBizPromptBox) kdtEntrys.getColumn("stockingFarm").getEditor().getComponent(); 
		prmtPost1.setEntityViewInfo(view1);
		
		this.btnTraceUp.setVisible(true);
		this.btnTraceDown.setVisible(true);
		this.btnCopy.setVisible(false);
		this.btnEdit.setEnabled(true);
		
		
	}
    
	/**
	 * 保存
	 */
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		reloadData();
	}
	/**
	 * 提交
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(arg0);
	}
	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.setMessageText("审核通过");
		this.showMessage();
		lockUIForViewStatus();
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		reloadData();		
	}
	
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.setMessageText("反审核通过");
		this.showMessage();
		this.btnEdit.setEnabled(true);
		reloadData();
	}

	/**
	 * 重载单据内容
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws Exception
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
	 * 种蛋来源类型
	 */
	@Override
	protected void EggSourceType_actionPerformed(ActionEvent e)
			throws Exception {
		
		EggSourceType sourceType = (EggSourceType) this.EggSourceType.getSelectedItem();
		if(sourceType == null){
			MsgBox.showInfo("来源类型不能为空");
			SysUtil.abort();
		}
		if(com.kingdee.eas.farm.hatch.EggSourceType.InternalFarm.equals(sourceType)){
			this.kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
			//this.kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(false);
			//this.kdtEntrys.getColumn("internalBreedingBatch").getStyleAttributes().setHided(false);
			//this.kdtEntrys.getColumn("henhouse").getStyleAttributes().setHided(false);
			//this.kdtEntrys.getColumn("internalEggBatch").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("sendDate").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("sendQty").getStyleAttributes().setHided(false);
			
			this.kdtEntrys.getColumn("stockingFarmer").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingFarm").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("stockingHouse").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(false);
		}else if(com.kingdee.eas.farm.hatch.EggSourceType.Purchase.equals(sourceType)){
			this.kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(false);
			this.kdtEntrys.getColumn("internalFarm").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("internalBreedingBatch").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("henhouse").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("internalEggBatch").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("sendDate").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("sendQty").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingFarmer").getStyleAttributes().setHided(true);
			
			this.kdtEntrys.getColumn("stockingFarm").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingHouse").getStyleAttributes().setHided(true);
			this.kdtEntrys.getColumn("stockingBatch").getStyleAttributes().setHided(true);
			
			
			
			
		}else if(com.kingdee.eas.farm.hatch.EggSourceType.SubContract.equals(sourceType)){
			MsgBox.showInfo("暂不支持放养种蛋接收，请从放养业务模块操作");
			SysUtil.abort();
		}
	}
	/**
	 * 业务日期变化
	 */
	@Override
	protected void pkBizDate_dataChanged(DataChangeEvent e) throws Exception {
		
		super.pkBizDate_dataChanged(e);
	}
	/**
	 * 孵化场变化
	 */
	@Override
	protected void prmthatchFactory_dataChanged(DataChangeEvent e)
			throws Exception {
		
		super.prmthatchFactory_dataChanged(e);
	}
    /**
     * 初始化 转栏分录 过滤条件
     */
    private void initEntrysFilter(){
    	// 养殖场过滤
    	
    	// 养殖批次
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(cuInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("CU.id",cuInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("CU.id","",CompareType.EQUALS));
		}
		view.setFilter(filterInfo);
		
		final KDBizPromptBox batch_Prompt = new KDBizPromptBox();
        batch_Prompt.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        batch_Prompt.setVisible(true);
        batch_Prompt.setEditable(true);
        batch_Prompt.setDisplayFormat("$number$");
        batch_Prompt.setEditFormat("$number$");
        batch_Prompt.setCommitFormat("$number$");
        batch_Prompt.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(batch_Prompt);
        
        
        // 养殖场过滤条件
        this.kdtEntrys.getColumn("internalFarm").setEditor(kdtEntrys_henhouse_CellEditor);
        
        // 批次 过滤
        updateEntryBatchFilter(null, null,  "internalBreedingBatch");
        // 禽舍 过滤
        updateEntryHenhouseFilter(null, null,  "henhouse");
        
       
    }
    
    /**
     * 根据 过滤条件设置 批次过滤条件
     * @param row
     * @param farm
     * @param batchInfo
     * @param fieldName
     */
    private void updateEntryBatchFilter(IRow row,
    		BreedStoorgSetInfo farm, 
    		String fieldName){
    	

   	 // 禽舍添加过滤条件
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(farm != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id",farm.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id","",CompareType.EQUALS));
		}
		
		
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%鸡舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_batch_PromptBox = new KDBizPromptBox();
       kdtEntrys_batch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7ParentBreedBatchQuery");
       kdtEntrys_batch_PromptBox.setVisible(true);
       kdtEntrys_batch_PromptBox.setEditable(true);
       kdtEntrys_batch_PromptBox.setDisplayFormat("$number$");
       kdtEntrys_batch_PromptBox.setEditFormat("$number$");
       kdtEntrys_batch_PromptBox.setCommitFormat("$number$");
       kdtEntrys_batch_PromptBox.setEntityViewInfo(view);
       KDTDefaultCellEditor kdtEntrys_batch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batch_PromptBox);

       if(row == null){
       	this.kdtEntrys.getColumn(fieldName).setEditor(kdtEntrys_batch_CellEditor);
       }else{
       	row.getCell(fieldName).setEditor(kdtEntrys_batch_CellEditor);
       }
    	
    }
    
    /**
     * 根据 过滤条件设置 禽舍过滤条件
     * @param row
     * @param farm
     * @param batchInfo
     * @param fieldName
     */
    private void updateEntryHenhouseFilter(IRow row,
    		BreedStoorgSetInfo farm, 
    		String fieldName){
    	
    	
    	 // 禽舍添加过滤条件
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(farm != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id",farm.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("farm.id","",CompareType.EQUALS));
		}
		
		
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%鸡舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);

        if(row == null){
        	this.kdtEntrys.getColumn(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }else{
        	row.getCell(fieldName).setEditor(kdtEntrys_henhouse_CellEditor);
        }
        
    }
	/**
	 * 分录编辑 事件
	 */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    	int rowIndex = e.getRowIndex();
    	int colIndex = e.getColIndex();
    	
    	// 
    	IRow row = this.kdtEntrys.getRow(rowIndex);
    	if(colIndex == kdtEntrys.getColumnIndex("internalBreedingBatch")){
    		ParentBreedBatchInfo batchInfo = (ParentBreedBatchInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();
    		BreedStoorgSetInfo fromFarm = null;
    		if(batchInfo != null){
    			fromFarm = batchInfo.getFarm();
    		}
    		// 禽舍过滤
    		updateEntryHenhouseFilter(row, fromFarm,  "henhouse");
    		
    		
    	}else if(colIndex == kdtEntrys.getColumnIndex("internalFarm")){
    		BreedStoorgSetInfo farm = (BreedStoorgSetInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();
    	
    		// 批次过滤
    		updateEntryBatchFilter(row, farm,  "internalBreedingBatch");
    		
    	}
    	if(kdtEntrys.getColumnKey(colIndex).equals("stockingFarm")){
    		if(kdtEntrys.getCell(rowIndex, "stockingFarm").equals(null)){
    			
    		}else{
    			FarmInfo farm =  (FarmInfo) kdtEntrys.getCell(rowIndex, "stockingFarm").getValue();
        		EntityViewInfo view = new EntityViewInfo();
        		FilterInfo filterInfo = new FilterInfo();
        		filterInfo.getFilterItems().add(new FilterItemInfo("farm.name",farm.getName(),CompareType.EQUALS));   		
        		view.setFilter(filterInfo);
        		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("stockingBatch").getEditor().getComponent(); 
        		prmtPost.setEntityViewInfo(view);
        		
        		FilterInfo filterInfo1 = new FilterInfo();
        		filterInfo1.getFilterItems().add(new FilterItemInfo("name","%"+farm.getName()+"%",CompareType.LIKE));
        		EntityViewInfo view1 = new EntityViewInfo();
        		view1.setFilter(filterInfo1);
        		KDBizPromptBox prmtPost1 = (KDBizPromptBox) kdtEntrys.getColumn("stockingHouse").getEditor().getComponent(); 
        		prmtPost1.setEntityViewInfo(view1);
	
    		}
    		
    		
    	}
    	
    	if(kdtEntrys.getColumnKey(colIndex).equals("stockingFarmer")){
    		if(kdtEntrys.getCell(rowIndex, "stockingFarmer").equals(null)){
    			
    		}else{
    			FarmersInfo farm =  (FarmersInfo) kdtEntrys.getCell(rowIndex, "stockingFarmer").getValue();
        		EntityViewInfo view = new EntityViewInfo();
        		FilterInfo filterInfo = new FilterInfo();
        		filterInfo.getFilterItems().add(new FilterItemInfo("name",farm.getName(),CompareType.EQUALS));   		
        		view.setFilter(filterInfo);
        		KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntrys.getColumn("stockingFarm").getEditor().getComponent(); 
        		prmtPost.setEntityViewInfo(view);
    		}
    		
    		
    	}
    	
    	
    	
    	
    	//yumignxu  20180830
		//BigDecimal runQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"runQty").getValue());
		BigDecimal qcEggQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"quaEggQty").getValue());
		BigDecimal smallEggQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"quaSmaallEggQty").getValue());
		BigDecimal ccd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"weakEggQty").getValue());
		BigDecimal jxd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"mutanEggQty").getValue());
		BigDecimal shd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"doubleYolkQty").getValue());
		BigDecimal zd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"zd").getValue());
		BigDecimal rd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"rd").getValue());
		BigDecimal dpd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"brokenEggQty").getValue());
		BigDecimal pd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"xpd").getValue());
		BigDecimal fxd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"fxd").getValue());
		BigDecimal allQty = qcEggQty.add(smallEggQty).add(ccd).add(jxd).add(shd).add(zd).add(rd).add(dpd).add(pd).add(fxd).add(BigDecimal.ZERO);
		kdtEntrys.getCell(e.getRowIndex(), "reQty").setValue(allQty);	
		BigDecimal diffQty = BigDecimal.ZERO;
		if(kdtEntrys.getCell(e.getRowIndex(),"sendQty").equals(null)){
			
		}else{
			diffQty = allQty.subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"sendQty").getValue()));
		}
		kdtEntrys.getCell(e.getRowIndex(), "cys").setValue(diffQty);
    	
    	
    	
    	
    }
    
}