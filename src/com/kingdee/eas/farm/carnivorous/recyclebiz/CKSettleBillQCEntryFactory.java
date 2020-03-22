package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillQCEntryFactory
{
    private CKSettleBillQCEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4B257E29") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4B257E29") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4B257E29"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillQCEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4B257E29"));
    }
}