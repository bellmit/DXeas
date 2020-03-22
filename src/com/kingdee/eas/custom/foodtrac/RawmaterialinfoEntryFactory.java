package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RawmaterialinfoEntryFactory
{
    private RawmaterialinfoEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FDC9203A") ,com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FDC9203A") ,com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FDC9203A"));
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FDC9203A"));
    }
}