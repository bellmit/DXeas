package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillSeedEntryFactory
{
    private CKSettleBillSeedEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("954E36CA") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("954E36CA") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("954E36CA"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSeedEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("954E36CA"));
    }
}