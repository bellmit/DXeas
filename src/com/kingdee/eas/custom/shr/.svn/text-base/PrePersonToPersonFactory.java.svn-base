package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PrePersonToPersonFactory
{
    private PrePersonToPersonFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IPrePersonToPerson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPerson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E4D4B92") ,com.kingdee.eas.custom.shr.IPrePersonToPerson.class);
    }
    
    public static com.kingdee.eas.custom.shr.IPrePersonToPerson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPerson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E4D4B92") ,com.kingdee.eas.custom.shr.IPrePersonToPerson.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IPrePersonToPerson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPerson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E4D4B92"));
    }
    public static com.kingdee.eas.custom.shr.IPrePersonToPerson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IPrePersonToPerson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E4D4B92"));
    }
}