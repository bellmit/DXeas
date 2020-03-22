package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementOfAccountFeedsnewInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementOfAccountFeedsnewInfo()
    {
        this("id");
    }
    protected AbstractStatementOfAccountFeedsnewInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������ϸ 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ������ϸ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getFeedsone()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("feedsone");
    }
    public void setFeedsone(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("feedsone", item);
    }
    /**
     * Object:������ϸ's ��������property 
     */
    public String getFeedName()
    {
        return getString("feedName");
    }
    public void setFeedName(String item)
    {
        setString("feedName", item);
    }
    /**
     * Object:������ϸ's ��������property 
     */
    public java.math.BigDecimal getFeedQty()
    {
        return getBigDecimal("feedQty");
    }
    public void setFeedQty(java.math.BigDecimal item)
    {
        setBigDecimal("feedQty", item);
    }
    /**
     * Object:������ϸ's ���Ͻ��property 
     */
    public java.math.BigDecimal getFeedAC()
    {
        return getBigDecimal("feedAC");
    }
    public void setFeedAC(java.math.BigDecimal item)
    {
        setBigDecimal("feedAC", item);
    }
    /**
     * Object:������ϸ's ������property 
     */
    public java.math.BigDecimal getFeedWeight()
    {
        return getBigDecimal("feedWeight");
    }
    public void setFeedWeight(java.math.BigDecimal item)
    {
        setBigDecimal("feedWeight", item);
    }
    /**
     * Object:������ϸ's ����property 
     */
    public java.math.BigDecimal getPackageNumber()
    {
        return getBigDecimal("packageNumber");
    }
    public void setPackageNumber(java.math.BigDecimal item)
    {
        setBigDecimal("packageNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DC4F02D7");
    }
}