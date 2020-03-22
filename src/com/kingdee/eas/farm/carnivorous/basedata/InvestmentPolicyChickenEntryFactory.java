package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InvestmentPolicyChickenEntryFactory
{
    private InvestmentPolicyChickenEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("26691CE4") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("26691CE4") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("26691CE4"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChickenEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("26691CE4"));
    }
}