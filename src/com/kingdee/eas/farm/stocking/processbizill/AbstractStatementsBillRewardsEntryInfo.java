package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsBillRewardsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementsBillRewardsEntryInfo()
    {
        this("id");
    }
    protected AbstractStatementsBillRewardsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���ͷ�¼ 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:���ͷ�¼'s ��Ŀ����property 
     */
    public String getItemName()
    {
        return getString("itemName");
    }
    public void setItemName(String item)
    {
        setString("itemName", item);
    }
    /**
     * Object:���ͷ�¼'s ���property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:���ͷ�¼'s ������Ŀidproperty 
     */
    public String getItemID()
    {
        return getString("itemID");
    }
    public void setItemID(String item)
    {
        setString("itemID", item);
    }
    /**
     * Object:���ͷ�¼'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FD6F157E");
    }
}