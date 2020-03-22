package com.kingdee.eas.weighbridge;

import java.io.Serializable;

public class QcBillInfo extends AbstractQcBillInfo implements Serializable 
{
    public QcBillInfo()
    {
        super();
    }
    protected QcBillInfo(String pkField)
    {
        super(pkField);
    }
}