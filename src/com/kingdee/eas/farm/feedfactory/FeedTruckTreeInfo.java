package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;

public class FeedTruckTreeInfo extends AbstractFeedTruckTreeInfo implements Serializable 
{
    public FeedTruckTreeInfo()
    {
        super();
    }
    protected FeedTruckTreeInfo(String pkField)
    {
        super(pkField);
    }
}