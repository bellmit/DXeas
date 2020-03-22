package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;

public class BasePriceOfOtherCompanyInfo extends AbstractBasePriceOfOtherCompanyInfo implements Serializable 
{
    public BasePriceOfOtherCompanyInfo()
    {
        super();
    }
    protected BasePriceOfOtherCompanyInfo(String pkField)
    {
        super(pkField);
    }
}