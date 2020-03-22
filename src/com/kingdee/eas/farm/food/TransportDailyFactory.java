package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransportDailyFactory
{
    private TransportDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ITransportDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8949F39A") ,com.kingdee.eas.farm.food.ITransportDaily.class);
    }
    
    public static com.kingdee.eas.farm.food.ITransportDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8949F39A") ,com.kingdee.eas.farm.food.ITransportDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ITransportDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8949F39A"));
    }
    public static com.kingdee.eas.farm.food.ITransportDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ITransportDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8949F39A"));
    }
}