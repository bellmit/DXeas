package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlePolicyRecycleEntryFactory
{
    private SettlePolicyRecycleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5951043E") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5951043E") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5951043E"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyRecycleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5951043E"));
    }
}