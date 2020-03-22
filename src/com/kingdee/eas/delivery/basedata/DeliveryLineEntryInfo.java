package com.kingdee.eas.delivery.basedata;

import java.io.Serializable;

public class DeliveryLineEntryInfo extends AbstractDeliveryLineEntryInfo implements Serializable 
{
    public DeliveryLineEntryInfo()
    {
        super();
    }
    protected DeliveryLineEntryInfo(String pkField)
    {
        super(pkField);
    }
}