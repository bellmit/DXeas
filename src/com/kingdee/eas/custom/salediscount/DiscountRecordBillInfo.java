package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

public class DiscountRecordBillInfo extends AbstractDiscountRecordBillInfo implements Serializable 
{
    public DiscountRecordBillInfo()
    {
        super();
    }
    protected DiscountRecordBillInfo(String pkField)
    {
        super(pkField);
    }
}