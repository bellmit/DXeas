/**
 * output package name
 */
package com.kingdee.eas.farm.pig.ccpig.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.pig.PigFarmInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CCPigBatchEditUI extends AbstractCCPigBatchEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCPigBatchEditUI.class);
    
    
    private DataChangeListener bizDateDataChangeListener;
    private DataChangeListener batchDataChangeListener;
    private DataChangeListener pigfarmDataChangeListener;
    

    private PigFarmInfo currFarmInfo;
    /**
     * output class constructor
     */
    public CCPigBatchEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	removeLisenters();
        super.loadFields();

        
        this.currFarmInfo = (PigFarmInfo) prmtpigFarm.getValue();
        if(currFarmInfo != null){
        	
        	setPigFarm(currFarmInfo);
			
        }
        addLisenters();
    }

    /**
     * 清空监听
     */
    private void removeLisenters(){
    	
    	if(pigfarmDataChangeListener != null){
    		this.prmtpigFarm.removeDataChangeListener(pigfarmDataChangeListener);
    	}
    	
    }
    
    /**
     * 添加监听
     */
    private void addLisenters(){

        pigfarmDataChangeListener  = new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpigFarm_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }

			
        };
        this.prmtpigFarm.addDataChangeListener(pigfarmDataChangeListener);
    }
    
    
    /**
     * 养殖场值变化事件
     * @param e
     */
    private void prmtpigFarm_dataChanged(DataChangeEvent e) {
    	// 获取批次明细信息
    	PigFarmInfo oldFarmInfo = (PigFarmInfo) e.getOldValue();
    	PigFarmInfo newFarmInfo = (PigFarmInfo) e.getNewValue();
    	
    	
    	// 删除批次后 清理分录信息
    	if(newFarmInfo == null){
    		if(MsgBox.showConfirm2("删除养殖场，会同步清空批次和分录明细,确定删除？") == MsgBox.OK){
    			
    			clearAllEntrys();
    			return;
    		}else{
    			removeLisenters();
    			this.prmtpigFarm.setValue(oldFarmInfo);
    			addLisenters();
    			return;
    		}
    	}else{
    		currFarmInfo = newFarmInfo;
    		
			clearAllEntrys();
    		setPigFarm(currFarmInfo);
    	}
    	
    	
		
	}
    
    /**
     * 清空所有分录
     */
    private void clearAllEntrys(){
    	// 清理分录明细
    	this.kdtEntrys.removeRows();
    	
    	this.editData.getEntrys().clear();
    	
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
    	
        super.storeFields();
    }
    
    /**
     * 初始化
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 初始化
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
			// 如果所在组织不是 养殖场，则不允许 新增修改操作
			
			
		}else {
			if(this.getOprtState().equals("EDIT")){
//				checkCanEdit();
				
			}
			// 初始界面数据
//			initData();
		}
		
		 // 设置默认当前库存组织所有猪舍信息
        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
        if(currStorageOrgInfo == null){
        	MsgBox.showInfo("当前未在任何库存组织中，不能进行新增养殖日报操作");
        	SysUtil.abort();
        }
        
//        this.kdtAssEntrys.getColumn("days").getStyleAttributes().setLocked(true);
//        this.kdtAssEntrys.getColumn("breedingStock").getStyleAttributes().setLocked(true);
//      // 更新库存组织
        setPigFarm(null);
        // 设置成本对象过滤条件
        setCostObjectFilter();
        // 设置默认的仔猪来源过滤条件为空
        setPigsourceCostobjFilter(null,0,true);
	}
	/**
	 * 更新仔猪来源后 同步更新仔猪批次过滤条件
	 */
	@Override
	protected void kdtPigletBatchEntry_editStopped(KDTEditEvent e)
			throws Exception {
		int rowIndex = e.getRowIndex();
		int colIndex = e.getColIndex();
		if(colIndex == kdtPigletBatchEntry.getColumn("company").getColumnIndex()){
			CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) kdtPigletBatchEntry.getCell(rowIndex, colIndex).getValue();
			// 更新成本对象过滤条件
			setPigsourceCostobjFilter(companyInfo, rowIndex, false);
		}
	}
    /**
     * 设置仔猪来源过滤条件
     * @param companyInfo
     * @param rowIndex
     */
    private void setPigsourceCostobjFilter(CompanyOrgUnitInfo companyInfo, int rowIndex, boolean isAll){
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(companyInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("company.id",companyInfo.getId().toString(),CompareType.EQUALS));
			
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("company.id","",CompareType.EQUALS));
		}
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%猪舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_costobj_PromptBox = new KDBizPromptBox();
        kdtEntrys_costobj_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEntrys_costobj_PromptBox.setVisible(true);
        kdtEntrys_costobj_PromptBox.setEditable(true);
        kdtEntrys_costobj_PromptBox.setDisplayFormat("$name$");
        kdtEntrys_costobj_PromptBox.setEditFormat("$number$");
        kdtEntrys_costobj_PromptBox.setCommitFormat("$number$");
        kdtEntrys_costobj_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_costobj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costobj_PromptBox);
        // 仔猪来源
        if(!isAll){
        	this.kdtPigletBatchEntry.getCell(rowIndex,"costObject").setEditor(kdtEntrys_costobj_CellEditor);
        }else{
        	this.kdtPigletBatchEntry.getColumn("costObject").setEditor(kdtEntrys_costobj_CellEditor);
        }
    }
    /**
     * 设置 养殖场到 控件中并且 更新相关过滤条件
     * @param orgInfo
     * @throws BOSException 
     */
    private void setPigFarm(PigFarmInfo currFarmInfo) {
    	try{
	    	// 更新各个分录中仓库的 过滤条件
	    	 // 仓库添加过滤条件
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
	//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
			if(currFarmInfo != null){
				filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id",currFarmInfo.getId().toString(),CompareType.EQUALS));
			}else{
				filterInfo.getFilterItems().add(new FilterItemInfo("pigFarm.id","",CompareType.EQUALS));
			}
	//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%猪舍%",CompareType.LIKE));
			view.setFilter(filterInfo);
			
			final KDBizPromptBox kdtEntrys_pighouse_PromptBox = new KDBizPromptBox();
	        kdtEntrys_pighouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
	        kdtEntrys_pighouse_PromptBox.setVisible(true);
	        kdtEntrys_pighouse_PromptBox.setEditable(true);
	        kdtEntrys_pighouse_PromptBox.setDisplayFormat("$name$");
	        kdtEntrys_pighouse_PromptBox.setEditFormat("$number$");
	        kdtEntrys_pighouse_PromptBox.setCommitFormat("$number$");
	        kdtEntrys_pighouse_PromptBox.setEntityViewInfo(view);
	        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pighouse_PromptBox);
	        // 饲喂信息
	        this.kdtEntrys.getColumn("pigHouse").setEditor(kdtEntrys_henhouse_CellEditor);
	        // 水电信息
	//        this.kdtWEEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
	        // 燃料信息
	//        this.kdtFuelEntrys.getColumn("henhouse").setEditor(kdtEntrys_warehouse_CellEditor);
	        // 疫苗信息
	//        this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
	        // 其他信息
	//        this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
	        
	        
    	}catch (Exception e) {
    		e.printStackTrace();
			this.handleException(e);
		}
        
    }
    
    /**
     * 设置成本对象过滤条件
     */
    private void setCostObjectFilter(){
    	 // 设置 成本对象过滤条件
        EntityViewInfo view = new EntityViewInfo();
        FilterInfo filterInfo = new FilterInfo();
        CompanyOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentFIUnit();
        filterInfo.getFilterItems().add(new FilterItemInfo("company.id",orgInfo.getId().toString(),CompareType.EQUALS));
//		filterInfo.getFilterItems().add(new FilterItemInfo("StorageOrgUnit.name",orgInfo.getName(),CompareType.EQUALS));
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","商品鸡%",CompareType.LIKE));
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","父母代%",CompareType.LIKE));//add by dai 20150820
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","商品鸡苗%",CompareType.NOTLIKE));
//		filterInfo.setMaskString("(#0 or #1) and (#2 or #3 ) and #4");
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","",CompareType.LIKE));
		SorterItemInfo sortItem = new SorterItemInfo("number");
		sortItem.setSortType(SortType.DESCEND);
		view.getSorter().add(sortItem);
		view.setFilter(filterInfo);
		
		this.prmtcostObject.setEntityViewInfo(view);
    }
    
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.ccpig.CCPigBatchFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo objectValue = new com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
  
    @Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
    	if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem())){
			try{
				
				
				super.actionSave_actionPerformed(e);
				
			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}
			
			
		}else{
			MsgBox.showWarning("只能保存新增或者保存的单据");
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
	
	
	
	@Override
	public void actionUpdateBatchMarket_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionUpdateBatchMarket_actionPerformed(e);
	}

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

}