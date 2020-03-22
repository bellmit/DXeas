package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenBasicDataFactory
{
    private ChickenBasicDataFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IChickenBasicData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IChickenBasicData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D0049E2E") ,com.kingdee.eas.custom.szcount.IChickenBasicData.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IChickenBasicData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IChickenBasicData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D0049E2E") ,com.kingdee.eas.custom.szcount.IChickenBasicData.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IChickenBasicData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IChickenBasicData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D0049E2E"));
    }
    public static com.kingdee.eas.custom.szcount.IChickenBasicData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IChickenBasicData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D0049E2E"));
    }
}