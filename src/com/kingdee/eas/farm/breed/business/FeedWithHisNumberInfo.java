package com.kingdee.eas.farm.breed.business;

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