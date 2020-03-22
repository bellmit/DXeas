package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillViewReqEntryFactory
{
    private CKSettleBillViewReqEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A7511D50") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A7511D50") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A7511D50"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillViewReqEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A7511D50"));
    }
}