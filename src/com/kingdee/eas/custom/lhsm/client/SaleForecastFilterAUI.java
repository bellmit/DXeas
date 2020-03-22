/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.filter.CompositeFilterElement;
import com.kingdee.eas.scm.common.filter.RangeFilterElement;
import com.kingdee.eas.scm.common.filter.SingleFilterElement;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.common.util.SCMQueryFormat;
import com.kingdee.eas.scm.common.verify.VerifyItem;
import com.kingdee.eas.scm.common.verify.VerifyType;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class SaleForecastFilterAUI extends AbstractSaleForecastFilterAUI
{
	private static final Logger logger = CoreUIObject.getLogger(SaleForecastFilterAUI.class);
	protected F7ContextManager f7Manager = null;
	private KDBizPromptBox[] prmtBillNumF7s = null;
	String cuid;
	String cuname;
	String cunumber;
	/**
	 * output class constructor
	 */
	public SaleForecastFilterAUI() throws Exception
	{
		super();
		this.f7Manager = new F7ContextManager(this, getMainBizOrgType(), 1);
	}
	protected OrgType getMainBizOrgType()   {
		return OrgType.Storage;
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}
	public void onLoad()throws Exception{
		cuid = SysContext.getSysContext().getCurrentFIUnit().getId()
		.toString();
		cuname=SysContext.getSysContext().getCurrentFIUnit().getName().toString();
		cunumber=SysContext.getSysContext().getCurrentFIUnit().getNumber();
		super.onLoad();
		setF7Filter();
		setDefaultValue();

		// bizDateFrom
		// bizDateTo
		// bizPromptMaterialNumFrom		
		this.bizPromptMaterialNumFrom.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialQuery");		
		this.bizPromptMaterialNumFrom.setEditFormat("$number$");		
		this.bizPromptMaterialNumFrom.setDisplayFormat("$number$");		
		this.bizPromptMaterialNumFrom.setEditable(true);
		// bizPromptMaterialNumTo		
		this.bizPromptMaterialNumTo.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialQuery");		
		this.bizPromptMaterialNumTo.setEditFormat("$number$");		
		this.bizPromptMaterialNumTo.setDisplayFormat("$number$");		
		this.bizPromptMaterialNumTo.setEditable(true);
		// comBoxBillState
		// bizPromptStOrgUnitFrom
		// bizPromptCustomerFrom		
		this.bizPromptCustomerFrom.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerQuery");		
		this.bizPromptCustomerFrom.setEditFormat("$number$");		
		this.bizPromptCustomerFrom.setDisplayFormat("$number$");		
		this.bizPromptCustomerFrom.setEditable(true);
		// bizPromptCustomerTo		
		this.bizPromptCustomerTo.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerQuery");		
		this.bizPromptCustomerTo.setEditFormat("$number$");		
		this.bizPromptCustomerTo.setDisplayFormat("$number$");		
		this.bizPromptCustomerTo.setEditable(true);

		//		this.bizPromptStOrgUnitFrom.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
		this.bizPromptStOrgUnitFrom.setEditable(true);		
		this.bizPromptStOrgUnitFrom.setDisplayFormat("$name$");		
		this.bizPromptStOrgUnitFrom.setEditFormat("$number$");		
		this.bizPromptStOrgUnitFrom.setCommitFormat("$number$");		
		this.bizPromptStOrgUnitFrom.setRequired(true);
		//        this.bizPromptStOrgUnitFrom.setEnabledMultiSelection(true);

		//        bizPromptStOrgUnitFrom.setValue(SysContext.getSysContext().getCurrentStorageUnit());
		bizPromptStOrgUnitFrom.setValue(SysContext.getSysContext().getCurrentFIUnit());
		CompanyF7 cf7=new CompanyF7();
		bizPromptStOrgUnitFrom.setSelector(cf7);

		FilterInfo filterInfo=new FilterInfo();
		if(cunumber.equals("4")){
			Set materialsID = new LinkedHashSet();
			StringBuffer sql=new StringBuffer();
			sql.append("select t2.fid from T_ORG_Company t1 inner join  T_ORG_Company t2 on t2.FLongNumber like concat(t1.FLongNumber,'%') where t1.FNumber='"+cunumber+"'");
			//sql.append(" where t2.fparentid= '"+cuid+"' ");
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()){
				String  companyid=rs.getString("fid");
				materialsID.add(companyid);
			}
			filterInfo.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("id",cuid,CompareType.EQUALS));
		}
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);
		this.bizPromptStOrgUnitFrom.setEntityViewInfo(evi);
	}
	protected void setDefaultValue(){
		SCMQueryFormat.formatStartTime(this.bizDateFrom);
		SCMQueryFormat.formatEndTime(this.bizDateTo);
		//SCMQueryFormat.formatBillStatus(this, this.comBoxBillState);
	}
	protected void setBizMaterialF7(KDBizPromptBox bizMaterialBox, boolean isMulSelect, String queryInfo){
		this.f7Manager.registerBizMaterialF7(bizMaterialBox, null, queryInfo, null, isMulSelect);
	}
	protected void setNeedMainOrgF7s(KDBizPromptBox[] f7s){
		//addF7SelectorListener(f7s);
		this.f7Manager.setPrmtNeedOrgF7s(f7s);
	}
	protected void setBillNumberF7s(KDBizPromptBox[] f7s)
	{
		this.prmtBillNumF7s = f7s;
	}
	private void setF7Filter() throws Exception{
		/* 104 */     setBizMaterialF7(this.bizPromptMaterialNumFrom, false, null);
		/* 105 */     setBizMaterialF7(this.bizPromptMaterialNumTo, false, null);
		/*     */ 
		/* 113 */     this.f7Manager.registerBizCustomerF7(this.bizPromptCustomerFrom, null, null, null, OrgType.Company, true);
		/* 114 */     this.f7Manager.registerBizCustomerF7(this.bizPromptCustomerTo, null, null, null, OrgType.Company, true);

		/* 137 */     setNeedMainOrgF7s(new KDBizPromptBox[] { this.bizPromptMaterialNumFrom, this.bizPromptMaterialNumTo });
		/*     */ 
		/* 141 */    // setBillNumberF7s(new KDBizPromptBox[] { this.bizPromptNumberFrom, this.bizPromptNumberTo });
		/*     */ 
		/* 144 */     //setShowAllSealOrg(new KDBizPromptBox[] { this.bizPromptDepartmentFrom, this.bizPromptDepartmentTo }, new OrgType[] { OrgType.Admin, OrgType.Admin });
	/*     */   }

	public FilterInfo getFilterInfo() {
		CompositeFilterElement elements = new CompositeFilterElement(0);
		//elements.add(new RangeFilterElement("number", this.bizPromptNumberFrom, this.bizPromptNumberTo));
		elements.add(new RangeFilterElement("customer.number", this.bizPromptCustomerFrom, this.bizPromptCustomerTo));
		elements.add(new RangeFilterElement("entrys.materialNumber.number", this.bizPromptMaterialNumFrom, this.bizPromptMaterialNumTo));

		CompositeFilterElement DateElements = new CompositeFilterElement(0);
		DateElements.add(new RangeFilterElement("bizDate", this.bizDateFrom, this.bizDateTo));
		DateElements.addVerifyItem(new VerifyItem(VerifyType.LESS_EQUAL_TYPE, SCMClientUtils.getResource("CompareDate")));
		elements.add(DateElements);
		//storageOrgUnit.number
		//        SingleFilterElement mainOrgElement = new SingleFilterElement("company.number", this.bizPromptStOrgUnitFrom);
		//        mainOrgElement.addVerifyItem(new VerifyItem(VerifyType.REQUIRED_TYPE, InvClientUtils.getResource("StorageOrgUnitNotNull")));
		//        elements.add(mainOrgElement);
		if(bizPromptStOrgUnitFrom.getValue() == null){
			commUtils.giveUserTipsAndRetire("ÇëÑ¡Ôñ¹«Ë¾");
		}

		//elements.add(new SingleFilterElement("state", this.comBoxBillState, BillBaseStatusEnum.NULL));
		//SingleFilterElement mainOrgElement = new SingleFilterElement("CU.number", this.bizPromptStOrgUnitFrom);
		FilterInfo filterinfo = new FilterInfo();
		filterinfo=elements.getFilterInfo();
		
		String str= "select t2.fnumber from T_ORG_Company t1 inner join  T_ORG_Company t2 on t2.FLongNumber like concat(t1.FLongNumber,'%') where t1.FNumber='"+((IPropertyContainer)bizPromptStOrgUnitFrom.getValue()).getString("number")+"'";
		SQLExecutorFactory rSQLExecutorFactory;
		IRowSet rs;
		try {
			HashSet<String> set = new HashSet<String>();
			rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rs.size() > 0){
				while(rs.next()){
					set.add(rs.getString("fnumber"));
				}
				String maskString = filterinfo.getMaskString();
				int size = filterinfo.getFilterItems().size();
				filterinfo.getFilterItems().add(new FilterItemInfo("company.number",set,CompareType.INCLUDE));
				maskString +=" AND #"+size;
				filterinfo.setMaskString(maskString);
			}else{
				SingleFilterElement mainOrgElement = new SingleFilterElement("company.number", this.bizPromptStOrgUnitFrom);
				mainOrgElement.addVerifyItem(new VerifyItem(VerifyType.REQUIRED_TYPE, InvClientUtils.getResource("StorageOrgUnitNotNull")));
				elements.add(mainOrgElement);
				filterinfo=elements.getFilterInfo();
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filterinfo;
	}
}