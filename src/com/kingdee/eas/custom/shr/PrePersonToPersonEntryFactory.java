package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PrePersonToPersonEntryFactory
{
    private PrePersonToPersonEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IPrePersonToPersonEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPersonEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("526D3800") ,com.kingdee.eas.custom.shr.IPrePersonToPersonEntry.class);
    }
    
    public static com.kingdee.eas.custom.shr.IPrePersonToPersonEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPersonEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("526D3800") ,com.kingdee.eas.custom.shr.IPrePersonToPersonEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IPrePersonToPersonEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPersonEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("526D3800"));
    }
    public static com.kingdee.eas.custom.shr.IPrePersonToPersonEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPersonEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("526D3800"));
    }
}