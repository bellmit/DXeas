package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillSlaughterEntryFactory
{
    private CKSettleBillSlaughterEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("94588416") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("94588416") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("94588416"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillSlaughterEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("94588416"));
    }
}