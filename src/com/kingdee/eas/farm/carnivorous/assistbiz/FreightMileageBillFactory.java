package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreightMileageBillFactory
{
    private FreightMileageBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9FDB479D") ,com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9FDB479D") ,com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9FDB479D"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IFreightMileageBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9FDB479D"));
    }
}