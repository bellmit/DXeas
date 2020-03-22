/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.common.util.StringUtil;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.client.MaterialGroupPromptBox;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryInfo;
import com.kingdee.eas.custom.salediscount.DiscountTypeEnum;
import com.kingdee.eas.custom.salediscount.EntryState;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DSEntryBatchAddUI extends AbstractDSEntryBatchAddUI
{
    private static final Logger logger = CoreUIObject.getLogger(DSEntryBatchAddUI.class);
    
    /**
     * output class constructor
     */
    public DSEntryBatchAddUI() throws Exception
    {
        super();
       
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUI();
	}

	/**
     * 初始化界面内容
     * @throws Exception 
     */
    private void initUI() throws Exception{
    	Map context = this.getUIContext();
    	if(context != null && context.containsKey("dsType")){
    		DiscountTypeEnum dsType = (DiscountTypeEnum)context.get("dsType");
    		if(DiscountTypeEnum.ShiWu.equals(dsType)){
    			this.lbStandard1.setVisible(false);
    			this.ftfStandard1.setVisible(false);
    			this.lbStandard2.setVisible(false);
    			this.ftfStandard2.setVisible(false);
    			this.lbStandard3.setVisible(false);
    			this.ftfStandard3.setVisible(false);
    			this.lbStandard4.setVisible(false);
    			this.ftfStandard4.setVisible(false);
    			this.lbStandard5.setVisible(false);
    			this.ftfStandard5.setVisible(false);
    			
    			
    			
    			this.lbSwQty1.setVisible(true);
    			this.ftfSwQty1.setVisible(true);
    			this.lbSwStandard1.setVisible(true);
    			this.ftfSwStandard1.setVisible(true);
    			
    			this.lbSwQty2.setVisible(true);
    			this.ftfSwQty2.setVisible(true);
    			this.lbSwStandard2.setVisible(true);
    			this.ftfSwStandard2.setVisible(true);
    			
    			this.lbSwQty3.setVisible(true);
    			this.ftfSwQty3.setVisible(true);
    			this.lbSwStandard3.setVisible(true);
    			this.ftfSwStandard3.setVisible(true);
    			
    			this.lbSwQty4.setVisible(true);
    			this.ftfSwQty4.setVisible(true);
    			this.lbSwStandard4.setVisible(true);
    			this.ftfSwStandard4.setVisible(true);
    			
    			this.lbSwQty5.setVisible(true);
    			this.ftfSwQty5.setVisible(true);
    			this.lbSwStandard5.setVisible(true);
    			this.ftfSwStandard5.setVisible(true);
    			
    			
    		}else{
    			this.lbStandard1.setVisible(true);
    			this.ftfStandard1.setVisible(true);
    			this.lbStandard2.setVisible(true);
    			this.ftfStandard2.setVisible(true);
    			this.lbStandard3.setVisible(true);
    			this.ftfStandard3.setVisible(true);
    			this.lbStandard4.setVisible(true);
    			this.ftfStandard4.setVisible(true);
    			this.lbStandard5.setVisible(true);
    			this.ftfStandard5.setVisible(true);
    			
    			
    			
    			this.lbSwQty1.setVisible(false);
    			this.ftfSwQty1.setVisible(false);
    			this.lbSwStandard1.setVisible(false);
    			this.ftfSwStandard1.setVisible(false);
    			
    			this.lbSwQty2.setVisible(false);
    			this.ftfSwQty2.setVisible(false);
    			this.lbSwStandard2.setVisible(false);
    			this.ftfSwStandard2.setVisible(false);
    			
    			this.lbSwQty3.setVisible(false);
    			this.ftfSwQty3.setVisible(false);
    			this.lbSwStandard3.setVisible(false);
    			this.ftfSwStandard3.setVisible(false);
    			
    			this.lbSwQty4.setVisible(false);
    			this.ftfSwQty4.setVisible(false);
    			this.lbSwStandard4.setVisible(false);
    			this.ftfSwStandard4.setVisible(false);
    			
    			this.lbSwQty5.setVisible(false);
    			this.ftfSwQty5.setVisible(false);
    			this.lbSwStandard5.setVisible(false);
    			this.ftfSwStandard5.setVisible(false);
    			
    		}
    	}
//    	// 客户
//    	F7CustomerTreeDetailListUI customerF7Tree = new F7CustomerTreeDetailListUI();
//    	customerF7Tree.setQueryPK(parseQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery"));
    	
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
		prmtCustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// 设置客户F7的过滤条件
		prmtCustomer.setEntityViewInfo(evi);
		prmtCustomer.setCommitFormat("$number$");//提交格式
		prmtCustomer.setDisplayFormat("$number$");//显示格式
		prmtCustomer.setEditFormat("$number$");//编辑格式
		prmtCustomer.setEnabledMultiSelection(true);
		// 设置客户F7展现形式为左树右表
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtCustomer,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"companyOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(true);
		prmtCustomer.setSelector(selectorAdaptor);
		prmtCustomer.addSelectorListener(selectorAdaptor);
		
	    
	    
	     if (prmtMaterial == null) {
	       prmtMaterial = new KDBizPromptBox();
	     }
	     prmtMaterial.setEditable(true);
	     prmtMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialSalesNoGroupQuery");
	     prmtMaterial.setDisplayFormat("$number$");
	     prmtMaterial.setEditFormat("$number$");
	    
	     prmtMaterial.setCommitFormat("$number$;$name$;$model$;$helpCode$");
	     SaleOrgUnitInfo saleOrgUnitInfo = SysContext.getSysContext().getCurrentSaleUnit();
	     prmtMaterial.setCurrentMainBizOrgUnit(saleOrgUnitInfo, OrgType.Sale);
	     EntityViewInfo viewInfo = new EntityViewInfo();
	     filterInfo = new FilterInfo();
//	     filterInfo.getFilterItems().add(new FilterItemInfo("materialGroup.id", ((MaterialGroupInfo)(MaterialGroupInfo)this.kdtEntries.getCell(row, "materialGroup").getValue()).getId().toString(), CompareType.EQUALS));
	 
	     filterInfo.getFilterItems().add(new FilterItemInfo("Sales.status", String.valueOf(com.kingdee.eas.basedata.master.material.UsedStatusEnum.APPROVED.getValue()), CompareType.EQUALS));
	 
	     filterInfo.getFilterItems().add(new FilterItemInfo("status", new Integer(1)));

//	     SaleOrgUnitInfo saleOrgUnitInfo = SysContext.getSysContext().getCurrentSaleUnit();
//	     if(saleOrgUnitInfo!= null){
//	    	 filterInfo.getFilterItems().add(new FilterItemInfo("SaleOrgUnit.id", saleOrgUnitInfo.getId().toString(), CompareType.EQUALS));
//	     }
//	     if (this.prmtSaleOrgUnit.getValue() != null) {
//	       filterInfo.getFilterItems().add(new FilterItemInfo("SaleOrgUnit.id", ((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getValue()).getId().toString(), CompareType.INCLUDE));
//	     }
	 
	     viewInfo.setFilter(filterInfo);
	    GeneralKDPromptSelectorAdaptor selectorLisenter = null;
	    selectorLisenter = new GeneralKDPromptSelectorAdaptor(prmtMaterial,
	 		"com.kingdee.eas.basedata.master.material.client.F7MaterialTreeListUI",
	 		this, 
	 		MaterialGroupInfo.getBosType(),
	 		QueryInfoConstants.MATERIAL_SALE, 
	 		"BrowserGroup.id", 
	 		QueryInfoConstants.getMaterialQueryOrgId(OrgType.Sale));

	     selectorLisenter.setIsMultiSelect(true);
	     prmtMaterial.setSelector(selectorLisenter);
	     prmtMaterial.setEntityViewInfo(viewInfo);
//	     prmtMaterial.getQueryAgent().resetRuntimeEntityView();
	     prmtMaterial.setEnabledMultiSelection(true);
	    
	     
	     // 选择列
	     this.kdtCustomer.checkParsed();
	     this.kdtMaterial.checkParsed();
		KDCheckBox cb = new KDCheckBox();
		cb.setSelected(false);
		this.kdtCustomer.getColumn("selected").setEditor(
				new KDTDefaultCellEditor(cb));
		this.kdtMaterial.getColumn("selected").setEditor(
				new KDTDefaultCellEditor(cb));
    	// 物料设置
//		prmtMaterial.setCommitFormat("$number$");//提交格式
//		prmtMaterial.setDisplayFormat("$number$");//显示格式
//		prmtMaterial.setEditFormat("$number$");//编辑格式
//		GeneralKDPromptSelectorAdaptor selectorLisenter = null;
//      
//        selectorLisenter = new GeneralKDPromptSelectorAdaptor(prmtMaterial,
//        		"com.kingdee.eas.basedata.master.material.client.F7MaterialTreeListUI",
//        		this, 
//        		MaterialGroupInfo.getBosType(),
//        		QueryInfoConstants.MATERIAL_SALE, 
//        		"BrowserGroup.id", 
//        		QueryInfoConstants.getMaterialQueryOrgId(OrgType.Sale));
//
//        selectorLisenter.setIsMultiSelect(true);
//       
//        prmtMaterial.setQueryInfo(QueryInfoConstants.MATERIAL_SALE);
//        prmtMaterial.setSelector(selectorLisenter);
//        prmtMaterial.addSelectorListener(selectorLisenter);
//        prmtMaterial.setEnabledMultiSelection(true);
//        
//        selectorLisenter.setQueryProperty("helpCode", "or");
		
		
		// 物料分类f7
		MaterialGroupPromptBox groupBox = new MaterialGroupPromptBox(this);
//	    KDBizPromptBox bizMaterialGroupBox = new KDBizPromptBox();
	    prmtMaterialGroup.setEditFormat("$number$");
	    prmtMaterialGroup.setDisplayFormat("$name$");
	    prmtMaterialGroup.setCommitFormat("$number$");
	    prmtMaterialGroup.setSelector(groupBox);
		
	
    }

    protected MetaDataPK parseQueryInfo(String info)
    /*      */   {
    /*  835 */     if (StringUtil.isEmptyString(info))
    /*      */     {
    /*  837 */       return null;
    /*      */     }
    /*      */ 
    /*  840 */     int pos = info.lastIndexOf(46);
    /*  841 */     if (pos < 0)
    /*      */     {
    /*  843 */       return null;
    /*      */     }
    /*      */ 
    /*  846 */     String packageName = info.substring(0, pos);
    /*  847 */     String className = info.substring(pos + 1);
    /*  848 */     return new MetaDataPK(packageName, className);
    /*      */   }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * 整理选中的客户和物料  根据笛卡尔积  算出 对应的
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        List<DiscountSetEntryInfo> DSEntrys = new ArrayList<DiscountSetEntryInfo>();
       

    	BigDecimal qty1 = this.ftfQty1.getBigDecimalValue();
    	BigDecimal standard1 = this.ftfStandard1.getBigDecimalValue();
    	BigDecimal qty2 = this.ftfQty2.getBigDecimalValue();
    	BigDecimal standard2 = this.ftfStandard2.getBigDecimalValue();
    	
    	BigDecimal swqty1 = this.ftfSwQty1.getBigDecimalValue();
    	BigDecimal swstandard1 = this.ftfSwStandard1.getBigDecimalValue();
    	BigDecimal swqty2 = this.ftfSwQty2.getBigDecimalValue();
    	BigDecimal swstandard2 = this.ftfSwStandard2.getBigDecimalValue();
    	
    	BigDecimal qty3 = this.ftfQty3.getBigDecimalValue();
    	BigDecimal standard3 = this.ftfStandard3.getBigDecimalValue();
    	BigDecimal swqty3 = this.ftfSwQty3.getBigDecimalValue();
    	BigDecimal swstandard3= this.ftfSwStandard3.getBigDecimalValue();
    
    	BigDecimal qty4 = this.ftfQty4.getBigDecimalValue();
    	BigDecimal standard4 = this.ftfStandard4.getBigDecimalValue();
    	BigDecimal swqty4 = this.ftfSwQty4.getBigDecimalValue();
    	BigDecimal swstandard4= this.ftfSwStandard4.getBigDecimalValue();
    	
    	BigDecimal qty5 = this.ftfQty5.getBigDecimalValue();
    	BigDecimal standard5 = this.ftfStandard5.getBigDecimalValue();
    	BigDecimal swqty5 = this.ftfSwQty5.getBigDecimalValue();
    	BigDecimal swstandard5= this.ftfSwStandard5.getBigDecimalValue();
    	
    	
       
     // 物料
    	for(int j = 0 ; j < this.kdtMaterial.getRowCount(); j++){
        	IRow currMRow = this.kdtMaterial.getRow(j);
        	MaterialInfo materialInfo = new MaterialInfo();
        	materialInfo.setId(BOSUuid.read((String)currMRow.getCell("materialID").getValue()));
        	materialInfo.setNumber((String)currMRow.getCell("number").getValue());
        	materialInfo.setName((String)currMRow.getCell("name").getValue());
        	
        	if(this.kdtCustomer.getRowCount() > 0){
             
		        // 整理客户信息
		        for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
		        	IRow currRow = this.kdtCustomer.getRow(i);
		        	CustomerInfo customerInfo = new CustomerInfo();
		        	
		        	customerInfo.setId(BOSUuid.read((String)currRow.getCell("customerID").getValue()));
		        	customerInfo.setNumber((String)currRow.getCell("number").getValue());
		        	customerInfo.setName((String)currRow.getCell("name").getValue());
	        	
	        	
	            	// 生成 折让设置分录
	            	DiscountSetEntryInfo newEntryInfo = new DiscountSetEntryInfo();
	            	newEntryInfo.setCustomer(customerInfo);
	            	newEntryInfo.setMaterial(materialInfo);
	            	newEntryInfo.setQty1(qty1);
	            	newEntryInfo.setQty2(qty2);
	            	newEntryInfo.setStandard1(standard1);
	            	newEntryInfo.setStandard2(standard2);
	            	
	            	newEntryInfo.setSwQty1(swqty1);
	            	newEntryInfo.setSwQty2(swqty2);
	            	newEntryInfo.setSwStandard1(swstandard1==null?0:swstandard1.intValue());
	            	newEntryInfo.setSwStandard2(swstandard2==null?0:swstandard2.intValue());
	            	
	            	newEntryInfo.setQty3(qty3);
	            	newEntryInfo.setStandard3(standard3);
	            	newEntryInfo.setSwQty3(swqty3);
	            	newEntryInfo.setSwStandard3(swstandard3==null?0:swstandard3.intValue());
	            	
	            	newEntryInfo.setQty4(qty4);
	            	newEntryInfo.setStandard4(standard4);
	            	newEntryInfo.setSwQty4(swqty4);
	            	newEntryInfo.setSwStandard4(swstandard4==null?0:swstandard4.intValue());
	            	
	            	newEntryInfo.setQty5(qty5);
	            	newEntryInfo.setStandard5(standard5);
	            	newEntryInfo.setSwQty5(swqty5);
	            	newEntryInfo.setSwStandard5(swstandard5==null?0:swstandard5.intValue());
	            	
	            	
	            	
	            	newEntryInfo.setQtyLimit(this.ftfQtyLimit.getBigDecimalValue());
	        		newEntryInfo.setSdLimit(this.ftfSDLimit.getBigDecimalValue());
	        		newEntryInfo.setSaleAmountLimit(this.ftfSaleAmountLimit.getBigDecimalValue());
	        		newEntryInfo.setLockedState(EntryState.UnLocked);
	        		
	        		newEntryInfo.setAccumulaMaterialGroup((MaterialGroupInfo) this.prmtMaterialGroup.getValue());
	        		
	            	DSEntrys.add(newEntryInfo);
		        }
        	}else{
        		// 生成 折让设置分录
            	DiscountSetEntryInfo newEntryInfo = new DiscountSetEntryInfo();
//            	newEntryInfo.setCustomer(customerInfo);
            	newEntryInfo.setMaterial(materialInfo);
            	newEntryInfo.setQty1(qty1);
            	newEntryInfo.setQty2(qty2);
            	newEntryInfo.setStandard1(standard1);
            	newEntryInfo.setStandard2(standard2);
            	
            	newEntryInfo.setSwQty1(swqty1);
            	newEntryInfo.setSwQty2(swqty2);
            	newEntryInfo.setSwStandard1(swstandard1==null?0:swstandard1.intValue());
            	newEntryInfo.setSwStandard2(swstandard2==null?0:swstandard2.intValue());
            	
            	newEntryInfo.setQty3(qty3);
            	newEntryInfo.setStandard3(standard3);
            	newEntryInfo.setSwQty3(swqty3);
            	newEntryInfo.setSwStandard3(swstandard3==null?0:swstandard3.intValue());
            	
            	newEntryInfo.setQty4(qty4);
            	newEntryInfo.setStandard4(standard4);
            	newEntryInfo.setSwQty4(swqty4);
            	newEntryInfo.setSwStandard4(swstandard4==null?0:swstandard4.intValue());
            	
            	newEntryInfo.setQty5(qty5);
            	newEntryInfo.setStandard5(standard5);
            	newEntryInfo.setSwQty5(swqty5);
            	newEntryInfo.setSwStandard5(swstandard5==null?0:swstandard5.intValue());
            	
            	
            	
            	newEntryInfo.setQtyLimit(this.ftfQtyLimit.getBigDecimalValue());
        		newEntryInfo.setSdLimit(this.ftfSDLimit.getBigDecimalValue());
        		newEntryInfo.setSaleAmountLimit(this.ftfSaleAmountLimit.getBigDecimalValue());
        		newEntryInfo.setLockedState(EntryState.UnLocked);
        		
        		newEntryInfo.setAccumulaMaterialGroup((MaterialGroupInfo) this.prmtMaterialGroup.getValue());
        		
            	DSEntrys.add(newEntryInfo);
        	}
            
        }
        
        
        
        this.getUIContext().put("DSEntrys", DSEntrys);
        this.getUIWindow().close();
        
    }

    /**
     * output btnUnSelectAllCustomer_actionPerformed method
     */
    protected void btnUnSelectAllCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			this.kdtCustomer.getCell(i, "selected").setValue(false);
		}
    }

    /**
     * output btnRemoveCustomer_actionPerformed method
     */
    protected void btnRemoveCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	boolean allNoChecked = false;
    	for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			Boolean selected = (Boolean) this.kdtCustomer.getCell(i, "selected").getValue();
			if(selected){
				allNoChecked = true;
			}
		}
    	if(!allNoChecked){
    		MsgBox.showInfo("没有选择任何客户");
    		return;
    	}
    	if(MsgBox.showConfirm2("确认移除选中的客户？") == MsgBox.OK){
	    	for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
				Boolean selected = (Boolean) this.kdtCustomer.getCell(i, "selected").getValue();
				if(selected){
					this.kdtCustomer.removeRow(i);
					i--;
				}
			}
    	}
    }

    /**
     * output btnSelectAllCustomer_actionPerformed method
     */
    protected void btnSelectAllCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	for(int i = 0 ; i < this.kdtCustomer.getRowCount(); i++){
			this.kdtCustomer.getCell(i, "selected").setValue(true);
		}
    }

    /**
     * output btnSelectAllMaterial_actionPerformed method
     */
    protected void btnSelectAllMaterial_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	for(int i = 0 ; i < this.kdtMaterial.getRowCount(); i++){
			this.kdtMaterial.getCell(i, "selected").setValue(true);
		}
    }

    /**
     * output btnUnSelectAllMaterial_actionPerformed method
     */
    protected void btnUnSelectAllMaterial_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	for(int i = 0 ; i < this.kdtMaterial.getRowCount(); i++){
			this.kdtMaterial.getCell(i, "selected").setValue(false);
		}
    }

    /**
     * output btnRemoveMaterial_actionPerformed method
     */
    protected void btnRemoveMaterial_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	boolean allNoChecked = false;
    	for(int i = 0 ; i < this.kdtMaterial.getRowCount(); i++){
			Boolean selected = (Boolean) this.kdtMaterial.getCell(i, "selected").getValue();
			if(selected){
				allNoChecked = true;
			}
		}
    	if(!allNoChecked){
    		MsgBox.showInfo("没有选择任何物料");
    		return;
    	}
    	if(MsgBox.showConfirm2("确认移除选中的物料？") == MsgBox.OK){
	    	for(int i = 0 ; i < this.kdtMaterial.getRowCount(); i++){
				Boolean selected = (Boolean) this.kdtMaterial.getCell(i, "selected").getValue();
				if(selected){
					this.kdtMaterial.removeRow(i);
					i--;
				}
			}
    	}
    }

    /**
     * output prmtCustomer_dataChanged method
     */
    protected void prmtCustomer_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
       
        if(this.prmtCustomer.getData() != null){
        	 Object selectCustomers = this.prmtCustomer.getData();
        	 if(selectCustomers != null && selectCustomers.getClass().equals(CustomerInfo.class)){
        		 CustomerInfo customerInfo = (CustomerInfo) selectCustomers;
     			if(customerInfo != null){
	        			String id = customerInfo.getId().toString();
	        			String number = customerInfo.getNumber();
	        			String name = customerInfo.getName();
	        			// 已经存在的 客户不重复添加
	        			if(this.isExistCustomer(id)){
	        				return;
	        			}
	        				
	        			
	        			IRow newRow = this.kdtCustomer.addRow();
	        			newRow.getCell("customerID").setValue(id);
	        			newRow.getCell("selected").setValue(Boolean.FALSE);
	        			newRow.getCell("number").setValue(number);
	        			newRow.getCell("name").setValue(name);
     			}
        	 }else{
	        	Object[] selectedCustomers = (Object[]) selectCustomers;
	        	if(selectedCustomers.length > 0){
	        		for(int i = 0; i < selectedCustomers.length; i++){
	        			CustomerInfo customerInfo = (CustomerInfo) selectedCustomers[i];
	        			if(customerInfo != null){
		        			String id = customerInfo.getId().toString();
		        			String number = customerInfo.getNumber();
		        			String name = customerInfo.getName();
		        			// 已经存在的 客户不重复添加
		        			if(this.isExistCustomer(id)){
		        				continue;
		        			}
		        			IRow newRow = this.kdtCustomer.addRow();
		        			newRow.getCell("customerID").setValue(id);
		        			newRow.getCell("selected").setValue(Boolean.FALSE);
		        			newRow.getCell("number").setValue(number);
		        			newRow.getCell("name").setValue(name);
	        			}
	        		}
	        	}
        	 }
         }
    }
    /**
     * 校验分录中是否已经存在对应的客户ID了
     * @param customerID
     * @return
     */
    private boolean isExistCustomer(String customerID){
    	for(int i = 0; i < this.kdtCustomer.getRowCount(); i++){
			String csID = (String)this.kdtCustomer.getRow(i).getCell("customerID").getValue();
			if(customerID.equals(csID)){
				return true;
			}
		}
    	
    	
    	return false;
		
    }
    /**
     * output prmtMaterial_dataChanged method
     */
    protected void prmtMaterial_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    	 
         if(this.prmtMaterial.getData() != null){
        	 Object selectMaterials = this.prmtMaterial.getData();
         	Object[] selectedMaterials = (Object[]) selectMaterials;
         	if(selectedMaterials.length > 0){
         		for(int i = 0; i < selectedMaterials.length; i++){
         			MaterialInfo materialInfo = (MaterialInfo) selectedMaterials[i];
         			if(materialInfo != null){
	         			String id = materialInfo.getId().toString();
	         			String number = materialInfo.getNumber();
	         			String name = materialInfo.getName();
	         			// 如果已经存在物料  则 不重复添加
	         			if(this.isExistMaterial(id)){
	         				continue;
	         			}
	         			IRow newRow = this.kdtMaterial.addRow();
	         			newRow.getCell("materialID").setValue(id);
	         			newRow.getCell("selected").setValue(Boolean.FALSE);
	         			newRow.getCell("number").setValue(number);
	         			newRow.getCell("name").setValue(name);
         			}
         		}
         	}
          }
    }

    /**
     * 校验分录中是否已经存在对应的物料ID了
     * @param customerID
     * @return
     */
    private boolean isExistMaterial(String materialID){
    	for(int i = 0; i < this.kdtMaterial.getRowCount(); i++){
			String csID = (String)this.kdtMaterial.getRow(i).getCell("materialID").getValue();
			if(materialID.equals(csID)){
				return true;
			}
		}
    	
    	
    	return false;
		
    }

}