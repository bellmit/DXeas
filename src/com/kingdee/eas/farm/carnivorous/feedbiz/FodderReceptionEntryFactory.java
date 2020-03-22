package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderReceptionEntryFactory
{
    private FodderReceptionEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B2A4525D") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B2A4525D") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B2A4525D"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReceptionEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B2A4525D"));
    }
}