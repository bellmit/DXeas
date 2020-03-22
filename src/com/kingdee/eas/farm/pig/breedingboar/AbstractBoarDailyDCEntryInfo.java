package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarDailyDCEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBoarDailyDCEntryInfo()
    {
        this("id");
    }
    protected AbstractBoarDailyDCEntryInfo(String pkField)
    {
        super(pkField);
        put("DeathEarNumberEntrys", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryDeathEarNumberEntryCollection());
    }
    /**
     * Object: ������¼ 's null property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������¼'s ��עproperty 
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
     * Object:������¼'s ��������property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:������¼'s ������kg��property 
     */
    public java.math.BigDecimal getDeathWeight()
    {
        return getBigDecimal("deathWeight");
    }
    public void setDeathWeight(java.math.BigDecimal item)
    {
        setBigDecimal("deathWeight", item);
    }
    /**
     * Object:������¼'s ����ԭ��property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    /**
     * Object: ������¼ 's ���� property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pigHouse");
    }
    public void setPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pigHouse", item);
    }
    /**
     * Object: ������¼ 's ����������ϸ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryDeathEarNumberEntryCollection getDeathEarNumberEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryDeathEarNumberEntryCollection)get("DeathEarNumberEntrys");
    }
    /**
     * Object:������¼'s ���أ�kg/ͷ��property 
     */
    public java.math.BigDecimal getPerWeight()
    {
        return getBigDecimal("perWeight");
    }
    public void setPerWeight(java.math.BigDecimal item)
    {
        setBigDecimal("perWeight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9276A114");
    }
}