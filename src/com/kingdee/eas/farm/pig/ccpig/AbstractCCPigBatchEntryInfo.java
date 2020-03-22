package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBatchEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigBatchEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigBatchEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public int getInitQty()
    {
        return getInt("initQty");
    }
    public void setInitQty(int item)
    {
        setInt("initQty", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getIncoopDate()
    {
        return getDate("incoopDate");
    }
    public void setIncoopDate(java.util.Date item)
    {
        setDate("incoopDate", item);
    }
    /**
     * Object:��¼'s ����ȫ����property 
     */
    public boolean isIsMarket()
    {
        return getBoolean("isMarket");
    }
    public void setIsMarket(boolean item)
    {
        setBoolean("isMarket", item);
    }
    /**
     * Object:��¼'s ��ȫ��������property 
     */
    public java.util.Date getMarketDate()
    {
        return getDate("marketDate");
    }
    public void setMarketDate(java.util.Date item)
    {
        setDate("marketDate", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public int getMarketQty()
    {
        return getInt("marketQty");
    }
    public void setMarketQty(int item)
    {
        setInt("marketQty", item);
    }
    /**
     * Object:��¼'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pigHouse");
    }
    public void setPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pigHouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("87FDE866");
    }
}