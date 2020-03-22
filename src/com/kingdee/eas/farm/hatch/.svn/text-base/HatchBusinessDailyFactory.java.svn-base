package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBusinessDailyFactory
{
    private HatchBusinessDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBusinessDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBusinessDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("049F6067") ,com.kingdee.eas.farm.hatch.IHatchBusinessDaily.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBusinessDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBusinessDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("049F6067") ,com.kingdee.eas.farm.hatch.IHatchBusinessDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBusinessDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBusinessDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("049F6067"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBusinessDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBusinessDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("049F6067"));
    }
}