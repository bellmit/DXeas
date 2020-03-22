package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class ExtractFromInfo extends AbstractExtractFromInfo implements Serializable 
{
    public ExtractFromInfo()
    {
        super();
    }
    protected ExtractFromInfo(String pkField)
    {
        super(pkField);
    }
}