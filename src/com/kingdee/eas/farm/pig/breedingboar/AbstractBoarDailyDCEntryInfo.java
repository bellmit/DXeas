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
     * Object: 死亡记录 's null property 
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
     * Object:死亡记录's 备注property 
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
     * Object:死亡记录's 死亡数量property 
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
     * Object:死亡记录's 重量（kg）property 
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
     * Object:死亡记录's 死亡原因property 
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
     * Object: 死亡记录 's 猪舍 property 
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
     * Object: 死亡记录 's 死亡耳标明细 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryDeathEarNumberEntryCollection getDeathEarNumberEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryDeathEarNumberEntryCollection)get("DeathEarNumberEntrys");
    }
    /**
     * Object:死亡记录's 均重（kg/头）property 
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