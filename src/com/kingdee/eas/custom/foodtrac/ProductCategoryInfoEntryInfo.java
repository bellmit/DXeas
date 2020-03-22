package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;

public class ProductCategoryInfoEntryInfo extends AbstractProductCategoryInfoEntryInfo implements Serializable 
{
    public ProductCategoryInfoEntryInfo()
    {
        super();
    }
    protected ProductCategoryInfoEntryInfo(String pkField)
    {
        super(pkField);
    }
}