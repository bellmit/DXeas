/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.billStatus;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DiscountRecordBillEditUI extends AbstractDiscountRecordBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DiscountRecordBillEditUI.class);
    
    /**
     * output class constructor
     */
    public DiscountRecordBillEditUI() throws Exception
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

   
//    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUIComponets();
//		// 非手动创建单据界面锁定
//		initUIStateByBillSourceType();
		
		
	}
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salediscount.DiscountRecordBillFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo objectValue = new com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setStatus(billStatus.save);
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
    
    
  
	/**
	 * 设置默认值
	 */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("status",new Integer(2));
//		vo.put("sourceType","TA");
        
    } 
	/**
     * 重载单据内容
     * @throws Exception 
     * @throws BOSException 
     * @throws EASBizException 
     */
	private void reloadData() throws EASBizException, BOSException, Exception{
		if(this.editData != null && this.editData.getId() != null){
//			this.editData = ((IDiscountRecordBill)this.getBizInterface()).getDiscountRecordBillInfo(new ObjectUuidPK(this.editData.getId()));
//			this.status.setSelectedItem(this.editData.getStatus());
//			this.loadData();
//			this.setDataObject(this.editData);
//			loadFields();
//			this.ref
			IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
	        IObjectValue iObjectValue = getValue(iObjectPk);
	        setDataObject(iObjectValue);
	        loadFields();
	        setSave(true);
			
//			this.loadFields();
//			this.initOldData(this.editData);
//			this.status.setEnabled(false);
		}
	}
    /**
     * 初始化界面功能、按钮显示属性
     */
	private void initUIComponets() {
//		this.status.setEditable(false);
//		this.btnAddLine.setVisible(false);
//		this.btnInsertLine.setVisible(false);
//		this.btnRemoveLine.setVisible(false);
//		this.btnRemove.setVisible(false);
//		this.btnAddNew.setVisible(false);
//		this.btnEdit.setVisible(false);
//		
//		this.kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
//		this.kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
//		this.kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
//		
		this.status.setEditable(false);
		this.status.setEnabled(false);
		this.pkauditTime.setEditable(false);
		this.pkauditTime.setEnabled(false);
		
		
		this.txtamount.setEnabled(false);
		this.txtamount.setEditable(false);
		
//		this.chkisConfirmed.setEnabled(false);
//		this.chkisConfirmed.setEditable(false);
		
		this.chkisInitBill.setEnabled(false);
		this.chkisInitBill.setEditable(false);
		// 手工添加时只能是初始化单
		if(this.getOprtState().equals("ADDNEW")){
			this.chkisInitBill.setSelected(true);
		}
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
		
		this.btnSubmit.setEnabled(true);
		this.actionSubmit.setEnabled(true);
		
		this.btnDelVoucher.setVisible(false);
		this.btnVoucher.setVisible(false);
		// 设置界面全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 新增时设置 单据来源为手动
		if("ADDNEW".equals(getOprtState())){
			
		}
		
		
		
		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		// 添加财务组织条件
		filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
		evi.setFilter(filterInfo);
    	// 设置F7查询元数据
		String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
//		prmtCustomer.setQueryInfo(queryInfo);
		// 设置主业务组织
		prmtcustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// 设置客户F7的过滤条件
		prmtcustomer.setEntityViewInfo(evi);
		prmtcustomer.setCommitFormat("$number$");//提交格式
		prmtcustomer.setDisplayFormat("$number$");//显示格式
		prmtcustomer.setEditFormat("$number$");//编辑格式
		prmtcustomer.setEnabledMultiSelection(false);
		// 设置客户F7展现形式为左树右表
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtcustomer,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"companyOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(false);
		prmtcustomer.setSelector(selectorAdaptor);
		prmtcustomer.addSelectorListener(selectorAdaptor);
		
		
		
		KDBizPromptBox prmtMaterial = new KDBizPromptBox();
		
	     prmtMaterial.setEditable(true);
	     prmtMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialSalesNoGroupQuery");
	     prmtMaterial.setDisplayFormat("$number$");
	     prmtMaterial.setEditFormat("$number$");
	    
	     prmtMaterial.setCommitFormat("$number$;$name$;$model$;$helpCode$");
	     SaleOrgUnitInfo saleOrgUnitInfo = SysContext.getSysContext().getCurrentSaleUnit();
	     prmtMaterial.setCurrentMainBizOrgUnit(saleOrgUnitInfo, OrgType.Sale);
	     EntityViewInfo viewInfo = new EntityViewInfo();
	     filterInfo = new FilterInfo();
//		     filterInfo.getFilterItems().add(new FilterItemInfo("materialGroup.id", ((MaterialGroupInfo)(MaterialGroupInfo)this.kdtEntries.getCell(row, "materialGroup").getValue()).getId().toString(), CompareType.EQUALS));
	 
	     filterInfo.getFilterItems().add(new FilterItemInfo("Sales.status", String.valueOf(com.kingdee.eas.basedata.master.material.UsedStatusEnum.APPROVED.getValue()), CompareType.EQUALS));
	 
	     filterInfo.getFilterItems().add(new FilterItemInfo("status", new Integer(1)));

//		     SaleOrgUnitInfo saleOrgUnitInfo = SysContext.getSysContext().getCurrentSaleUnit();
//		     if(saleOrgUnitInfo!= null){
//		    	 filterInfo.getFilterItems().add(new FilterItemInfo("SaleOrgUnit.id", saleOrgUnitInfo.getId().toString(), CompareType.EQUALS));
//		     }
//		     if (this.prmtSaleOrgUnit.getValue() != null) {
//		       filterInfo.getFilterItems().add(new FilterItemInfo("SaleOrgUnit.id", ((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getValue()).getId().toString(), CompareType.INCLUDE));
//		     }
	 
	     viewInfo.setFilter(filterInfo);
	    GeneralKDPromptSelectorAdaptor selectorLisenter = null;
	    selectorLisenter = new GeneralKDPromptSelectorAdaptor(prmtMaterial,
	 		"com.kingdee.eas.basedata.master.material.client.F7MaterialTreeListUI",
	 		this, 
	 		MaterialGroupInfo.getBosType(),
	 		QueryInfoConstants.MATERIAL_SALE, 
	 		"BrowserGroup.id", 
	 		QueryInfoConstants.getMaterialQueryOrgId(OrgType.Sale));

	     selectorLisenter.setIsMultiSelect(false);
	     prmtMaterial.setSelector(selectorLisenter);
	     prmtMaterial.setEntityViewInfo(viewInfo);
//		     prmtMaterial.getQueryAgent().resetRuntimeEntityView();
	     prmtMaterial.setEnabledMultiSelection(false);
	     
	     KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(prmtMaterial);
	        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
	        
	        
	     // 默认值
	     if(("VIEW".equals(getOprtState()) || "EDIT".equals(getOprtState())) && this.status.getSelectedItem() == null){
	    	 this.editData.setStatus(com.kingdee.eas.custom.salediscount.billStatus.save);
	    	 this.status.setSelectedItem(com.kingdee.eas.custom.salediscount.billStatus.save);
	     }
	}
	
	/**
	 * 保存方法
	 * 
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// 更新单据头 金额  税额
//		updateHeaderAmount();
		if(this.editData != null && this.editData.getId() != null && !this.editData.getStatus().equals(billStatus.save)){
			MsgBox.showWarning("不能保存已经提交或者审核的单据");
			SysUtil.abort();
		}
		try{
			super.actionSave_actionPerformed(e);
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
		
		
	}
	/**
	 * 提交前验证
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
//		updateHeaderAmount();
		if(this.editData != null && this.editData.getId() != null && this.editData.getStatus().equals(billStatus.audit)){
			MsgBox.showWarning("不能提交已经审核的单据");
			SysUtil.abort();
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtamount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"总金额"});
		}
		try{
			super.actionSubmit_actionPerformed(e);
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
		
	}
	
	
	/**
	 * 审核
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getStatus().equals(billStatus.submit)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
			SysUtil.abort();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
		
	}
	/**
	 * 反审核
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getStatus().equals(billStatus.audit)){
			MsgBox.showWarning("不能反审核未审核的单据");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("反审核完成");
			reloadData();
			SysUtil.abort();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
		
	}
	
	 /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
    	super.kdtEntrys_Changed(rowIndex, colIndex);
    	// 如果是  折让金额 发生变化  则 重新计算 单据头
    	if("discountAmount".equals(this.getDetailTable().getColumn(colIndex).getKey())){
    		updateAmount();
    	}
    	
    	
    }
    /**
     * 更新单据头 金额合计
     */
    private void updateAmount(){
    	int rowCount = this.getDetailTable().getRowCount();
    	BigDecimal amount =new BigDecimal("0");
    	for(int i = 0; i < rowCount ; i++){
    		BigDecimal discountAmount = (BigDecimal) this.getDetailTable().getCell(i, "discountAmount").getValue();
    		if(discountAmount != null){
    			amount = amount.add(discountAmount);
    		}
    	}
    	
    	this.txtamount.setValue(amount);
    }
          

}