package com.kingdee.eas.custom.znck;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialLedRelInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMaterialLedRelInfo()
    {
        this("id");
    }
    protected AbstractMaterialLedRelInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.znck.MaterialLedRelEntryCollection());
    }
    /**
     * Object: 配件与库位灯关联表 's 分录 property 
     */
    public com.kingdee.eas.custom.znck.MaterialLedRelEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.znck.MaterialLedRelEntryCollection)get("entrys");
    }
    /**
     * Object:配件与库位灯关联表's 是否生成凭证property 
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
     * Object:配件与库位灯关联表's 灯号property 
     */
    public int getLedNumber()
    {
        return getInt("ledNumber");
    }
    public void setLedNumber(int item)
    {
        setInt("ledNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4AD48FBC");
    }
}