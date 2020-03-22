package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SquareChechPermissionEntryUserFactory
{
    private SquareChechPermissionEntryUserFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7A2EDD11") ,com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser.class);
    }
    
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7A2EDD11") ,com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7A2EDD11"));
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermissionEntryUser)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7A2EDD11"));
    }
}