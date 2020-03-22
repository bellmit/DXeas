package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchFactory
{
    private BatchFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatch getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatch)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("83B77AD8") ,com.kingdee.eas.farm.carnivorous.basedata.IBatch.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatch getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatch)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("83B77AD8") ,com.kingdee.eas.farm.carnivorous.basedata.IBatch.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatch getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatch)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("83B77AD8"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatch getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatch)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("83B77AD8"));
    }
}