package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class DrugCostEntryInfo extends AbstractDrugCostEntryInfo implements Serializable 
{
    public DrugCostEntryInfo()
    {
        super();
    }
    protected DrugCostEntryInfo(String pkField)
    {
        super(pkField);
    }
}