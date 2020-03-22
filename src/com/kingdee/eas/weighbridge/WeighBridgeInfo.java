package com.kingdee.eas.weighbridge;

import java.io.Serializable;

public class WeighBridgeInfo extends AbstractWeighBridgeInfo implements Serializable 
{
    public WeighBridgeInfo()
    {
        super();
    }
    protected WeighBridgeInfo(String pkField)
    {
        super(pkField);
    }
}