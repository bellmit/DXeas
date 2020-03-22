package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ThirdpartycheckFactory
{
    private ThirdpartycheckFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D040E724") ,com.kingdee.eas.custom.foodtrac.IThirdpartycheck.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D040E724") ,com.kingdee.eas.custom.foodtrac.IThirdpartycheck.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D040E724"));
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D040E724"));
    }
}