package com.kingdee.eas.custom.test;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractExcelOutputInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractExcelOutputInfo()
    {
        this("id");
    }
    protected AbstractExcelOutputInfo(String pkField)
    {
        super(pkField);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7DF2FCC7");
    }
}