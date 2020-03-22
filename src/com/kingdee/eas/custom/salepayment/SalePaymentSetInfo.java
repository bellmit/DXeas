package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;

public class SalePaymentSetInfo extends AbstractSalePaymentSetInfo implements Serializable 
{
    public SalePaymentSetInfo()
    {
        super();
    }
    protected SalePaymentSetInfo(String pkField)
    {
        super(pkField);
    }
}