package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class ServiceItemsInfo extends AbstractServiceItemsInfo implements Serializable 
{
    public ServiceItemsInfo()
    {
        super();
    }
    protected ServiceItemsInfo(String pkField)
    {
        super(pkField);
    }
}