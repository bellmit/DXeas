package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlementDEInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettlementDEInfo()
    {
        this("id");
    }
    protected AbstractSettlementDEInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: Զ���벹�� 's null property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.SettlementInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.SettlementInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basedata.SettlementInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:Զ���벹��'s �˳�����property 
     */
    public int getKilometertop()
    {
        return getInt("kilometertop");
    }
    public void setKilometertop(int item)
    {
        setInt("kilometertop", item);
    }
    /**
     * Object:Զ���벹��'s �˳�����property 
     */
    public int getKilometerend()
    {
        return getInt("kilometerend");
    }
    public void setKilometerend(int item)
    {
        setInt("kilometerend", item);
    }
    /**
     * Object:Զ���벹��'s �������property 
     */
    public java.math.BigDecimal getSubprice()
    {
        return getBigDecimal("subprice");
    }
    public void setSubprice(java.math.BigDecimal item)
    {
        setBigDecimal("subprice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B541A116");
    }
}