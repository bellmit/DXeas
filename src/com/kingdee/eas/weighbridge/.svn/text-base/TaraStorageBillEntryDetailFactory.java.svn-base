package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TaraStorageBillEntryDetailFactory
{
    private TaraStorageBillEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9B563978") ,com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail.class);
    }
    
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9B563978") ,com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9B563978"));
    }
    public static com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ITaraStorageBillEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9B563978"));
    }
}