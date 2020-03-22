/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.ChikenType;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class AddBatchEntryUI extends AbstractAddBatchEntryUI
{
    private static final Logger logger = CoreUIObject.getLogger(AddBatchEntryUI.class);
    
    private StorageOrgUnitInfo currentOrg;
    
    /**
     * output class constructor
     */
    public AddBatchEntryUI() throws Exception
    {
        super();
    }
    
    
    
    @Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		// 当前库存组织
		currentOrg = SysContext.getSysContext().getCurrentStorageUnit();
		if(currentOrg == null){
			MsgBox.showInfo("请先切换到对应的养殖场再修改批次信息");
			SysUtil.abort();
		}
		// 设置库存组织
		setStorageOrgUnit(currentOrg,null);
        
		
	}

    /**
     * 设置 库存组织信息到 控件中
     * 并且 更新相关过滤条件
     * @param orgInfo
     */
    private void setStorageOrgUnit(StorageOrgUnitInfo orgInfo,BreedBatchInfo batchInfo){
    	this.currentOrg = orgInfo;
    	
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
		
		
        prmtHenhouse.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseQuery");
        prmtHenhouse.setVisible(true);
        prmtHenhouse.setEditable(true);
        prmtHenhouse.setDisplayFormat("$number$");
        prmtHenhouse.setEditFormat("$number$");
        prmtHenhouse.setCommitFormat("$number$");
        prmtHenhouse.setEntityViewInfo(view);
        
        
        // 批次过滤条件
		this.prmtBatchNumber.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");
		this.prmtBatchNumber.setVisible(true);		
        this.prmtBatchNumber.setEditable(true);		
        this.prmtBatchNumber.setDisplayFormat("$name$");		
        this.prmtBatchNumber.setEditFormat("$number$");		
        this.prmtBatchNumber.setCommitFormat("$number$");
        EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
      
//        filter.getFilterItems().add(new FilterItemInfo("CU.id",orgInfo.getId().toString(),CompareType.EQUALS));
        
        // 设置默认当前库存组织所有鸡舍信息
        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",orgInfo.getId().toString(),CompareType.EQUALS));
        evi.setFilter(filter);
        this.prmtBatchNumber.setEntityViewInfo(evi);
        
        // 商品鸡 设置鸡舍类别不可选择
        if(batchInfo != null && HenhouseType.CC.equals(batchInfo.getHouseType())){
        	this.cbChickentype.setSelectedItem(ChikenType.CommecialChiken);
        	this.cbChickentype.setEditable(false);
        }else{
        	this.cbChickentype.setSelectedItem(null);
        	this.cbChickentype.setEditable(true);
        }
        
    }

	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * 批次编码变化
     */
    @Override
	protected void prmtBatchNumber_dataChanged(DataChangeEvent e)
			throws Exception {
    	 // 批次信息
        BreedBatchInfo batchInfo = (BreedBatchInfo) prmtBatchNumber.getValue();
        
        // 设置库存组织
		setStorageOrgUnit(currentOrg,batchInfo);
	}



	/**
     * output btnConfirm_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnConfirm_actionPerformed(e);
        
        // 批次信息
        BreedBatchInfo batchInfo = (BreedBatchInfo) prmtBatchNumber.getValue();
       
        // 鸡舍信息
        HenhouseInfo henhouseInfo = (HenhouseInfo) prmtHenhouse.getValue();
        // 鸡类别
        ChikenType chikenType = (ChikenType) cbChickentype.getSelectedItem();
        
        if(batchInfo == null){
        	MsgBox.showInfo("养殖批次不能为空");
        	SysUtil.abort();
        }
        if(henhouseInfo == null){
        	MsgBox.showInfo("鸡舍不能为空");
        	SysUtil.abort();
        }
        
        
        
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnCancel_actionPerformed(e);
    }

    
}