package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzCountPositionSetFactory
{
    private SzCountPositionSetFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("382C2B1C") ,com.kingdee.eas.custom.szcount.ISzCountPositionSet.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("382C2B1C") ,com.kingdee.eas.custom.szcount.ISzCountPositionSet.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("382C2B1C"));
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("382C2B1C"));
    }
}