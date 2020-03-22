package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggReceiveBillEntryPickDetailFactory
{
    private EggReceiveBillEntryPickDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7821EB35") ,com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7821EB35") ,com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7821EB35"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBillEntryPickDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7821EB35"));
    }
}