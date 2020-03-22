/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.business.BusinessBreedFacadeFactory;
import com.kingdee.eas.farm.breed.business.CCLeaveBillEntryInfo;
import com.kingdee.eas.farm.breed.business.CCLeaveBillInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CCLeaveBillEditUI extends AbstractCCLeaveBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCLeaveBillEditUI.class);
    
    private BreedBatchInfo currBreedBatchInfo;
    private StorageOrgUnitInfo cuInfo;
    /**
     * output class constructor
     */
    public CCLeaveBillEditUI() throws Exception
    {
        super();
        
        cuInfo = SysContext.getSysContext().getCurrentStorageUnit();
		if(cuInfo == null){
			MsgBox.showInfo("当前所在组织不是任何养殖场，不能填报商品鸡出厂记录单");
			SysUtil.abort();
			
		}
		
		// 获取日期
		Date currDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currDate);
		cal.add(Calendar.DATE, -1);
		// 获取上一天
		currBreedBatchInfo = BusinessBreedFacadeFactory.getRemoteInstance().getFarmBreedDailyByDate(cuInfo.getId().toString(), cal.getTime());
		// 前一天没有日报不允许 做出厂记录
		if("ADDNEW".equals(this.getOprtState()) && currBreedBatchInfo == null){
			MsgBox.showInfo("请先补上昨天的日报，再进行出场操作");
			SysUtil.abort();
		}
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.FINISH)) {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(true);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.mBtnAudit.setEnabled(true);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(true);
			this.tBtnUnAudit.setEnabled(false);
		}else {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(false);
		}
        storageOrgUnitChanged(null);
        
        
    }

    /**
	 * 初始化
	 */
	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		
		// 设置过滤条件
		setHenhouseFilter();
	
		// 设置养殖批次过滤条件
		setBreedBatchFilter();
	}
    /**
     * 设置鸡舍过滤条件
     */
	private void setHenhouseFilter(){
	
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        // 鸡舍过滤 当前组织且鸡舍类型为商品鸡舍
        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.CC.getValue(),CompareType.EQUALS));
      
        StorageOrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("chickenFarm.id",cuInfo.getId().toString(),CompareType.EQUALS));
		
        evi.setFilter(filter);
		final KDBizPromptBox kdtEntrys_henHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henHouse_PromptBox.setVisible(true);
        kdtEntrys_henHouse_PromptBox.setEditable(true);
        kdtEntrys_henHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setCommitFormat("$number$");
        
        
       
        
        kdtEntrys_henHouse_PromptBox.setEntityViewInfo(evi);
        
        KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henhouse").setRenderer(kdtEntrys_henHouse_OVR);
			
			
	       
		
	}
	 /**
     * 设置养殖批次过滤条件
     */
	private void setBreedBatchFilter(){
	
		EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        // 鸡舍过滤 当前组织且鸡舍类型为商品鸡舍
//        filter.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.CC,CompareType.EQUALS));
      
        StorageOrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentStorageUnit();
        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",cuInfo.getId().toString(),CompareType.EQUALS));
		
        evi.setFilter(filter);
		final KDBizPromptBox kdtEntrys_henHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");
        kdtEntrys_henHouse_PromptBox.setVisible(true);
        kdtEntrys_henHouse_PromptBox.setEditable(true);
        kdtEntrys_henHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setCommitFormat("$number$");
        
        SorterItemCollection sorter = new SorterItemCollection();
        SorterItemInfo sortItem = new SorterItemInfo("bizDate");
        sortItem.setSortType(SortType.DESCEND);
        sorter.add(sortItem);
        evi.setSorter(sorter);
        
        kdtEntrys_henHouse_PromptBox.setEntityViewInfo(evi);
        KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
        this.kdtEntrys.getColumn("breedBatch").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("breedBatch").setRenderer(kdtEntrys_henHouse_OVR);
			
			
	       
		
	}
    @Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)||FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.FINISH)) {
    		MsgBox.showWarning("单据已经审核或完成，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)||FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.FINISH)) {
    		MsgBox.showWarning("单据已经审核或完成，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
	}
	/**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)||FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.FINISH)) {
    		MsgBox.showWarning("单据已经审核或完成，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		this.loadData();
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
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)||FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.FINISH)) {
    		MsgBox.showWarning("单据已经尚未审核或者完成，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
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
        return com.kingdee.eas.farm.breed.business.CCLeaveBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
    	CCLeaveBillEntryInfo newEntryInfo = new CCLeaveBillEntryInfo();
    	newEntryInfo.setBreedBatch(currBreedBatchInfo);
    	if(currBreedBatchInfo != null && currBreedBatchInfo.getCostObject() != null ){
    		if(currBreedBatchInfo.getCostObject() != null && StringUtils.isBlank(currBreedBatchInfo.getCostObject().getBatchNumber())){
    			// TODO  获取一下成本对象
    			
    		}
    		newEntryInfo.setBatch(currBreedBatchInfo.getCostObject().getBatchNumber());
    	}
        return  newEntryInfo;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.business.CCLeaveBillInfo objectValue = new com.kingdee.eas.farm.breed.business.CCLeaveBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        StorageOrgUnitInfo stroageUnitOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        if(stroageUnitOrgInfo.isIsBizUnit())
        	objectValue.setStorageOrgUnit(stroageUnitOrgInfo);
        objectValue.getEntrys().add(new CCLeaveBillEntryInfo());
        return objectValue;
    }
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		StorageBizUnitF7 storageF7 = new StorageBizUnitF7();
		storageF7.setIsCUFilter(true);
		this.prmtStorageOrgUnit.setSelector(storageF7);
		this.prmtStorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				storageOrgUnitChanged(e);
			}});
		
		this.contLastUpdateUser.setVisible(true);
        this.contLastUpdateTime.setVisible(true);
        
        final KDBizPromptBox kdtEntrys_PromptBox = new KDBizPromptBox();
		F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this,kdtEntrys_PromptBox);
		m7.setBaseFilter(new FilterInfo());
		kdtEntrys_PromptBox.setSelector(m7);
		kdtEntrys_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_PromptBox.setEditFormat("$name$");
		kdtEntrys_PromptBox.setCommitFormat("$name$");
        KDTDefaultCellEditor kdtEntrys_CellEditor = new KDTDefaultCellEditor(kdtEntrys_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_CellEditor);
        
        this.prmtcar.setRequired(true);
        this.kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
        this.kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
        this.kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
        
        /*EntityViewInfo ev=new EntityViewInfo();
        final FilterInfo filter=new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("carType","1",CompareType.EQUALS));
        filter.setMaskString("#0");
		ev.setFilter(filter);
		//this.prmtcar.setEntityViewInfo(ev);
		
		this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$number$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(true);
        		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.publicdata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.publicdata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true,ctx);
					prmtcar_F7ListUI.setFilterForQuery(filter);
					prmtcar.setSelector(prmtcar_F7ListUI);
				}
			}
		});*/
	}
	/**
	 * 库存组织
	 * @param e
	 * @throws SQLException 
	 * @throws BOSException 
	 */
	private void  storageOrgUnitChanged(DataChangeEvent e)  {
		//仓库过滤条件
		if(this.prmtStorageOrgUnit.getValue()!=null) {
			try{
				StorageOrgUnitInfo companyInfo = (StorageOrgUnitInfo) this.prmtStorageOrgUnit.getValue();
				setWarehouseFilter("warehouse",companyInfo.getId().toString());//仓库过滤条件
			}catch(Exception e1){}
		}else {
			setWarehouseFilter("warehouse",null);//仓库过滤条件
		}
		
		
		
	}
	/**
	 * 设置仓库过滤条件
	 */
	private void setWarehouseFilter(String colName,String companyID) {
		final KDBizPromptBox kdtEntrys_warehouse_PromptBox = new KDBizPromptBox();
		kdtEntrys_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
		kdtEntrys_warehouse_PromptBox.setVisible(true);
		kdtEntrys_warehouse_PromptBox.setEditable(true);
		kdtEntrys_warehouse_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_warehouse_PromptBox.setEditFormat("$number$");
		kdtEntrys_warehouse_PromptBox.setCommitFormat("$number$");
		
		if(StringUtils.isNotBlank(companyID)) {
			EntityViewInfo ev=new EntityViewInfo();
	        FilterInfo filter=new FilterInfo();
	        filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",companyID,CompareType.EQUALS));
	        filter.getFilterItems().add(new FilterItemInfo("name","%料塔%",CompareType.NOTLIKE));
	        filter.setMaskString("#0 AND #1");
			ev.setFilter(filter);
			kdtEntrys_warehouse_PromptBox.setEntityViewInfo(ev);
		}
		
		KDTDefaultCellEditor kdtEntrys_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_warehouse_PromptBox);
		this.kdtEntrys.getColumn(colName).setEditor(kdtEntrys_warehouse_CellEditor);
		ObjectValueRender kdtEntrys_warehouse_OVR = new ObjectValueRender();
		kdtEntrys_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn(colName).setRenderer(kdtEntrys_warehouse_OVR);
	}
	
	
	
    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	super.kdtEntrys_Changed(rowIndex, colIndex);
    	
    	// 养殖批次更新时自动将批次号带到分录中
    	 if ("breedBatch".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
    		 BreedBatchInfo currBatch = (BreedBatchInfo) this.kdtEntrys.getCell(rowIndex, colIndex).getValue();
    		 if(currBatch != null){
    			 CostObjectInfo currCostInfo = currBatch.getCostObject();
    			 if(currCostInfo == null){
    				 currBatch = BreedBatchFactory.getRemoteInstance().getBreedBatchInfo(new ObjectUuidPK(currBatch.getId().toString()));
    				 currCostInfo = currBatch.getCostObject();
    			 }
    			 
				 String currCostNumber = currCostInfo.getBatchNumber();
				 if(StringUtils.isBlank(currCostNumber)){
					 currCostInfo = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(currCostInfo.getId()));
					 currCostNumber = currCostInfo.getBatchNumber();
				 }
				 
				 this.kdtEntrys.getCell(rowIndex, "batch").setValue(currCostNumber);
    			 
    		 }else{
    			 this.kdtEntrys.getCell(rowIndex, "batch").setValue("");
    		 }
    		 
    		 this.kdtEntrys.getCell(rowIndex, "batch").getStyleAttributes().setLocked(false);
    	 }
    }
//            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
//kdtEntrys.getCell(rowIndex,"materialNum").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));
//
//}
//
//    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
//kdtEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));
//
//}
//
//    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
//kdtEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"baseUnit"));
//
//}

}