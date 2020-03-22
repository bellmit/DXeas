package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class DrugCostInfo extends AbstractDrugCostInfo implements Serializable 
{
    public DrugCostInfo()
    {
        super();
    }
    protected DrugCostInfo(String pkField)
    {
        super(pkField);
    }
}