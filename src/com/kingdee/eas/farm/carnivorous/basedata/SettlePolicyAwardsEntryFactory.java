package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlePolicyAwardsEntryFactory
{
    private SettlePolicyAwardsEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("39BDDDDD") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("39BDDDDD") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("39BDDDDD"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyAwardsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("39BDDDDD"));
    }
}