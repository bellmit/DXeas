package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransportationrecordAssEntryFactory
{
    private TransportationrecordAssEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E0A331F4") ,com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E0A331F4") ,com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E0A331F4"));
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E0A331F4"));
    }
}