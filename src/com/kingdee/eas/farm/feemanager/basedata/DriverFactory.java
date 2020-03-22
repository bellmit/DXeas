package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DriverFactory
{
    private DriverFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IDriver getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriver)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("68E9FED4") ,com.kingdee.eas.farm.feemanager.basedata.IDriver.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.IDriver getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriver)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("68E9FED4") ,com.kingdee.eas.farm.feemanager.basedata.IDriver.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IDriver getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriver)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("68E9FED4"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IDriver getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriver)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("68E9FED4"));
    }
}