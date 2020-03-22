package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchHouseFactory
{
    private HatchHouseFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchHouse getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouse)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C7202F4E") ,com.kingdee.eas.farm.hatch.IHatchHouse.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchHouse getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouse)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C7202F4E") ,com.kingdee.eas.farm.hatch.IHatchHouse.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchHouse getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouse)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C7202F4E"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchHouse getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchHouse)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C7202F4E"));
    }
}