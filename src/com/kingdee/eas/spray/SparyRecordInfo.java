package com.kingdee.eas.spray;

import java.io.Serializable;

public class SparyRecordInfo extends AbstractSparyRecordInfo implements Serializable 
{
    public SparyRecordInfo()
    {
        super();
    }
    protected SparyRecordInfo(String pkField)
    {
        super(pkField);
    }
}