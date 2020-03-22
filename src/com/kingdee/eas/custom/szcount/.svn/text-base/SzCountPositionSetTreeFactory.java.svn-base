package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzCountPositionSetTreeFactory
{
    private SzCountPositionSetTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1D124DA") ,com.kingdee.eas.custom.szcount.ISzCountPositionSetTree.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1D124DA") ,com.kingdee.eas.custom.szcount.ISzCountPositionSetTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1D124DA"));
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1D124DA"));
    }
}