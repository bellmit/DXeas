package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.io.Serializable;

public class DataBaseConnectionInfo extends AbstractDataBaseConnectionInfo implements Serializable 
{
    public DataBaseConnectionInfo()
    {
        super();
    }
    protected DataBaseConnectionInfo(String pkField)
    {
        super(pkField);
    }
}