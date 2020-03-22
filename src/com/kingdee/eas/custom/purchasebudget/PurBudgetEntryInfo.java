package com.kingdee.eas.custom.purchasebudget;

import java.io.Serializable;

public class PurBudgetEntryInfo extends AbstractPurBudgetEntryInfo implements Serializable 
{
    public PurBudgetEntryInfo()
    {
        super();
    }
    protected PurBudgetEntryInfo(String pkField)
    {
        super(pkField);
    }
}