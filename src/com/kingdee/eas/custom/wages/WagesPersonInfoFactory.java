package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WagesPersonInfoFactory
{
    private WagesPersonInfoFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWagesPersonInfo getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfo)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("607FA346") ,com.kingdee.eas.custom.wages.IWagesPersonInfo.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWagesPersonInfo getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfo)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("607FA346") ,com.kingdee.eas.custom.wages.IWagesPersonInfo.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWagesPersonInfo getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfo)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("607FA346"));
    }
    public static com.kingdee.eas.custom.wages.IWagesPersonInfo getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfo)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("607FA346"));
    }
}