package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQcEggTypeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractQcEggTypeEntryInfo()
    {
        this("id");
    }
    protected AbstractQcEggTypeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 合格蛋类型 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.QcEggTypeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.QcEggTypeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.QcEggTypeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:合格蛋类型's 合格蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.QcEggTypeEnum getQcEggsType()
    {
        return com.kingdee.eas.farm.hatch.QcEggTypeEnum.getEnum(getInt("qcEggsType"));
    }
    public void setQcEggsType(com.kingdee.eas.farm.hatch.QcEggTypeEnum item)
    {
		if (item != null) {
        setInt("qcEggsType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("165BFB96");
    }
}