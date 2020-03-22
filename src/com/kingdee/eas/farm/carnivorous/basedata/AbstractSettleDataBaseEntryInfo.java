package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleDataBaseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleDataBaseEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleDataBaseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ҩƷ�ɱ����Ϸ�¼ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ��Ŀproperty 
     */
    public String getItem()
    {
        return getString("item");
    }
    public void setItem(String item)
    {
        setString("item", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ϵ��property 
     */
    public java.math.BigDecimal getCoe()
    {
        return getBigDecimal("coe");
    }
    public void setCoe(java.math.BigDecimal item)
    {
        setBigDecimal("coe", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("28C0A32A");
    }
}