package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarFactory
{
    private CarFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICar getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICar)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F8E7B111") ,com.kingdee.eas.publicdata.ICar.class);
    }
    
    public static com.kingdee.eas.publicdata.ICar getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICar)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F8E7B111") ,com.kingdee.eas.publicdata.ICar.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICar getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICar)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F8E7B111"));
    }
    public static com.kingdee.eas.publicdata.ICar getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICar)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F8E7B111"));
    }
}