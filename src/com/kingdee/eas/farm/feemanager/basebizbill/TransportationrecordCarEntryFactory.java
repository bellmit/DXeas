package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransportationrecordCarEntryFactory
{
    private TransportationrecordCarEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F6808881") ,com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F6808881") ,com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F6808881"));
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecordCarEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F6808881"));
    }
}