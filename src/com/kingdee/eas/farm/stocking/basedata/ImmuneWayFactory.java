package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ImmuneWayFactory
{
    private ImmuneWayFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IImmuneWay getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IImmuneWay)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("713B633B") ,com.kingdee.eas.farm.stocking.basedata.IImmuneWay.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IImmuneWay getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IImmuneWay)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("713B633B") ,com.kingdee.eas.farm.stocking.basedata.IImmuneWay.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IImmuneWay getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IImmuneWay)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("713B633B"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IImmuneWay getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IImmuneWay)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("713B633B"));
    }
}