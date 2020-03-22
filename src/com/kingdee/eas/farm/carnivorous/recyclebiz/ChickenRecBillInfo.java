package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;

public class ChickenRecBillInfo extends AbstractChickenRecBillInfo implements Serializable 
{
    public ChickenRecBillInfo()
    {
        super();
    }
    protected ChickenRecBillInfo(String pkField)
    {
        super(pkField);
    }
}