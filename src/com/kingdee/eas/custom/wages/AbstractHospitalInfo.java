package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHospitalInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHospitalInfo()
    {
        this("id");
    }
    protected AbstractHospitalInfo(String pkField)
    {
        super(pkField);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("65CCD242");
    }
}