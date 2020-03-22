package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzCountPositionSetOperatorEntryFactory
{
    private SzCountPositionSetOperatorEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D9DCA872") ,com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D9DCA872") ,com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D9DCA872"));
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetOperatorEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D9DCA872"));
    }
}