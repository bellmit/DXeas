package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QcEggTypeFactory
{
    private QcEggTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A84C223C") ,com.kingdee.eas.farm.stocking.basedata.IQcEggType.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A84C223C") ,com.kingdee.eas.farm.stocking.basedata.IQcEggType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A84C223C"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IQcEggType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IQcEggType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A84C223C"));
    }
}