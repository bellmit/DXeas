package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarEntryFactory
{
    private CarEntryFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICarEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AA4169E1") ,com.kingdee.eas.publicdata.ICarEntry.class);
    }
    
    public static com.kingdee.eas.publicdata.ICarEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AA4169E1") ,com.kingdee.eas.publicdata.ICarEntry.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICarEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AA4169E1"));
    }
    public static com.kingdee.eas.publicdata.ICarEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AA4169E1"));
    }
}