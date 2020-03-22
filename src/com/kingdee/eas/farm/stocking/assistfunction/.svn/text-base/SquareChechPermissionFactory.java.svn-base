package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SquareChechPermissionFactory
{
    private SquareChechPermissionFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("506C83AC") ,com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission.class);
    }
    
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("506C83AC") ,com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("506C83AC"));
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.ISquareChechPermission)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("506C83AC"));
    }
}