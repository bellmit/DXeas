package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OutStorageBillEntryDetailFactory
{
    private OutStorageBillEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E577EA54") ,com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail.class);
    }
    
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E577EA54") ,com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E577EA54"));
    }
    public static com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E577EA54"));
    }
}