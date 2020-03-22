package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;

public class JournalTimesInfo extends AbstractJournalTimesInfo implements Serializable 
{
    public JournalTimesInfo()
    {
        super();
    }
    protected JournalTimesInfo(String pkField)
    {
        super(pkField);
    }
}