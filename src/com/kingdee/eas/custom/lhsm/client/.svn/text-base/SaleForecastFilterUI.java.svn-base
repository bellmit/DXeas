/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.client.SCMCommonF7KDTableListener;
import com.kingdee.eas.scm.common.filter.CompositeFilterElement;
import com.kingdee.eas.scm.common.filter.RangeFilterElement;
import com.kingdee.eas.scm.common.filter.SingleFilterElement;
import com.kingdee.eas.scm.common.util.SCMQueryFormat;
import com.kingdee.eas.scm.common.verify.VerifyItem;
import com.kingdee.eas.scm.common.verify.VerifyType;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;

/**
 * ≤ª π”√
 * @author lenovo
 *
 */
public class SaleForecastFilterUI extends AbstractSaleForecastFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(SaleForecastFilterUI.class);
    /**
     * output class constructor
     */
    public SaleForecastFilterUI() throws Exception
    {
        super();
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
	private void getElementsInfo(){
		
	}
   protected OrgType getMainBizOrgType()   {
     return OrgType.Storage;
   }
   

protected void setMainBizF7(KDBizPromptBox bizOrgUnitBox) {
	super.setMainBizF7(this.bizPromptStOrgUnitFrom);
}
/*     */   private void setF7Filter() throws Exception
/*     */   {
/* 104 */     setBizMaterialF7(this.bizPromptMaterialNumFrom, false, null);
/* 105 */     setBizMaterialF7(this.bizPromptMaterialNumTo, false, null);
/*     */ 
/* 113 */     this.f7Manager.registerBizCustomerF7(this.bizPromptCustomerFrom, null, null, null, OrgType.Company, true);
/* 114 */     this.f7Manager.registerBizCustomerF7(this.bizPromptCustomerTo, null, null, null, OrgType.Company, true);

/*     */ 
/* 125 */     this.f7Manager.registerContextChangeF7(this.bizPromptNumberFrom, getPropertyOfMainBizOrg());
/* 126 */     this.f7Manager.registerContextChangeF7(this.bizPromptNumberTo, getPropertyOfMainBizOrg());
/*     */ 
/*     */ 
/* 133 */     this.bizPromptNumberFrom.addCommonF7KDTableListener(new SCMCommonF7KDTableListener("baseStatus"));
/* 134 */     this.bizPromptNumberTo.addCommonF7KDTableListener(new SCMCommonF7KDTableListener("baseStatus"));
/*     */ 
/* 137 */     setNeedMainOrgF7s(new KDBizPromptBox[] { this.bizPromptMaterialNumFrom, this.bizPromptMaterialNumTo });
/*     */ 
/* 141 */     setBillNumberF7s(new KDBizPromptBox[] { this.bizPromptNumberFrom, this.bizPromptNumberTo });
/*     */ 
/* 144 */     //setShowAllSealOrg(new KDBizPromptBox[] { this.bizPromptDepartmentFrom, this.bizPromptDepartmentTo }, new OrgType[] { OrgType.Admin, OrgType.Admin });
/*     */   }
/*     */ 
		public void onLoad()throws Exception{
			super.onLoad();
				
/* 161 */     	setF7Filter();
/* 163 */     	setDefaultValue();
				//if (getMainBizOrgF7().getText() != null)mainOrgChanged();
				this.labBillState.setVisible(false);
				this.comBoxBillState.setVisible(false);		
				this.comBoxBillState.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.lhsm.ForecastEnum").toArray());		
				this.comBoxBillState.setRequired(false);		
				this.comBoxBillState.setEnabled(false);
				
				this.bizPromptStOrgUnitFrom.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
				this.bizPromptStOrgUnitFrom.setEditable(true);		
		        this.bizPromptStOrgUnitFrom.setDisplayFormat("$name$");		
		        this.bizPromptStOrgUnitFrom.setEditFormat("$number$");		
		        this.bizPromptStOrgUnitFrom.setCommitFormat("$number$");		
		        this.bizPromptStOrgUnitFrom.setRequired(true);
		        this.bizPromptStOrgUnitFrom.setEnabledMultiSelection(true);
		        
		        bizPromptStOrgUnitFrom.setValue(SysContext.getSysContext().getCurrentStorageUnit());
		        
				Set materialsID = new LinkedHashSet();
		        StringBuffer sql=new StringBuffer();
				String materialid="";
				sql=new StringBuffer();
				sql.append("select fnumber,cforgidid fid from ct_czc_ssorglist  ");
				IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				while(rs.next()){
					String  companyid=rs.getString("fid");
					materialsID.add(companyid);
				}
				
				sql=new StringBuffer();
				sql.append("select  t1.fid,t1.fname_l2,t1.fnumber  ");
				sql.append(" from CT_lhs_ADMINfoodA t1 ");
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				while(rs.next()){
					String  companyid=rs.getString("fid");
					materialsID.add(companyid);
				}
				FilterInfo filterInfoa=new FilterInfo();
				filterInfoa.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
				EntityViewInfo evi=new EntityViewInfo();
				evi.setFilter(filterInfoa);
				this.bizPromptStOrgUnitFrom.setEntityViewInfo(evi);
				
			
/*     */   }
/*     */ 
/*     */   protected void setDefaultValue()
/*     */   {
/* 173 */     SCMQueryFormat.formatStartTime(this.bizDateFrom);
/* 174 */     SCMQueryFormat.formatEndTime(this.bizDateTo);
/* 175 */     //SCMQueryFormat.formatBillStatus(this, this.comBoxBillState);
/*     */   }
/*     */   public Object[] getUnVisibleBillStatus()
/*     */   {
/* 180 */     return new Object[] { BillBaseStatusEnum.RELEASED, BillBaseStatusEnum.BLOCKED, BillBaseStatusEnum.CLOSED, BillBaseStatusEnum.DELETED };
/*     */   }
/*     */ 
/*     */   public Object[] getAdditiveBillStatus()
/*     */   {
/* 190 */     return null;
/*     */   }
/*     */ 
/*     */   public KDBizPromptBox getMainBizOrgF7()
/*     */   {
/* 200 */     return this.bizPromptStOrgUnitFrom;
/*     */   }
/*     */ 
/*     */   protected String getViewPermission() {
/* 204 */     return "saleissue_view";
/*     */   }
/*     */ 
/*     */   protected String getPropertyOfMainBizOrg()
/*     */   {
/* 214 */     return "companyOrgUnit.id";
/*     */   }
		public boolean isPrepareInit() {
		     return true;
		}
		public FilterInfo getFilterInfo() {
			 CompositeFilterElement elements = new CompositeFilterElement(0);
	         elements.add(new RangeFilterElement("number", this.bizPromptNumberFrom, this.bizPromptNumberTo));
	         //elements.add(new RangeFilterElement("sourceBillType.number", this.bizPromptSoureBillTypeFrom, this.bizPromptSoureBillTypeTo));
	         elements.add(new RangeFilterElement("customer.number", this.bizPromptCustomerFrom, this.bizPromptCustomerTo));
	         //elements.add(new RangeFilterElement("adminOrgUnit.number", this.bizPromptDepartmentFrom, this.bizPromptDepartmentTo));
	         //elements.add(new RangeFilterElement("entry.sourceBillNumber", this.txtSourBillNumFrom, this.txtSourBillNumto));		         elements.add(new RangeFilterElement("material.number", this.bizPromptMaterialNumFrom, this.bizPromptMaterialNumTo));
	         elements.add(new RangeFilterElement("entrys.materialNumber.number", this.bizPromptMaterialNumFrom, this.bizPromptMaterialNumTo));
	         //elements.add(new RangeFilterElement("warehouse.number", this.bizPromptWarehouseFrom, this.bizPromptWarehouseTo));

	         CompositeFilterElement DateElements = new CompositeFilterElement(0);
	         DateElements.add(new RangeFilterElement("bizDate", this.bizDateFrom, this.bizDateTo));
	         DateElements.addVerifyItem(new VerifyItem(VerifyType.LESS_EQUAL_TYPE, SCMClientUtils.getResource("CompareDate")));
	         elements.add(DateElements);
	         //storageOrgUnit.number
	         SingleFilterElement mainOrgElement = new SingleFilterElement("CU.number", this.bizPromptStOrgUnitFrom);
	         mainOrgElement.addVerifyItem(new VerifyItem(VerifyType.REQUIRED_TYPE, InvClientUtils.getResource("StorageOrgUnitNotNull")));
	         elements.add(mainOrgElement);

	         //elements.add(new SingleFilterElement("state", this.comBoxBillState, BillBaseStatusEnum.NULL));
	         
			 FilterInfo filterinfo = new FilterInfo();
			 filterinfo=elements.getFilterInfo();
			
			return filterinfo;
		}
		
}