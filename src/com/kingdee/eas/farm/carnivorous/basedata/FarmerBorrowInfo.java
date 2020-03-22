package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FarmerBorrowInfo extends AbstractFarmerBorrowInfo implements Serializable 
{
    public FarmerBorrowInfo()
    {
        super();
    }
    protected FarmerBorrowInfo(String pkField)
    {
        super(pkField);
    }
}