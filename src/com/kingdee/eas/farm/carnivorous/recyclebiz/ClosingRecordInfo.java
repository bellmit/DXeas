package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;

public class ClosingRecordInfo extends AbstractClosingRecordInfo implements Serializable 
{
    public ClosingRecordInfo()
    {
        super();
    }
    protected ClosingRecordInfo(String pkField)
    {
        super(pkField);
    }
}