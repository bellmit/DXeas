package com.kingdee.eas.custom.salediscount.client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.commonquery.client.CustomerParams;
import com.kingdee.eas.base.form.metadata.EnumItem;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.DiscountTypeEnum;
import com.kingdee.eas.custom.salediscount.DsNameTypeEnum;
import com.kingdee.eas.framework.CheckedStatusEnum;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;
import com.kingdee.eas.scm.common.filter.QueryFilterManager;
import com.kingdee.eas.scm.common.filter.SingleFilterElement;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.enums.EnumUtils;

public class DiscountSetQueryUI extends AbstractDiscountSetQueryUI
{
  private static final Logger logger = CoreUIObject.getLogger(DiscountSetQueryUI.class);

  public DiscountSetQueryUI()
    throws Exception
  {
    SingleFilterElement mainOrgElement = new SingleFilterElement("saleOrgUnit.number", this.prmtSaleOrgFrom);
    getFilterManager().setElement(mainOrgElement);
    getFilterManager().setMainOrgElement(mainOrgElement, "saleOrgUnit.id");
    
   
  }

	@Override
public RptParams getCustomCondition() {
	// TODO Auto-generated method stub
	return super.getCustomCondition();
}

@Override
public CustomerParams getCustomerParams() {
	// TODO Auto-generated method stub
	return super.getCustomerParams();
}

@Override
public QueryFilterManager getFilterManager() {
	// TODO Auto-generated method stub
	return super.getFilterManager();
}

	/**
	 *初始化
	 */
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.prmtSaleOrgFrom.setEnabled(false);
		this.prmtSaleOrgFrom.setEditable(false);
		// 折讓類別
		EnumItem enumItem = new EnumItem();
		enumItem.setDisplayValue_L1("all");
		enumItem.setDisplayValue_L2("全部");
		enumItem.setDisplayValue_L3("全部");
		enumItem.setDisplayValueValue("全部");
		enumItem.setValue(0);
//		enumItem.
		this.cbDiscountType.addItem(enumItem);
		this.cbDiscountType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salediscount.DiscountTypeEnum").toArray());	
		
//		this.cbDiscountType.addItem(new )
		this.cbDiscountType.setSelectedIndex(0);
        this.cbDiscountType.setRequired(false);
        
     	// 政策類別
		
//		enumItem.
		this.cbPolicyType.addItem(enumItem);
		this.cbPolicyType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salediscount.DsNameTypeEnum").toArray());	
		
//		this.cbDiscountType.addItem(new )
		this.cbPolicyType.setSelectedIndex(0);
        this.cbPolicyType.setRequired(false);
        
        
        this.cbAuditState.addItem(enumItem);
		this.cbAuditState.addItems(EnumUtils.getEnumList("com.kingdee.eas.framework.CheckedStatusEnum").toArray());	
		
//		this.cbDiscountType.addItem(new )
		this.cbAuditState.setSelectedIndex(0);
        this.cbAuditState.setRequired(false);
        
        this.cbDelState.addItem(enumItem);
		this.cbDelState.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum").toArray());	
		
//		this.cbDiscountType.addItem(new )
		this.cbDelState.setSelectedIndex(0);
        this.cbDelState.setRequired(false);
		
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
		prmtCustomer.setEnabledMultiSelection(false);
		// 设置客户F7展现形式为左树右表
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtCustomer,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"companyOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(false);
		prmtCustomer.setSelector(selectorAdaptor);
		prmtCustomer.addSelectorListener(selectorAdaptor);
        
		// 日期默认 
		Date endDate = this.dpEffectEndDate.getSqlDate();
		SimpleDateFormat sdfss = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		String endDateStr = sdfss.format(endDate);
		endDate = sdfss.parse(endDateStr);
		
		this.dpEffectEndDate.setValue(endDate);
		
		
		// 开始日期
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDateStr = sdf.format(nowDate);
		nowDate = sdf.parse(nowDateStr);
		
		Calendar c = Calendar.getInstance();
		c.setTime(nowDate);
		
