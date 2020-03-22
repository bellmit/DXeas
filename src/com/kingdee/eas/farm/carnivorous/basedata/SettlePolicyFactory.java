package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlePolicyFactory
{
    private SettlePolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E1DFECFF") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E1DFECFF") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E1DFECFF"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E1DFECFF"));
    }
}