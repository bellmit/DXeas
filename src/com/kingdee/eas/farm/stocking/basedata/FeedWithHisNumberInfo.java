package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class FeedWithHisNumberInfo extends AbstractFeedWithHisNumberInfo implements Serializable 
{
    public FeedWithHisNumberInfo()
    {
        super();
    }
    protected FeedWithHisNumberInfo(String pkField)
    {
        super(pkField);
    }
}