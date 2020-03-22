package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarTreeFactory
{
    private CarTreeFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICarTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("ECBEA84F") ,com.kingdee.eas.publicdata.ICarTree.class);
    }
    
    public static com.kingdee.eas.publicdata.ICarTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("ECBEA84F") ,com.kingdee.eas.publicdata.ICarTree.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICarTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("ECBEA84F"));
    }
    public static com.kingdee.eas.publicdata.ICarTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICarTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("ECBEA84F"));
    }
}