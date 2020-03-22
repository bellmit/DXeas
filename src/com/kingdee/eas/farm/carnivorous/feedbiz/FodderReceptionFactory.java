package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderReceptionFactory
{
    private FodderReceptionFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("713C6B15") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("713C6B15") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("713C6B15"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFodderReception)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("713C6B15"));
    }
}