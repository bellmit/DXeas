package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarDailyCullEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBoarDailyCullEntryInfo()
    {
        this("id");
    }
    protected AbstractBoarDailyCullEntryInfo(String pkField)
    {
        super(pkField);
        put("CullEarNumberEntrys", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCullEarNumberEntryCollection());
    }
    /**
     * Object: ��̭��¼ 's null property 
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
     * Object: ��̭��¼ 's ���� property 
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
     * Object:��̭��¼'s ��̭����property 
     */
    public int getCullQty()
    {
        return getInt("cullQty");
    }
    public void setCullQty(int item)
    {
        setInt("cullQty", item);
    }
    /**
     * Object:��̭��¼'s ������kg��property 
     */
    public java.math.BigDecimal getCullWeight()
    {
        return getBigDecimal("cullWeight");
    }
    public void setCullWeight(java.math.BigDecimal item)
    {
        setBigDecimal("cullWeight", item);
    }
    /**
     * Object:��̭��¼'s ��̭ԭ��property 
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
     * Object:��̭��¼'s ��עproperty 
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
     * Object: ��̭��¼ 's ��̭������ϸ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCullEarNumberEntryCollection getCullEarNumberEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCullEarNumberEntryCollection)get("CullEarNumberEntrys");
    }
    /**
     * Object:��̭��¼'s ���أ�kg/ͷ��property 
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
        return new BOSObjectType("8E1A2FA1");
    }
}