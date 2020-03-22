package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class ConFeedPolicyInfo extends AbstractConFeedPolicyInfo implements Serializable 
{
    public ConFeedPolicyInfo()
    {
        super();
    }
    protected ConFeedPolicyInfo(String pkField)
    {
        super(pkField);
    }
}