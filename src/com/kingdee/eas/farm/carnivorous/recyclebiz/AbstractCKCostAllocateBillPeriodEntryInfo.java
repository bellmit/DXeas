package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKCostAllocateBillPeriodEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKCostAllocateBillPeriodEntryInfo()
    {
        this("id");
    }
    protected AbstractCKCostAllocateBillPeriodEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 会计科目 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 会计科目 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object: 会计科目 's 会计科目编码 property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getAccountView()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("accountView");
    }
    public void setAccountView(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("accountView", item);
    }
    /**
     * Object:会计科目's 会计科目名称property 
     */
    public String getAccountName()
    {
        return getString("accountName");
    }
    public void setAccountName(String item)
    {
        setString("accountName", item);
    }
    /**
     * Object:会计科目's 剩余金额property 
     */
    public java.math.BigDecimal getRestCost()
    {
        return getBigDecimal("restCost");
    }
    public void setRestCost(java.math.BigDecimal item)
    {
        setBigDecimal("restCost", item);
    }
    /**
     * Object:会计科目's 本期分摊费用property 
     */
    public java.math.BigDecimal getCurrentCost()
    {
        return getBigDecimal("currentCost");
    }
    public void setCurrentCost(java.math.BigDecimal item)
    {
        setBigDecimal("currentCost", item);
    }
    /**
     * Object:会计科目's 期末余额property 
     */
    public java.math.BigDecimal getEndingBanace()
    {
        return getBigDecimal("endingBanace");
    }
    public void setEndingBanace(java.math.BigDecimal item)
    {
        setBigDecimal("endingBanace", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("77C6D43B");
    }
}