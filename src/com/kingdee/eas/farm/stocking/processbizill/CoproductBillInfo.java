package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;

public class CoproductBillInfo extends AbstractCoproductBillInfo implements Serializable 
{
    public CoproductBillInfo()
    {
        super();
    }
    protected CoproductBillInfo(String pkField)
    {
        super(pkField);
    }
}