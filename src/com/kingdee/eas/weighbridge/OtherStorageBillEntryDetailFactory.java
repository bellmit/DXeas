package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherStorageBillEntryDetailFactory
{
    private OtherStorageBillEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9BC68F56") ,com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail.class);
    }
    
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9BC68F56") ,com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9BC68F56"));
    }
    public static com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IOtherStorageBillEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9BC68F56"));
    }
}