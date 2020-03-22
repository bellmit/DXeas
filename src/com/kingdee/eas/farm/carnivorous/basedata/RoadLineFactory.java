package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RoadLineFactory
{
    private RoadLineFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRoadLine getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRoadLine)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("470162D6") ,com.kingdee.eas.farm.carnivorous.basedata.IRoadLine.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IRoadLine getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRoadLine)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("470162D6") ,com.kingdee.eas.farm.carnivorous.basedata.IRoadLine.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRoadLine getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRoadLine)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("470162D6"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IRoadLine getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IRoadLine)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("470162D6"));
    }
}