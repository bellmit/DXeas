package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEarlyEggStockInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEarlyEggStockInfo()
    {
        this("id");
    }
    protected AbstractEarlyEggStockInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.hatch.EarlyEggStockEntryCollection());
    }
    /**
     * Object: 种禽养殖户种蛋库存期初 's 分录 property 
     */
    public com.kingdee.eas.farm.hatch.EarlyEggStockEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.EarlyEggStockEntryCollection)get("entrys");
    }
    /**
     * Object:种禽养殖户种蛋库存期初's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 种禽养殖户种蛋库存期初 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:种禽养殖户种蛋库存期初's 摘要property 
     */
    public String getSummary()
    {
        return getString("summary");
    }
    public void setSummary(String item)
    {
        setString("summary", item);
    }
    /**
     * Object:种禽养殖户种蛋库存期初's 单据状态property 
     */
    public com.kingdee.eas.farm.hatch.billStatus getBillStatus()
    {
        return com.kingdee.eas.farm.hatch.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.farm.hatch.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FBBB1B46");
    }
}