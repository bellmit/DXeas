package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreightMileageBillEntryFactory
{
    private FreightMileageBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49020AD5") ,com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49020AD5") ,com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49020AD5"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49020AD5"));
    }
}