package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderStdEntryFactory
{
    private FodderStdEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("030B4DC7") ,com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("030B4DC7") ,com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("030B4DC7"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFodderStdEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("030B4DC7"));
    }
}