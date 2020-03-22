package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class BatchTreeInfo extends AbstractBatchTreeInfo implements Serializable 
{
    public BatchTreeInfo()
    {
        super();
    }
    protected BatchTreeInfo(String pkField)
    {
        super(pkField);
    }
}