package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStrainInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractStrainInfo()
    {
        this("id");
    }
    protected AbstractStrainInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 品系 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.StrainTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.StrainTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.StrainTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0E00CBB5");
    }
}