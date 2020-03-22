package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQcEggTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractQcEggTypeInfo()
    {
        this("id");
    }
    protected AbstractQcEggTypeInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.stocking.basedata.QcEggTypeEntryCollection());
    }
    /**
     * Object: 出雏合格蛋类型 's 合格蛋类型 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.QcEggTypeEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.QcEggTypeEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A84C223C");
    }
}