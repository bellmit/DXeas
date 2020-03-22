package com.kingdee.eas.farm.food;

import java.io.Serializable;

public class DeliveryCarInfo extends AbstractDeliveryCarInfo implements Serializable 
{
    public DeliveryCarInfo()
    {
        super();
    }
    protected DeliveryCarInfo(String pkField)
    {
        super(pkField);
    }
}