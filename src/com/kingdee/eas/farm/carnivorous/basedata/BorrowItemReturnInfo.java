package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class BorrowItemReturnInfo extends AbstractBorrowItemReturnInfo implements Serializable 
{
    public BorrowItemReturnInfo()
    {
        super();
    }
    protected BorrowItemReturnInfo(String pkField)
    {
        super(pkField);
    }
}