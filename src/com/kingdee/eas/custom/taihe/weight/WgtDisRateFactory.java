package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WgtDisRateFactory
{
    private WgtDisRateFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5DBA1500") ,com.kingdee.eas.custom.taihe.weight.IWgtDisRate.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5DBA1500") ,com.kingdee.eas.custom.taihe.weight.IWgtDisRate.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5DBA1500"));
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5DBA1500"));
    }
}