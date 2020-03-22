package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;

public class FeedTruckInfo extends AbstractFeedTruckInfo implements Serializable 
{
    public FeedTruckInfo()
    {
        super();
    }
    protected FeedTruckInfo(String pkField)
    {
        super(pkField);
    }
}