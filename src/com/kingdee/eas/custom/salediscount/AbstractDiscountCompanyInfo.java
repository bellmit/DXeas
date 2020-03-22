package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountCompanyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDiscountCompanyInfo()
    {
        this("id");
    }
    protected AbstractDiscountCompanyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 折让公司 's 组别 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountCompanyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountCompanyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salediscount.DiscountCompanyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 折让公司 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:折让公司's 立折property 
     */
    public boolean isEnableLZdiscount()
    {
        return getBoolean("enableLZdiscount");
    }
    public void setEnableLZdiscount(boolean item)
    {
        setBoolean("enableLZdiscount", item);
    }
    /**
     * Object:折让公司's 实物折扣property 
     */
    public boolean isEnableSWDiscount()
    {
        return getBoolean("enableSWDiscount");
    }
    public void setEnableSWDiscount(boolean item)
    {
        setBoolean("enableSWDiscount", item);
    }
    /**
     * Object:折让公司's 月折property 
     */
    public boolean isEnableMonthDiscount()
    {
        return getBoolean("enableMonthDiscount");
    }
    public void setEnableMonthDiscount(boolean item)
    {
        setBoolean("enableMonthDiscount", item);
    }
    /**
     * Object:折让公司's 年折property 
     */
    public boolean isEnableYearDiscount()
    {
        return getBoolean("enableYearDiscount");
    }
    public void setEnableYearDiscount(boolean item)
    {
        setBoolean("enableYearDiscount", item);
    }
    /**
     * Object:折让公司's 分销折扣property 
     */
    public boolean isEnableFXDiscount()
    {
        return getBoolean("enableFXDiscount");
    }
    public void setEnableFXDiscount(boolean item)
    {
        setBoolean("enableFXDiscount", item);
    }
    /**
     * Object:折让公司's 订单月折BOTP编码property 
     */
    public String getOrderYZToRecordBotp()
    {
        return getString("orderYZToRecordBotp");
    }
    public void setOrderYZToRecordBotp(String item)
    {
        setString("orderYZToRecordBotp", item);
    }
    /**
     * Object:折让公司's 订单年折BOTP编码property 
     */
    public String getOrderYearZToRecordBotp()
    {
        return getString("orderYearZToRecordBotp");
    }
    public void setOrderYearZToRecordBotp(String item)
    {
        setString("orderYearZToRecordBotp", item);
    }
    /**
     * Object:折让公司's 订单分销BOTP编码property 
     */
    public String getOrderFXToRecordBotp()
    {
        return getString("orderFXToRecordBotp");
    }
    public void setOrderFXToRecordBotp(String item)
    {
        setString("orderFXToRecordBotp", item);
    }
    /**
     * Object:折让公司's 记录单生成收款单BOTPproperty 
     */
    public String getRecordToReceivingBotp()
    {
        return getString("recordToReceivingBotp");
    }
    public void setRecordToReceivingBotp(String item)
    {
        setString("recordToReceivingBotp", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AFF2E9A1");
    }
}