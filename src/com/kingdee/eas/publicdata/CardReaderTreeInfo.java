package com.kingdee.eas.publicdata;

import java.io.Serializable;

public class CardReaderTreeInfo extends AbstractCardReaderTreeInfo implements Serializable 
{
    public CardReaderTreeInfo()
    {
        super();
    }
    protected CardReaderTreeInfo(String pkField)
    {
        super(pkField);
    }
}