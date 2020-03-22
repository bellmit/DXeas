package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillFodderEntryFactory
{
    private CKSettleBillFodderEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("829B38A5") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("829B38A5") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("829B38A5"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillFodderEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("829B38A5"));
    }
}