package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RawmaterialinfoFactory
{
    private RawmaterialinfoFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfo getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfo)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C95BA718") ,com.kingdee.eas.custom.foodtrac.IRawmaterialinfo.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfo getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfo)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C95BA718") ,com.kingdee.eas.custom.foodtrac.IRawmaterialinfo.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfo getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfo)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C95BA718"));
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfo getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfo)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C95BA718"));
    }
}