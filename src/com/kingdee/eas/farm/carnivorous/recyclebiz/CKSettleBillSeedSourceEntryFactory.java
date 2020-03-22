package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillSeedSourceEntryFactory
{
    private CKSettleBillSeedSourceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0298956F") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0298956F") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0298956F"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedSourceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0298956F"));
    }
}