		c.add(Calendar.MONTH, -1); 
		this.dpEffectBeginDate.setValue(c.getTime());
        
		this.setUITitle("折让政策 - 查询条件");
	}

	@Override
	public FilterInfo getFilterInfo() {
		// TODO Auto-generated method stub
		FilterInfo fi = super.getFilterInfo();
		if(fi == null) fi = new FilterInfo();
		
		String number = this.tfNumber.getText();
		String name = this.tfName.getText();
		
		if(StringUtils.isNotBlank(number)){
			fi.getFilterItems().add(new FilterItemInfo("number","%" + StringUtils.trim(number) + "%",CompareType.LIKE));
		}
		
		if(StringUtils.isNotBlank(name)){
			fi.getFilterItems().add(new FilterItemInfo("name","%" + StringUtils.trim(name) + "%",CompareType.LIKE));
		}
		if(this.cbDiscountType.getSelectedItem() != null){
			if(cbDiscountType.getSelectedItem().getClass() == DiscountTypeEnum.class){
				
				fi.getFilterItems().add(new FilterItemInfo("discountType",((DiscountTypeEnum)cbDiscountType.getSelectedItem()).getValue(),CompareType.EQUALS));
			}
		}
		if(this.cbPolicyType.getSelectedItem() != null){
			if(cbPolicyType.getSelectedItem().getClass() == DsNameTypeEnum.class){
				
				fi.getFilterItems().add(new FilterItemInfo("dsNameType",((DsNameTypeEnum)cbPolicyType.getSelectedItem()).getValue(),CompareType.EQUALS));
			}
		}
		if(this.cbAuditState.getSelectedItem() != null){
			if(cbAuditState.getSelectedItem().getClass() == CheckedStatusEnum.class){
				
				fi.getFilterItems().add(new FilterItemInfo("checkedStatus",((CheckedStatusEnum)cbAuditState.getSelectedItem()).getValue(),CompareType.EQUALS));
			}
		}
		
		if(this.cbDelState.getSelectedItem() != null){
			if(cbDelState.getSelectedItem().getClass() == ForbidStatusEnum.class){
				
				fi.getFilterItems().add(new FilterItemInfo("blockedStatus",((ForbidStatusEnum)cbDelState.getSelectedItem()).getValue(),CompareType.EQUALS));
			}
		}
		
		
		
		if(this.dpEffectBeginDate.getSqlDate() != null){
			Date beginDate = this.dpEffectBeginDate.getSqlDate();
			fi.getFilterItems().add(new FilterItemInfo("effectiveDate",beginDate,CompareType.GREATER_EQUALS));
		}
		
		if(this.dpEffectEndDate.getSqlDate() != null){
			Date endDate = this.dpEffectEndDate.getSqlDate();
			Calendar c = Calendar.getInstance();
			c.setTime(endDate);
			int day = c.get(Calendar.DATE);
			c.set(Calendar.DATE, day + 1); 
			endDate = c.getTime();
			fi.getFilterItems().add(new FilterItemInfo("effectiveDate",endDate,CompareType.LESS_EQUALS));
		}
		
//		if(this.prmtCustomer.getValue() != null){
//			CustomerInfo currCustomerInfo = (CustomerInfo) this.prmtCustomer.getValue();
//			fi.getFilterItems().add(new FilterItemInfo("effectiveDate",beginDate,CompareType.GREATER_EQUALS));
//		}
		return fi;
	}

	public void storeFields()
	  {
	    super.storeFields();
	  }

  public KDBizPromptBox getMainBizOrgF7()
  {
    return this.prmtSaleOrgFrom;
  }

  public boolean verify() {
    if (this.prmtSaleOrgFrom.getValue() == null) {
      MsgBox.showInfo(this, SCMClientUtils.getResource("SALEORGNOTNULL"));

      return false;
    }
    return true;
  }

  protected String getViewPermission()
  {
    return "pricepolicy_view";
  }

  protected OrgType getMainBizOrgType()
  {
    return OrgType.Sale;
  }

  public boolean isSupportVirturalOrgs() {
    return true;
  }
}
