package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;

public class ProdCountInfo extends AbstractProdCountInfo implements Serializable 
{
    public ProdCountInfo()
    {
        super();
    }
    protected ProdCountInfo(String pkField)
    {
        super(pkField);
    }
}