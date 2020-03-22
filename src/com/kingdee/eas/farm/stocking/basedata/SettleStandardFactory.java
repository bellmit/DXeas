package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleStandardFactory
{
    private SettleStandardFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandard getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandard)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B1E872B9") ,com.kingdee.eas.farm.stocking.basedata.ISettleStandard.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandard getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandard)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B1E872B9") ,com.kingdee.eas.farm.stocking.basedata.ISettleStandard.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandard getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandard)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B1E872B9"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandard getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandard)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B1E872B9"));
    }
}