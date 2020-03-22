/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.EventListener;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.DecimalFormatEx;
import com.kingdee.bos.ctrl.swing.NumberFormatterEx;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.salepayment.IndexType;
import com.kingdee.eas.custom.salepayment.Quarter;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class AreaTargetEditUI extends AbstractAreaTargetEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AreaTargetEditUI.class);
    
    /**
     * output class constructor
     */
    public AreaTargetEditUI() throws Exception
    {
        super();
        
        DecimalFormatEx dfEx = new DecimalFormatEx("##");
        NumberFormatterEx formatter = new NumberFormatterEx();
        formatter.setFormat(dfEx);
        this.txtyear.setDisplayFormatter(formatter);
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        
     // 
   	 // prmtarea		
      
       // prmtcompanyTargetInfo	
      
    }

    /**
     * 初始化界面组件    大区、公司指标
     */
    public void initUIP(){
    	super.initUIP();
    	
     
			
    }
    
    /**
     * 设置公司过滤条件
     */
    private void setCompanyFilter(CompanyOrgUnitInfo companyInfo){
    	
    	
    	String companyID = "";
    	String companyName = "";
    	if(companyInfo != null){
    		companyID = companyInfo.getId().toString();
    		companyName = companyInfo.getName();
    	}
    	// 设置大区公司过滤
    	FilterInfo commpanyFilter = new FilterInfo();
    	commpanyFilter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
    	
    	EntityViewInfo	areaEVI = new EntityViewInfo();
    	areaEVI.setFilter(commpanyFilter);
    	
    	this.prmtarea.setQueryInfo("com.kingdee.eas.custom.salepayment.app.AreaSetF7Query");		
        this.prmtarea.setEditable(true);		
        this.prmtarea.setDisplayFormat("$name$");		
        this.prmtarea.setEditFormat("$number$");		
        this.prmtarea.setCommitFormat("$number$");		
        this.prmtarea.setRequired(false);
    	this.prmtarea.setEntityViewInfo(areaEVI);
    	prmtarea.setValue(null);
    	
    	// 设置公司指标过滤
    	FilterInfo commpanyFilter1 = new FilterInfo();
    	commpanyFilter1.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
    	commpanyFilter1.getFilterItems().add(new FilterItemInfo("CU.id",companyID,CompareType.EQUALS));
    	
    	EntityViewInfo	companyPEVI = new EntityViewInfo();
    	companyPEVI.setFilter(commpanyFilter1);
    	
    	
    	this.prmtcompanyTargetInfo = new KDBizPromptBox();
        this.prmtcompanyTargetInfo.setQueryInfo("com.kingdee.eas.custom.salepayment.app.CompanyTargetF7Query");		
        this.prmtcompanyTargetInfo.setVisible(true);		
        this.prmtcompanyTargetInfo.setEditable(true);		
        this.prmtcompanyTargetInfo.setDisplayFormat("$number$");		
        this.prmtcompanyTargetInfo.setEditFormat("$number$");		
        this.prmtcompanyTargetInfo.setCommitFormat("$number$");		
        this.prmtcompanyTargetInfo.setRequired(false);
    	this.prmtcompanyTargetInfo.setEntityViewInfo(companyPEVI);
    	this.prmtcompanyTargetInfo.setValue(null);
    }
    
    /**
     * 公司变化
     */
    protected void prmtcompany_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) this.prmtcompany.getValue();
        // 设置公司过滤条件
        setCompanyFilter(companyInfo);
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
        return com.kingdee.eas.custom.salepayment.AreaTargetFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.custom.salepayment.AreaTargetTreeInfo)getUIContext().get(UIContext.PARENTNODE));
            String treeName = this.editData.getTreeid().getName();
            if(StringUtils.isNotBlank(treeName)){
            	int year = Integer.parseInt(treeName);
            	editData.put("year", year);
            }
        }
    }
    /**
     * 添加校验  指标类型和 季度 选中值
     */
    public void beforeStoreFields(ActionEvent e) throws Exception{
    	super.beforeStoreFields(e);
    	// 
    	IndexType selType =  (IndexType) this.indexType.getSelectedItem();
    	if(selType != null){
    		Quarter selQuarter = (Quarter) this.quarter.getSelectedItem();
    		// 校验 季度 是否与 指标类型匹配
    		if(selQuarter != null){
    			if(IndexType.YEAR_VALUE.equals(selType.getValue()) && !Quarter.WHOLEYEAR_VALUE.equals(selQuarter.getValue())){
    				MsgBox.showInfo("指标类型为【年】时，季度只能选【整年】");
    				SysUtil.abort();
    			}else if(IndexType.QUARTER_VALUE.equals(selType.getValue()) && Quarter.WHOLEYEAR_VALUE.equals(selQuarter.getValue())){
    				MsgBox.showInfo("指标类型为【季度】时，季度不能选【整年】");
    				SysUtil.abort();
    			}
    		}
    	}
    	
    }
    
    
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.AreaTargetInfo objectValue = new com.kingdee.eas.custom.salepayment.AreaTargetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        return objectValue;
    }
    /**
     * 界面初始化
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
//		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		
	}

    /**
     * 分录更新
     */
	@Override
	public void kdtSalerEntry_Changed(int rowIndex, int colIndex)
			throws Exception {
		// 自动调用上级功能
		super.kdtSalerEntry_Changed(rowIndex, colIndex);
		
		if(colIndex == this.kdtSalerEntry.getColumnIndex("profitTarget")){
			updateAreaProfitSum();
		}
	}
	
	/**
	 * 更新区域指标合计
	 */
	private void updateAreaProfitSum() {
		Integer profitSum = 0;
		for(int i = 0; i < this.kdtSalerEntry.getRowCount(); i++){
			Integer areaProfit = (Integer) this.kdtSalerEntry.getCell(i, "profitTarget").getValue();
			if(areaProfit != null){
				profitSum = profitSum + areaProfit;
			}
			 
		}
		// 设置区域合计
		this.txtsalerProfitSum.setValue(profitSum);
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
			MsgBox.showWarning("只能反审核处于审核状态的单据");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	/**
	 * 提交前校验
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.NULL.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
		
				super.actionSubmit_actionPerformed(e);
				
			
			
			
		}else{
			MsgBox.showWarning("只能提交未审核的单据");
			SysUtil.abort();
		}
	}
	
}