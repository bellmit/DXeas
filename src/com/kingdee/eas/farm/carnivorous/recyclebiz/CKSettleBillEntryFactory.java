package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillEntryFactory
{
    private CKSettleBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C38F233B") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C38F233B") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C38F233B"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C38F233B"));
    }
}