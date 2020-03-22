package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillSaleEntryFactory
{
    private CKSettleBillSaleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("69C9FAB4") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("69C9FAB4") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("69C9FAB4"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSaleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("69C9FAB4"));
    }
}